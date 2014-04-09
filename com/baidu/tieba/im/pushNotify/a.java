package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialSettingItemData;
import com.baidu.tieba.im.chat.officialBar.bb;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.groupInfo.aa;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.ImSystemShowNotifyMessage;
import com.baidu.tieba.im.r;
import com.baidu.tieba.im.validate.ValidateItemData;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    private static a a;
    private String b;
    private String c;
    private ImMessageCenterShowItemData f;
    private ImMessageCenterShowItemData g;
    private ImMessageCenterShowItemData h;
    private List<GroupUpdateMessage> j;
    private LinkedList<ImMessageCenterShowItemData> d = new LinkedList<>();
    private LinkedList<ImMessageCenterShowItemData> e = new LinkedList<>();
    private final com.baidu.tbadk.coreExtra.b.c i = new com.baidu.tbadk.coreExtra.b.c();
    private com.baidu.adp.framework.c.a k = new b(this, 2001128);

    private a() {
        com.baidu.adp.framework.c.a().a(this.k);
    }

    public static void a() {
        GroupNewsPojo groupNewsPojo;
        String str;
        Exception e;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        long j = 0;
        com.baidu.adp.lib.util.f.e(" time:" + System.currentTimeMillis());
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "apply_join_success");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String content = groupNewsPojo.getContent();
            if (TextUtils.isEmpty(content)) {
                com.baidu.adp.lib.util.f.b("content is null");
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
                aa.a().b(TbadkApplication.E(), str, true);
                aa.a().a(TbadkApplication.E(), str, true);
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
                com.baidu.tbadk.coreExtra.messageCenter.d.a().b(com.baidu.adp.lib.f.b.a(str, 0), j);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(imMessageCenterPojo.getGid(), 0L);
                r.a(new c(linkedHashMap, imMessageCenterPojo), new d(imMessageCenterPojo));
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put(str, Long.valueOf(j));
                r.a(new e(linkedHashMap2), null);
                com.baidu.adp.lib.util.f.e("save apply approved data: " + groupNewsPojo.toString());
            }
            LinkedHashMap linkedHashMap22 = new LinkedHashMap();
            linkedHashMap22.put(str, Long.valueOf(j));
            r.a(new e(linkedHashMap22), null);
            com.baidu.adp.lib.util.f.e("save apply approved data: " + groupNewsPojo.toString());
        }
    }

    public static void a(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        r.a(new f(false), null);
    }

    public static void a(String str, boolean z) {
        GroupNewsPojo groupNewsPojo;
        GroupNewsPojo groupNewsPojo2;
        int a2 = com.baidu.tieba.im.db.d.a().a("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change", 1);
        int a3 = com.baidu.tieba.im.db.d.a().a("group_event_info", 1);
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
        List<UpdatesItemData> a4 = com.baidu.tieba.im.groupUpdates.p.a(com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change"));
        if (a4 == null || a4.isEmpty()) {
            com.baidu.adp.lib.util.f.e(" groupupdates is null or empty");
            d().g = null;
            return;
        }
        com.baidu.adp.lib.util.f.e("得到群组动态消息+" + a2);
        UpdatesItemData updatesItemData = a4.get(0);
        imMessageCenterShowItemData.setFriendId(String.valueOf(3));
        imMessageCenterShowItemData.setFriendName(TbadkApplication.j().b().getApplicationContext().getString(com.baidu.tieba.im.j.group_updates));
        imMessageCenterShowItemData.setTitle(updatesItemData.getTitle());
        imMessageCenterShowItemData.setMsgContent(updatesItemData.getContent());
        imMessageCenterShowItemData.setOwnerName(String.valueOf(3));
        imMessageCenterShowItemData.setOwnerId(TbadkApplication.E());
        imMessageCenterShowItemData.setServerTime(updatesItemData.getTime());
        String updatesType = updatesItemData.getUpdatesType();
        d().c = updatesItemData.getContent();
        if (z && !TextUtils.isEmpty(updatesType) && updatesType.equals("group_name_change")) {
            String groupId = updatesItemData.getGroupId();
            if (!TextUtils.isEmpty(groupId)) {
                com.baidu.adp.lib.util.f.e("update msg group name" + updatesItemData.getGroupName());
                com.baidu.tieba.im.f.h.a(groupId, updatesItemData.getGroupName());
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("dismiss_group")) {
                com.baidu.adp.lib.util.f.e("dismiss begin");
                LinkedList<GroupNewsPojo> a5 = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "dismiss_group");
                if (a5 != null && !a5.isEmpty() && (groupNewsPojo2 = a5.get(0)) != null) {
                    String gid = groupNewsPojo2.getGid();
                    if (!TextUtils.isEmpty(gid)) {
                        com.baidu.tieba.im.f.h.a(gid);
                    }
                }
            } else if (str.equals("kick_out")) {
                com.baidu.adp.lib.util.f.e("begin");
                LinkedList<GroupNewsPojo> a6 = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "kick_out");
                if (a6 != null && !a6.isEmpty() && (groupNewsPojo = a6.get(0)) != null) {
                    String gid2 = groupNewsPojo.getGid();
                    if (!TextUtils.isEmpty(gid2)) {
                        com.baidu.tieba.im.f.h.a(gid2);
                    }
                }
            }
        }
        com.baidu.tbadk.core.sharedPref.b.a().b("is_show_updates", true);
        com.baidu.adp.framework.c.a().b(new ImSystemShowNotifyMessage(updatesItemData.getNotice_id()));
    }

    public final synchronized void a(boolean z, boolean z2, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.adp.lib.util.f.e(" get recent isNeedShowNotify:" + z);
        a(z, z2);
        if (aVar != null) {
            aVar.a(null);
        }
    }

    public final synchronized void b(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        a(z, false, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(a aVar, ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() == 0) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        return ((!TextUtils.isEmpty(gid) && gid.equals(Integer.valueOf(x.a))) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getLast_content_time() <= 0 || TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getCustomGroupType() == 3 || imMessageCenterPojo.getCustomGroupType() == 5) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tbadk.coreExtra.b.c cVar) {
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
                HashMap<String, String> y = cVar.y();
                boolean d = com.baidu.tieba.im.chat.personaltalk.a.a().d(TbadkApplication.E(), friendId);
                com.baidu.adp.lib.util.f.e("isNofity:" + d + " gid:" + friendId + "count:" + imMessageCenterShowItemData.getUnReadCount());
                if (d) {
                    com.baidu.adp.lib.util.f.e("lastContent:" + imMessageCenterShowItemData.getMsgContent());
                    if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                        cVar.j(imMessageCenterShowItemData.getMsgContent());
                        String friendName = imMessageCenterShowItemData.getFriendName();
                        com.baidu.adp.lib.util.f.e("p.getGid:" + friendId + " gname:" + friendName + " unread_count:" + imMessageCenterShowItemData.getUnReadCount());
                        y.put(friendId, friendName);
                    }
                    cVar.l(cVar.w() + imMessageCenterShowItemData.getUnReadCount());
                }
            } else if (ownerName.equals(String.valueOf(1))) {
                HashMap<String, String> s = cVar.s();
                boolean d2 = aa.a().d(TbadkApplication.E(), friendId);
                com.baidu.adp.lib.util.f.e("isNofity:" + d2 + " gid:" + friendId + "count:" + imMessageCenterShowItemData.getUnReadCount());
                if (d2) {
                    com.baidu.adp.lib.util.f.e("lastContent:" + imMessageCenterShowItemData.getMsgContent());
                    if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                        cVar.c(imMessageCenterShowItemData.getMsgContent());
                        String friendName2 = imMessageCenterShowItemData.getFriendName();
                        s.put(friendId, friendName2);
                        com.baidu.adp.lib.util.f.e("p.getGid:" + friendId + " gname:" + friendName2 + " unread_count:" + imMessageCenterShowItemData.getUnReadCount());
                    }
                } else {
                    cVar.g(cVar.l() + imMessageCenterShowItemData.getUnReadCount());
                }
                cVar.a(cVar.c() + imMessageCenterShowItemData.getUnReadCount());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [594=4] */
    private synchronized void a(boolean z, boolean z2) {
        this.d.clear();
        this.e.clear();
        this.h = null;
        com.baidu.tbadk.coreExtra.b.c cVar = new com.baidu.tbadk.coreExtra.b.c();
        cVar.a(z);
        cVar.b(z2);
        com.baidu.tieba.im.b.e.a(new g(this, cVar));
        cVar.a();
        cVar.b();
        cVar.f(com.baidu.tbadk.coreExtra.messageCenter.a.a().p().w());
        cVar.h(com.baidu.tbadk.coreExtra.messageCenter.a.a().p().i());
        Iterator<ImMessageCenterShowItemData> it = this.d.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        Iterator<ImMessageCenterShowItemData> it2 = this.e.iterator();
        while (it2.hasNext()) {
            c(it2.next());
        }
        d();
        if (l()) {
            cVar.j(com.baidu.tbadk.coreExtra.messageCenter.a.a().p().f());
            ImMessageCenterShowItemData imMessageCenterShowItemData = d().f;
            if (imMessageCenterShowItemData != null) {
                int unReadCount = imMessageCenterShowItemData.getUnReadCount();
                String str = d().b;
                cVar.d(unReadCount);
                if (unReadCount > 0) {
                    cVar.i(str);
                    cVar.d(imMessageCenterShowItemData.getFriendName());
                }
                com.baidu.adp.lib.util.f.e("validata Count:" + unReadCount + "validata summary:" + str);
            } else {
                cVar.d(0);
            }
        }
        d();
        if (m()) {
            ImMessageCenterShowItemData imMessageCenterShowItemData2 = d().g;
            cVar.i(com.baidu.tbadk.coreExtra.messageCenter.a.a().p().d());
            if (imMessageCenterShowItemData2 != null) {
                int unReadCount2 = imMessageCenterShowItemData2.getUnReadCount();
                int unReadCountExtra = imMessageCenterShowItemData2.getUnReadCountExtra();
                String str2 = d().c;
                cVar.b(unReadCount2);
                cVar.c(unReadCountExtra);
                if (unReadCount2 > 0) {
                    cVar.e(imMessageCenterShowItemData2.getFriendName());
                    cVar.h(str2);
                }
                if (unReadCountExtra > 0) {
                    cVar.f(imMessageCenterShowItemData2.getTitle());
                    cVar.g(imMessageCenterShowItemData2.getMsgContent());
                }
                com.baidu.adp.lib.util.f.e("updates Count:" + unReadCount2 + " updates summary:" + str2);
            } else {
                cVar.b(0);
                com.baidu.adp.lib.util.f.e(new StringBuilder(" getUpdate is null0").toString());
            }
        }
        if (this.e != null && this.e.size() > 0) {
            a(cVar);
        }
        if (((((cVar.w() + cVar.c()) + cVar.d()) + cVar.f()) + cVar.g()) - cVar.l() <= 0) {
            cVar.a(false);
        }
        TbadkApplication.j();
        if (!TbadkApplication.af()) {
            cVar.a(0);
        }
        if (!TbadkApplication.j().ag()) {
            cVar.l(0);
            cVar.e(0);
        }
        if (TbadkApplication.j().ai() <= 0) {
            cVar.a(0);
            cVar.l(0);
            cVar.e(0);
            cVar.a(false);
        }
        if (!TbadkApplication.j().ag() || TbadkApplication.j().ai() <= 0) {
            cVar.l(0);
            cVar.a(false);
        }
        if (z2) {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2012111));
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(cVar);
    }

    private static void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData != null) {
            String friendId = imMessageCenterShowItemData.getFriendId();
            if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                PersonalSettingItemData b = com.baidu.tieba.im.chat.personaltalk.a.a().b(TbadkApplication.E(), friendId);
                if (b != null) {
                    imMessageCenterShowItemData.setGroupSetting(b);
                }
            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                OfficialSettingItemData b2 = bb.a().b(TbadkApplication.E(), friendId);
                if (b2 != null) {
                    imMessageCenterShowItemData.setGroupSetting(b2);
                }
            } else {
                GroupSettingItemData b3 = aa.a().b(TbadkApplication.E(), friendId);
                if (b3 != null) {
                    imMessageCenterShowItemData.setGroupSetting(b3);
                }
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.b.c cVar) {
        String[] split;
        if (this.e != null && this.e.size() != 0) {
            Collections.sort(this.e, new h(this));
            Iterator<ImMessageCenterShowItemData> it = this.e.iterator();
            int i = 0;
            while (it.hasNext()) {
                i = it.next().getUnReadCount() + i;
            }
            this.h = this.e.getFirst().m251clone();
            if (com.baidu.tieba.im.model.p.a()) {
                cVar.k(com.baidu.tbadk.coreExtra.messageCenter.a.a().p().g());
                cVar.e(i);
                this.h.setUnReadCount(i);
            } else {
                this.h.setUnReadCount(0);
                cVar.e(0);
            }
            cVar.a(this.h.getFriendName());
            String msgContent = this.h.getMsgContent();
            if (TextUtils.isEmpty(msgContent)) {
                msgContent = "";
            } else {
                if (msgContent.split(":").length == 2) {
                    msgContent = String.valueOf(TbadkApplication.j().c().getString(com.baidu.tieba.im.j.official_msg_list_name, split[0])) + ":" + split[1];
                }
            }
            cVar.b(msgContent);
        }
    }

    public final void a(String str) {
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

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator<ImMessageCenterShowItemData> it = this.e.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getFriendId())) {
                    it.remove();
                }
            }
        }
    }

    public final void b() {
        if (this.d != null) {
            this.d.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ImMessageCenterShowItemData b(a aVar, String str, ImMessageCenterPojo imMessageCenterPojo) {
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
            imMessageCenterShowItemData.setOwnerId(TbadkApplication.E());
            imMessageCenterShowItemData.setFriendName(imMessageCenterPojo.getGroup_name());
            imMessageCenterShowItemData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
            if (imMessageCenterPojo.getCustomGroupType() == 2 || imMessageCenterPojo.getCustomGroupType() == 4) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ImMessageCenterShowItemData a(a aVar, String str, ImMessageCenterPojo imMessageCenterPojo) {
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (!TextUtils.isEmpty(str) && imMessageCenterPojo != null) {
            Iterator<ImMessageCenterShowItemData> it = aVar.e.iterator();
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
                aVar.e.add(imMessageCenterShowItemData);
            } else if (imMessageCenterPojo.getIs_hidden() == 1) {
                aVar.e.remove(imMessageCenterShowItemData);
                return null;
            }
            imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
            imMessageCenterShowItemData.setOwnerId(TbadkApplication.E());
            imMessageCenterShowItemData.setFriendName(imMessageCenterPojo.getGroup_name());
            imMessageCenterShowItemData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                imMessageCenterShowItemData.setOwnerName(String.valueOf(4));
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                imMessageCenterShowItemData.setOwnerName(String.valueOf(5));
            } else {
                imMessageCenterShowItemData.setOwnerName(String.valueOf(1));
            }
            imMessageCenterShowItemData.setServerTime(imMessageCenterPojo.getLast_content_time());
            imMessageCenterShowItemData.setUnReadCount(imMessageCenterPojo.getUnread_count());
            imMessageCenterShowItemData.setSelf(imMessageCenterPojo.isSelf());
            if (TextUtils.isEmpty(imMessageCenterPojo.getLast_content())) {
                imMessageCenterShowItemData.setUnReadCount(0);
            } else {
                imMessageCenterShowItemData.setMsgContent(imMessageCenterPojo.getLast_content());
            }
            if (OfficialBarChatActivity.a && str.equals(GroupChatActivity.b)) {
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            if (bb.a().d(TbadkApplication.E(), imMessageCenterPojo.getGid())) {
                return imMessageCenterShowItemData;
            }
            imMessageCenterShowItemData.setUnReadCount(0);
            return imMessageCenterShowItemData;
        }
        return null;
    }

    public static void a(com.baidu.tieba.im.a<Void> aVar) {
        r.a(new i(), null);
    }

    public static void c() {
        com.baidu.adp.lib.util.f.e("begin");
        int a2 = com.baidu.tieba.im.db.d.a().a("apply_join_group", 1);
        com.baidu.adp.lib.util.f.e("unReadCount" + a2);
        if (-1 == a2) {
            d().f = null;
            return;
        }
        if (d().f == null) {
            d().f = new ImMessageCenterShowItemData();
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = d().f;
        imMessageCenterShowItemData.setUnReadCount(a2);
        List<ValidateItemData> a3 = com.baidu.tieba.im.validate.n.a(com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "apply_join_group"));
        if (a3 == null || a3.isEmpty()) {
            com.baidu.adp.lib.util.f.e("convertValidate is null");
            d().f = null;
            return;
        }
        com.baidu.adp.lib.util.f.e("convertValidate is not null");
        ValidateItemData validateItemData = a3.get(0);
        String str = String.valueOf(validateItemData.getUserName()) + TbadkApplication.j().b().getApplicationContext().getString(com.baidu.tieba.im.j.validate_im_apply_prefix1) + validateItemData.getGroupName();
        imMessageCenterShowItemData.setFriendId(String.valueOf(2));
        imMessageCenterShowItemData.setFriendName(TbadkApplication.j().b().getApplicationContext().getString(com.baidu.tieba.im.j.valicate));
        imMessageCenterShowItemData.setMsgContent(str);
        imMessageCenterShowItemData.setOwnerName(String.valueOf(2));
        imMessageCenterShowItemData.setOwnerId(TbadkApplication.E());
        imMessageCenterShowItemData.setServerTime(validateItemData.getApplyTime());
        d().b = str;
        com.baidu.tbadk.core.sharedPref.b.a().b("is_show_validate", true);
        com.baidu.adp.framework.c.a().b(new ImSystemShowNotifyMessage(validateItemData.getNotice_id()));
        com.baidu.adp.lib.util.f.e(" new validate data");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(String str) {
        ImMessageCenterPojo a2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = true;
        try {
            a2 = com.baidu.tieba.im.b.e.a(o.a().e());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a2 == null) {
            return;
        }
        long parseLong = Long.parseLong(str);
        com.baidu.adp.lib.util.f.e("curMid:" + parseLong + " p.getLast_rid():" + a2.getLast_rid());
        if (a2 != null) {
            if (parseLong <= a2.getLast_rid()) {
                z = false;
            }
        }
        d().b(z, new j());
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
        return this.j;
    }

    public final LinkedList<ImMessageCenterShowItemData> h() {
        return this.e;
    }

    public final void a(List<GroupUpdateMessage> list) {
        if (list != null) {
            if (this.j == null) {
                this.j = new LinkedList();
            }
            this.j.clear();
            this.j.addAll(list);
        }
    }

    public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.f = imMessageCenterShowItemData;
    }

    public final ImMessageCenterShowItemData i() {
        return this.g;
    }

    public final void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.g = imMessageCenterShowItemData;
    }

    public final ImMessageCenterShowItemData j() {
        return this.h;
    }

    public final void k() {
        this.h = null;
    }

    public static boolean l() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("is_show_validate", true);
    }

    public static boolean m() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("is_show_updates", true);
    }
}
