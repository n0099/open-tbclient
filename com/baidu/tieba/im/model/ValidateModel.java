package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
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
    public static void updateValidateData(j<Boolean> jVar, final ValidateItemData validateItemData) {
        if (validateItemData != null) {
            z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.model.ValidateModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.y
                public Boolean doInBackground() {
                    return Boolean.valueOf(d.bDC().a(ValidateItemData.this));
                }
            }, jVar);
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
                    d.bDC().q(linkedList);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void deleteValidateData(final ValidateItemData validateItemData, j<Boolean> jVar) {
        if (validateItemData != null) {
            z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.model.ValidateModel.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.y
                public Boolean doInBackground() {
                    return Boolean.valueOf(d.bDC().zr(ValidateItemData.this.getNotice_id()));
                }
            }, jVar);
        }
    }

    public static void requestValidateDataFromDB(final int i, final int i2, j<LinkedList<GroupNewsPojo>> jVar) {
        z.b(new y<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.model.ValidateModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            public LinkedList<GroupNewsPojo> doInBackground() {
                return d.bDC().a(0L, i, i2, "apply_join_group");
            }
        }, jVar);
    }

    public static void requestValidateDataCountFromDB(j<Integer> jVar) {
        z.b(new y<Integer>() { // from class: com.baidu.tieba.im.model.ValidateModel.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.y
            public Integer doInBackground() {
                return Integer.valueOf(d.bDC().zp("apply_join_group"));
            }
        }, jVar);
    }

    public static ValidateItemData getByNoticeid(String str) {
        return convertToValidateItemData(d.bDC().zq(str));
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
            ImMessageCenterPojo aS = b.bGb().aS(str, 1);
            if (aS != null) {
                str2 = aS.getGroup_name();
            }
            validateItemData.setGroupName(str2);
        }
    }
}
