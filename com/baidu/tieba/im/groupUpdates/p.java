package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private List<UpdatesItemData> bcv = new ArrayList();

    public static void a(UpdatesItemData updatesItemData, com.baidu.tieba.im.a<Boolean> aVar) {
        if (updatesItemData != null) {
            com.baidu.tieba.im.e.a(new q(updatesItemData), aVar);
        }
    }

    public void b(com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.e.a(new r(this), aVar);
    }

    public String Pi() {
        String str;
        String str2 = "";
        if (this.bcv == null || this.bcv.size() == 0) {
            return null;
        }
        int size = this.bcv.size();
        int i = 0;
        while (i < size) {
            UpdatesItemData updatesItemData = this.bcv.get(i);
            if (updatesItemData == null || TextUtils.isEmpty(updatesItemData.getNotice_id()) || !TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
                str = str2;
            } else {
                str = String.valueOf(str2) + (Long.parseLong(updatesItemData.getNotice_id()) / 100);
                if (i < size - 1) {
                    str = String.valueOf(str) + ",";
                }
            }
            i++;
            str2 = str;
        }
        return str2;
    }

    public void Pj() {
        this.bcv.clear();
    }

    public void ya() {
        Pj();
    }

    public void d(UpdatesItemData updatesItemData) {
        this.bcv.add(updatesItemData);
    }

    public void e(UpdatesItemData updatesItemData) {
        this.bcv.remove(updatesItemData);
    }

    public int Pk() {
        return this.bcv.size();
    }

    public void X(List<UpdatesItemData> list) {
        if (list != null) {
            for (UpdatesItemData updatesItemData : list) {
                if (updatesItemData.isSelected()) {
                    this.bcv.add(updatesItemData);
                }
            }
        }
    }

    public static void c(com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> aVar) {
        com.baidu.tieba.im.e.a(new s(), aVar);
    }

    public static List<UpdatesItemData> n(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList linkedList2 = new LinkedList();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator<GroupNewsPojo> it = linkedList.iterator();
        while (it.hasNext()) {
            UpdatesItemData f = f(it.next());
            if (f != null) {
                linkedList2.add(f);
            }
        }
        return linkedList2;
    }

    public static UpdatesItemData f(GroupNewsPojo groupNewsPojo) {
        UpdatesItemData updatesItemData;
        String content = groupNewsPojo.getContent();
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            if (jSONObject.isNull("notice_id")) {
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
                updatesItemData = (UpdatesItemData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(content, UpdatesItemData.class);
            }
            return updatesItemData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
