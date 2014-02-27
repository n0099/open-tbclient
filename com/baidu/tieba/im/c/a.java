package com.baidu.tieba.im.c;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.groupInfo.v;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.validate.ValidateItemData;
import com.baidu.tieba.mention.ah;
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
public final class a implements com.baidu.tieba.im.messageCenter.g {
    private static a a;
    private String b;
    private String c;
    private ImMessageCenterShowItemData f;
    private ImMessageCenterShowItemData g;
    private List<GroupUpdateMessage> i;
    private LinkedList<ImMessageCenterShowItemData> d = new LinkedList<>();
    private final ConcurrentHashMap<String, i> e = new ConcurrentHashMap<>();
    private final ah h = new ah();

    private a() {
        com.baidu.tieba.im.messageCenter.d.a().a(-128, this);
    }

    public static void a() {
        GroupNewsPojo groupNewsPojo;
        String str;
        Exception e;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        long j = 0;
        com.baidu.adp.lib.util.e.e(" time:" + System.currentTimeMillis());
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.c.a().a(0L, 1, 0, "apply_join_success");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String content = groupNewsPojo.getContent();
            if (TextUtils.isEmpty(content)) {
                com.baidu.adp.lib.util.e.b("content is null");
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
                v.c(TiebaApplication.v(), str, true);
                v.a(TiebaApplication.v(), str, true);
                v.c(TiebaApplication.v(), str, true);
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(str);
                imMessageCenterPojo.setGroup_head(optString);
                imMessageCenterPojo.setGroup_name(optString2);
                imMessageCenterPojo.setIs_delete(0);
                imMessageCenterPojo.setLast_content_time(groupNewsPojo.getTime());
                imMessageCenterPojo.setIs_hidden(0);
                imMessageCenterPojo.setUnread_count(0);
                imMessageCenterPojo.setLast_content(optString3);
                imMessageCenterPojo.setLast_rid(j * 100);
                imMessageCenterPojo.setPulled_msgId(j * 100);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(imMessageCenterPojo.getGid(), 0L);
                com.baidu.tieba.im.i.a(new b(linkedHashMap, imMessageCenterPojo), new c(imMessageCenterPojo));
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put(str, Long.valueOf(j));
                com.baidu.tieba.im.i.a(new d(linkedHashMap2), null);
                com.baidu.adp.lib.util.e.e("save apply approved data: " + groupNewsPojo.toString());
            }
            LinkedHashMap linkedHashMap22 = new LinkedHashMap();
            linkedHashMap22.put(str, Long.valueOf(j));
            com.baidu.tieba.im.i.a(new d(linkedHashMap22), null);
            com.baidu.adp.lib.util.e.e("save apply approved data: " + groupNewsPojo.toString());
        }
    }

    public static void a(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.i.a(new e(false), null);
    }

    public static void a(String str, boolean z) {
        GroupNewsPojo groupNewsPojo;
        GroupNewsPojo groupNewsPojo2;
        int a2 = com.baidu.tieba.im.db.c.a().a("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change", 1);
        int a3 = com.baidu.tieba.im.db.c.a().a("group_event_info", 1);
        if (-1 == a2) {
            d().g = null;
            return;
        }
        if (d().g == null) {
            d().g = new ImMessageCenterShowItemData();
            d().g.setOwnerName(String.valueOf(3));
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = d().g;
        imMessageCenterShowItemData.setUnReadCount(a2);
        imMessageCenterShowItemData.setUnReadCountExtra(a3);
        List<UpdatesItemData> a4 = com.baidu.tieba.im.groupUpdates.m.a(com.baidu.tieba.im.db.c.a().a(0L, 1, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change"));
        if (a4 == null || a4.isEmpty()) {
            com.baidu.adp.lib.util.e.e(" groupupdates is null or empty");
            d().g = null;
            return;
        }
        com.baidu.adp.lib.util.e.e("得到群组动态消息+" + a2);
        UpdatesItemData updatesItemData = a4.get(0);
        imMessageCenterShowItemData.setFriendId(String.valueOf(3));
        imMessageCenterShowItemData.setFriendName(TiebaApplication.g().b().getApplicationContext().getString(R.string.group_updates));
        imMessageCenterShowItemData.setTitle(updatesItemData.getTitle());
        imMessageCenterShowItemData.setMsgContent(updatesItemData.getContent());
        imMessageCenterShowItemData.setOwnerName(String.valueOf(3));
        imMessageCenterShowItemData.setOwnerId(TiebaApplication.v());
        imMessageCenterShowItemData.setServerTime(updatesItemData.getTime());
        String updatesType = updatesItemData.getUpdatesType();
        d().c = updatesItemData.getContent();
        if (z && !TextUtils.isEmpty(updatesType) && updatesType.equals("group_name_change")) {
            String groupId = updatesItemData.getGroupId();
            if (!TextUtils.isEmpty(groupId)) {
                com.baidu.adp.lib.util.e.e("update msg group name" + updatesItemData.getGroupName());
                com.baidu.tieba.im.util.d.a(groupId, updatesItemData.getGroupName());
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("dismiss_group")) {
                com.baidu.adp.lib.util.e.e("dismiss begin");
                LinkedList<GroupNewsPojo> a5 = com.baidu.tieba.im.db.c.a().a(0L, 1, 0, "dismiss_group");
                if (a5 != null && !a5.isEmpty() && (groupNewsPojo2 = a5.get(0)) != null) {
                    String gid = groupNewsPojo2.getGid();
                    if (!TextUtils.isEmpty(gid)) {
                        com.baidu.tieba.im.util.d.a(gid);
                    }
                }
            } else if (str.equals("kick_out")) {
                com.baidu.adp.lib.util.e.e("begin");
                LinkedList<GroupNewsPojo> a6 = com.baidu.tieba.im.db.c.a().a(0L, 1, 0, "kick_out");
                if (a6 != null && !a6.isEmpty() && (groupNewsPojo = a6.get(0)) != null) {
                    String gid2 = groupNewsPojo.getGid();
                    if (!TextUtils.isEmpty(gid2)) {
                        com.baidu.tieba.im.util.d.a(gid2);
                    }
                }
            }
        }
        com.baidu.tieba.sharedPref.b.a().b("is_show_updates", true);
        com.baidu.tieba.im.messageCenter.d.a().d(new com.baidu.tieba.im.message.n(updatesItemData.getNotice_id()));
    }

    public final synchronized void b(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.adp.lib.util.e.e(" get recent isNeedShowNotify:" + z);
        a(z, com.baidu.tieba.im.db.h.a().d());
        if (aVar != null) {
            aVar.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(a aVar, ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null || imMessageCenterPojo.getGroup_type() == 1) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        return ((!TextUtils.isEmpty(gid) && gid.equals(Integer.valueOf(q.a))) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getLast_content_time() <= 0 || TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getGroup_type() == 7 || imMessageCenterPojo.getGroup_type() == 8) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData, ah ahVar) {
        if (imMessageCenterShowItemData != null) {
            String friendId = imMessageCenterShowItemData.getFriendId();
            if (TextUtils.isEmpty(friendId)) {
                return;
            }
            if (GroupChatActivity.a && friendId.equals(GroupChatActivity.b)) {
                return;
            }
            if ((PersonalChatActivity.a && friendId.equals(PersonalChatActivity.b)) || TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                return;
            }
            String ownerName = imMessageCenterShowItemData.getOwnerName();
            if (TextUtils.isEmpty(ownerName)) {
                return;
            }
            if (ownerName.equals(String.valueOf(4))) {
                HashMap<String, String> p = ahVar.p();
                boolean b = com.baidu.tieba.im.chat.personaltalk.a.b(TiebaApplication.v(), friendId);
                com.baidu.adp.lib.util.e.e("isNofity:" + b + " gid:" + friendId + "count:" + imMessageCenterShowItemData.getUnReadCount());
                if (b) {
                    com.baidu.adp.lib.util.e.e("lastContent:" + imMessageCenterShowItemData.getMsgContent());
                    if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                        ahVar.i(imMessageCenterShowItemData.getMsgContent());
                        String friendName = imMessageCenterShowItemData.getFriendName();
                        com.baidu.adp.lib.util.e.e("p.getGid:" + friendId + " gname:" + friendName + " unread_count:" + imMessageCenterShowItemData.getUnReadCount());
                        p.put(friendId, friendName);
                    }
                    ahVar.h(ahVar.n() + imMessageCenterShowItemData.getUnReadCount());
                }
            } else if (ownerName.equals(String.valueOf(1))) {
                HashMap<String, String> k = ahVar.k();
                boolean b2 = v.b(TiebaApplication.v(), friendId);
                com.baidu.adp.lib.util.e.e("isNofity:" + b2 + " gid:" + friendId + "count:" + imMessageCenterShowItemData.getUnReadCount());
                if (b2) {
                    com.baidu.adp.lib.util.e.e("lastContent:" + imMessageCenterShowItemData.getMsgContent());
                    if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                        ahVar.a(imMessageCenterShowItemData.getMsgContent());
                        String friendName2 = imMessageCenterShowItemData.getFriendName();
                        k.put(friendId, friendName2);
                        com.baidu.adp.lib.util.e.e("p.getGid:" + friendId + " gname:" + friendName2 + " unread_count:" + imMessageCenterShowItemData.getUnReadCount());
                    }
                } else {
                    ahVar.e(ahVar.e() + imMessageCenterShowItemData.getUnReadCount());
                }
                ahVar.a(ahVar.a() + imMessageCenterShowItemData.getUnReadCount());
            }
        }
    }

    private synchronized void a(boolean z, com.baidu.tieba.im.db.d dVar) {
        this.d.clear();
        if (dVar != null) {
            ah ahVar = new ah();
            ahVar.a(z);
            dVar.a(new f(this, ahVar));
            HashMap<String, String> k = ahVar.k();
            Set<String> keySet = k.keySet();
            if (keySet.size() != 1) {
                ahVar.b((String) null);
            } else {
                ahVar.b(k.get(keySet.iterator().next()));
            }
            HashMap<String, String> p = ahVar.p();
            Set<String> keySet2 = p.keySet();
            if (keySet2.size() != 1) {
                ahVar.j(null);
            } else {
                ahVar.j(p.get(keySet2.iterator().next()));
            }
            if (this.d != null) {
                Iterator<ImMessageCenterShowItemData> it = this.d.iterator();
                while (it.hasNext()) {
                    ImMessageCenterShowItemData next = it.next();
                    if (next.getGroupSetting() == null) {
                        c(next);
                    }
                }
                d();
                if (i()) {
                    ahVar.g(com.baidu.tieba.mention.v.a().r().d());
                    ImMessageCenterShowItemData imMessageCenterShowItemData = d().f;
                    if (imMessageCenterShowItemData != null) {
                        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
                        String str = d().b;
                        ahVar.d(unReadCount);
                        if (unReadCount > 0) {
                            ahVar.h(str);
                            ahVar.c(imMessageCenterShowItemData.getFriendName());
                        }
                        com.baidu.adp.lib.util.e.e("validata Count:" + unReadCount + "validata summary:" + str);
                    } else {
                        ahVar.d(0);
                    }
                }
                d();
                if (j()) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData2 = d().g;
                    ahVar.f(com.baidu.tieba.mention.v.a().r().b());
                    if (imMessageCenterShowItemData2 != null) {
                        int unReadCount2 = imMessageCenterShowItemData2.getUnReadCount();
                        int unReadCountExtra = imMessageCenterShowItemData2.getUnReadCountExtra();
                        String str2 = d().c;
                        ahVar.b(unReadCount2);
                        ahVar.c(unReadCountExtra);
                        if (unReadCount2 > 0) {
                            ahVar.d(imMessageCenterShowItemData2.getFriendName());
                            ahVar.g(str2);
                        }
                        if (unReadCountExtra > 0) {
                            ahVar.e(imMessageCenterShowItemData2.getTitle());
                            ahVar.f(imMessageCenterShowItemData2.getMsgContent());
                        }
                        com.baidu.adp.lib.util.e.e("updates Count:" + unReadCount2 + " updates summary:" + str2);
                    } else {
                        ahVar.b(0);
                        com.baidu.adp.lib.util.e.e(new StringBuilder(" getUpdate is null0").toString());
                    }
                }
                if ((((ahVar.n() + ahVar.a()) + ahVar.b()) + ahVar.d()) - ahVar.e() <= 0) {
                    ahVar.a(false);
                }
                if (!TiebaApplication.g().S()) {
                    ahVar.a(0);
                }
                if (!TiebaApplication.g().R()) {
                    ahVar.h(0);
                }
                if (TiebaApplication.g().G() <= 0) {
                    ahVar.a(0);
                    ahVar.h(0);
                    ahVar.a(false);
                }
                if (!TiebaApplication.g().R() || TiebaApplication.g().G() <= 0) {
                    ahVar.h(0);
                    ahVar.a(false);
                }
                com.baidu.tieba.mention.v.a().a(ahVar);
            }
        }
    }

    private void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData != null) {
            String friendId = imMessageCenterShowItemData.getFriendId();
            if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                PersonalSettingItemData a2 = com.baidu.tieba.im.chat.personaltalk.a.a(TiebaApplication.v(), friendId);
                if (a2 != null) {
                    imMessageCenterShowItemData.setGroupSetting(a2);
                    this.e.put(imMessageCenterShowItemData.getFriendId(), a2);
                    return;
                }
                return;
            }
            GroupSettingItemData a3 = v.a(TiebaApplication.v(), friendId);
            if (a3 != null) {
                imMessageCenterShowItemData.setGroupSetting(a3);
                this.e.put(imMessageCenterShowItemData.getFriendId(), a3);
            }
        }
    }

    public final void a(String str) {
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (!TextUtils.isEmpty(str) && this.d != null) {
            Iterator<ImMessageCenterShowItemData> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    imMessageCenterShowItemData = null;
                    break;
                }
                imMessageCenterShowItemData = it.next();
                if (str.equals(imMessageCenterShowItemData.getFriendId())) {
                    break;
                }
            }
            c(imMessageCenterShowItemData);
        }
    }

    public final void b(String str) {
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        Iterator<ImMessageCenterShowItemData> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                imMessageCenterShowItemData = null;
                break;
            }
            imMessageCenterShowItemData = it.next();
            if (str.equals(imMessageCenterShowItemData.getFriendId())) {
                break;
            }
        }
        if (imMessageCenterShowItemData != null) {
            this.d.remove(imMessageCenterShowItemData);
        }
    }

    public final void b() {
        if (this.d != null) {
            this.d.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ImMessageCenterShowItemData a(a aVar, String str, ImMessageCenterPojo imMessageCenterPojo) {
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (!TextUtils.isEmpty(str) && imMessageCenterPojo != null) {
            Iterator<ImMessageCenterShowItemData> it = aVar.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    imMessageCenterShowItemData = null;
                    break;
                }
                imMessageCenterShowItemData = it.next();
                if (str.equals(imMessageCenterShowItemData.getFriendId())) {
                    break;
                }
            }
            if (imMessageCenterShowItemData == null) {
                if (imMessageCenterPojo.getIs_hidden() == 1) {
                    return null;
                }
                imMessageCenterShowItemData = new ImMessageCenterShowItemData();
                aVar.d.add(imMessageCenterShowItemData);
            } else if (imMessageCenterPojo.getIs_hidden() == 1) {
                aVar.d.remove(imMessageCenterShowItemData);
                return null;
            }
            imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
            imMessageCenterShowItemData.setOwnerId(TiebaApplication.v());
            imMessageCenterShowItemData.setFriendName(imMessageCenterPojo.getGroup_name());
            imMessageCenterShowItemData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
            if (imMessageCenterPojo.getGroup_type() == 6) {
                imMessageCenterShowItemData.setOwnerName(String.valueOf(4));
            } else {
                imMessageCenterShowItemData.setOwnerName(String.valueOf(1));
            }
            imMessageCenterShowItemData.setServerTime(imMessageCenterPojo.getLast_content_time());
            imMessageCenterShowItemData.setUnReadCount(imMessageCenterPojo.getUnread_count());
            if (TextUtils.isEmpty(imMessageCenterPojo.getLast_content())) {
                imMessageCenterShowItemData.setUnReadCount(0);
                return imMessageCenterShowItemData;
            }
            imMessageCenterShowItemData.setMsgContent(imMessageCenterPojo.getLast_content());
            return imMessageCenterShowItemData;
        }
        return null;
    }

    public static void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.i.a(new g(), null);
    }

    public static void c() {
        com.baidu.adp.lib.util.e.e("begin");
        int a2 = com.baidu.tieba.im.db.c.a().a("apply_join_group", 1);
        com.baidu.adp.lib.util.e.e("unReadCount" + a2);
        if (-1 == a2) {
            d().f = null;
            return;
        }
        if (d().f == null) {
            d().f = new ImMessageCenterShowItemData();
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = d().f;
        imMessageCenterShowItemData.setUnReadCount(a2);
        List<ValidateItemData> a3 = com.baidu.tieba.im.validate.l.a(com.baidu.tieba.im.db.c.a().a(0L, 1, 0, "apply_join_group"));
        if (a3 == null || a3.isEmpty()) {
            com.baidu.adp.lib.util.e.e("convertValidate is null");
            d().f = null;
            return;
        }
        com.baidu.adp.lib.util.e.e("convertValidate is not null");
        ValidateItemData validateItemData = a3.get(0);
        String str = String.valueOf(validateItemData.getUserName()) + TiebaApplication.g().b().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + validateItemData.getGroupName();
        imMessageCenterShowItemData.setFriendId(String.valueOf(2));
        imMessageCenterShowItemData.setFriendName(TiebaApplication.g().b().getApplicationContext().getString(R.string.valicate));
        imMessageCenterShowItemData.setMsgContent(str);
        imMessageCenterShowItemData.setOwnerName(String.valueOf(2));
        imMessageCenterShowItemData.setOwnerId(TiebaApplication.v());
        imMessageCenterShowItemData.setServerTime(validateItemData.getApplyTime());
        d().b = str;
        com.baidu.tieba.sharedPref.b.a().b("is_show_validate", true);
        com.baidu.tieba.im.messageCenter.d.a().d(new com.baidu.tieba.im.message.n(validateItemData.getNotice_id()));
        com.baidu.adp.lib.util.e.e(" new validate data");
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public final LinkedList<ImMessageCenterShowItemData> e() {
        return this.d;
    }

    public final ImMessageCenterShowItemData f() {
        return this.f;
    }

    public final List<GroupUpdateMessage> g() {
        return this.i;
    }

    public final void a(List<GroupUpdateMessage> list) {
        if (list != null) {
            if (this.i == null) {
                this.i = new LinkedList();
            }
            this.i.clear();
            this.i.addAll(list);
        }
    }

    public final i c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.e.get(str);
    }

    public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.f = imMessageCenterShowItemData;
    }

    public final ImMessageCenterShowItemData h() {
        return this.g;
    }

    public final void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.g = imMessageCenterShowItemData;
    }

    public static boolean i() {
        return com.baidu.tieba.sharedPref.b.a().a("is_show_validate", true);
    }

    public static boolean j() {
        return com.baidu.tieba.sharedPref.b.a().a("is_show_updates", true);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        switch (sVar.w()) {
            case -128:
                if (sVar instanceof com.baidu.tieba.im.message.n) {
                    String a2 = ((com.baidu.tieba.im.message.n) sVar).a();
                    com.baidu.tieba.im.db.d d = com.baidu.tieba.im.db.h.a().d();
                    if (!TextUtils.isEmpty(a2)) {
                        boolean z = true;
                        if (d != null) {
                            try {
                                ImMessageCenterPojo a3 = d.a(j.a().e());
                                if (a3 == null) {
                                    return;
                                }
                                long parseLong = Long.parseLong(a2);
                                com.baidu.adp.lib.util.e.e("curMid:" + parseLong + " p.getLast_rid():" + a3.getLast_rid());
                                if (a3 != null) {
                                    if (parseLong <= a3.getLast_rid()) {
                                        z = false;
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        d().b(z, new h());
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
