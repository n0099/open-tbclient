package com.baidu.tieba.im.pushNotify;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.aa;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.x;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.groupInfo.v;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.validate.ValidateItemData;
import com.baidu.tieba.mention.ae;
import com.baidu.tieba.mention.t;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.conversation.RConversation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1682a;
    private static Handler l = new Handler();
    private String c;
    private String d;
    private RecentChatFriendData f;
    private RecentChatFriendData g;
    private List<GroupUpdateMessage> i;
    private long b = 0;
    private LinkedList<RecentChatFriendData> e = new LinkedList<>();
    private ae h = new ae();
    private boolean j = false;
    private boolean k = false;
    private long m = 0;

    public void a(long j) {
        this.b = j;
    }

    private a() {
        b();
        a();
    }

    public void a() {
        this.k = com.baidu.tieba.sharedPref.b.a().a("is_show_updates", true);
    }

    public void b() {
        this.j = com.baidu.tieba.sharedPref.b.a().a("is_show_validate", true);
    }

    public static void c() {
        GroupNewsPojo groupNewsPojo;
        com.baidu.adp.lib.h.d.d("begin");
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.g.a().a(0L, 1, "kick_out");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                jSONObject.put("notice_id", groupNewsPojo.getNotice_id());
                str = jSONObject.optJSONObject("eventParam").optString("groupId");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                if (!v.c(TiebaApplication.C(), str)) {
                    com.baidu.adp.lib.h.d.d("not in return");
                    return;
                }
                v.a(TiebaApplication.C(), str, false);
                v.c(TiebaApplication.C(), str, false);
                l.post(new b(str));
                com.baidu.adp.lib.h.d.d("save kick data: " + groupNewsPojo.toString());
            }
        }
    }

    public static void d() {
        GroupNewsPojo groupNewsPojo;
        String str;
        Exception e;
        JSONObject optJSONObject;
        com.baidu.adp.lib.h.d.d(" time:" + System.currentTimeMillis());
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.g.a().a(0L, 1, "apply_join_success");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String content = groupNewsPojo.getContent();
            if (TextUtils.isEmpty(content)) {
                com.baidu.adp.lib.h.d.a("content is null");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                jSONObject.put("notice_id", groupNewsPojo.getNotice_id());
                optJSONObject = jSONObject.optJSONObject("eventParam");
                str = optJSONObject.optString("groupId");
            } catch (Exception e2) {
                str = "";
                e = e2;
            }
            try {
                String optString = optJSONObject.optString("groupImage");
                String optString2 = optJSONObject.optString("groupName");
                long optLong = optJSONObject.optLong("lastMsgId");
                v.c(TiebaApplication.C(), str, true);
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(str);
                imMessageCenterPojo.setGroup_head(optString);
                imMessageCenterPojo.setGroup_name(optString2);
                imMessageCenterPojo.setIs_delete(0);
                imMessageCenterPojo.setLast_content_time(groupNewsPojo.getTime());
                imMessageCenterPojo.setIs_hidden(0);
                imMessageCenterPojo.setUnread_count(0);
                imMessageCenterPojo.setLast_msgId(aa.b(optLong));
                imMessageCenterPojo.setPulled_msgId(aa.b(optLong));
                com.baidu.tieba.im.db.n.a().a(imMessageCenterPojo, new d(imMessageCenterPojo));
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                LinkedList<String> linkedList = new LinkedList<>();
                linkedList.add(str);
                com.baidu.tieba.im.db.a.a().a(linkedList, (com.baidu.tieba.im.a<Void>) null);
                com.baidu.adp.lib.h.d.d("save apply approved data: " + groupNewsPojo.toString());
            }
            LinkedList<String> linkedList2 = new LinkedList<>();
            linkedList2.add(str);
            com.baidu.tieba.im.db.a.a().a(linkedList2, (com.baidu.tieba.im.a<Void>) null);
            com.baidu.adp.lib.h.d.d("save apply approved data: " + groupNewsPojo.toString());
        }
    }

    public static void a(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.m.a(new e(z), aVar);
    }

    public static void a(boolean z) {
        int a2 = com.baidu.tieba.im.db.g.a().a("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change", 1);
        if (-1 == a2) {
            g().g = null;
            return;
        }
        if (g().g == null) {
            g().g = new RecentChatFriendData();
            g().g.setOwnerName(String.valueOf(3));
        }
        RecentChatFriendData recentChatFriendData = g().g;
        recentChatFriendData.setUnReadCount(a2);
        g().b(a2);
        List<UpdatesItemData> a3 = com.baidu.tieba.im.groupUpdates.m.a(com.baidu.tieba.im.db.g.a().a(0L, 1, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change"));
        if (a3 == null || a3.isEmpty()) {
            com.baidu.adp.lib.h.d.d(" groupupdates is null or empty");
            g().g = null;
            return;
        }
        com.baidu.adp.lib.h.d.d("得到群组动态消息+" + a2);
        UpdatesItemData updatesItemData = a3.get(0);
        recentChatFriendData.setFriendId(String.valueOf(3));
        recentChatFriendData.setFriendName(TiebaApplication.g().getApplicationContext().getString(R.string.group_updates));
        recentChatFriendData.setMsgContent(updatesItemData.getContent());
        recentChatFriendData.setOwnerName(String.valueOf(3));
        recentChatFriendData.setOwnerId(TiebaApplication.C());
        recentChatFriendData.setServerTime(updatesItemData.getTime());
        String updatesType = updatesItemData.getUpdatesType();
        g().c(updatesItemData.getContent());
        if (z) {
            a(updatesItemData, updatesType);
        }
        com.baidu.tieba.sharedPref.b.a().b("is_show_updates", true);
        g().a();
        l.post(new f(updatesItemData.getNotice_id()));
    }

    public synchronized void b(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.adp.lib.h.d.d(" get recent isNeedShowNotify:" + z);
        x.a().a(new h(this, z, aVar));
    }

    private void a(ae aeVar) {
        if (aeVar != null) {
            HashMap<String, String> j = aeVar.j();
            Set<String> keySet = j.keySet();
            if (keySet.size() != 1) {
                aeVar.b((String) null);
            } else {
                aeVar.b(j.get(keySet.iterator().next()));
            }
        }
    }

    private boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || imMessageCenterPojo.getGroup_type() == 1 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getLast_content_time() <= 0 || TextUtils.isEmpty(imMessageCenterPojo.getLast_content())) ? false : true;
    }

    private void a(RecentChatFriendData recentChatFriendData, ae aeVar) {
        if (recentChatFriendData != null) {
            String friendId = recentChatFriendData.getFriendId();
            if (!TextUtils.isEmpty(friendId)) {
                if ((!MsglistActivity.f1401a || !friendId.equals(MsglistActivity.b)) && !TextUtils.isEmpty(recentChatFriendData.getMsgContent())) {
                    HashMap<String, String> j = aeVar.j();
                    boolean b = v.b(TiebaApplication.C(), friendId);
                    com.baidu.adp.lib.h.d.d("isNofity:" + b + " gid:" + friendId + "count:" + recentChatFriendData.getUnReadCount());
                    if (!b) {
                        aeVar.d(aeVar.e() + recentChatFriendData.getUnReadCount());
                        return;
                    }
                    com.baidu.adp.lib.h.d.d("lastContent:" + recentChatFriendData.getMsgContent());
                    if (recentChatFriendData.getUnReadCount() > 0) {
                        aeVar.a(recentChatFriendData.getMsgContent());
                        String friendName = recentChatFriendData.getFriendName();
                        j.put(friendId, friendName);
                        com.baidu.adp.lib.h.d.d("p.getGid:" + friendId + " gname:" + friendName + " unread_count:" + recentChatFriendData.getUnReadCount());
                    }
                    aeVar.a(aeVar.b() + recentChatFriendData.getUnReadCount());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        if (concurrentHashMap != null) {
            Set<String> keySet = concurrentHashMap.keySet();
            if (keySet != null) {
                int size = keySet.size();
                ae aeVar = new ae();
                aeVar.a();
                aeVar.a(z);
                try {
                    Iterator<String> it = keySet.iterator();
                    for (int i = 0; i < size; i++) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next)) {
                            ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(next);
                            com.baidu.adp.lib.h.d.d("=======lastPojo:" + imMessageCenterPojo.toString());
                            if (a(imMessageCenterPojo)) {
                                a(a(next, imMessageCenterPojo), aeVar);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                a(aeVar);
                int size2 = aeVar.j().size();
                com.baidu.adp.lib.h.d.d("======= after process groupMsg unReadGroupMsg:" + aeVar.b() + "  gidAndNameSize:" + size2 + " self unCount:" + aeVar.g() + " notNotify:" + aeVar.e());
                if (this.e != null) {
                    Iterator<RecentChatFriendData> it2 = this.e.iterator();
                    while (it2.hasNext()) {
                        RecentChatFriendData next2 = it2.next();
                        if (next2.getGroupSetting() == null) {
                            a(next2);
                        }
                    }
                    if (g().j) {
                        c(aeVar);
                    }
                    if (g().k) {
                        b(aeVar);
                    }
                    if (((aeVar.b() + aeVar.c()) + aeVar.d()) - aeVar.e() <= 0) {
                        aeVar.a(false);
                    }
                    com.baidu.adp.lib.h.d.d("=======unReadGroupMsg:" + aeVar.b() + "  gidAndNameSize:" + size2 + " self unCount:" + aeVar.g() + " notNotify:" + aeVar.e() + " isShowNotify:" + aeVar.f());
                    if (!TiebaApplication.g().ae() || TiebaApplication.g().R() <= 0) {
                        aeVar.a(0L);
                        aeVar.a(false);
                    }
                    t.a().b(aeVar);
                }
            }
        }
    }

    public void a(RecentChatFriendData recentChatFriendData) {
        if (recentChatFriendData != null) {
            GroupSettingItemData a2 = v.a(TiebaApplication.C(), recentChatFriendData.getFriendId());
            if (a2 != null) {
                recentChatFriendData.setGroupSetting(a2);
            }
        }
    }

    public void a(String str) {
        RecentChatFriendData recentChatFriendData;
        if (!TextUtils.isEmpty(str) && this.e != null) {
            Iterator<RecentChatFriendData> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    recentChatFriendData = null;
                    break;
                }
                recentChatFriendData = it.next();
                if (str.equals(recentChatFriendData.getFriendId())) {
                    break;
                }
            }
            a(recentChatFriendData);
        }
    }

    private void b(ae aeVar) {
        RecentChatFriendData recentChatFriendData = g().g;
        aeVar.e(t.a().t().c());
        if (recentChatFriendData != null) {
            long unReadCount = recentChatFriendData.getUnReadCount();
            String h = g().h();
            aeVar.b(unReadCount);
            if (unReadCount > 0) {
                aeVar.d(recentChatFriendData.getFriendName());
                aeVar.e(h);
            }
            com.baidu.adp.lib.h.d.d("updates Count:" + unReadCount + " updates summary:" + h);
            return;
        }
        aeVar.b(0L);
        com.baidu.adp.lib.h.d.d(" getUpdate is null0");
    }

    private void c(ae aeVar) {
        aeVar.f(t.a().t().d());
        RecentChatFriendData recentChatFriendData = g().f;
        if (recentChatFriendData != null) {
            long unReadCount = recentChatFriendData.getUnReadCount();
            String i = g().i();
            aeVar.c(unReadCount);
            if (unReadCount > 0) {
                aeVar.f(i);
                aeVar.c(recentChatFriendData.getFriendName());
            }
            com.baidu.adp.lib.h.d.d("validata Count:" + unReadCount + "validata summary:" + i);
            return;
        }
        aeVar.c(0L);
    }

    public void b(String str) {
        RecentChatFriendData recentChatFriendData;
        Iterator<RecentChatFriendData> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                recentChatFriendData = null;
                break;
            }
            recentChatFriendData = it.next();
            if (str.equals(recentChatFriendData.getFriendId())) {
                break;
            }
        }
        if (recentChatFriendData != null) {
            this.e.remove(recentChatFriendData);
        }
    }

    public void e() {
        if (this.e != null) {
            this.e.clear();
        }
    }

    private RecentChatFriendData a(String str, ImMessageCenterPojo imMessageCenterPojo) {
        RecentChatFriendData recentChatFriendData;
        if (!TextUtils.isEmpty(str) && imMessageCenterPojo != null) {
            Iterator<RecentChatFriendData> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    recentChatFriendData = null;
                    break;
                }
                recentChatFriendData = it.next();
                if (str.equals(recentChatFriendData.getFriendId())) {
                    break;
                }
            }
            if (recentChatFriendData == null) {
                if (imMessageCenterPojo.getIs_hidden() == 1) {
                    return null;
                }
                recentChatFriendData = new RecentChatFriendData();
                this.e.add(recentChatFriendData);
            } else if (imMessageCenterPojo.getIs_hidden() == 1) {
                this.e.remove(recentChatFriendData);
                return null;
            }
            recentChatFriendData.setFriendId(imMessageCenterPojo.getGid());
            recentChatFriendData.setOwnerId(TiebaApplication.C());
            recentChatFriendData.setFriendName(imMessageCenterPojo.getGroup_name());
            recentChatFriendData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
            recentChatFriendData.setOwnerName(String.valueOf(1));
            recentChatFriendData.setServerTime(imMessageCenterPojo.getLast_content_time());
            recentChatFriendData.setUnReadCount(imMessageCenterPojo.getUnread_count());
            recentChatFriendData.setLastMsgUserName(imMessageCenterPojo.getLast_user_name());
            if (TextUtils.isEmpty(imMessageCenterPojo.getLast_content())) {
                recentChatFriendData.setUnReadCount(0);
                return recentChatFriendData;
            }
            recentChatFriendData.setMsgContent(imMessageCenterPojo.getLast_content());
            return recentChatFriendData;
        }
        return null;
    }

    private static void a(UpdatesItemData updatesItemData, String str) {
        if (!TextUtils.isEmpty(str) && str.equals("group_name_change")) {
            String groupId = updatesItemData.getGroupId();
            if (!TextUtils.isEmpty(groupId)) {
                com.baidu.adp.lib.h.d.d("update msg group name" + updatesItemData.getGroupName());
                com.baidu.tieba.im.db.n.a().a(groupId, updatesItemData.getGroupName());
            }
        }
    }

    public static void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.m.a(new i(), aVar);
    }

    public static void f() {
        com.baidu.adp.lib.h.d.d("begin");
        int a2 = com.baidu.tieba.im.db.g.a().a("apply_join_group", 1);
        com.baidu.adp.lib.h.d.d(RConversation.COL_UNREAD_COUNT + a2);
        if (-1 == a2) {
            g().f = null;
            return;
        }
        if (g().f == null) {
            g().f = new RecentChatFriendData();
        }
        RecentChatFriendData recentChatFriendData = g().f;
        recentChatFriendData.setUnReadCount(a2);
        g().a(a2);
        List<ValidateItemData> a3 = com.baidu.tieba.im.validate.k.a(com.baidu.tieba.im.db.g.a().a(0L, 1, "apply_join_group"));
        if (a3 == null || a3.isEmpty()) {
            com.baidu.adp.lib.h.d.d("convertValidate is null");
            g().f = null;
            return;
        }
        com.baidu.adp.lib.h.d.d("convertValidate is not null");
        ValidateItemData validateItemData = a3.get(0);
        String str = validateItemData.getUserName() + TiebaApplication.g().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + validateItemData.getGroupName();
        recentChatFriendData.setFriendId(String.valueOf(2));
        recentChatFriendData.setFriendName(TiebaApplication.g().getApplicationContext().getString(R.string.valicate));
        recentChatFriendData.setMsgContent(str);
        recentChatFriendData.setOwnerName(String.valueOf(2));
        recentChatFriendData.setOwnerId(TiebaApplication.C());
        recentChatFriendData.setServerTime(validateItemData.getApplyTime());
        g().d(str);
        com.baidu.tieba.sharedPref.b.a().b("is_show_validate", true);
        g().b();
        l.post(new j(validateItemData.getNotice_id()));
        com.baidu.adp.lib.h.d.d(" new validate data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo;
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            boolean z2 = true;
            if (concurrentHashMap != null) {
                try {
                    imMessageCenterPojo = concurrentHashMap.get(n.a().d());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (imMessageCenterPojo != null) {
                    long parseLong = Long.parseLong(str);
                    com.baidu.adp.lib.h.d.d("curMid:" + parseLong + " p.getLast_msgId():" + imMessageCenterPojo.getLast_msgId());
                    if (imMessageCenterPojo != null) {
                        if (parseLong <= imMessageCenterPojo.getLast_msgId()) {
                            z = false;
                            z2 = z;
                            g().b(z2, new l());
                        }
                    }
                } else {
                    return;
                }
            }
            z = true;
            z2 = z;
            g().b(z2, new l());
        }
    }

    public static a g() {
        if (f1682a == null) {
            synchronized (a.class) {
                if (f1682a == null) {
                    f1682a = new a();
                }
            }
        }
        return f1682a;
    }

    public void b(long j) {
        this.m = j;
    }

    public String h() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public String i() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public LinkedList<RecentChatFriendData> j() {
        return this.e;
    }

    public RecentChatFriendData k() {
        return this.f;
    }

    public List<GroupUpdateMessage> l() {
        return this.i;
    }

    public void a(List<GroupUpdateMessage> list) {
        if (list != null) {
            if (this.i == null) {
                this.i = new LinkedList();
            }
            this.i.clear();
            this.i.addAll(list);
        }
    }

    public void b(RecentChatFriendData recentChatFriendData) {
        this.f = recentChatFriendData;
    }

    public RecentChatFriendData m() {
        return this.g;
    }

    public void c(RecentChatFriendData recentChatFriendData) {
        this.g = recentChatFriendData;
    }

    public boolean n() {
        return this.j;
    }

    public boolean o() {
        return this.k;
    }
}
