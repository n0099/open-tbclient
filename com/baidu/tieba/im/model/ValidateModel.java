package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import d.a.c.e.p.l;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
import d.a.n0.f1.h.d;
import d.a.n0.f1.k.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ValidateModel {
    public static ValidateItemData convertToValidateItemData(GroupNewsPojo groupNewsPojo) {
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
                ValidateItemData validateItemData = new ValidateItemData();
                validateItemData.setNotice_id(groupNewsPojo.getNotice_id());
                validateItemData.setApplyReason(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG));
                validateItemData.setApplyTime(groupNewsPojo.getTime());
                JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject == null) {
                    return null;
                }
                validateItemData.setUserName(optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
                validateItemData.setPortrait(optJSONObject.optString("portrait"));
                String optString = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                validateItemData.setGroupId(optString);
                setGroupName(validateItemData, optString);
                validateItemData.setUserId(optJSONObject.optString("userId"));
                validateItemData.setInviterUserId(optJSONObject.optLong(ApplyJoinGroupActivityConfig.INVITE_USER_ID));
                validateItemData.setJoinType(optJSONObject.optInt(ApplyJoinGroupActivityConfig.JOIN_TYPE));
                validateItemData.setExt(groupNewsPojo.getExt());
                return validateItemData;
            }
            ValidateItemData validateItemData2 = (ValidateItemData) OrmObject.objectWithJsonStr(content, ValidateItemData.class);
            setGroupName(validateItemData2, validateItemData2.getGroupId());
            return validateItemData2;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
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

    public static void deleteValidateData(final ValidateItemData validateItemData, n<Boolean> nVar) {
        if (validateItemData == null) {
            return;
        }
        h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.ValidateModel.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.m0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.f().a(ValidateItemData.this.getNotice_id()));
            }
        }, nVar);
    }

    public static ValidateItemData getByNoticeid(String str) {
        return convertToValidateItemData(d.f().d(str));
    }

    public static void markShown(List<ValidateItemData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        final LinkedList linkedList = new LinkedList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ValidateItemData validateItemData = list.get(i2);
            if (validateItemData != null && !validateItemData.isShown()) {
                validateItemData.setShown(true);
                linkedList.add(new GroupNewsPojo(validateItemData));
            }
        }
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.model.ValidateModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                d.f().n(linkedList);
                return null;
            }
        }.execute(new Void[0]);
    }

    public static void requestValidateDataCountFromDB(n<Integer> nVar) {
        h0.c(new f0<Integer>() { // from class: com.baidu.tieba.im.model.ValidateModel.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.m0.z0.f0
            public Integer doInBackground() {
                return Integer.valueOf(d.f().e("apply_join_group"));
            }
        }, nVar);
    }

    public static void requestValidateDataFromDB(final int i2, final int i3, n<LinkedList<GroupNewsPojo>> nVar) {
        h0.c(new f0<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.model.ValidateModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.z0.f0
            public LinkedList<GroupNewsPojo> doInBackground() {
                return d.f().c(0L, i2, i3, "apply_join_group");
            }
        }, nVar);
    }

    public static void setGroupName(ValidateItemData validateItemData, String str) {
        if (!BdBaseApplication.getInst().isDebugMode() || l.C()) {
            ImMessageCenterPojo i2 = b.o().i(str, 1);
            validateItemData.setGroupName(i2 != null ? i2.getGroup_name() : "");
        }
    }

    public static void updateValidateData(n<Boolean> nVar, final ValidateItemData validateItemData) {
        if (validateItemData == null) {
            return;
        }
        h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.ValidateModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.m0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.f().j(ValidateItemData.this));
            }
        }, nVar);
    }
}
