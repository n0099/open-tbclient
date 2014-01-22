package com.baidu.tieba.im.c;

import android.text.TextUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.GroupIdTypeData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.ae;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.util.by;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.messageCenter.g {
    private static m a = null;
    private Map<String, LinkedList<WeakReference<l>>> b = new HashMap();
    private String c;

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (a == null) {
                a = new m();
            }
            mVar = a;
        }
        return mVar;
    }

    public void b() {
        e();
    }

    public void a(String str, l lVar) {
        if (lVar != null && !TextUtils.isEmpty(str)) {
            LinkedList<WeakReference<l>> linkedList = this.b.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.b.put(str, linkedList);
            }
            linkedList.add(new WeakReference<>(lVar));
        }
    }

    public void a(l lVar) {
        if (lVar != null) {
            for (LinkedList<WeakReference<l>> linkedList : this.b.values()) {
                Iterator<WeakReference<l>> it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference<l> next = it.next();
                    l lVar2 = next.get();
                    if (lVar2 != null && lVar2.equals(lVar)) {
                        linkedList.remove(next);
                        break;
                    }
                }
            }
        }
    }

    private m() {
    }

    private void e() {
        com.baidu.tieba.im.messageCenter.e.a().a(202006, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-100, this);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null) {
            com.baidu.adp.lib.g.e.d("cmd:" + qVar.w());
            switch (qVar.w()) {
                case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                    a((com.baidu.tieba.im.data.c) qVar);
                    return;
                case 202006:
                    a((u) qVar);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null) {
            com.baidu.adp.lib.g.e.d("cmd: " + uVar.w() + "groupId: " + uVar.c());
            String valueOf = String.valueOf(uVar.c());
            by.a(202006, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf);
            if (!TextUtils.isEmpty(valueOf)) {
                com.baidu.tieba.im.b.a.c().a(uVar.c(), uVar.b(), uVar.a());
            }
        }
    }

    public void c() {
        com.baidu.tieba.im.b.a.c().i();
    }

    private void a(com.baidu.tieba.im.data.c cVar) {
        GroupIdTypeData a2;
        if (cVar != null && (a2 = cVar.a()) != null) {
            int groupType = a2.getGroupType();
            com.baidu.adp.lib.g.e.d("type  " + groupType);
            if (1 == groupType) {
                this.c = String.valueOf(a2.getGroupId());
                com.baidu.adp.lib.g.e.d("systemGroupId:" + this.c);
                a(cVar, groupType);
                return;
            }
            if (1 != groupType) {
            }
        }
    }

    public void a(CommonMsgPojo commonMsgPojo) {
        boolean z;
        if (commonMsgPojo != null) {
            com.baidu.tieba.im.message.g chatMessage = commonMsgPojo.toChatMessage();
            if (chatMessage != null) {
                SystemMsgData i = com.baidu.tieba.im.d.d.i(chatMessage);
                z = i == null || i.getIsSelf();
                if (TiebaApplication.B()) {
                    if (chatMessage.g().getId().equals(TiebaApplication.A()) && chatMessage.i() != 11) {
                        z = false;
                    }
                }
            } else {
                z = true;
            }
            if (commonMsgPojo.getRead_flag() == 0) {
                z = false;
            }
            if (!TiebaApplication.h().Z() && !commonMsgPojo.isPrivate()) {
                z = false;
            }
            if (!TiebaApplication.h().Y() && commonMsgPojo.isPrivate()) {
                z = false;
            }
            String gid = commonMsgPojo.getGid();
            if (!TextUtils.isEmpty(gid) && GroupChatActivity.a && gid.equals(GroupChatActivity.b)) {
                z = false;
            } else if (!TextUtils.isEmpty(gid) && PersonalChatActivity.a && gid.equals(PersonalChatActivity.b)) {
                z = false;
            } else if (!TextUtils.isEmpty(gid) && SnapGroupChatActivity.l && gid.equals(SnapGroupChatActivity.m)) {
                z = false;
            }
            k e = a.h().e(gid);
            if (e != null) {
                boolean isAcceptNotify = e.isAcceptNotify();
                if (z && !isAcceptNotify) {
                    z = false;
                }
                a.h().b(z, new n(this));
                return;
            }
            com.baidu.tieba.im.chat.personaltalk.a.a(TiebaApplication.A(), commonMsgPojo.getGid(), new o(this, z));
        }
    }

    public void a(boolean z) {
        a.h().b(z, new q(this));
    }

    public void a(GroupNewsPojo groupNewsPojo) {
        LinkedList<WeakReference<l>> linkedList = this.b.get("group_msg_arrived");
        com.baidu.adp.lib.g.e.d("dispatch group chat ");
        int i = 0;
        if (linkedList != null && !linkedList.isEmpty()) {
            Iterator<WeakReference<l>> it = linkedList.iterator();
            while (it.hasNext()) {
                l lVar = it.next().get();
                if (lVar != null) {
                    i++;
                    lVar.a(groupNewsPojo);
                }
                i = i;
            }
        }
        com.baidu.adp.lib.g.e.d("dispatch group chat: " + i + " times");
    }

    private void a(com.baidu.tieba.im.data.c cVar, int i) {
        com.baidu.tieba.im.m.a(new r(this, cVar, i), new s(this));
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
                ae.a().a(new t(this, groupId, a2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LinkedList<GroupNewsPojo> b(com.baidu.tieba.im.data.c cVar, int i) {
        long j;
        GroupNewsPojo groupNewsPojo;
        if (1 != i) {
            return null;
        }
        try {
            LinkedList<GroupNewsPojo> a2 = a(cVar.b());
            if (a2 == null || a2.isEmpty()) {
                return null;
            }
            LinkedList<GroupNewsPojo> a3 = com.baidu.tieba.im.db.l.a().a(0L, 1, 0, null);
            if (a3 == null || a3.size() <= 0 || (groupNewsPojo = a3.get(0)) == null || TextUtils.isEmpty(groupNewsPojo.getNotice_id())) {
                j = -1;
            } else {
                j = Long.parseLong(groupNewsPojo.getNotice_id());
            }
            com.baidu.adp.lib.g.e.d(" lastDBMid:" + j);
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            Iterator<GroupNewsPojo> it = a2.iterator();
            while (it.hasNext()) {
                GroupNewsPojo next = it.next();
                if (!TextUtils.isEmpty(next.getNotice_id())) {
                    long parseLong = Long.parseLong(next.getNotice_id());
                    com.baidu.adp.lib.g.e.d(" lastDBMid:" + j + " mid:" + parseLong);
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
                    com.baidu.adp.lib.g.e.d("system lastmid pull:" + next2.getNotice_id());
                    if (next2.getCmd().equals("apply_join_group")) {
                        a.g();
                    } else if ("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info".contains(next2.getCmd())) {
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
                    LinkedList<WeakReference<l>> linkedList2 = this.b.get(next.getCmd());
                    com.baidu.adp.lib.g.e.d("dispatch system cmd:" + next.getCmd());
                    int i = 0;
                    if (linkedList2 != null && !linkedList2.isEmpty()) {
                        Iterator<WeakReference<l>> it2 = linkedList2.iterator();
                        while (it2.hasNext()) {
                            l lVar = it2.next().get();
                            if (lVar != null) {
                                i++;
                                lVar.a(next);
                            }
                            i = i;
                        }
                    }
                    com.baidu.adp.lib.g.e.d("dispatch system cmd:" + next.getCmd() + " " + i + " times");
                }
            }
        }
    }

    private static LinkedList<GroupNewsPojo> a(com.baidu.tieba.im.data.f fVar) {
        List<com.baidu.tieba.im.message.b> a2;
        if (fVar == null || (a2 = fVar.a()) == null || a2.size() == 0) {
            return null;
        }
        LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
        com.baidu.adp.lib.g.e.d("size:" + a2.size());
        int i = 0;
        for (com.baidu.tieba.im.message.b bVar : a2) {
            int i2 = i + 1;
            com.baidu.adp.lib.g.e.d("idx:" + i + "  cmd:" + bVar.w() + " content:" + bVar.k());
            GroupNewsPojo a3 = a(bVar);
            if (a3 != null) {
                linkedList.add(a3);
            }
            i = i2;
        }
        com.baidu.adp.lib.g.e.d("after convert size:" + linkedList.size());
        return linkedList;
    }

    private static GroupNewsPojo a(com.baidu.tieba.im.message.b bVar) {
        UpdatesItemData a2;
        String k = bVar.k();
        if (TextUtils.isEmpty(k)) {
            com.baidu.adp.lib.g.e.d(" system message content is null or empty");
            return null;
        }
        try {
            com.baidu.adp.lib.g.e.d("system msg:" + bVar.k());
            if (k.startsWith("[")) {
                com.baidu.adp.lib.g.e.d("system msg content is no json");
                return null;
            }
            String optString = new JSONObject(k).optString("eventId");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.adp.lib.g.e.d(" system message content no eventId");
                return null;
            }
            com.baidu.adp.lib.g.e.d("system message content eventID is " + optString);
            GroupNewsPojo groupNewsPojo = new GroupNewsPojo(bVar, optString);
            groupNewsPojo.setOriginalPushMsg(bVar);
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd) && cmd.equals("group_name_change")) {
                UpdatesItemData a3 = com.baidu.tieba.im.groupUpdates.m.a(groupNewsPojo);
                if (a3 != null && !TextUtils.isEmpty(a3.getGroupName())) {
                    String groupId = a3.getGroupId();
                    if (!TextUtils.isEmpty(groupId)) {
                        com.baidu.adp.lib.g.e.d("update msg group name" + a3.getGroupName());
                        com.baidu.tieba.im.db.t.a().b(groupId, a3.getGroupName());
                    }
                }
            } else if (!TextUtils.isEmpty(cmd) && cmd.equals("group_head_change") && (a2 = com.baidu.tieba.im.groupUpdates.m.a(groupNewsPojo)) != null) {
                String groupId2 = a2.getGroupId();
                if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(a2.getGroupHeadUrl())) {
                    com.baidu.adp.lib.g.e.d("update msg group head" + a2.getGroupHeadUrl());
                    com.baidu.tieba.im.db.t.a().c(groupId2, a2.getGroupHeadUrl());
                }
            }
            return groupNewsPojo;
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.adp.lib.g.e.d("system message convert json error happen");
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
