package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.PushMessage;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class u extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
        com.baidu.tieba.im.pushNotify.o.a().a(String.valueOf(groupMsgData.b().getGroupId()));
        com.baidu.tieba.im.r.a(new v(this, groupMsgData), new w(this, groupMsgData));
    }

    public u() {
        super(2013000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(u uVar, LinkedList linkedList) {
        UpdatesItemData a;
        ImMessageCenterPojo a2;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                GroupNewsPojo groupNewsPojo = (GroupNewsPojo) it.next();
                if (groupNewsPojo != null && !TextUtils.isEmpty(groupNewsPojo.getCmd()) && groupNewsPojo.getCmd().equals("group_head_change") && (a = com.baidu.tieba.im.groupUpdates.p.a(groupNewsPojo)) != null) {
                    String groupId = a.getGroupId();
                    if (!TextUtils.isEmpty(groupId) && (a2 = com.baidu.tieba.im.b.e.a(groupId)) != null) {
                        a2.setGroup_head(a.getGroupHeadUrl());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedList<GroupNewsPojo> a(GroupMsgData groupMsgData) {
        LinkedList linkedList;
        long j;
        GroupNewsPojo groupNewsPojo;
        try {
            LinkedList<com.baidu.tieba.im.message.a.a> c = groupMsgData.c();
            if (c == null || c.size() == 0) {
                linkedList = null;
            } else {
                LinkedList linkedList2 = new LinkedList();
                Iterator<com.baidu.tieba.im.message.a.a> it = c.iterator();
                while (it.hasNext()) {
                    GroupNewsPojo a = a(it.next());
                    if (a != null) {
                        linkedList2.add(a);
                    }
                }
                linkedList = linkedList2;
            }
            if (linkedList == null || linkedList.isEmpty()) {
                return null;
            }
            LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, null);
            if (a2 == null || a2.size() <= 0 || (groupNewsPojo = a2.get(0)) == null || TextUtils.isEmpty(groupNewsPojo.getNotice_id())) {
                j = -1;
            } else {
                j = Long.parseLong(groupNewsPojo.getNotice_id());
            }
            LinkedList<GroupNewsPojo> linkedList3 = new LinkedList<>();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                GroupNewsPojo groupNewsPojo2 = (GroupNewsPojo) it2.next();
                if (!TextUtils.isEmpty(groupNewsPojo2.getNotice_id()) && Long.parseLong(groupNewsPojo2.getNotice_id()) > j) {
                    linkedList3.add(groupNewsPojo2);
                }
            }
            com.baidu.tieba.im.db.d.a().a(linkedList3);
            Iterator<GroupNewsPojo> it3 = linkedList3.iterator();
            while (it3.hasNext()) {
                GroupNewsPojo next = it3.next();
                if (next != null) {
                    if (next.getCmd().equals("apply_join_group")) {
                        com.baidu.tieba.im.pushNotify.a.c();
                    } else if ("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(next.getCmd())) {
                        com.baidu.tieba.im.pushNotify.a.a(next.getCmd(), true);
                    } else if (next.getCmd().equals("apply_join_success")) {
                        com.baidu.tieba.im.pushNotify.a.a();
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
    public static /* synthetic */ void b(u uVar, LinkedList linkedList) {
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                GroupNewsPojo groupNewsPojo = (GroupNewsPojo) it.next();
                if (groupNewsPojo != null) {
                    com.baidu.adp.framework.c.a().b(PushMessage.a(groupNewsPojo));
                    com.baidu.adp.lib.util.f.e("dispatch system cmd:" + groupNewsPojo.getCmd());
                }
            }
        }
    }

    private static GroupNewsPojo a(com.baidu.tieba.im.message.a.a aVar) {
        UpdatesItemData a;
        String v = aVar.v();
        if (TextUtils.isEmpty(v)) {
            com.baidu.adp.lib.util.f.e(" system message content is null or empty");
            return null;
        }
        try {
            com.baidu.adp.lib.util.f.e("system msg:" + aVar.v());
            if (v.startsWith("[")) {
                com.baidu.adp.lib.util.f.e("system msg content is no json");
                return null;
            }
            String optString = new JSONObject(v).optString("eventId");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.adp.lib.util.f.e(" system message content no eventId");
                return null;
            }
            com.baidu.adp.lib.util.f.e("system message content eventID is " + optString);
            GroupNewsPojo groupNewsPojo = new GroupNewsPojo(aVar, optString);
            groupNewsPojo.setOriginalPushMsg(aVar);
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd) && cmd.equals("group_name_change")) {
                UpdatesItemData a2 = com.baidu.tieba.im.groupUpdates.p.a(groupNewsPojo);
                if (a2 != null && !TextUtils.isEmpty(a2.getGroupName())) {
                    String groupId = a2.getGroupId();
                    if (!TextUtils.isEmpty(groupId)) {
                        com.baidu.adp.lib.util.f.e("update msg group name" + a2.getGroupName());
                        com.baidu.tieba.im.f.h.a(groupId, a2.getGroupName());
                    }
                }
            } else if (!TextUtils.isEmpty(cmd) && cmd.equals("group_head_change") && (a = com.baidu.tieba.im.groupUpdates.p.a(groupNewsPojo)) != null) {
                String groupId2 = a.getGroupId();
                if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(a.getGroupHeadUrl())) {
                    com.baidu.adp.lib.util.f.e("update msg group head" + a.getGroupHeadUrl());
                    com.baidu.tieba.im.f.h.b(groupId2, a.getGroupHeadUrl());
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
