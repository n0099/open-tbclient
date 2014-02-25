package com.baidu.tieba.im.c;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.be;
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
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.im.messageCenter.g {
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
        com.baidu.tieba.im.messageCenter.e.a().a(-128, this);
    }

    public static void a() {
        GroupNewsPojo groupNewsPojo;
        com.baidu.adp.lib.util.f.e("begin");
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.c.a().a(0L, 1, 0, "kick_out");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String gid = groupNewsPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                com.baidu.tieba.im.util.d.a(gid);
            }
        }
    }

    public static void b() {
        GroupNewsPojo groupNewsPojo;
        String str;
        Exception e;
        long j = 0;
        com.baidu.adp.lib.util.f.e(" time:" + System.currentTimeMillis());
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.c.a().a(0L, 1, 0, "apply_join_success");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String content = groupNewsPojo.getContent();
            if (TextUtils.isEmpty(content)) {
                com.baidu.adp.lib.util.f.b("content is null");
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
                    j = optJSONObject.optLong("lastMsgId");
                    v.c(TiebaApplication.A(), str, true);
                    v.a(TiebaApplication.A(), str, true);
                    v.c(TiebaApplication.A(), str, true);
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(str);
                    imMessageCenterPojo.setGroup_head(optString);
                    imMessageCenterPojo.setGroup_name(optString2);
                    imMessageCenterPojo.setIs_delete(0);
                    imMessageCenterPojo.setLast_content_time(groupNewsPojo.getTime());
                    imMessageCenterPojo.setIs_hidden(0);
                    imMessageCenterPojo.setUnread_count(0);
                    imMessageCenterPojo.setLast_content(optString3);
                    imMessageCenterPojo.setLast_rid(be.b(j));
                    imMessageCenterPojo.setPulled_msgId(be.b(j));
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(imMessageCenterPojo.getGid(), 0L);
                    com.baidu.tieba.im.j.a(new b(linkedHashMap, imMessageCenterPojo), new c(imMessageCenterPojo));
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put(str, Long.valueOf(j));
                    com.baidu.tieba.im.j.a(new d(linkedHashMap2), null);
                    com.baidu.adp.lib.util.f.e("save apply approved data: " + groupNewsPojo.toString());
                }
            } catch (Exception e3) {
                str = "";
                e = e3;
            }
            LinkedHashMap linkedHashMap22 = new LinkedHashMap();
            linkedHashMap22.put(str, Long.valueOf(j));
            com.baidu.tieba.im.j.a(new d(linkedHashMap22), null);
            com.baidu.adp.lib.util.f.e("save apply approved data: " + groupNewsPojo.toString());
        }
    }

    public static void a(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.j.a(new e(z), aVar);
    }

    public static void a(String str, boolean z) {
        int a2 = com.baidu.tieba.im.db.c.a().a("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change", 1);
        int a3 = com.baidu.tieba.im.db.c.a().a("group_event_info", 1);
        if (-1 == a2) {
            f().g = null;
            return;
        }
        if (f().g == null) {
            f().g = new ImMessageCenterShowItemData();
            f().g.setOwnerName(String.valueOf(3));
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = f().g;
        imMessageCenterShowItemData.setUnReadCount(a2);
        imMessageCenterShowItemData.setUnReadCountExtra(a3);
        List<UpdatesItemData> a4 = com.baidu.tieba.im.groupUpdates.m.a(com.baidu.tieba.im.db.c.a().a(0L, 1, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change"));
        if (a4 == null || a4.isEmpty()) {
            com.baidu.adp.lib.util.f.e(" groupupdates is null or empty");
            f().g = null;
            return;
        }
        com.baidu.adp.lib.util.f.e("得到群组动态消息+" + a2);
        UpdatesItemData updatesItemData = a4.get(0);
        imMessageCenterShowItemData.setFriendId(String.valueOf(3));
        imMessageCenterShowItemData.setFriendName(TiebaApplication.g().b().getApplicationContext().getString(R.string.group_updates));
        imMessageCenterShowItemData.setTitle(updatesItemData.getTitle());
        imMessageCenterShowItemData.setMsgContent(updatesItemData.getContent());
        imMessageCenterShowItemData.setOwnerName(String.valueOf(3));
        imMessageCenterShowItemData.setOwnerId(TiebaApplication.A());
        imMessageCenterShowItemData.setServerTime(updatesItemData.getTime());
        String updatesType = updatesItemData.getUpdatesType();
        f().c(updatesItemData.getContent());
        if (z) {
            a(updatesItemData, updatesType);
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("dismiss_group")) {
                c();
            } else if (str.equals("kick_out")) {
                a();
            }
        }
        com.baidu.tieba.sharedPref.b.a().b("is_show_updates", true);
        com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.im.message.n(updatesItemData.getNotice_id()));
    }

    public static void c() {
        GroupNewsPojo groupNewsPojo;
        com.baidu.adp.lib.util.f.e("dismiss begin");
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.c.a().a(0L, 1, 0, "dismiss_group");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String gid = groupNewsPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                com.baidu.tieba.im.util.d.a(gid);
            }
        }
    }

    public synchronized void b(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.adp.lib.util.f.e(" get recent isNeedShowNotify:" + z);
        a(z, com.baidu.tieba.im.db.h.a().d());
        if (aVar != null) {
            aVar.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null || imMessageCenterPojo.getGroup_type() == 1) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        return ((!TextUtils.isEmpty(gid) && gid.equals(Integer.valueOf(q.a))) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getLast_content_time() <= 0 || TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getGroup_type() == 7 || imMessageCenterPojo.getGroup_type() == 8) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, ah ahVar) {
        if (imMessageCenterShowItemData != null) {
            String friendId = imMessageCenterShowItemData.getFriendId();
            if (!TextUtils.isEmpty(friendId)) {
                if (!GroupChatActivity.a || !friendId.equals(GroupChatActivity.b)) {
                    if ((!PersonalChatActivity.a || !friendId.equals(PersonalChatActivity.b)) && !TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                        String ownerName = imMessageCenterShowItemData.getOwnerName();
                        if (!TextUtils.isEmpty(ownerName)) {
                            if (ownerName.equals(String.valueOf(4))) {
                                a(imMessageCenterShowItemData, ahVar, friendId);
                            } else if (ownerName.equals(String.valueOf(1))) {
                                b(imMessageCenterShowItemData, ahVar, friendId);
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData, ah ahVar, String str) {
        HashMap<String, String> r = ahVar.r();
        boolean b = com.baidu.tieba.im.chat.personaltalk.a.b(TiebaApplication.A(), str);
        com.baidu.adp.lib.util.f.e("isNofity:" + b + " gid:" + str + "count:" + imMessageCenterShowItemData.getUnReadCount());
        if (b) {
            com.baidu.adp.lib.util.f.e("lastContent:" + imMessageCenterShowItemData.getMsgContent());
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                ahVar.i(imMessageCenterShowItemData.getMsgContent());
                String friendName = imMessageCenterShowItemData.getFriendName();
                com.baidu.adp.lib.util.f.e("p.getGid:" + str + " gname:" + friendName + " unread_count:" + imMessageCenterShowItemData.getUnReadCount());
                r.put(str, friendName);
            }
            ahVar.h(ahVar.p() + imMessageCenterShowItemData.getUnReadCount());
        }
    }

    private void b(ImMessageCenterShowItemData imMessageCenterShowItemData, ah ahVar, String str) {
        HashMap<String, String> m = ahVar.m();
        boolean b = v.b(TiebaApplication.A(), str);
        com.baidu.adp.lib.util.f.e("isNofity:" + b + " gid:" + str + "count:" + imMessageCenterShowItemData.getUnReadCount());
        if (!b) {
            ahVar.e(ahVar.g() + imMessageCenterShowItemData.getUnReadCount());
        } else {
            com.baidu.adp.lib.util.f.e("lastContent:" + imMessageCenterShowItemData.getMsgContent());
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                ahVar.a(imMessageCenterShowItemData.getMsgContent());
                String friendName = imMessageCenterShowItemData.getFriendName();
                m.put(str, friendName);
                com.baidu.adp.lib.util.f.e("p.getGid:" + str + " gname:" + friendName + " unread_count:" + imMessageCenterShowItemData.getUnReadCount());
            }
        }
        ahVar.a(ahVar.c() + imMessageCenterShowItemData.getUnReadCount());
    }

    private synchronized void a(boolean z, com.baidu.tieba.im.db.d dVar) {
        this.d.clear();
        if (dVar != null) {
            ah ahVar = new ah();
            ahVar.a(z);
            dVar.a(new f(this, ahVar));
            ahVar.a();
            ahVar.b();
            if (this.d != null) {
                Iterator<ImMessageCenterShowItemData> it = this.d.iterator();
                while (it.hasNext()) {
                    ImMessageCenterShowItemData next = it.next();
                    if (next.getGroupSetting() == null) {
                        a(next);
                    }
                }
                if (f().m()) {
                    b(ahVar);
                }
                if (f().n()) {
                    a(ahVar);
                }
                if ((((ahVar.p() + ahVar.c()) + ahVar.d()) + ahVar.f()) - ahVar.g() <= 0) {
                    ahVar.a(false);
                }
                if (!TiebaApplication.g().Y()) {
                    ahVar.a(0);
                }
                if (!TiebaApplication.g().X()) {
                    ahVar.h(0);
                }
                if (TiebaApplication.g().M() <= 0) {
                    ahVar.a(0);
                    ahVar.h(0);
                    ahVar.a(false);
                }
                if (!TiebaApplication.g().X() || TiebaApplication.g().M() <= 0) {
                    ahVar.h(0);
                    ahVar.a(false);
                }
                com.baidu.tieba.mention.v.a().b(ahVar);
            }
        }
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData != null) {
            String friendId = imMessageCenterShowItemData.getFriendId();
            if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                PersonalSettingItemData a2 = com.baidu.tieba.im.chat.personaltalk.a.a(TiebaApplication.A(), friendId);
                if (a2 != null) {
                    imMessageCenterShowItemData.setGroupSetting(a2);
                    this.e.put(imMessageCenterShowItemData.getFriendId(), a2);
                    return;
                }
                return;
            }
            GroupSettingItemData a3 = v.a(TiebaApplication.A(), friendId);
            if (a3 != null) {
                imMessageCenterShowItemData.setGroupSetting(a3);
                this.e.put(imMessageCenterShowItemData.getFriendId(), a3);
            }
        }
    }

    public void a(String str) {
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
            a(imMessageCenterShowItemData);
        }
    }

    private void a(ah ahVar) {
        ImMessageCenterShowItemData imMessageCenterShowItemData = f().g;
        ahVar.f(com.baidu.tieba.mention.v.a().u().d());
        if (imMessageCenterShowItemData != null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            int unReadCountExtra = imMessageCenterShowItemData.getUnReadCountExtra();
            String g = f().g();
            ahVar.b(unReadCount);
            ahVar.c(unReadCountExtra);
            if (unReadCount > 0) {
                ahVar.d(imMessageCenterShowItemData.getFriendName());
                ahVar.g(g);
            }
            if (unReadCountExtra > 0) {
                ahVar.e(imMessageCenterShowItemData.getTitle());
                ahVar.f(imMessageCenterShowItemData.getMsgContent());
            }
            com.baidu.adp.lib.util.f.e("updates Count:" + unReadCount + " updates summary:" + g);
            return;
        }
        ahVar.b(0);
        com.baidu.adp.lib.util.f.e(" getUpdate is null0");
    }

    private void b(ah ahVar) {
        ahVar.g(com.baidu.tieba.mention.v.a().u().f());
        ImMessageCenterShowItemData imMessageCenterShowItemData = f().f;
        if (imMessageCenterShowItemData != null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            String h = f().h();
            ahVar.d(unReadCount);
            if (unReadCount > 0) {
                ahVar.h(h);
                ahVar.c(imMessageCenterShowItemData.getFriendName());
            }
            com.baidu.adp.lib.util.f.e("validata Count:" + unReadCount + "validata summary:" + h);
            return;
        }
        ahVar.d(0);
    }

    public void b(String str) {
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

    public void d() {
        if (this.d != null) {
            this.d.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterShowItemData a(String str, ImMessageCenterPojo imMessageCenterPojo) {
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (!TextUtils.isEmpty(str) && imMessageCenterPojo != null) {
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
            if (imMessageCenterShowItemData == null) {
                if (imMessageCenterPojo.getIs_hidden() == 1) {
                    return null;
                }
                imMessageCenterShowItemData = new ImMessageCenterShowItemData();
                this.d.add(imMessageCenterShowItemData);
            } else if (imMessageCenterPojo.getIs_hidden() == 1) {
                this.d.remove(imMessageCenterShowItemData);
                return null;
            }
            imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
            imMessageCenterShowItemData.setOwnerId(TiebaApplication.A());
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

    private static void a(UpdatesItemData updatesItemData, String str) {
        if (!TextUtils.isEmpty(str) && str.equals("group_name_change")) {
            String groupId = updatesItemData.getGroupId();
            if (!TextUtils.isEmpty(groupId)) {
                com.baidu.adp.lib.util.f.e("update msg group name" + updatesItemData.getGroupName());
                com.baidu.tieba.im.util.d.a(groupId, updatesItemData.getGroupName());
            }
        }
    }

    public static void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.j.a(new g(), aVar);
    }

    public static void e() {
        com.baidu.adp.lib.util.f.e("begin");
        int a2 = com.baidu.tieba.im.db.c.a().a("apply_join_group", 1);
        com.baidu.adp.lib.util.f.e("unReadCount" + a2);
        if (-1 == a2) {
            f().f = null;
            return;
        }
        if (f().f == null) {
            f().f = new ImMessageCenterShowItemData();
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = f().f;
        imMessageCenterShowItemData.setUnReadCount(a2);
        List<ValidateItemData> a3 = com.baidu.tieba.im.validate.l.a(com.baidu.tieba.im.db.c.a().a(0L, 1, 0, "apply_join_group"));
        if (a3 == null || a3.isEmpty()) {
            com.baidu.adp.lib.util.f.e("convertValidate is null");
            f().f = null;
            return;
        }
        com.baidu.adp.lib.util.f.e("convertValidate is not null");
        ValidateItemData validateItemData = a3.get(0);
        String str = String.valueOf(validateItemData.getUserName()) + TiebaApplication.g().b().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + validateItemData.getGroupName();
        imMessageCenterShowItemData.setFriendId(String.valueOf(2));
        imMessageCenterShowItemData.setFriendName(TiebaApplication.g().b().getApplicationContext().getString(R.string.valicate));
        imMessageCenterShowItemData.setMsgContent(str);
        imMessageCenterShowItemData.setOwnerName(String.valueOf(2));
        imMessageCenterShowItemData.setOwnerId(TiebaApplication.A());
        imMessageCenterShowItemData.setServerTime(validateItemData.getApplyTime());
        f().d(str);
        com.baidu.tieba.sharedPref.b.a().b("is_show_validate", true);
        com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.im.message.n(validateItemData.getNotice_id()));
        com.baidu.adp.lib.util.f.e(" new validate data");
    }

    private static void a(String str, com.baidu.tieba.im.db.d dVar) {
        if (!TextUtils.isEmpty(str)) {
            boolean z = true;
            if (dVar != null) {
                try {
                    ImMessageCenterPojo a2 = dVar.a(j.a().e());
                    if (a2 != null) {
                        long parseLong = Long.parseLong(str);
                        com.baidu.adp.lib.util.f.e("curMid:" + parseLong + " p.getLast_rid():" + a2.getLast_rid());
                        if (a2 != null) {
                            if (parseLong <= a2.getLast_rid()) {
                                z = false;
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            f().b(z, new h());
        }
    }

    public static synchronized a f() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public String g() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String h() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }

    public LinkedList<ImMessageCenterShowItemData> i() {
        return this.d;
    }

    public ImMessageCenterShowItemData j() {
        return this.f;
    }

    public List<GroupUpdateMessage> k() {
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

    public i e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.e.get(str);
    }

    public void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.f = imMessageCenterShowItemData;
    }

    public ImMessageCenterShowItemData l() {
        return this.g;
    }

    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.g = imMessageCenterShowItemData;
    }

    public boolean m() {
        return com.baidu.tieba.sharedPref.b.a().a("is_show_validate", true);
    }

    public boolean n() {
        return com.baidu.tieba.sharedPref.b.a().a("is_show_updates", true);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(s sVar) {
        switch (sVar.w()) {
            case -128:
                if (sVar instanceof com.baidu.tieba.im.message.n) {
                    a(((com.baidu.tieba.im.message.n) sVar).a(), com.baidu.tieba.im.db.h.a().d());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
