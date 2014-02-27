package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.im.c.j;
import com.baidu.tieba.im.db.h;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.m;
import com.baidu.tieba.im.i;
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
    protected final void a(com.baidu.tieba.im.data.c cVar) {
        j.a().a(String.valueOf(cVar.a().getGroupId()));
        i.a(new f(this, cVar), new g(this, cVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SystemMsgReceivedHandler systemMsgReceivedHandler, LinkedList linkedList) {
        UpdatesItemData a;
        ImMessageCenterPojo a2;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                GroupNewsPojo groupNewsPojo = (GroupNewsPojo) it.next();
                if (groupNewsPojo != null && !TextUtils.isEmpty(groupNewsPojo.getCmd()) && groupNewsPojo.getCmd().equals("group_head_change") && (a = m.a(groupNewsPojo)) != null) {
                    String groupId = a.getGroupId();
                    if (!TextUtils.isEmpty(groupId) && (a2 = h.a().d().a(groupId)) != null) {
                        a2.setGroup_head(a.getGroupHeadUrl());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedList<GroupNewsPojo> b(com.baidu.tieba.im.data.c cVar) {
        LinkedList linkedList;
        long j;
        GroupNewsPojo groupNewsPojo;
        try {
            com.baidu.tieba.im.data.f b = cVar.b();
            if (b == null) {
                linkedList = null;
            } else {
                List<com.baidu.tieba.im.message.b> a = b.a();
                if (a == null || a.size() == 0) {
                    linkedList = null;
                } else {
                    LinkedList linkedList2 = new LinkedList();
                    for (com.baidu.tieba.im.message.b bVar : a) {
                        GroupNewsPojo a2 = a(bVar);
                        if (a2 != null) {
                            linkedList2.add(a2);
                        }
                    }
                    linkedList = linkedList2;
                }
            }
            if (linkedList == null || linkedList.isEmpty()) {
                return null;
            }
            LinkedList<GroupNewsPojo> a3 = com.baidu.tieba.im.db.c.a().a(0L, 1, 0, null);
            if (a3 == null || a3.size() <= 0 || (groupNewsPojo = a3.get(0)) == null || TextUtils.isEmpty(groupNewsPojo.getNotice_id())) {
                j = -1;
            } else {
                j = Long.parseLong(groupNewsPojo.getNotice_id());
            }
            LinkedList<GroupNewsPojo> linkedList3 = new LinkedList<>();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                GroupNewsPojo groupNewsPojo2 = (GroupNewsPojo) it.next();
                if (!TextUtils.isEmpty(groupNewsPojo2.getNotice_id()) && Long.parseLong(groupNewsPojo2.getNotice_id()) > j) {
                    linkedList3.add(groupNewsPojo2);
                }
            }
            com.baidu.tieba.im.db.c.a().a(linkedList3);
            Iterator<GroupNewsPojo> it2 = linkedList3.iterator();
            while (it2.hasNext()) {
                GroupNewsPojo next = it2.next();
                if (next != null) {
                    if (next.getCmd().equals("apply_join_group")) {
                        com.baidu.tieba.im.c.a.c();
                    } else if ("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(next.getCmd())) {
                        com.baidu.tieba.im.c.a.a(next.getCmd(), true);
                    } else if (next.getCmd().equals("apply_join_success")) {
                        com.baidu.tieba.im.c.a.a();
                    }
                }
            }
            return linkedList3;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(SystemMsgReceivedHandler systemMsgReceivedHandler, LinkedList linkedList) {
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                GroupNewsPojo groupNewsPojo = (GroupNewsPojo) it.next();
                if (groupNewsPojo != null) {
                    com.baidu.tieba.im.messageCenter.d.a().d(new aa(groupNewsPojo));
                    com.baidu.adp.lib.util.e.e("dispatch system cmd:" + groupNewsPojo.getCmd());
                }
            }
        }
    }

    private static GroupNewsPojo a(com.baidu.tieba.im.message.b bVar) {
        UpdatesItemData a;
        String k = bVar.k();
        if (TextUtils.isEmpty(k)) {
            com.baidu.adp.lib.util.e.e(" system message content is null or empty");
            return null;
        }
        try {
            com.baidu.adp.lib.util.e.e("system msg:" + bVar.k());
            if (k.startsWith("[")) {
                com.baidu.adp.lib.util.e.e("system msg content is no json");
                return null;
            }
            String optString = new JSONObject(k).optString("eventId");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.adp.lib.util.e.e(" system message content no eventId");
                return null;
            }
            com.baidu.adp.lib.util.e.e("system message content eventID is " + optString);
            GroupNewsPojo groupNewsPojo = new GroupNewsPojo(bVar, optString);
            groupNewsPojo.setOriginalPushMsg(bVar);
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd) && cmd.equals("group_name_change")) {
                UpdatesItemData a2 = m.a(groupNewsPojo);
                if (a2 != null && !TextUtils.isEmpty(a2.getGroupName())) {
                    String groupId = a2.getGroupId();
                    if (!TextUtils.isEmpty(groupId)) {
                        com.baidu.adp.lib.util.e.e("update msg group name" + a2.getGroupName());
                        com.baidu.tieba.im.util.d.a(groupId, a2.getGroupName());
                    }
                }
            } else if (!TextUtils.isEmpty(cmd) && cmd.equals("group_head_change") && (a = m.a(groupNewsPojo)) != null) {
                String groupId2 = a.getGroupId();
                if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(a.getGroupHeadUrl())) {
                    com.baidu.adp.lib.util.e.e("update msg group head" + a.getGroupHeadUrl());
                    com.baidu.tieba.im.util.d.b(groupId2, a.getGroupHeadUrl());
                }
            }
            return groupNewsPojo;
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.adp.lib.util.e.e("system message convert json error happen");
            return null;
        }
    }
}
