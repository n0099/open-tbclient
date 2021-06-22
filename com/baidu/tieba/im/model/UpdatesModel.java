package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import d.a.n0.z0.f0;
import d.a.n0.z0.h0;
import d.a.n0.z0.n;
import d.a.o0.f1.h.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UpdatesModel {
    public List<UpdatesItemData> dataToDelete = new ArrayList();

    public static UpdatesItemData convertToUpdatesItem(GroupNewsPojo groupNewsPojo) {
        String content = groupNewsPojo.getContent();
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            if (true == jSONObject.isNull("notice_id")) {
                UpdatesItemData updatesItemData = new UpdatesItemData();
                updatesItemData.setNotice_id(groupNewsPojo.getNotice_id());
                updatesItemData.setContent(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG));
                JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject == null) {
                    return null;
                }
                updatesItemData.setUpdatesType(groupNewsPojo.getCmd());
                updatesItemData.setGroupHeadUrl(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_IMAGE));
                updatesItemData.setGroupId(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID));
                updatesItemData.setGroupName(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME));
                updatesItemData.setAuthorId(optJSONObject.optString("                                                                                                                                                                   "));
                updatesItemData.setAuthorName(optJSONObject.optString("authorName"));
                updatesItemData.setTime(groupNewsPojo.getTime());
                updatesItemData.setTitle(optJSONObject.optString("title"));
                updatesItemData.setEventLink(optJSONObject.optString("eventLink"));
                updatesItemData.setGroupActivityId(optJSONObject.optString("activityId"));
                return updatesItemData;
            }
            return (UpdatesItemData) OrmObject.objectWithJsonStr(content, UpdatesItemData.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List<UpdatesItemData> convertToUpdatesItemData(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList linkedList2 = new LinkedList();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator<GroupNewsPojo> it = linkedList.iterator();
        while (it.hasNext()) {
            UpdatesItemData convertToUpdatesItem = convertToUpdatesItem(it.next());
            if (convertToUpdatesItem != null) {
                linkedList2.add(convertToUpdatesItem);
            }
        }
        return linkedList2;
    }

    public static void deleteUpdatesData(final UpdatesItemData updatesItemData, n<Boolean> nVar) {
        if (updatesItemData == null) {
            return;
        }
        h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.UpdatesModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.n0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.f().a(UpdatesItemData.this.getNotice_id()));
            }
        }, nVar);
    }

    public static void requestUpdatesDataFromDB(n<LinkedList<GroupNewsPojo>> nVar) {
        h0.c(new f0<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.model.UpdatesModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.n0.z0.f0
            public LinkedList<GroupNewsPojo> doInBackground() {
                return d.f().c(0L, Integer.MAX_VALUE, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change");
            }
        }, nVar);
    }

    public static void updateUpdatesData(n<Boolean> nVar, UpdatesItemData... updatesItemDataArr) {
        if (updatesItemDataArr == null) {
            return;
        }
        final LinkedList linkedList = new LinkedList();
        for (UpdatesItemData updatesItemData : updatesItemDataArr) {
            linkedList.add(updatesItemData.toGroupNewsPojo());
        }
        h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.UpdatesModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.n0.z0.f0
            public Boolean doInBackground() {
                return d.f().n(linkedList);
            }
        }, nVar);
    }

    public void addSelect(UpdatesItemData updatesItemData) {
        this.dataToDelete.add(updatesItemData);
    }

    public void calculateSelects(List<UpdatesItemData> list) {
        if (list == null) {
            return;
        }
        for (UpdatesItemData updatesItemData : list) {
            if (updatesItemData.isSelected()) {
                this.dataToDelete.add(updatesItemData);
            }
        }
    }

    public void cancelSelect(UpdatesItemData updatesItemData) {
        this.dataToDelete.remove(updatesItemData);
    }

    public void clearSelect() {
        this.dataToDelete.clear();
    }

    public void deleteDatas(n<Boolean> nVar) {
        h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.UpdatesModel.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.n0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.f().b(UpdatesModel.this.dataToDelete));
            }
        }, nVar);
    }

    public String deleteDatasIds() {
        StringBuffer stringBuffer = new StringBuffer();
        List<UpdatesItemData> list = this.dataToDelete;
        if (list == null || list.size() == 0) {
            return null;
        }
        int size = this.dataToDelete.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdatesItemData updatesItemData = this.dataToDelete.get(i2);
            if (updatesItemData != null && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
                stringBuffer.append(Long.parseLong(updatesItemData.getNotice_id()) / 100);
                if (i2 < size - 1) {
                    stringBuffer.append(",");
                }
            }
        }
        return stringBuffer.toString();
    }

    public void destory() {
        clearSelect();
    }

    public int getDeleteSize() {
        return this.dataToDelete.size();
    }
}
