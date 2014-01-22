package com.baidu.tieba.im.c;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.ba;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.db.ae;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.validate.ValidateItemData;
import com.baidu.tieba.mention.ad;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a a;
    private static Handler m = new Handler();
    private String c;
    private String d;
    private RecentChatFriendData g;
    private RecentChatFriendData h;
    private List<GroupUpdateMessage> j;
    private long b = 0;
    private LinkedList<RecentChatFriendData> e = new LinkedList<>();
    private ConcurrentHashMap<String, k> f = new ConcurrentHashMap<>();
    private ad i = new ad();
    private boolean k = false;
    private boolean l = false;
    private long n = 0;

    public void a(long j) {
        this.b = j;
    }

    private a() {
        b();
        a();
    }

    public void a() {
        this.l = com.baidu.tieba.sharedPref.b.a().a("is_show_updates", true);
    }

    public void b() {
        this.k = com.baidu.tieba.sharedPref.b.a().a("is_show_validate", true);
    }

    public static void c() {
        GroupNewsPojo groupNewsPojo;
        com.baidu.adp.lib.g.e.d("begin");
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
        JSONObject jSONObject;
        JSONObject optJSONObject;
        long j = 0;
        com.baidu.adp.lib.g.e.d(" time:" + System.currentTimeMillis());
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.l.a().a(0L, 1, 0, "apply_join_success");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String content = groupNewsPojo.getContent();
            if (TextUtils.isEmpty(content)) {
                com.baidu.adp.lib.g.e.a("content is null");
                return;
            }
            try {
                jSONObject = new JSONObject(content);
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
                String optString3 = jSONObject.optString("userMsg");
                j = optJSONObject.optLong("lastMsgId");
                com.baidu.tieba.im.groupInfo.u.c(TiebaApplication.A(), str, true);
                com.baidu.tieba.im.groupInfo.u.a(TiebaApplication.A(), str, true);
                com.baidu.tieba.im.groupInfo.u.c(TiebaApplication.A(), str, true);
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(str);
                imMessageCenterPojo.setGroup_head(optString);
                imMessageCenterPojo.setGroup_name(optString2);
                imMessageCenterPojo.setIs_delete(0);
                imMessageCenterPojo.setLast_content_time(groupNewsPojo.getTime());
                imMessageCenterPojo.setIs_hidden(0);
                imMessageCenterPojo.setUnread_count(0);
                imMessageCenterPojo.setLast_content(optString3);
                imMessageCenterPojo.setLast_rid(ba.b(j));
                imMessageCenterPojo.setPulled_msgId(ba.b(j));
                com.baidu.tieba.im.db.t.a().a(imMessageCenterPojo, new b(imMessageCenterPojo));
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put(str, Long.valueOf(j));
                com.baidu.tieba.im.db.d.a().a(linkedHashMap, (com.baidu.tieba.im.a<Void>) null);
                com.baidu.adp.lib.g.e.d("save apply approved data: " + groupNewsPojo.toString());
            }
            LinkedHashMap<String, Long> linkedHashMap2 = new LinkedHashMap<>();
            linkedHashMap2.put(str, Long.valueOf(j));
            com.baidu.tieba.im.db.d.a().a(linkedHashMap2, (com.baidu.tieba.im.a<Void>) null);
            com.baidu.adp.lib.g.e.d("save apply approved data: " + groupNewsPojo.toString());
        }
    }

    public static void a(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.m.a(new c(z), aVar);
    }

    public static void a(boolean z) {
        int a2 = com.baidu.tieba.im.db.l.a().a("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info", 1);
        int a3 = com.baidu.tieba.im.db.l.a().a("group_event_info", 1);
        if (-1 == a2) {
            h().h = null;
            return;
        }
        if (h().h == null) {
            h().h = new RecentChatFriendData();
            h().h.setOwnerName(String.valueOf(3));
        }
        RecentChatFriendData recentChatFriendData = h().h;
        recentChatFriendData.setUnReadCount(a2);
        recentChatFriendData.setUnReadCountExtra(a3);
        h().b(a2);
        List<UpdatesItemData> a4 = com.baidu.tieba.im.groupUpdates.m.a(com.baidu.tieba.im.db.l.a().a(0L, 1, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info"));
        if (a4 == null || a4.isEmpty()) {
            com.baidu.adp.lib.g.e.d(" groupupdates is null or empty");
            h().h = null;
            return;
        }
        com.baidu.adp.lib.g.e.d("得到群组动态消息+" + a2);
        UpdatesItemData updatesItemData = a4.get(0);
        recentChatFriendData.setFriendId(String.valueOf(3));
        recentChatFriendData.setFriendName(TiebaApplication.h().getApplicationContext().getString(R.string.group_updates));
        recentChatFriendData.setTitle(updatesItemData.getTitle());
        recentChatFriendData.setMsgContent(updatesItemData.getContent());
        recentChatFriendData.setOwnerName(String.valueOf(3));
        recentChatFriendData.setOwnerId(TiebaApplication.A());
        recentChatFriendData.setServerTime(updatesItemData.getTime());
        String updatesType = updatesItemData.getUpdatesType();
        h().c(updatesItemData.getContent());
        if (z) {
            a(updatesItemData, updatesType);
        }
        com.baidu.tieba.sharedPref.b.a().b("is_show_updates", true);
        h().a();
        m.post(new d(updatesItemData.getNotice_id()));
    }

    public static void e() {
        GroupNewsPojo groupNewsPojo;
        com.baidu.adp.lib.g.e.d("dismiss begin");
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.l.a().a(0L, 1, 0, "dismiss_group");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String gid = groupNewsPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                com.baidu.tieba.im.db.a.a(gid);
            }
        }
    }

    public synchronized void b(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.adp.lib.g.e.d(" get recent isNeedShowNotify:" + z);
        ae.a().a(new f(this, z, aVar));
    }

    private boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null || imMessageCenterPojo.getGroup_type() == 1) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        return ((!TextUtils.isEmpty(gid) && gid.equals(Integer.valueOf(com.baidu.tieba.im.chat.q.a))) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getLast_content_time() <= 0 || TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getGroup_type() == 7) ? false : true;
    }

    private void a(RecentChatFriendData recentChatFriendData, ad adVar) {
        if (recentChatFriendData != null) {
            String friendId = recentChatFriendData.getFriendId();
            if (!TextUtils.isEmpty(friendId)) {
                if (!GroupChatActivity.a || !friendId.equals(GroupChatActivity.b)) {
                    if ((!PersonalChatActivity.a || !friendId.equals(PersonalChatActivity.b)) && !TextUtils.isEmpty(recentChatFriendData.getMsgContent())) {
                        String ownerName = recentChatFriendData.getOwnerName();
                        if (!TextUtils.isEmpty(ownerName)) {
                            if (ownerName.equals(String.valueOf(4))) {
                                a(recentChatFriendData, adVar, friendId);
                            } else if (ownerName.equals(String.valueOf(1))) {
                                b(recentChatFriendData, adVar, friendId);
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(RecentChatFriendData recentChatFriendData, ad adVar, String str) {
        HashMap<String, String> s = adVar.s();
        boolean b = com.baidu.tieba.im.chat.personaltalk.a.b(TiebaApplication.A(), str);
        com.baidu.adp.lib.g.e.d("isNofity:" + b + " gid:" + str + "count:" + recentChatFriendData.getUnReadCount());
        if (b) {
            com.baidu.adp.lib.g.e.d("lastContent:" + recentChatFriendData.getMsgContent());
            if (recentChatFriendData.getUnReadCount() > 0) {
                adVar.i(recentChatFriendData.getMsgContent());
                String friendName = recentChatFriendData.getFriendName();
                com.baidu.adp.lib.g.e.d("p.getGid:" + str + " gname:" + friendName + " unread_count:" + recentChatFriendData.getUnReadCount());
                s.put(str, friendName);
            }
            adVar.h(adVar.q() + recentChatFriendData.getUnReadCount());
        }
    }

    private void b(RecentChatFriendData recentChatFriendData, ad adVar, String str) {
        HashMap<String, String> n = adVar.n();
        boolean b = com.baidu.tieba.im.groupInfo.u.b(TiebaApplication.A(), str);
        com.baidu.adp.lib.g.e.d("isNofity:" + b + " gid:" + str + "count:" + recentChatFriendData.getUnReadCount());
        if (!b) {
            adVar.e(adVar.h() + recentChatFriendData.getUnReadCount());
        } else {
            com.baidu.adp.lib.g.e.d("lastContent:" + recentChatFriendData.getMsgContent());
            if (recentChatFriendData.getUnReadCount() > 0) {
                adVar.a(recentChatFriendData.getMsgContent());
                String friendName = recentChatFriendData.getFriendName();
                n.put(str, friendName);
                com.baidu.adp.lib.g.e.d("p.getGid:" + str + " gname:" + friendName + " unread_count:" + recentChatFriendData.getUnReadCount());
            }
        }
        adVar.a(adVar.d() + recentChatFriendData.getUnReadCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        Set<String> keySet;
        this.e.clear();
        if (concurrentHashMap != null && (keySet = concurrentHashMap.keySet()) != null) {
            int size = keySet.size();
            ad adVar = new ad();
            adVar.a();
            adVar.a(z);
            try {
                Iterator<String> it = keySet.iterator();
                for (int i = 0; i < size; i++) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(next);
                        com.baidu.adp.lib.g.e.d("=======lastPojo:" + imMessageCenterPojo.toString());
                        if (a(imMessageCenterPojo)) {
                            a(a(next, imMessageCenterPojo), adVar);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            adVar.b();
            adVar.c();
            if (this.e != null) {
                Iterator<RecentChatFriendData> it2 = this.e.iterator();
                while (it2.hasNext()) {
                    RecentChatFriendData next2 = it2.next();
                    if (next2.getGroupSetting() == null) {
                        a(next2);
                    }
                }
                if (h().k) {
                    b(adVar);
                }
                if (h().l) {
                    a(adVar);
                }
                if ((((adVar.q() + adVar.d()) + adVar.e()) + adVar.g()) - adVar.h() <= 0) {
                    adVar.a(false);
                }
                if (!TiebaApplication.h().Z()) {
                    adVar.a(0);
                }
                if (!TiebaApplication.h().Y()) {
                    adVar.h(0);
                }
                if (TiebaApplication.h().M() <= 0) {
                    adVar.a(0);
                    adVar.h(0);
                    adVar.a(false);
                }
                if (!TiebaApplication.h().Y() || TiebaApplication.h().M() <= 0) {
                    adVar.h(0);
                    adVar.a(false);
                }
                com.baidu.tieba.mention.s.a().b(adVar);
            }
        }
    }

    public void a(RecentChatFriendData recentChatFriendData) {
        if (recentChatFriendData != null) {
            String friendId = recentChatFriendData.getFriendId();
            if (String.valueOf(4).equals(recentChatFriendData.getOwnerName())) {
                PersonalSettingItemData a2 = com.baidu.tieba.im.chat.personaltalk.a.a(TiebaApplication.A(), friendId);
                if (a2 != null) {
                    recentChatFriendData.setGroupSetting(a2);
                    this.f.put(recentChatFriendData.getFriendId(), a2);
                    return;
                }
                return;
            }
            GroupSettingItemData a3 = com.baidu.tieba.im.groupInfo.u.a(TiebaApplication.A(), friendId);
            if (a3 != null) {
                recentChatFriendData.setGroupSetting(a3);
                this.f.put(recentChatFriendData.getFriendId(), a3);
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

    private void a(ad adVar) {
        RecentChatFriendData recentChatFriendData = h().h;
        adVar.f(com.baidu.tieba.mention.s.a().u().e());
        if (recentChatFriendData != null) {
            int unReadCount = recentChatFriendData.getUnReadCount();
            int unReadCountExtra = recentChatFriendData.getUnReadCountExtra();
            String i = h().i();
            adVar.b(unReadCount);
            adVar.c(unReadCountExtra);
            if (unReadCount > 0) {
                adVar.d(recentChatFriendData.getFriendName());
                adVar.g(i);
            }
            if (unReadCountExtra > 0) {
                adVar.e(recentChatFriendData.getTitle());
                adVar.f(recentChatFriendData.getMsgContent());
            }
            com.baidu.adp.lib.g.e.d("updates Count:" + unReadCount + " updates summary:" + i);
            return;
        }
        adVar.b(0);
        com.baidu.adp.lib.g.e.d(" getUpdate is null0");
    }

    private void b(ad adVar) {
        adVar.g(com.baidu.tieba.mention.s.a().u().g());
        RecentChatFriendData recentChatFriendData = h().g;
        if (recentChatFriendData != null) {
            int unReadCount = recentChatFriendData.getUnReadCount();
            String j = h().j();
            adVar.d(unReadCount);
            if (unReadCount > 0) {
                adVar.h(j);
                adVar.c(recentChatFriendData.getFriendName());
            }
            com.baidu.adp.lib.g.e.d("validata Count:" + unReadCount + "validata summary:" + j);
            return;
        }
        adVar.d(0);
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
            recentChatFriendData.setOwnerId(TiebaApplication.A());
            recentChatFriendData.setFriendName(imMessageCenterPojo.getGroup_name());
            recentChatFriendData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
            if (imMessageCenterPojo.getGroup_type() == 6) {
                recentChatFriendData.setOwnerName(String.valueOf(4));
            } else {
                recentChatFriendData.setOwnerName(String.valueOf(1));
            }
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
                com.baidu.adp.lib.g.e.d("update msg group name" + updatesItemData.getGroupName());
                com.baidu.tieba.im.db.t.a().a(groupId, updatesItemData.getGroupName());
            }
        }
    }

    public static void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.m.a(new g(), aVar);
    }

    public static void g() {
        com.baidu.adp.lib.g.e.d("begin");
        int a2 = com.baidu.tieba.im.db.l.a().a("apply_join_group", 1);
        com.baidu.adp.lib.g.e.d("unReadCount" + a2);
        if (-1 == a2) {
            h().g = null;
            return;
        }
        if (h().g == null) {
            h().g = new RecentChatFriendData();
        }
        RecentChatFriendData recentChatFriendData = h().g;
        recentChatFriendData.setUnReadCount(a2);
        h().a(a2);
        List<ValidateItemData> a3 = com.baidu.tieba.im.validate.l.a(com.baidu.tieba.im.db.l.a().a(0L, 1, 0, "apply_join_group"));
        if (a3 == null || a3.isEmpty()) {
            com.baidu.adp.lib.g.e.d("convertValidate is null");
            h().g = null;
            return;
        }
        com.baidu.adp.lib.g.e.d("convertValidate is not null");
        ValidateItemData validateItemData = a3.get(0);
        String str = validateItemData.getUserName() + TiebaApplication.h().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + validateItemData.getGroupName();
        recentChatFriendData.setFriendId(String.valueOf(2));
        recentChatFriendData.setFriendName(TiebaApplication.h().getApplicationContext().getString(R.string.valicate));
        recentChatFriendData.setMsgContent(str);
        recentChatFriendData.setOwnerName(String.valueOf(2));
        recentChatFriendData.setOwnerId(TiebaApplication.A());
        recentChatFriendData.setServerTime(validateItemData.getApplyTime());
        h().d(str);
        com.baidu.tieba.sharedPref.b.a().b("is_show_validate", true);
        h().b();
        m.post(new h(validateItemData.getNotice_id()));
        com.baidu.adp.lib.g.e.d(" new validate data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo;
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            boolean z2 = true;
            if (concurrentHashMap != null) {
                try {
                    imMessageCenterPojo = concurrentHashMap.get(m.a().d());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (imMessageCenterPojo != null) {
                    long parseLong = Long.parseLong(str);
                    com.baidu.adp.lib.g.e.d("curMid:" + parseLong + " p.getLast_rid():" + imMessageCenterPojo.getLast_rid());
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

    public static synchronized a h() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public void b(long j) {
        this.n = j;
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
        return this.g;
    }

    public List<GroupUpdateMessage> m() {
        return this.j;
    }

    public void a(List<GroupUpdateMessage> list) {
        if (list != null) {
            if (this.j == null) {
                this.j = new LinkedList();
            }
            this.j.clear();
            this.j.addAll(list);
        }
    }

    public k e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f.get(str);
    }

    public void b(RecentChatFriendData recentChatFriendData) {
        this.g = recentChatFriendData;
    }

    public RecentChatFriendData n() {
        return this.h;
    }

    public void c(RecentChatFriendData recentChatFriendData) {
        this.h = recentChatFriendData;
    }

    public boolean o() {
        return this.k;
    }

    public boolean p() {
        return this.l;
    }
}
