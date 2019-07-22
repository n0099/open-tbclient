package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.d;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ValidateModel {
    public static void updateValidateData(k<Boolean> kVar, final ValidateItemData validateItemData) {
        if (validateItemData != null) {
            aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.model.ValidateModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    return Boolean.valueOf(d.bCA().a(ValidateItemData.this));
                }
            }, kVar);
        }
    }

    public static void markShown(List<ValidateItemData> list) {
        if (list != null && !list.isEmpty()) {
            final LinkedList linkedList = new LinkedList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ValidateItemData validateItemData = list.get(i);
                if (validateItemData != null && !validateItemData.isShown()) {
                    validateItemData.setShown(true);
                    linkedList.add(new GroupNewsPojo(validateItemData));
                }
            }
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.model.ValidateModel.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    d.bCA().q(linkedList);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void deleteValidateData(final ValidateItemData validateItemData, k<Boolean> kVar) {
        if (validateItemData != null) {
            aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.model.ValidateModel.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    return Boolean.valueOf(d.bCA().yR(ValidateItemData.this.getNotice_id()));
                }
            }, kVar);
        }
    }

    public static void requestValidateDataFromDB(final int i, final int i2, k<LinkedList<GroupNewsPojo>> kVar) {
        aa.b(new z<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.model.ValidateModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            public LinkedList<GroupNewsPojo> doInBackground() {
                return d.bCA().a(0L, i, i2, "apply_join_group");
            }
        }, kVar);
    }

    public static void requestValidateDataCountFromDB(k<Integer> kVar) {
        aa.b(new z<Integer>() { // from class: com.baidu.tieba.im.model.ValidateModel.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Integer doInBackground() {
                return Integer.valueOf(d.bCA().yP("apply_join_group"));
            }
        }, kVar);
    }

    public static ValidateItemData getByNoticeid(String str) {
        return convertToValidateItemData(d.bCA().yQ(str));
    }

    public static List<ValidateItemData> convertToValidateItemDataList(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList linkedList2 = new LinkedList();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator<GroupNewsPojo> it = linkedList.iterator();
        while (it.hasNext()) {
            ValidateItemData convertToValidateItemData = convertToValidateItemData(it.next());
            if (convertToValidateItemData != null) {
                linkedList2.add(convertToValidateItemData);
            }
        }
        return linkedList2;
    }

    public static ValidateItemData convertToValidateItemData(GroupNewsPojo groupNewsPojo) {
        ValidateItemData validateItemData;
        if (groupNewsPojo == null) {
            return null;
        }
        String content = groupNewsPojo.getContent();
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            if (true == jSONObject.isNull("notice_id")) {
                validateItemData = new ValidateItemData();
                validateItemData.setNotice_id(groupNewsPojo.getNotice_id());
                validateItemData.setApplyReason(jSONObject.optString("userMsg"));
                validateItemData.setApplyTime(groupNewsPojo.getTime());
                JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                if (optJSONObject == null) {
                    validateItemData = null;
                } else {
                    validateItemData.setUserName(optJSONObject.optString("userName"));
                    validateItemData.setPortrait(optJSONObject.optString(IntentConfig.PORTRAIT));
                    String optString = optJSONObject.optString("groupId");
                    validateItemData.setGroupId(optString);
                    setGroupName(validateItemData, optString);
                    validateItemData.setUserId(optJSONObject.optString("userId"));
                    validateItemData.setInviterUserId(optJSONObject.optLong(ApplyJoinGroupActivityConfig.INVITE_USER_ID));
                    validateItemData.setJoinType(optJSONObject.optInt(ApplyJoinGroupActivityConfig.JOIN_TYPE));
                    validateItemData.setExt(groupNewsPojo.getExt());
                }
            } else {
                validateItemData = (ValidateItemData) OrmObject.objectWithJsonStr(content, ValidateItemData.class);
                setGroupName(validateItemData, validateItemData.getGroupId());
            }
            return validateItemData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void setGroupName(ValidateItemData validateItemData, String str) {
        if (!BdBaseApplication.getInst().isDebugMode() || l.ks()) {
            String str2 = "";
            ImMessageCenterPojo aQ = b.bEZ().aQ(str, 1);
            if (aQ != null) {
                str2 = aQ.getGroup_name();
            }
            validateItemData.setGroupName(str2);
        }
    }
}
