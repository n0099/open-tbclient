package com.baidu.tieba.im.model;

import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.d;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class UpdatesModel {
    private List<UpdatesItemData> dataToDelete = new ArrayList();

    public static void updateUpdatesData(l<Boolean> lVar, UpdatesItemData... updatesItemDataArr) {
        if (updatesItemDataArr != null) {
            final LinkedList linkedList = new LinkedList();
            for (UpdatesItemData updatesItemData : updatesItemDataArr) {
                linkedList.add(updatesItemData.toGroupNewsPojo());
            }
            ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.model.UpdatesModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    return d.cpB().m(linkedList);
                }
            }, lVar);
        }
    }

    public static void deleteUpdatesData(final UpdatesItemData updatesItemData, l<Boolean> lVar) {
        if (updatesItemData != null) {
            ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.model.UpdatesModel.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    return Boolean.valueOf(d.cpB().GP(UpdatesItemData.this.getNotice_id()));
                }
            }, lVar);
        }
    }

    public void deleteDatas(l<Boolean> lVar) {
        ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.model.UpdatesModel.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ac
            public Boolean doInBackground() {
                return Boolean.valueOf(d.cpB().dp(UpdatesModel.this.dataToDelete));
            }
        }, lVar);
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

    public static void requestUpdatesDataFromDB(l<LinkedList<GroupNewsPojo>> lVar) {
        ad.b(new ac<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.model.UpdatesModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            public LinkedList<GroupNewsPojo> doInBackground() {
                return d.cpB().a(0L, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change");
            }
        }, lVar);
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
                updatesItemData.setContent(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG));
                JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject == null) {
                    updatesItemData = null;
                } else {
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
