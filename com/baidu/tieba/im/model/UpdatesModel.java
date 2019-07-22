package com.baidu.tieba.im.model;

import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.d;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UpdatesModel {
    private List<UpdatesItemData> dataToDelete = new ArrayList();

    public static void updateUpdatesData(k<Boolean> kVar, UpdatesItemData... updatesItemDataArr) {
        if (updatesItemDataArr != null) {
            final LinkedList linkedList = new LinkedList();
            for (UpdatesItemData updatesItemData : updatesItemDataArr) {
                linkedList.add(updatesItemData.toGroupNewsPojo());
            }
            aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.model.UpdatesModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    return d.bCA().q(linkedList);
                }
            }, kVar);
        }
    }

    public static void deleteUpdatesData(final UpdatesItemData updatesItemData, k<Boolean> kVar) {
        if (updatesItemData != null) {
            aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.model.UpdatesModel.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.z
                public Boolean doInBackground() {
                    return Boolean.valueOf(d.bCA().yR(UpdatesItemData.this.getNotice_id()));
                }
            }, kVar);
        }
    }

    public void deleteDatas(k<Boolean> kVar) {
        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.model.UpdatesModel.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                return Boolean.valueOf(d.bCA().cU(UpdatesModel.this.dataToDelete));
            }
        }, kVar);
    }

    public String deleteDatasIds() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.dataToDelete == null || this.dataToDelete.size() == 0) {
            return null;
        }
        int size = this.dataToDelete.size();
        for (int i = 0; i < size; i++) {
            UpdatesItemData updatesItemData = this.dataToDelete.get(i);
            if (updatesItemData != null && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
                stringBuffer.append(Long.parseLong(updatesItemData.getNotice_id()) / 100);
                if (i < size - 1) {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        return stringBuffer.toString();
    }

    public void clearSelect() {
        this.dataToDelete.clear();
    }

    public void destory() {
        clearSelect();
    }

    public void addSelect(UpdatesItemData updatesItemData) {
        this.dataToDelete.add(updatesItemData);
    }

    public void cancelSelect(UpdatesItemData updatesItemData) {
        this.dataToDelete.remove(updatesItemData);
    }

    public int getDeleteSize() {
        return this.dataToDelete.size();
    }

    public void calculateSelects(List<UpdatesItemData> list) {
        if (list != null) {
            for (UpdatesItemData updatesItemData : list) {
                if (updatesItemData.isSelected()) {
                    this.dataToDelete.add(updatesItemData);
                }
            }
        }
    }

    public static void requestUpdatesDataFromDB(k<LinkedList<GroupNewsPojo>> kVar) {
        aa.b(new z<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.model.UpdatesModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            public LinkedList<GroupNewsPojo> doInBackground() {
                return d.bCA().a(0L, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change");
            }
        }, kVar);
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

    public static UpdatesItemData convertToUpdatesItem(GroupNewsPojo groupNewsPojo) {
        UpdatesItemData updatesItemData;
        String content = groupNewsPojo.getContent();
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            if (true == jSONObject.isNull("notice_id")) {
                updatesItemData = new UpdatesItemData();
                updatesItemData.setNotice_id(groupNewsPojo.getNotice_id());
                updatesItemData.setContent(jSONObject.optString("userMsg"));
                JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                if (optJSONObject == null) {
                    updatesItemData = null;
                } else {
                    updatesItemData.setUpdatesType(groupNewsPojo.getCmd());
                    updatesItemData.setGroupHeadUrl(optJSONObject.optString("groupImage"));
                    updatesItemData.setGroupId(optJSONObject.optString("groupId"));
                    updatesItemData.setGroupName(optJSONObject.optString("groupName"));
                    updatesItemData.setAuthorId(optJSONObject.optString("                                                                                                                                                                   "));
                    updatesItemData.setAuthorName(optJSONObject.optString("authorName"));
                    updatesItemData.setTime(groupNewsPojo.getTime());
                    updatesItemData.setTitle(optJSONObject.optString("title"));
                    updatesItemData.setEventLink(optJSONObject.optString("eventLink"));
                    updatesItemData.setGroupActivityId(optJSONObject.optString("activityId"));
                }
            } else {
                updatesItemData = (UpdatesItemData) OrmObject.objectWithJsonStr(content, UpdatesItemData.class);
            }
            return updatesItemData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
