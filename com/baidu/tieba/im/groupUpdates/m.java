package com.baidu.tieba.im.groupUpdates;

import android.text.TextUtils;
import cn.jingling.lib.file.Shared;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private List<UpdatesItemData> f1631a = new ArrayList();

    public static void a(UpdatesItemData updatesItemData, com.baidu.tieba.im.a<Boolean> aVar) {
        if (updatesItemData != null) {
            com.baidu.tieba.im.db.g.a().a(updatesItemData.getNotice_id(), aVar);
        }
    }

    public void a(com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.db.g.a().a(this.f1631a, aVar);
    }

    public String a() {
        String str;
        String str2 = "";
        if (this.f1631a == null || this.f1631a.size() == 0) {
            return null;
        }
        int size = this.f1631a.size();
        int i = 0;
        while (i < size) {
            UpdatesItemData updatesItemData = this.f1631a.get(i);
            if (updatesItemData == null || TextUtils.isEmpty(updatesItemData.getNotice_id()) || !TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
                str = str2;
            } else {
                str = str2 + (Long.parseLong(updatesItemData.getNotice_id()) / 100);
                if (i < size - 1) {
                    str = str + ",";
                }
            }
            i++;
            str2 = str;
        }
        return str2;
    }

    public void b() {
        this.f1631a.clear();
    }

    public void c() {
        b();
    }

    public void a(UpdatesItemData updatesItemData) {
        this.f1631a.add(updatesItemData);
    }

    public void b(UpdatesItemData updatesItemData) {
        this.f1631a.remove(updatesItemData);
    }

    public int d() {
        return this.f1631a.size();
    }

    public static void b(com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> aVar) {
        com.baidu.tieba.im.db.g.a().a(0L, Shared.INFINITY, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change", aVar);
    }

    public static List<UpdatesItemData> a(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList linkedList2 = new LinkedList();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator<GroupNewsPojo> it = linkedList.iterator();
        while (it.hasNext()) {
            UpdatesItemData a2 = a(it.next());
            if (a2 != null) {
                linkedList2.add(a2);
            }
        }
        return linkedList2;
    }

    public static UpdatesItemData a(GroupNewsPojo groupNewsPojo) {
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
                    updatesItemData.setAuthorId(optJSONObject.optString("authorId"));
                    updatesItemData.setAuthorName(optJSONObject.optString("authorName"));
                    updatesItemData.setTime(groupNewsPojo.getTime());
                    updatesItemData.setTitle(optJSONObject.optString("title"));
                }
            } else {
                updatesItemData = (UpdatesItemData) new GsonBuilder().create().fromJson(content, (Class<Object>) UpdatesItemData.class);
            }
            return updatesItemData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
