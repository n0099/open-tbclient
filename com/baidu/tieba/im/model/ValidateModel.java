package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
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
/* loaded from: classes26.dex */
public class ValidateModel {
    public static void updateValidateData(m<Boolean> mVar, final ValidateItemData validateItemData) {
        if (validateItemData != null) {
            ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.model.ValidateModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    return Boolean.valueOf(d.cVQ().a(ValidateItemData.this));
                }
            }, mVar);
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
                    d.cVQ().m(linkedList);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public static void deleteValidateData(final ValidateItemData validateItemData, m<Boolean> mVar) {
        if (validateItemData != null) {
            ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.model.ValidateModel.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    return Boolean.valueOf(d.cVQ().Nl(ValidateItemData.this.getNotice_id()));
                }
            }, mVar);
        }
    }

    public static void requestValidateDataFromDB(final int i, final int i2, m<LinkedList<GroupNewsPojo>> mVar) {
        ad.b(new ac<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.model.ValidateModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            public LinkedList<GroupNewsPojo> doInBackground() {
                return d.cVQ().a(0L, i, i2, "apply_join_group");
            }
        }, mVar);
    }

    public static void requestValidateDataCountFromDB(m<Integer> mVar) {
        ad.b(new ac<Integer>() { // from class: com.baidu.tieba.im.model.ValidateModel.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ac
            public Integer doInBackground() {
                return Integer.valueOf(d.cVQ().Nj("apply_join_group"));
            }
        }, mVar);
    }

    public static ValidateItemData getByNoticeid(String str) {
        return convertToValidateItemData(d.cVQ().Nk(str));
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
                validateItemData.setApplyReason(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG));
                validateItemData.setApplyTime(groupNewsPojo.getTime());
                JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject == null) {
                    validateItemData = null;
                } else {
                    validateItemData.setUserName(optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
                    validateItemData.setPortrait(optJSONObject.optString("portrait"));
                    String optString = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                    validateItemData.setGroupId(optString);
                    setGroupName(validateItemData, optString);
                    validateItemData.setUserId(optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
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
        if (!BdBaseApplication.getInst().isDebugMode() || l.isMainThread()) {
            String str2 = "";
            ImMessageCenterPojo bl = b.cYD().bl(str, 1);
            if (bl != null) {
                str2 = bl.getGroup_name();
            }
            validateItemData.setGroupName(str2);
        }
    }
}
