package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupIdTypeData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.x;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.util.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    private static n f1779a = null;
    private Map<String, LinkedList<WeakReference<m>>> b = new HashMap();
    private String c;

    public static n a() {
        if (f1779a == null) {
            synchronized (n.class) {
                if (f1779a == null) {
                    f1779a = new n();
                }
            }
        }
        return f1779a;
    }

    public void b() {
        e();
    }

    public void a(String str, m mVar) {
        if (mVar != null && !TextUtils.isEmpty(str)) {
            LinkedList<WeakReference<m>> linkedList = this.b.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.b.put(str, linkedList);
            }
            linkedList.add(new WeakReference<>(mVar));
        }
    }

    public void a(m mVar) {
        if (mVar != null) {
            for (LinkedList<WeakReference<m>> linkedList : this.b.values()) {
                Iterator<WeakReference<m>> it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference<m> next = it.next();
                    m mVar2 = next.get();
                    if (mVar2 != null && mVar2.equals(mVar)) {
                        linkedList.remove(next);
                        break;
                    }
                }
            }
        }
    }

    private n() {
    }

    private void e() {
        com.baidu.tieba.im.messageCenter.f.a().a(202006, this);
        com.baidu.tieba.im.messageCenter.f.a().a(-100, this);
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        if (message != null) {
            com.baidu.adp.lib.h.d.d("cmd:" + message.getCmd());
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
            com.baidu.adp.lib.h.d.d("cmd: " + pushNotifyMessage.getCmd() + "groupId: " + pushNotifyMessage.getGroupId());
            String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
            y.a(202006, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf);
            if (!TextUtils.isEmpty(valueOf)) {
                com.baidu.tieba.im.c.a.a().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
            }
        }
    }

    public void c() {
        com.baidu.tieba.im.c.a.a().h();
    }

    private void a(GroupMsgData groupMsgData) {
        GroupIdTypeData groupInfo;
        if (groupMsgData != null && (groupInfo = groupMsgData.getGroupInfo()) != null) {
            int groupType = groupInfo.getGroupType();
            com.baidu.adp.lib.h.d.d("type  " + groupType);
            if (1 == groupType) {
                this.c = String.valueOf(groupInfo.getGroupId());
                com.baidu.adp.lib.h.d.d("systemGroupId:" + this.c);
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
                SystemMsgData h = com.baidu.tieba.im.d.c.h(chatMessage);
                if (h != null && !h.getIsSelf()) {
                    z = false;
                }
                if (TiebaApplication.B()) {
                    if (chatMessage.getUserInfo().getId().equals(TiebaApplication.A()) && chatMessage.getMsgType() != 11) {
                        z = false;
                    }
                }
            }
            if (groupMsgPojo.getRead_flag() == 0) {
                z = false;
            }
            String gid = groupMsgPojo.getGid();
            boolean z2 = MsglistActivity.f1493a;
            if (!TextUtils.isEmpty(gid) && z2 && gid.equals(MsglistActivity.b)) {
                z = false;
            }
        }
        a.g().b(z, new o(this));
    }

    public void a(GroupNewsPojo groupNewsPojo) {
        LinkedList<WeakReference<m>> linkedList = this.b.get("group_msg_arrived");
        com.baidu.adp.lib.h.d.d("dispatch group chat ");
        int i = 0;
        if (linkedList != null && !linkedList.isEmpty()) {
            Iterator<WeakReference<m>> it = linkedList.iterator();
            while (it.hasNext()) {
                m mVar = it.next().get();
                if (mVar != null) {
                    i++;
                    mVar.a(groupNewsPojo);
                }
                i = i;
            }
        }
        com.baidu.adp.lib.h.d.d("dispatch group chat: " + i + " times");
    }

    private void a(GroupMsgData groupMsgData, int i) {
        com.baidu.tieba.im.m.a(new p(this, groupMsgData, i), new q(this));
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
                x.a().a(new r(this, groupId, a2));
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
            LinkedList<GroupNewsPojo> a3 = com.baidu.tieba.im.db.g.a().a(0L, 1, null);
            if (a3 == null || a3.size() <= 0 || (groupNewsPojo = a3.get(0)) == null || TextUtils.isEmpty(groupNewsPojo.getNotice_id())) {
                j = -1;
            } else {
                j = Long.parseLong(groupNewsPojo.getNotice_id());
            }
            com.baidu.adp.lib.h.d.d(" lastDBMid:" + j);
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            Iterator<GroupNewsPojo> it = a2.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (!TextUtils.isEmpty(next.getNotice_id())) {
                    long parseLong = Long.parseLong(next.getNotice_id());
                    com.baidu.adp.lib.h.d.d(" lastDBMid:" + j + " mid:" + parseLong);
                    if (parseLong > j) {
                        linkedList.add(next);
                    }
                }
            }
            com.baidu.tieba.im.db.g.a().a(linkedList);
            Iterator<GroupNewsPojo> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                GroupNewsPojo next2 = it2.next();
                if (next2 != null) {
                    com.baidu.adp.lib.h.d.d("system lastmid pull:" + next2.getNotice_id());
                    if (next2.getCmd().equals("apply_join_group")) {
                        a.f();
                    } else if ("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change".contains(next2.getCmd())) {
                        a.a(true);
                    } else if (next2.getCmd().equals("apply_join_success")) {
                        a.d();
                    } else if (next2.getCmd().equals("kick_out")) {
                        a.c();
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
                    LinkedList<WeakReference<m>> linkedList2 = this.b.get(next.getCmd());
                    com.baidu.adp.lib.h.d.d("dispatch system cmd:" + next.getCmd());
                    int i = 0;
                    if (linkedList2 != null && !linkedList2.isEmpty()) {
                        Iterator<WeakReference<m>> it2 = linkedList2.iterator();
                        while (it2.hasNext()) {
                            m mVar = it2.next().get();
                            if (mVar != null) {
                                i++;
                                mVar.a(next);
                            }
                            i = i;
                        }
                    }
                    com.baidu.adp.lib.h.d.d("dispatch system cmd:" + next.getCmd() + " " + i + " times");
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
        com.baidu.adp.lib.h.d.d("size:" + a2.size());
        int i = 0;
        for (ChatMessage chatMessage : a2) {
            int i2 = i + 1;
            com.baidu.adp.lib.h.d.d("idx:" + i + "  cmd:" + chatMessage.getCmd() + " content:" + chatMessage.getContent());
            GroupNewsPojo a3 = a(chatMessage);
            if (a3 != null) {
                linkedList.add(a3);
            }
            i = i2;
        }
        com.baidu.adp.lib.h.d.d("after convert size:" + linkedList.size());
        return linkedList;
    }

    private static GroupNewsPojo a(ChatMessage chatMessage) {
        UpdatesItemData a2;
        String content = chatMessage.getContent();
        if (TextUtils.isEmpty(content)) {
            com.baidu.adp.lib.h.d.d(" system message content is null or empty");
            return null;
        }
        try {
            com.baidu.adp.lib.h.d.d("system msg:" + chatMessage.getContent());
            if (content.startsWith("[")) {
                com.baidu.adp.lib.h.d.d("system msg content is no json");
                return null;
            }
            String optString = new JSONObject(content).optString("eventId");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.adp.lib.h.d.d(" system message content no eventId");
                return null;
            }
            com.baidu.adp.lib.h.d.d("system message content eventID is " + optString);
            GroupNewsPojo groupNewsPojo = new GroupNewsPojo(chatMessage, optString);
            groupNewsPojo.setOriginalPushMsg(chatMessage);
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd) && cmd.equals("group_name_change")) {
                String gid = groupNewsPojo.getGid();
                UpdatesItemData a3 = com.baidu.tieba.im.groupUpdates.m.a(groupNewsPojo);
                if (!TextUtils.isEmpty(gid) && a3 != null && !TextUtils.isEmpty(a3.getGroupName())) {
                    com.baidu.adp.lib.h.d.d("update msg group name" + a3.getGroupName());
                    com.baidu.tieba.im.db.n.a().b(gid, a3.getGroupName());
                }
            } else if (!TextUtils.isEmpty(cmd) && cmd.equals("group_head_change") && (a2 = com.baidu.tieba.im.groupUpdates.m.a(groupNewsPojo)) != null) {
                String groupId = a2.getGroupId();
                if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(a2.getGroupHeadUrl())) {
                    com.baidu.adp.lib.h.d.d("update msg group head" + a2.getGroupHeadUrl());
                    com.baidu.tieba.im.db.n.a().c(groupId, a2.getGroupHeadUrl());
                }
            }
            return groupNewsPojo;
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.adp.lib.h.d.d("system message convert json error happen");
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
