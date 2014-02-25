package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.im.c.j;
import com.baidu.tieba.im.db.h;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.m;
import com.baidu.tieba.im.message.aa;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SystemMsgReceivedHandler extends d {
    public SystemMsgReceivedHandler() {
        super(1);
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    protected void a(com.baidu.tieba.im.data.c cVar) {
        a.a(cVar);
        j.a().a(String.valueOf(cVar.a().getGroupId()));
        com.baidu.tieba.im.j.a(new f(this, cVar), new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        if (linkedList != null) {
            Iterator<GroupNewsPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.getCmd()) && next.getCmd().equals("group_head_change")) {
                    a(next);
                }
            }
        }
    }

    private void a(GroupNewsPojo groupNewsPojo) {
        ImMessageCenterPojo a;
        UpdatesItemData a2 = m.a(groupNewsPojo);
        if (a2 != null) {
            String groupId = a2.getGroupId();
            if (!TextUtils.isEmpty(groupId) && (a = h.a().d().a(groupId)) != null) {
                a.setGroup_head(a2.getGroupHeadUrl());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LinkedList<GroupNewsPojo> b(com.baidu.tieba.im.data.c cVar) {
        long j;
        GroupNewsPojo groupNewsPojo;
        try {
            LinkedList<GroupNewsPojo> a = a(cVar.b());
            if (a == null || a.isEmpty()) {
                return null;
            }
            LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.c.a().a(0L, 1, 0, null);
            if (a2 == null || a2.size() <= 0 || (groupNewsPojo = a2.get(0)) == null || TextUtils.isEmpty(groupNewsPojo.getNotice_id())) {
                j = -1;
            } else {
                j = Long.parseLong(groupNewsPojo.getNotice_id());
            }
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            Iterator<GroupNewsPojo> it = a.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (!TextUtils.isEmpty(next.getNotice_id()) && Long.parseLong(next.getNotice_id()) > j) {
                    linkedList.add(next);
                }
            }
            com.baidu.tieba.im.db.c.a().a(linkedList);
            Iterator<GroupNewsPojo> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                GroupNewsPojo next2 = it2.next();
                if (next2 != null) {
                    if (next2.getCmd().equals("apply_join_group")) {
                        com.baidu.tieba.im.c.a.e();
                    } else if ("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(next2.getCmd())) {
                        com.baidu.tieba.im.c.a.a(next2.getCmd(), true);
                    } else if (next2.getCmd().equals("apply_join_success")) {
                        com.baidu.tieba.im.c.a.b();
                    }
                }
            }
            return linkedList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LinkedList<GroupNewsPojo> linkedList) {
        if (linkedList != null) {
            Iterator<GroupNewsPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (next != null) {
                    com.baidu.tieba.im.messageCenter.e.a().d(new aa(next));
                    com.baidu.adp.lib.util.f.e("dispatch system cmd:" + next.getCmd());
                }
            }
        }
    }

    private static LinkedList<GroupNewsPojo> a(com.baidu.tieba.im.data.f fVar) {
        List<com.baidu.tieba.im.message.b> a;
        if (fVar == null || (a = fVar.a()) == null || a.size() == 0) {
            return null;
        }
        LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
        for (com.baidu.tieba.im.message.b bVar : a) {
            GroupNewsPojo a2 = a(bVar);
            if (a2 != null) {
                linkedList.add(a2);
            }
        }
        return linkedList;
    }

    private static GroupNewsPojo a(com.baidu.tieba.im.message.b bVar) {
        UpdatesItemData a;
        String k = bVar.k();
        if (TextUtils.isEmpty(k)) {
            com.baidu.adp.lib.util.f.e(" system message content is null or empty");
            return null;
        }
        try {
            com.baidu.adp.lib.util.f.e("system msg:" + bVar.k());
            if (k.startsWith("[")) {
                com.baidu.adp.lib.util.f.e("system msg content is no json");
                return null;
            }
            String optString = new JSONObject(k).optString("eventId");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.adp.lib.util.f.e(" system message content no eventId");
                return null;
            }
            com.baidu.adp.lib.util.f.e("system message content eventID is " + optString);
            GroupNewsPojo groupNewsPojo = new GroupNewsPojo(bVar, optString);
            groupNewsPojo.setOriginalPushMsg(bVar);
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd) && cmd.equals("group_name_change")) {
                UpdatesItemData a2 = m.a(groupNewsPojo);
                if (a2 != null && !TextUtils.isEmpty(a2.getGroupName())) {
                    String groupId = a2.getGroupId();
                    if (!TextUtils.isEmpty(groupId)) {
                        com.baidu.adp.lib.util.f.e("update msg group name" + a2.getGroupName());
                        com.baidu.tieba.im.util.d.a(groupId, a2.getGroupName());
                    }
                }
            } else if (!TextUtils.isEmpty(cmd) && cmd.equals("group_head_change") && (a = m.a(groupNewsPojo)) != null) {
                String groupId2 = a.getGroupId();
                if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(a.getGroupHeadUrl())) {
                    com.baidu.adp.lib.util.f.e("update msg group head" + a.getGroupHeadUrl());
                    com.baidu.tieba.im.util.d.b(groupId2, a.getGroupHeadUrl());
                }
            }
            return groupNewsPojo;
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.adp.lib.util.f.e("system message convert json error happen");
            return null;
        }
    }
}
