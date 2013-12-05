package com.baidu.tieba.im.pushNotify;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.ac;
import com.baidu.tieba.im.db.ad;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.t;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.groupInfo.u;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.validate.ValidateItemData;
import com.baidu.tieba.mention.ae;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.conversation.RConversation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1857a;
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
        com.baidu.adp.lib.h.e.d("begin");
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.l.a().a(0L, 1, 0, "kick_out");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String gid = groupNewsPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                com.baidu.tieba.im.db.a.a(gid);
            }
        }
    }

    public static void d() {
        GroupNewsPojo groupNewsPojo;
        String str;
        Exception e;
        com.baidu.adp.lib.h.e.d(" time:" + System.currentTimeMillis());
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.l.a().a(0L, 1, 0, "apply_join_success");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String content = groupNewsPojo.getContent();
            if (TextUtils.isEmpty(content)) {
                com.baidu.adp.lib.h.e.a("content is null");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                jSONObject.put("notice_id", groupNewsPojo.getNotice_id());
                JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                str = optJSONObject.optString("groupId");
                try {
                    String optString = optJSONObject.optString("groupImage");
                    String optString2 = optJSONObject.optString("groupName");
                    String optString3 = jSONObject.optString("userMsg");
                    long optLong = optJSONObject.optLong("lastMsgId");
                    u.c(TiebaApplication.B(), str, true);
                    u.a(TiebaApplication.B(), str, true);
                    u.c(TiebaApplication.B(), str, true);
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(str);
                    imMessageCenterPojo.setGroup_head(optString);
                    imMessageCenterPojo.setGroup_name(optString2);
                    imMessageCenterPojo.setIs_delete(0);
                    imMessageCenterPojo.setLast_content_time(groupNewsPojo.getTime());
                    imMessageCenterPojo.setIs_hidden(0);
                    imMessageCenterPojo.setUnread_count(0);
                    imMessageCenterPojo.setLast_content(optString3);
                    imMessageCenterPojo.setLast_rid(ac.b(optLong));
                    imMessageCenterPojo.setPulled_msgId(ac.b(optLong));
                    t.a().a(imMessageCenterPojo, new b(imMessageCenterPojo));
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    LinkedList<String> linkedList = new LinkedList<>();
                    linkedList.add(str);
                    com.baidu.tieba.im.db.d.a().a(linkedList, (com.baidu.tieba.im.a<Void>) null);
                    com.baidu.adp.lib.h.e.d("save apply approved data: " + groupNewsPojo.toString());
                }
            } catch (Exception e3) {
                str = "";
                e = e3;
            }
            LinkedList<String> linkedList2 = new LinkedList<>();
            linkedList2.add(str);
            com.baidu.tieba.im.db.d.a().a(linkedList2, (com.baidu.tieba.im.a<Void>) null);
            com.baidu.adp.lib.h.e.d("save apply approved data: " + groupNewsPojo.toString());
        }
    }

    public static void a(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.m.a(new c(z), aVar);
    }

    public static void a(boolean z) {
        int a2 = com.baidu.tieba.im.db.l.a().a("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out", 1);
        if (-1 == a2) {
            h().g = null;
            return;
        }
        if (h().g == null) {
            h().g = new RecentChatFriendData();
            h().g.setOwnerName(String.valueOf(3));
        }
        RecentChatFriendData recentChatFriendData = h().g;
        recentChatFriendData.setUnReadCount(a2);
        h().b(a2);
        List<UpdatesItemData> a3 = com.baidu.tieba.im.groupUpdates.m.a(com.baidu.tieba.im.db.l.a().a(0L, 1, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out"));
        if (a3 == null || a3.isEmpty()) {
            com.baidu.adp.lib.h.e.d(" groupupdates is null or empty");
            h().g = null;
            return;
        }
        com.baidu.adp.lib.h.e.d("得到群组动态消息+" + a2);
        UpdatesItemData updatesItemData = a3.get(0);
        recentChatFriendData.setFriendId(String.valueOf(3));
        recentChatFriendData.setFriendName(TiebaApplication.h().getApplicationContext().getString(R.string.group_updates));
        recentChatFriendData.setMsgContent(updatesItemData.getContent());
        recentChatFriendData.setOwnerName(String.valueOf(3));
        recentChatFriendData.setOwnerId(TiebaApplication.B());
        recentChatFriendData.setServerTime(updatesItemData.getTime());
        String updatesType = updatesItemData.getUpdatesType();
        h().c(updatesItemData.getContent());
        if (z) {
            a(updatesItemData, updatesType);
        }
        com.baidu.tieba.sharedPref.b.a().b("is_show_updates", true);
        h().a();
        l.post(new d(updatesItemData.getNotice_id()));
    }

    public static void e() {
        GroupNewsPojo groupNewsPojo;
        com.baidu.adp.lib.h.e.d("dismiss begin");
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.l.a().a(0L, 1, 0, "dismiss_group");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String gid = groupNewsPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                com.baidu.tieba.im.db.a.a(gid);
            }
        }
    }

    public synchronized void b(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.adp.lib.h.e.d(" get recent isNeedShowNotify:" + z);
        ad.a().a(new f(this, z, aVar));
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
                if ((!MsglistActivity.f1534a || !friendId.equals(MsglistActivity.b)) && !TextUtils.isEmpty(recentChatFriendData.getMsgContent())) {
                    HashMap<String, String> j = aeVar.j();
                    boolean b = u.b(TiebaApplication.B(), friendId);
                    com.baidu.adp.lib.h.e.d("isNofity:" + b + " gid:" + friendId + "count:" + recentChatFriendData.getUnReadCount());
                    if (!b) {
                        aeVar.d(aeVar.e() + recentChatFriendData.getUnReadCount());
                        return;
                    }
                    com.baidu.adp.lib.h.e.d("lastContent:" + recentChatFriendData.getMsgContent());
                    if (recentChatFriendData.getUnReadCount() > 0) {
                        aeVar.a(recentChatFriendData.getMsgContent());
                        String friendName = recentChatFriendData.getFriendName();
                        j.put(friendId, friendName);
                        com.baidu.adp.lib.h.e.d("p.getGid:" + friendId + " gname:" + friendName + " unread_count:" + recentChatFriendData.getUnReadCount());
                    }
                    aeVar.a(aeVar.b() + recentChatFriendData.getUnReadCount());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        Set<String> keySet;
        this.e.clear();
        if (concurrentHashMap != null && (keySet = concurrentHashMap.keySet()) != null) {
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
                        com.baidu.adp.lib.h.e.d("=======lastPojo:" + imMessageCenterPojo.toString());
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
            com.baidu.adp.lib.h.e.d("======= after process groupMsg unReadGroupMsg:" + aeVar.b() + "  gidAndNameSize:" + size2 + " self unCount:" + aeVar.g() + " notNotify:" + aeVar.e());
            if (this.e != null) {
                Iterator<RecentChatFriendData> it2 = this.e.iterator();
                while (it2.hasNext()) {
                    RecentChatFriendData next2 = it2.next();
                    if (next2.getGroupSetting() == null) {
                        a(next2);
                    }
                }
                if (h().j) {
                    c(aeVar);
                }
                if (h().k) {
                    b(aeVar);
                }
                if (((aeVar.b() + aeVar.c()) + aeVar.d()) - aeVar.e() <= 0) {
                    aeVar.a(false);
                }
                com.baidu.adp.lib.h.e.d("=======unReadGroupMsg:" + aeVar.b() + "  gidAndNameSize:" + size2 + " self unCount:" + aeVar.g() + " notNotify:" + aeVar.e() + " isShowNotify:" + aeVar.f());
                if (!TiebaApplication.h().aa() || TiebaApplication.h().N() <= 0) {
                    aeVar.a(0L);
                    aeVar.a(false);
                }
                com.baidu.tieba.mention.t.a().b(aeVar);
            }
        }
    }

    public void a(RecentChatFriendData recentChatFriendData) {
        if (recentChatFriendData != null) {
            GroupSettingItemData a2 = u.a(TiebaApplication.B(), recentChatFriendData.getFriendId());
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
        RecentChatFriendData recentChatFriendData = h().g;
        aeVar.e(com.baidu.tieba.mention.t.a().t().c());
        if (recentChatFriendData != null) {
            long unReadCount = recentChatFriendData.getUnReadCount();
            String i = h().i();
            aeVar.b(unReadCount);
            if (unReadCount > 0) {
                aeVar.d(recentChatFriendData.getFriendName());
                aeVar.e(i);
            }
            com.baidu.adp.lib.h.e.d("updates Count:" + unReadCount + " updates summary:" + i);
            return;
        }
        aeVar.b(0L);
        com.baidu.adp.lib.h.e.d(" getUpdate is null0");
    }

    private void c(ae aeVar) {
        aeVar.f(com.baidu.tieba.mention.t.a().t().d());
        RecentChatFriendData recentChatFriendData = h().f;
        if (recentChatFriendData != null) {
            long unReadCount = recentChatFriendData.getUnReadCount();
            String j = h().j();
            aeVar.c(unReadCount);
            if (unReadCount > 0) {
                aeVar.f(j);
                aeVar.c(recentChatFriendData.getFriendName());
            }
            com.baidu.adp.lib.h.e.d("validata Count:" + unReadCount + "validata summary:" + j);
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

    public void f() {
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
            recentChatFriendData.setOwnerId(TiebaApplication.B());
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
                com.baidu.adp.lib.h.e.d("update msg group name" + updatesItemData.getGroupName());
                t.a().a(groupId, updatesItemData.getGroupName());
            }
        }
    }

    public static void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.m.a(new g(), aVar);
    }

    public static void g() {
        com.baidu.adp.lib.h.e.d("begin");
        int a2 = com.baidu.tieba.im.db.l.a().a("apply_join_group", 1);
        com.baidu.adp.lib.h.e.d(RConversation.COL_UNREAD_COUNT + a2);
        if (-1 == a2) {
            h().f = null;
            return;
        }
        if (h().f == null) {
            h().f = new RecentChatFriendData();
        }
        RecentChatFriendData recentChatFriendData = h().f;
        recentChatFriendData.setUnReadCount(a2);
        h().a(a2);
        List<ValidateItemData> a3 = com.baidu.tieba.im.validate.l.a(com.baidu.tieba.im.db.l.a().a(0L, 1, 0, "apply_join_group"));
        if (a3 == null || a3.isEmpty()) {
            com.baidu.adp.lib.h.e.d("convertValidate is null");
            h().f = null;
            return;
        }
        com.baidu.adp.lib.h.e.d("convertValidate is not null");
        ValidateItemData validateItemData = a3.get(0);
        String str = validateItemData.getUserName() + TiebaApplication.h().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + validateItemData.getGroupName();
        recentChatFriendData.setFriendId(String.valueOf(2));
        recentChatFriendData.setFriendName(TiebaApplication.h().getApplicationContext().getString(R.string.valicate));
        recentChatFriendData.setMsgContent(str);
        recentChatFriendData.setOwnerName(String.valueOf(2));
        recentChatFriendData.setOwnerId(TiebaApplication.B());
        recentChatFriendData.setServerTime(validateItemData.getApplyTime());
        h().d(str);
        com.baidu.tieba.sharedPref.b.a().b("is_show_validate", true);
        h().b();
        l.post(new h(validateItemData.getNotice_id()));
        com.baidu.adp.lib.h.e.d(" new validate data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo;
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            boolean z2 = true;
            if (concurrentHashMap != null) {
                try {
                    imMessageCenterPojo = concurrentHashMap.get(l.a().d());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (imMessageCenterPojo != null) {
                    long parseLong = Long.parseLong(str);
                    com.baidu.adp.lib.h.e.d("curMid:" + parseLong + " p.getLast_rid():" + imMessageCenterPojo.getLast_rid());
                    if (imMessageCenterPojo != null) {
                        if (parseLong <= imMessageCenterPojo.getLast_rid()) {
                            z = false;
                            z2 = z;
                            h().b(z2, new j());
                        }
                    }
                } else {
                    return;
                }
            }
            z = true;
            z2 = z;
            h().b(z2, new j());
        }
    }

    public static a h() {
        if (f1857a == null) {
            synchronized (a.class) {
                if (f1857a == null) {
                    f1857a = new a();
                }
            }
        }
        return f1857a;
    }

    public void b(long j) {
        this.m = j;
    }

    public String i() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public String j() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public LinkedList<RecentChatFriendData> k() {
        return this.e;
    }

    public RecentChatFriendData l() {
        return this.f;
    }

    public List<GroupUpdateMessage> m() {
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

    public RecentChatFriendData n() {
        return this.g;
    }

    public void c(RecentChatFriendData recentChatFriendData) {
        this.g = recentChatFriendData;
    }

    public boolean o() {
        return this.j;
    }

    public boolean p() {
        return this.k;
    }
}
