package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.bw;
import com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialSettingItemData;
import com.baidu.tieba.im.chat.officialBar.bd;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.groupInfo.y;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.live.livenotify.LiveNotifyActivity;
import com.baidu.tieba.im.message.ImSystemShowNotifyMessage;
import com.baidu.tieba.im.newFriend.NewFriendDbManagerStatic;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.tieba.im.validate.ValidateItemData;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a a;
    private String b;
    private String c;
    private String d;
    private ImMessageCenterShowItemData g;
    private ImMessageCenterShowItemData h;
    private ImMessageCenterShowItemData i;
    private ImMessageCenterShowItemData j;
    private ImMessageCenterShowItemData k;
    private List<GroupUpdateMessage> n;
    private LinkedList<ImMessageCenterShowItemData> e = new LinkedList<>();
    private LinkedList<ImMessageCenterShowItemData> f = new LinkedList<>();
    private LinkedList<ImMessageCenterShowItemData> l = new LinkedList<>();
    private final com.baidu.tbadk.coreExtra.b.c m = new com.baidu.tbadk.coreExtra.b.c();
    private CustomMessageListener o = new b(this, 2001128);

    private a() {
        MessageManager.getInstance().registerListener(this.o);
    }

    public static void a() {
        GroupNewsPojo groupNewsPojo;
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "kick_out");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String gid = groupNewsPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                com.baidu.tieba.im.e.i.a(gid);
            }
        }
    }

    public static void b() {
        GroupNewsPojo groupNewsPojo;
        long j;
        String str;
        long j2 = 0;
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "apply_join_success");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String content = groupNewsPojo.getContent();
            if (!TextUtils.isEmpty(content)) {
                String str2 = "";
                try {
                    JSONObject jSONObject = new JSONObject(content);
                    jSONObject.put("notice_id", groupNewsPojo.getNotice_id());
                    JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                    str2 = optJSONObject.optString("groupId");
                    String optString = optJSONObject.optString("groupImage");
                    String optString2 = optJSONObject.optString("groupName");
                    String optString3 = jSONObject.optString("userMsg");
                    j2 = optJSONObject.optLong("lastMsgId");
                    y.a().b(TbadkApplication.getCurrentAccount(), str2, true);
                    y.a().a(TbadkApplication.getCurrentAccount(), str2, true);
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(str2);
                    imMessageCenterPojo.setGroup_head(optString);
                    imMessageCenterPojo.setGroup_name(optString2);
                    imMessageCenterPojo.setIs_delete(0);
                    imMessageCenterPojo.setLast_content_time(groupNewsPojo.getTime());
                    imMessageCenterPojo.setIs_hidden(0);
                    imMessageCenterPojo.setUnread_count(0);
                    imMessageCenterPojo.setLast_content(optString3);
                    imMessageCenterPojo.setLast_rid(bw.b(j2));
                    imMessageCenterPojo.setPulled_msgId(bw.b(j2));
                    com.baidu.tbadk.coreExtra.messageCenter.e.a().b(com.baidu.adp.lib.f.b.a(str2, 0), j2);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(imMessageCenterPojo.getGid(), 0L);
                    com.baidu.tieba.im.i.a(new e(linkedHashMap, imMessageCenterPojo), new f(imMessageCenterPojo));
                    j = j2;
                    str = str2;
                } catch (Exception e) {
                    j = j2;
                    str = str2;
                    e.printStackTrace();
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put(str, Long.valueOf(j));
                com.baidu.tieba.im.i.a(new g(linkedHashMap2), null);
            }
        }
    }

    public static void a(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.i.a(new h(z), aVar);
    }

    public static void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.i.a(new i(), aVar);
    }

    public static void c() {
        String content = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "passed_new_friend").get(0).getContent();
        if (!TextUtils.isEmpty(content)) {
            NewFriendDbManagerStatic.a().b(content);
        }
    }

    public static void d() {
        String content = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "delete_new_friend").get(0).getContent();
        if (!TextUtils.isEmpty(content)) {
            NewFriendDbManagerStatic.a().c(content);
        }
    }

    public static void e() {
        String content = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "apply_new_friend").get(0).getContent();
        if (!TextUtils.isEmpty(content)) {
            NewFriendDbManagerStatic.a().a(content);
        }
    }

    public static void a(String str) {
        int a2 = com.baidu.tieba.im.db.d.a().a("live_notify", 1);
        if (-1 == a2) {
            i().i = null;
            return;
        }
        if (i().i == null) {
            i().i = new ImMessageCenterShowItemData();
            i().i.setOwnerName(String.valueOf(6));
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = i().i;
        imMessageCenterShowItemData.setUnReadCount(a2);
        List<UpdatesItemData> a3 = com.baidu.tieba.im.live.livenotify.o.a(com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "live_notify"));
        if (a3 == null || a3.isEmpty()) {
            i().i = null;
            return;
        }
        UpdatesItemData updatesItemData = a3.get(0);
        imMessageCenterShowItemData.setFriendId(String.valueOf(6));
        imMessageCenterShowItemData.setFriendName(TbadkApplication.m252getInst().getApp().getApplicationContext().getString(com.baidu.tieba.y.live_chat_room_more_livenotify));
        imMessageCenterShowItemData.setTitle(updatesItemData.getTitle());
        imMessageCenterShowItemData.setMsgContent(updatesItemData.getContent());
        imMessageCenterShowItemData.setOwnerName(String.valueOf(6));
        imMessageCenterShowItemData.setOwnerId(TbadkApplication.getCurrentAccount());
        imMessageCenterShowItemData.setServerTime(updatesItemData.getTime());
        i().f(updatesItemData.getContent());
        com.baidu.tbadk.core.sharedPref.b.a().c("is_show_live_notify", true);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ImSystemShowNotifyMessage(updatesItemData.getNotice_id()));
    }

    public static void a(String str, boolean z) {
        int a2 = com.baidu.tieba.im.db.d.a().a("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change", 1);
        int a3 = com.baidu.tieba.im.db.d.a().a("group_event_info", 1);
        if (-1 == a2) {
            i().h = null;
            return;
        }
        if (i().h == null) {
            i().h = new ImMessageCenterShowItemData();
            i().h.setOwnerName(String.valueOf(3));
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = i().h;
        imMessageCenterShowItemData.setUnReadCount(a2);
        imMessageCenterShowItemData.setUnReadCountExtra(a3);
        List<UpdatesItemData> a4 = com.baidu.tieba.im.groupUpdates.p.a(com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change"));
        if (a4 == null || a4.isEmpty()) {
            i().h = null;
            return;
        }
        UpdatesItemData updatesItemData = a4.get(0);
        imMessageCenterShowItemData.setFriendId(String.valueOf(3));
        imMessageCenterShowItemData.setFriendName(TbadkApplication.m252getInst().getApp().getApplicationContext().getString(com.baidu.tieba.y.group_updates));
        imMessageCenterShowItemData.setTitle(updatesItemData.getTitle());
        imMessageCenterShowItemData.setMsgContent(updatesItemData.getContent());
        imMessageCenterShowItemData.setOwnerName(String.valueOf(3));
        imMessageCenterShowItemData.setOwnerId(TbadkApplication.getCurrentAccount());
        imMessageCenterShowItemData.setServerTime(updatesItemData.getTime());
        String updatesType = updatesItemData.getUpdatesType();
        i().e(updatesItemData.getContent());
        if (z) {
            a(updatesItemData, updatesType);
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("dismiss_group")) {
                f();
            } else if (str.equals("kick_out")) {
                a();
            }
        }
        com.baidu.tbadk.core.sharedPref.b.a().c("is_show_updates", true);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ImSystemShowNotifyMessage(updatesItemData.getNotice_id()));
    }

    public static void f() {
        GroupNewsPojo groupNewsPojo;
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "dismiss_group");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String gid = groupNewsPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                com.baidu.tieba.im.e.i.a(gid);
            }
        }
    }

    public synchronized void a(boolean z, boolean z2, com.baidu.tieba.im.a<Void> aVar) {
        a(z, z2);
        if (aVar != null) {
            aVar.a(null);
        }
    }

    public synchronized void b(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        a(z, false, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() == 0) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        return ((!TextUtils.isEmpty(gid) && gid.equals(String.valueOf(w.a))) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getLast_content_time() <= 0 || TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getCustomGroupType() == 3 || imMessageCenterPojo.getCustomGroupType() == 5) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterShowItemData != null) {
            String friendId = imMessageCenterShowItemData.getFriendId();
            if (!TextUtils.isEmpty(friendId)) {
                if (!GroupChatActivity.a || !friendId.equals(GroupChatActivity.b)) {
                    if ((!PersonalChatActivity.a || !friendId.equals(PersonalChatActivity.b)) && !TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                        String ownerName = imMessageCenterShowItemData.getOwnerName();
                        if (!TextUtils.isEmpty(ownerName)) {
                            if (ownerName.equals(String.valueOf(4))) {
                                a(imMessageCenterShowItemData, cVar, friendId);
                            } else if (ownerName.equals(String.valueOf(1))) {
                                b(imMessageCenterShowItemData, cVar, friendId);
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tbadk.coreExtra.b.c cVar, String str) {
        if (com.baidu.tieba.im.chat.personaltalk.a.a().d(TbadkApplication.getCurrentAccount(), str)) {
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                cVar.k(imMessageCenterShowItemData.getMsgContent());
                String friendName = imMessageCenterShowItemData.getFriendName();
                HashMap<String, String> y = cVar.y();
                if (y != null) {
                    y.put(str, friendName);
                }
            }
            cVar.l(cVar.w() + imMessageCenterShowItemData.getUnReadCount());
        }
    }

    private void b(ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tbadk.coreExtra.b.c cVar, String str) {
        HashMap<String, String> s = cVar.s();
        if (!y.a().d(TbadkApplication.getCurrentAccount(), str)) {
            cVar.g(cVar.l() + imMessageCenterShowItemData.getUnReadCount());
        } else if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            cVar.c(imMessageCenterShowItemData.getMsgContent());
            s.put(str, imMessageCenterShowItemData.getFriendName());
        }
        cVar.a(cVar.c() + imMessageCenterShowItemData.getUnReadCount());
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [711=7] */
    private synchronized void a(boolean z, boolean z2) {
        this.e.clear();
        this.f.clear();
        this.j = null;
        this.l.clear();
        this.k = null;
        com.baidu.tbadk.coreExtra.b.c cVar = new com.baidu.tbadk.coreExtra.b.c();
        cVar.a(z);
        cVar.b(z2);
        com.baidu.tieba.im.b.e.a(new j(this, cVar));
        cVar.a();
        cVar.b();
        cVar.f(com.baidu.tbadk.coreExtra.messageCenter.a.a().r().w());
        cVar.h(com.baidu.tbadk.coreExtra.messageCenter.a.a().r().i());
        Iterator<ImMessageCenterShowItemData> it = this.e.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        Iterator<ImMessageCenterShowItemData> it2 = this.f.iterator();
        while (it2.hasNext()) {
            a(it2.next());
        }
        Iterator<ImMessageCenterShowItemData> it3 = this.l.iterator();
        while (it3.hasNext()) {
            a(it3.next());
        }
        if (i().x()) {
            c(cVar);
        }
        if (i().y()) {
            a(cVar);
        }
        if (i().z()) {
            b(cVar);
        }
        if (this.f != null && this.f.size() > 0) {
            d(cVar);
        }
        if (this.l != null && this.l.size() > 0) {
            e(cVar);
        }
        if ((((((cVar.w() + cVar.c()) + cVar.d()) + cVar.f()) + cVar.g()) + cVar.A()) - cVar.l() <= 0) {
            cVar.a(false);
        }
        if (!TbadkApplication.m252getInst().isGroupMsgOn()) {
            cVar.a(0);
        }
        if (!TbadkApplication.m252getInst().isMsgChatOn()) {
            cVar.l(0);
            cVar.e(0);
        }
        if (TbadkApplication.m252getInst().getMsgFrequency() <= 0) {
            cVar.a(0);
            cVar.l(0);
            cVar.e(0);
            cVar.a(false);
        }
        if (!TbadkApplication.m252getInst().isMsgChatOn() || TbadkApplication.m252getInst().getMsgFrequency() <= 0) {
            cVar.l(0);
            cVar.a(false);
        }
        if (z2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2012111));
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.a().b(cVar);
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData != null) {
            String friendId = imMessageCenterShowItemData.getFriendId();
            if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                PersonalSettingItemData b = com.baidu.tieba.im.chat.personaltalk.a.a().b(TbadkApplication.getCurrentAccount(), friendId);
                if (b != null) {
                    imMessageCenterShowItemData.setGroupSetting(b);
                }
            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                OfficialSettingItemData b2 = bd.a().b(TbadkApplication.getCurrentAccount(), friendId);
                if (b2 != null) {
                    imMessageCenterShowItemData.setGroupSetting(b2);
                }
            } else {
                GroupSettingItemData b3 = y.a().b(TbadkApplication.getCurrentAccount(), friendId);
                if (b3 != null) {
                    imMessageCenterShowItemData.setGroupSetting(b3);
                }
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.b.c cVar) {
        ImMessageCenterShowItemData imMessageCenterShowItemData = i().h;
        cVar.i(com.baidu.tbadk.coreExtra.messageCenter.a.a().r().d());
        if (imMessageCenterShowItemData != null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            int unReadCountExtra = imMessageCenterShowItemData.getUnReadCountExtra();
            String j = i().j();
            cVar.b(unReadCount);
            cVar.c(unReadCountExtra);
            if (unReadCount > 0) {
                cVar.f(imMessageCenterShowItemData.getFriendName());
                cVar.i(j);
            }
            if (unReadCountExtra > 0) {
                cVar.g(imMessageCenterShowItemData.getTitle());
                cVar.h(imMessageCenterShowItemData.getMsgContent());
            }
            if (UpdatesActivity.a) {
                imMessageCenterShowItemData.setUnReadCount(0);
                return;
            }
            return;
        }
        cVar.b(0);
    }

    private void b(com.baidu.tbadk.coreExtra.b.c cVar) {
        ImMessageCenterShowItemData imMessageCenterShowItemData = i().i;
        cVar.n(com.baidu.tbadk.coreExtra.messageCenter.a.a().r().A());
        if (imMessageCenterShowItemData != null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            String k = i().k();
            cVar.m(unReadCount);
            if (unReadCount > 0) {
                cVar.m(imMessageCenterShowItemData.getFriendName());
                cVar.n(k);
            }
            if (LiveNotifyActivity.a) {
                imMessageCenterShowItemData.setUnReadCount(0);
                return;
            }
            return;
        }
        cVar.m(0);
    }

    private void c(com.baidu.tbadk.coreExtra.b.c cVar) {
        cVar.j(com.baidu.tbadk.coreExtra.messageCenter.a.a().r().f());
        ImMessageCenterShowItemData imMessageCenterShowItemData = i().g;
        if (imMessageCenterShowItemData != null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            String l = i().l();
            cVar.d(unReadCount);
            if (unReadCount > 0) {
                cVar.j(l);
                cVar.e(imMessageCenterShowItemData.getFriendName());
            }
            if (ValidateActivity.a) {
                imMessageCenterShowItemData.setUnReadCount(0);
                return;
            }
            return;
        }
        cVar.d(0);
    }

    private void d(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (this.f != null && this.f.size() != 0) {
            Collections.sort(this.f, new k(this));
            Iterator<ImMessageCenterShowItemData> it = this.f.iterator();
            int i = 0;
            while (it.hasNext()) {
                i = it.next().getUnReadCount() + i;
            }
            this.j = this.f.getFirst().m254clone();
            if (com.baidu.tieba.im.model.p.a()) {
                cVar.k(com.baidu.tbadk.coreExtra.messageCenter.a.a().r().g());
                cVar.e(i);
                this.j.setUnReadCount(i);
            } else {
                this.j.setUnReadCount(0);
                cVar.e(0);
            }
            cVar.a(this.j.getFriendName());
            String f = f(this.j);
            this.j.setMsgContent(f);
            cVar.b(f);
        }
    }

    private void e(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (this.l != null && this.l.size() != 0) {
            Collections.sort(this.l, new l(this));
            Iterator<ImMessageCenterShowItemData> it = this.l.iterator();
            int i = 0;
            while (it.hasNext()) {
                i = it.next().getUnReadCount() + i;
            }
            this.k = this.l.getFirst().m254clone();
            this.k.setOwnerName(String.valueOf(7));
            if (com.baidu.tieba.im.model.p.b()) {
                cVar.o(i);
                this.k.setUnReadCount(i);
            } else {
                this.k.setUnReadCount(0);
                cVar.o(0);
            }
            String e = e(this.k);
            this.k.setMsgContent(e);
            cVar.o(e);
        }
    }

    private String e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null || TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            return "";
        }
        if (imMessageCenterShowItemData.isSelf() || TextUtils.isEmpty(imMessageCenterShowItemData.getFriendName())) {
            return imMessageCenterShowItemData.getMsgContent();
        }
        return String.valueOf(imMessageCenterShowItemData.getFriendName()) + ":" + imMessageCenterShowItemData.getMsgContent();
    }

    private String f(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null || TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            return "";
        }
        if (imMessageCenterShowItemData.isSelf()) {
            return imMessageCenterShowItemData.getMsgContent();
        }
        return String.valueOf(TbadkApplication.m252getInst().getContext().getString(com.baidu.tieba.y.official_msg_list_name, imMessageCenterShowItemData.getFriendName())) + ":" + imMessageCenterShowItemData.getMsgContent();
    }

    public void b(String str) {
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        Iterator<ImMessageCenterShowItemData> it = this.e.iterator();
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
            this.e.remove(imMessageCenterShowItemData);
        }
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator<ImMessageCenterShowItemData> it = this.f.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getFriendId())) {
                    it.remove();
                }
            }
        }
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator<ImMessageCenterShowItemData> it = this.l.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getFriendId())) {
                    it.remove();
                }
            }
        }
    }

    public void g() {
        if (this.e != null) {
            this.e.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterShowItemData a(String str, ImMessageCenterPojo imMessageCenterPojo) {
        ImMessageCenterShowItemData imMessageCenterShowItemData = null;
        if (!TextUtils.isEmpty(str) && imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1) {
            imMessageCenterShowItemData = new ImMessageCenterShowItemData();
            this.e.add(imMessageCenterShowItemData);
            imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
            imMessageCenterShowItemData.setOwnerId(TbadkApplication.getCurrentAccount());
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
            } else {
                imMessageCenterShowItemData.setMsgContent(imMessageCenterPojo.getLast_content());
            }
        }
        return imMessageCenterShowItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterShowItemData b(String str, ImMessageCenterPojo imMessageCenterPojo) {
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (!TextUtils.isEmpty(str) && imMessageCenterPojo != null) {
            Iterator<ImMessageCenterShowItemData> it = this.f.iterator();
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
                this.f.add(imMessageCenterShowItemData);
            } else if (imMessageCenterPojo.getIs_hidden() == 1) {
                this.f.remove(imMessageCenterShowItemData);
                return null;
            }
            imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
            imMessageCenterShowItemData.setOwnerId(TbadkApplication.getCurrentAccount());
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
            if (!bd.a().d(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                imMessageCenterShowItemData.setUnReadCount(0);
                return imMessageCenterShowItemData;
            }
            return imMessageCenterShowItemData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterShowItemData c(String str, ImMessageCenterPojo imMessageCenterPojo) {
        ImMessageCenterShowItemData imMessageCenterShowItemData = null;
        if (!TextUtils.isEmpty(str) && imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1) {
            imMessageCenterShowItemData = new ImMessageCenterShowItemData();
            this.l.add(imMessageCenterShowItemData);
            imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
            imMessageCenterShowItemData.setOwnerId(TbadkApplication.getCurrentAccount());
            imMessageCenterShowItemData.setFriendName(imMessageCenterPojo.getGroup_name());
            imMessageCenterShowItemData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
            imMessageCenterShowItemData.setOwnerName(String.valueOf(4));
            imMessageCenterShowItemData.setServerTime(imMessageCenterPojo.getLast_content_time());
            imMessageCenterShowItemData.setUnReadCount(imMessageCenterPojo.getUnread_count());
            imMessageCenterShowItemData.setSelf(imMessageCenterPojo.isSelf());
            if (TextUtils.isEmpty(imMessageCenterPojo.getLast_content())) {
                imMessageCenterShowItemData.setUnReadCount(0);
            } else {
                imMessageCenterShowItemData.setMsgContent(imMessageCenterPojo.getLast_content());
            }
            if (PersonalChatActivity.a && str.equals(GroupChatActivity.b)) {
                imMessageCenterShowItemData.setUnReadCount(0);
            }
        }
        return imMessageCenterShowItemData;
    }

    private static void a(UpdatesItemData updatesItemData, String str) {
        if (!TextUtils.isEmpty(str) && str.equals("group_name_change")) {
            String groupId = updatesItemData.getGroupId();
            if (!TextUtils.isEmpty(groupId)) {
                com.baidu.tieba.im.e.i.a(groupId, updatesItemData.getGroupName());
            }
        }
    }

    public static void b(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.i.a(new c(), aVar);
    }

    public static void h() {
        int a2 = com.baidu.tieba.im.db.d.a().a("apply_join_group", 1);
        if (-1 == a2) {
            i().g = null;
            return;
        }
        if (i().g == null) {
            i().g = new ImMessageCenterShowItemData();
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = i().g;
        imMessageCenterShowItemData.setUnReadCount(a2);
        List<ValidateItemData> a3 = com.baidu.tieba.im.validate.n.a(com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "apply_join_group"));
        if (a3 == null || a3.isEmpty()) {
            i().g = null;
            return;
        }
        ValidateItemData validateItemData = a3.get(0);
        String str = String.valueOf(validateItemData.getUserName()) + TbadkApplication.m252getInst().getApp().getApplicationContext().getString(com.baidu.tieba.y.validate_im_apply_prefix1) + validateItemData.getGroupName();
        imMessageCenterShowItemData.setFriendId(String.valueOf(2));
        imMessageCenterShowItemData.setFriendName(TbadkApplication.m252getInst().getApp().getApplicationContext().getString(com.baidu.tieba.y.valicate));
        imMessageCenterShowItemData.setMsgContent(str);
        imMessageCenterShowItemData.setOwnerName(String.valueOf(2));
        imMessageCenterShowItemData.setOwnerId(TbadkApplication.getCurrentAccount());
        imMessageCenterShowItemData.setServerTime(validateItemData.getApplyTime());
        i().g(str);
        com.baidu.tbadk.core.sharedPref.b.a().c("is_show_validate", true);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ImSystemShowNotifyMessage(validateItemData.getNotice_id()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(String str) {
        ImMessageCenterPojo a2;
        if (!TextUtils.isEmpty(str)) {
            boolean z = true;
            try {
                a2 = com.baidu.tieba.im.b.e.a(q.a().e());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (a2 != null) {
                long parseLong = Long.parseLong(str);
                if (a2 != null) {
                    if (parseLong <= a2.getLast_rid()) {
                        z = false;
                    }
                }
                i().b(z, new d());
            }
        }
    }

    public static synchronized a i() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public String j() {
        return this.c;
    }

    public void e(String str) {
        this.c = str;
    }

    public String k() {
        return this.d;
    }

    public void f(String str) {
        this.d = str;
    }

    public String l() {
        return this.b;
    }

    public void g(String str) {
        this.b = str;
    }

    public LinkedList<ImMessageCenterShowItemData> m() {
        return this.e;
    }

    public ImMessageCenterShowItemData n() {
        return this.g;
    }

    public List<GroupUpdateMessage> o() {
        return this.n;
    }

    public LinkedList<ImMessageCenterShowItemData> p() {
        return this.f;
    }

    public LinkedList<ImMessageCenterShowItemData> q() {
        return this.l;
    }

    public void a(List<GroupUpdateMessage> list) {
        if (list != null) {
            if (this.n == null) {
                this.n = new LinkedList();
            }
            this.n.clear();
            this.n.addAll(list);
        }
    }

    public void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.g = imMessageCenterShowItemData;
    }

    public ImMessageCenterShowItemData r() {
        return this.h;
    }

    public ImMessageCenterShowItemData s() {
        return this.i;
    }

    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.i = imMessageCenterShowItemData;
    }

    public void d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.h = imMessageCenterShowItemData;
    }

    public synchronized ImMessageCenterShowItemData t() {
        return this.j;
    }

    public synchronized void u() {
        this.j = null;
    }

    public ImMessageCenterShowItemData v() {
        return this.k;
    }

    public synchronized void w() {
        this.k = null;
    }

    public boolean x() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("is_show_validate", true);
    }

    public boolean y() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("is_show_updates", true);
    }

    public boolean z() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("is_show_live_notify", true);
    }
}
