package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupIdTypeData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.ad;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.t;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.message.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    private static l f1866a = null;
    private Map<String, LinkedList<WeakReference<k>>> b = new HashMap();
    private String c;

    public static l a() {
        if (f1866a == null) {
            synchronized (l.class) {
                if (f1866a == null) {
                    f1866a = new l();
                }
            }
        }
        return f1866a;
    }

    public void b() {
        e();
    }

    public void a(String str, k kVar) {
        if (kVar != null && !TextUtils.isEmpty(str)) {
            LinkedList<WeakReference<k>> linkedList = this.b.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.b.put(str, linkedList);
            }
            linkedList.add(new WeakReference<>(kVar));
        }
    }

    public void a(k kVar) {
        if (kVar != null) {
            for (LinkedList<WeakReference<k>> linkedList : this.b.values()) {
                Iterator<WeakReference<k>> it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference<k> next = it.next();
                    k kVar2 = next.get();
                    if (kVar2 != null && kVar2.equals(kVar)) {
                        linkedList.remove(next);
                        break;
                    }
                }
            }
        }
    }

    private l() {
    }

    private void e() {
        com.baidu.tieba.im.messageCenter.e.a().a(202006, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-100, this);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        if (message != null) {
            com.baidu.adp.lib.h.e.d("cmd:" + message.getCmd());
            switch (message.getCmd()) {
                case -100:
                    a((GroupMsgData) message);
                    return;
                case 202006:
                    a((PushNotifyMessage) message);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            com.baidu.adp.lib.h.e.d("cmd: " + pushNotifyMessage.getCmd() + "groupId: " + pushNotifyMessage.getGroupId());
            String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
            com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(202006, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf));
            if (!TextUtils.isEmpty(valueOf)) {
                com.baidu.tieba.im.d.a.a().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
            }
        }
    }

    public void c() {
        com.baidu.tieba.im.d.a.a().g();
    }

    private void a(GroupMsgData groupMsgData) {
        GroupIdTypeData groupInfo;
        if (groupMsgData != null && (groupInfo = groupMsgData.getGroupInfo()) != null) {
            int groupType = groupInfo.getGroupType();
            com.baidu.adp.lib.h.e.d("type  " + groupType);
            if (1 == groupType) {
                this.c = String.valueOf(groupInfo.getGroupId());
                com.baidu.adp.lib.h.e.d("systemGroupId:" + this.c);
                a(groupMsgData, groupType);
                return;
            }
            if (1 != groupType) {
            }
        }
    }

    public void a(GroupMsgPojo groupMsgPojo) {
        boolean z = true;
        if (groupMsgPojo != null) {
            ChatMessage chatMessage = groupMsgPojo.toChatMessage();
            if (chatMessage != null) {
                SystemMsgData h = com.baidu.tieba.im.e.d.h(chatMessage);
                if (h != null && !h.getIsSelf()) {
                    z = false;
                }
                if (TiebaApplication.C()) {
                    if (chatMessage.getUserInfo().getId().equals(TiebaApplication.B()) && chatMessage.getMsgType() != 11) {
                        z = false;
                    }
                }
            }
            if (groupMsgPojo.getRead_flag() == 0) {
                z = false;
            }
            String gid = groupMsgPojo.getGid();
            boolean z2 = MsglistActivity.f1534a;
            if (!TextUtils.isEmpty(gid) && z2 && gid.equals(MsglistActivity.b)) {
                z = false;
            }
        }
        a.h().b(z, new m(this));
    }

    public void a(GroupNewsPojo groupNewsPojo) {
        LinkedList<WeakReference<k>> linkedList = this.b.get("group_msg_arrived");
        com.baidu.adp.lib.h.e.d("dispatch group chat ");
        int i = 0;
        if (linkedList != null && !linkedList.isEmpty()) {
            Iterator<WeakReference<k>> it = linkedList.iterator();
            while (it.hasNext()) {
                k kVar = it.next().get();
                if (kVar != null) {
                    i++;
                    kVar.a(groupNewsPojo);
                }
                i = i;
            }
        }
        com.baidu.adp.lib.h.e.d("dispatch group chat: " + i + " times");
    }

    private void a(GroupMsgData groupMsgData, int i) {
        com.baidu.tieba.im.m.a(new n(this, groupMsgData, i), new o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        if (linkedList != null) {
            Iterator<GroupNewsPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.getCmd()) && next.getCmd().equals("group_head_change")) {
                    b(next);
                }
            }
        }
    }

    private void b(GroupNewsPojo groupNewsPojo) {
        UpdatesItemData a2 = com.baidu.tieba.im.groupUpdates.m.a(groupNewsPojo);
        if (a2 != null) {
            String groupId = a2.getGroupId();
            if (!TextUtils.isEmpty(groupId)) {
                ad.a().a(new p(this, groupId, a2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LinkedList<GroupNewsPojo> b(GroupMsgData groupMsgData, int i) {
        long j;
        GroupNewsPojo groupNewsPojo;
        if (1 != i) {
            return null;
        }
        try {
            LinkedList<GroupNewsPojo> a2 = a(groupMsgData.getListMessage());
            if (a2 == null || a2.isEmpty()) {
                return null;
            }
            LinkedList<GroupNewsPojo> a3 = com.baidu.tieba.im.db.l.a().a(0L, 1, 0, null);
            if (a3 == null || a3.size() <= 0 || (groupNewsPojo = a3.get(0)) == null || TextUtils.isEmpty(groupNewsPojo.getNotice_id())) {
                j = -1;
            } else {
                j = Long.parseLong(groupNewsPojo.getNotice_id());
            }
            com.baidu.adp.lib.h.e.d(" lastDBMid:" + j);
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            Iterator<GroupNewsPojo> it = a2.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (!TextUtils.isEmpty(next.getNotice_id())) {
                    long parseLong = Long.parseLong(next.getNotice_id());
                    com.baidu.adp.lib.h.e.d(" lastDBMid:" + j + " mid:" + parseLong);
                    if (parseLong > j) {
                        linkedList.add(next);
                    }
                }
            }
            com.baidu.tieba.im.db.l.a().a(linkedList);
            Iterator<GroupNewsPojo> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                GroupNewsPojo next2 = it2.next();
                if (next2 != null) {
                    com.baidu.adp.lib.h.e.d("system lastmid pull:" + next2.getNotice_id());
                    if (next2.getCmd().equals("apply_join_group")) {
                        a.g();
                    } else if ("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out".contains(next2.getCmd())) {
                        a.a(true);
                        if (next2.getCmd().equals("dismiss_group")) {
                            a.e();
                        } else if (next2.getCmd().equals("kick_out")) {
                            a.c();
                        }
                    } else if (next2.getCmd().equals("apply_join_success")) {
                        a.d();
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
                    LinkedList<WeakReference<k>> linkedList2 = this.b.get(next.getCmd());
                    com.baidu.adp.lib.h.e.d("dispatch system cmd:" + next.getCmd());
                    int i = 0;
                    if (linkedList2 != null && !linkedList2.isEmpty()) {
                        Iterator<WeakReference<k>> it2 = linkedList2.iterator();
                        while (it2.hasNext()) {
                            k kVar = it2.next().get();
                            if (kVar != null) {
                                i++;
                                kVar.a(next);
                            }
                            i = i;
                        }
                    }
                    com.baidu.adp.lib.h.e.d("dispatch system cmd:" + next.getCmd() + " " + i + " times");
                }
            }
        }
    }

    private static LinkedList<GroupNewsPojo> a(com.baidu.tieba.im.data.b bVar) {
        List<ChatMessage> a2;
        if (bVar == null || (a2 = bVar.a()) == null || a2.size() == 0) {
            return null;
        }
        LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
        com.baidu.adp.lib.h.e.d("size:" + a2.size());
        int i = 0;
        for (ChatMessage chatMessage : a2) {
            int i2 = i + 1;
            com.baidu.adp.lib.h.e.d("idx:" + i + "  cmd:" + chatMessage.getCmd() + " content:" + chatMessage.getContent());
            GroupNewsPojo a3 = a(chatMessage);
            if (a3 != null) {
                linkedList.add(a3);
            }
            i = i2;
        }
        com.baidu.adp.lib.h.e.d("after convert size:" + linkedList.size());
        return linkedList;
    }

    private static GroupNewsPojo a(ChatMessage chatMessage) {
        UpdatesItemData a2;
        String content = chatMessage.getContent();
        if (TextUtils.isEmpty(content)) {
            com.baidu.adp.lib.h.e.d(" system message content is null or empty");
            return null;
        }
        try {
            com.baidu.adp.lib.h.e.d("system msg:" + chatMessage.getContent());
            if (content.startsWith("[")) {
                com.baidu.adp.lib.h.e.d("system msg content is no json");
                return null;
            }
            String optString = new JSONObject(content).optString("eventId");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.adp.lib.h.e.d(" system message content no eventId");
                return null;
            }
            com.baidu.adp.lib.h.e.d("system message content eventID is " + optString);
            GroupNewsPojo groupNewsPojo = new GroupNewsPojo(chatMessage, optString);
            groupNewsPojo.setOriginalPushMsg(chatMessage);
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd) && cmd.equals("group_name_change")) {
                UpdatesItemData a3 = com.baidu.tieba.im.groupUpdates.m.a(groupNewsPojo);
                if (a3 != null && !TextUtils.isEmpty(a3.getGroupName())) {
                    String groupId = a3.getGroupId();
                    if (!TextUtils.isEmpty(groupId)) {
                        com.baidu.adp.lib.h.e.d("update msg group name" + a3.getGroupName());
                        t.a().b(groupId, a3.getGroupName());
                    }
                }
            } else if (!TextUtils.isEmpty(cmd) && cmd.equals("group_head_change") && (a2 = com.baidu.tieba.im.groupUpdates.m.a(groupNewsPojo)) != null) {
                String groupId2 = a2.getGroupId();
                if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(a2.getGroupHeadUrl())) {
                    com.baidu.adp.lib.h.e.d("update msg group head" + a2.getGroupHeadUrl());
                    t.a().c(groupId2, a2.getGroupHeadUrl());
                }
            }
            return groupNewsPojo;
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.adp.lib.h.e.d("system message convert json error happen");
            return null;
        }
    }

    public String d() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }
}
