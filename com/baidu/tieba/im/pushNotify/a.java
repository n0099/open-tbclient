package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.bv;
import com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialSettingItemData;
import com.baidu.tieba.im.chat.officialBar.az;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.groupInfo.aa;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.ImSystemShowNotifyMessage;
import com.baidu.tieba.im.model.r;
import com.baidu.tieba.im.validate.ValidateItemData;
import com.baidu.tieba.y;
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
    private List<GroupUpdateMessage> l;
    private LinkedList<ImMessageCenterShowItemData> e = new LinkedList<>();
    private LinkedList<ImMessageCenterShowItemData> f = new LinkedList<>();
    private final com.baidu.tbadk.coreExtra.b.c k = new com.baidu.tbadk.coreExtra.b.c();
    private CustomMessageListener m = new b(this, MessageTypes.CMD_IM_SYSTEM_SHOW_NOTIFY);

    private a() {
        MessageManager.getInstance().registerListener(this.m);
    }

    public static void a() {
        GroupNewsPojo groupNewsPojo;
        BdLog.d("begin");
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
        String str;
        Exception e;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        long j = 0;
        BdLog.d(" time:" + System.currentTimeMillis());
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "apply_join_success");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String content = groupNewsPojo.getContent();
            if (TextUtils.isEmpty(content)) {
                BdLog.e("content is null");
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
                aa.a().b(TbadkApplication.getCurrentAccount(), str, true);
                aa.a().a(TbadkApplication.getCurrentAccount(), str, true);
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(str);
                imMessageCenterPojo.setGroup_head(optString);
                imMessageCenterPojo.setGroup_name(optString2);
                imMessageCenterPojo.setIs_delete(0);
                imMessageCenterPojo.setLast_content_time(groupNewsPojo.getTime());
                imMessageCenterPojo.setIs_hidden(0);
                imMessageCenterPojo.setUnread_count(0);
                imMessageCenterPojo.setLast_content(optString3);
                imMessageCenterPojo.setLast_rid(bv.b(j));
                imMessageCenterPojo.setPulled_msgId(bv.b(j));
                com.baidu.tbadk.coreExtra.messageCenter.e.a().b(com.baidu.adp.lib.f.b.a(str, 0), j);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(imMessageCenterPojo.getGid(), 0L);
                com.baidu.tieba.im.i.a(new d(linkedHashMap, imMessageCenterPojo), new e(imMessageCenterPojo));
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put(str, Long.valueOf(j));
                com.baidu.tieba.im.i.a(new f(linkedHashMap2), null);
                BdLog.d("save apply approved data: " + groupNewsPojo.toString());
            }
            LinkedHashMap linkedHashMap22 = new LinkedHashMap();
            linkedHashMap22.put(str, Long.valueOf(j));
            com.baidu.tieba.im.i.a(new f(linkedHashMap22), null);
            BdLog.d("save apply approved data: " + groupNewsPojo.toString());
        }
    }

    public static void a(boolean z, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.i.a(new g(z), aVar);
    }

    public static void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.i.a(new h(), aVar);
    }

    public static void a(String str) {
        int a2 = com.baidu.tieba.im.db.d.a().a("live_notify", 1);
        if (-1 == a2) {
            f().i = null;
            return;
        }
        if (f().i == null) {
            f().i = new ImMessageCenterShowItemData();
            f().i.setOwnerName(String.valueOf(6));
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = f().i;
        imMessageCenterShowItemData.setUnReadCount(a2);
        List<UpdatesItemData> a3 = com.baidu.tieba.im.live.livenotify.o.a(com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "live_notify"));
        if (a3 == null || a3.isEmpty()) {
            BdLog.d(" live notify is null or empty");
            f().i = null;
            return;
        }
        UpdatesItemData updatesItemData = a3.get(0);
        imMessageCenterShowItemData.setFriendId(String.valueOf(6));
        imMessageCenterShowItemData.setFriendName(TbadkApplication.m252getInst().getApp().getApplicationContext().getString(y.live_chat_room_more_livenotify));
        imMessageCenterShowItemData.setTitle(updatesItemData.getTitle());
        imMessageCenterShowItemData.setMsgContent(updatesItemData.getContent());
        imMessageCenterShowItemData.setOwnerName(String.valueOf(6));
        imMessageCenterShowItemData.setOwnerId(TbadkApplication.getCurrentAccount());
        imMessageCenterShowItemData.setServerTime(updatesItemData.getTime());
        f().e(updatesItemData.getContent());
        com.baidu.tbadk.core.sharedPref.b.a().b("is_show_live_notify", true);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ImSystemShowNotifyMessage(updatesItemData.getNotice_id()));
    }

    public static void a(String str, boolean z) {
        int a2 = com.baidu.tieba.im.db.d.a().a("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change", 1);
        int a3 = com.baidu.tieba.im.db.d.a().a("group_event_info", 1);
        if (-1 == a2) {
            f().h = null;
            return;
        }
        if (f().h == null) {
            f().h = new ImMessageCenterShowItemData();
            f().h.setOwnerName(String.valueOf(3));
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = f().h;
        imMessageCenterShowItemData.setUnReadCount(a2);
        imMessageCenterShowItemData.setUnReadCountExtra(a3);
        List<UpdatesItemData> a4 = com.baidu.tieba.im.groupUpdates.p.a(com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change"));
        if (a4 == null || a4.isEmpty()) {
            BdLog.d(" groupupdates is null or empty");
            f().h = null;
            return;
        }
        BdLog.d("得到群组动态消息+" + a2);
        UpdatesItemData updatesItemData = a4.get(0);
        imMessageCenterShowItemData.setFriendId(String.valueOf(3));
        imMessageCenterShowItemData.setFriendName(TbadkApplication.m252getInst().getApp().getApplicationContext().getString(y.group_updates));
        imMessageCenterShowItemData.setTitle(updatesItemData.getTitle());
        imMessageCenterShowItemData.setMsgContent(updatesItemData.getContent());
        imMessageCenterShowItemData.setOwnerName(String.valueOf(3));
        imMessageCenterShowItemData.setOwnerId(TbadkApplication.getCurrentAccount());
        imMessageCenterShowItemData.setServerTime(updatesItemData.getTime());
        String updatesType = updatesItemData.getUpdatesType();
        f().d(updatesItemData.getContent());
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
        com.baidu.tbadk.core.sharedPref.b.a().b("is_show_updates", true);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ImSystemShowNotifyMessage(updatesItemData.getNotice_id()));
    }

    public static void c() {
        GroupNewsPojo groupNewsPojo;
        BdLog.d("dismiss begin");
        LinkedList<GroupNewsPojo> a2 = com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "dismiss_group");
        if (a2 != null && !a2.isEmpty() && (groupNewsPojo = a2.get(0)) != null) {
            String gid = groupNewsPojo.getGid();
            if (!TextUtils.isEmpty(gid)) {
                com.baidu.tieba.im.e.i.a(gid);
            }
        }
    }

    public synchronized void a(boolean z, boolean z2, com.baidu.tieba.im.a<Void> aVar) {
        BdLog.d(" get recent isNeedShowNotify:" + z);
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
        return ((!TextUtils.isEmpty(gid) && gid.equals(Integer.valueOf(w.a))) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getLast_content_time() <= 0 || TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getCustomGroupType() == 3 || imMessageCenterPojo.getCustomGroupType() == 5) ? false : true;
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
        HashMap<String, String> y = cVar.y();
        if (com.baidu.tieba.im.chat.personaltalk.a.a().d(TbadkApplication.getCurrentAccount(), str)) {
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                cVar.k(imMessageCenterShowItemData.getMsgContent());
                y.put(str, imMessageCenterShowItemData.getFriendName());
            }
            cVar.l(cVar.w() + imMessageCenterShowItemData.getUnReadCount());
        }
    }

    private void b(ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tbadk.coreExtra.b.c cVar, String str) {
        HashMap<String, String> s = cVar.s();
        boolean d = aa.a().d(TbadkApplication.getCurrentAccount(), str);
        BdLog.d("isNofity:" + d + " gid:" + str + "count:" + imMessageCenterShowItemData.getUnReadCount());
        if (!d) {
            cVar.g(cVar.l() + imMessageCenterShowItemData.getUnReadCount());
        } else {
            BdLog.d("lastContent:" + imMessageCenterShowItemData.getMsgContent());
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                cVar.c(imMessageCenterShowItemData.getMsgContent());
                String friendName = imMessageCenterShowItemData.getFriendName();
                s.put(str, friendName);
                BdLog.d("p.getGid:" + str + " gname:" + friendName + " unread_count:" + imMessageCenterShowItemData.getUnReadCount());
            }
        }
        cVar.a(cVar.c() + imMessageCenterShowItemData.getUnReadCount());
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [656=7] */
    private synchronized void a(boolean z, boolean z2) {
        this.e.clear();
        this.f.clear();
        this.j = null;
        com.baidu.tbadk.coreExtra.b.c cVar = new com.baidu.tbadk.coreExtra.b.c();
        cVar.a(z);
        cVar.b(z2);
        com.baidu.tieba.im.b.e.a(new i(this, cVar));
        cVar.a();
        cVar.b();
        cVar.f(com.baidu.tbadk.coreExtra.messageCenter.a.a().s().w());
        cVar.h(com.baidu.tbadk.coreExtra.messageCenter.a.a().s().i());
        Iterator<ImMessageCenterShowItemData> it = this.e.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        Iterator<ImMessageCenterShowItemData> it2 = this.f.iterator();
        while (it2.hasNext()) {
            a(it2.next());
        }
        if (f().r()) {
            c(cVar);
        }
        if (f().s()) {
            a(cVar);
        }
        if (f().t()) {
            b(cVar);
        }
        if (this.f != null && this.f.size() > 0) {
            d(cVar);
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
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfig.MSG_NEW));
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
                OfficialSettingItemData b2 = az.a().b(TbadkApplication.getCurrentAccount(), friendId);
                if (b2 != null) {
                    imMessageCenterShowItemData.setGroupSetting(b2);
                }
            } else {
                GroupSettingItemData b3 = aa.a().b(TbadkApplication.getCurrentAccount(), friendId);
                if (b3 != null) {
                    imMessageCenterShowItemData.setGroupSetting(b3);
                }
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.b.c cVar) {
        ImMessageCenterShowItemData imMessageCenterShowItemData = f().h;
        cVar.i(com.baidu.tbadk.coreExtra.messageCenter.a.a().s().d());
        if (imMessageCenterShowItemData != null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            int unReadCountExtra = imMessageCenterShowItemData.getUnReadCountExtra();
            String g = f().g();
            cVar.b(unReadCount);
            cVar.c(unReadCountExtra);
            if (unReadCount > 0) {
                cVar.f(imMessageCenterShowItemData.getFriendName());
                cVar.i(g);
            }
            if (unReadCountExtra > 0) {
                cVar.g(imMessageCenterShowItemData.getTitle());
                cVar.h(imMessageCenterShowItemData.getMsgContent());
            }
            BdLog.d("updates Count:" + unReadCount + " updates summary:" + g);
            return;
        }
        cVar.b(0);
        BdLog.d(" getUpdate is null0");
    }

    private void b(com.baidu.tbadk.coreExtra.b.c cVar) {
        ImMessageCenterShowItemData imMessageCenterShowItemData = f().i;
        cVar.n(com.baidu.tbadk.coreExtra.messageCenter.a.a().s().A());
        if (imMessageCenterShowItemData != null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            String h = f().h();
            cVar.m(unReadCount);
            if (unReadCount > 0) {
                cVar.m(imMessageCenterShowItemData.getFriendName());
                cVar.n(h);
            }
            BdLog.d("live notify Count:" + unReadCount + " live notify summary:" + h);
            return;
        }
        cVar.m(0);
        BdLog.d(" live notify is null0");
    }

    private void c(com.baidu.tbadk.coreExtra.b.c cVar) {
        cVar.j(com.baidu.tbadk.coreExtra.messageCenter.a.a().s().f());
        ImMessageCenterShowItemData imMessageCenterShowItemData = f().g;
        if (imMessageCenterShowItemData != null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            String i = f().i();
            cVar.d(unReadCount);
            if (unReadCount > 0) {
                cVar.j(i);
                cVar.e(imMessageCenterShowItemData.getFriendName());
            }
            BdLog.d("validata Count:" + unReadCount + "validata summary:" + i);
            return;
        }
        cVar.d(0);
    }

    private void d(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (this.f != null && this.f.size() != 0) {
            Collections.sort(this.f, new j(this));
            Iterator<ImMessageCenterShowItemData> it = this.f.iterator();
            int i = 0;
            while (it.hasNext()) {
                i = it.next().getUnReadCount() + i;
            }
            this.j = this.f.getFirst().m254clone();
            if (r.a()) {
                cVar.k(com.baidu.tbadk.coreExtra.messageCenter.a.a().s().g());
                cVar.e(i);
                this.j.setUnReadCount(i);
            } else {
                this.j.setUnReadCount(0);
                cVar.e(0);
            }
            cVar.a(this.j.getFriendName());
            cVar.b(h(this.j.getMsgContent()));
        }
    }

    private String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(":");
        return split.length == 2 ? String.valueOf(TbadkApplication.m252getInst().getContext().getString(y.official_msg_list_name, split[0])) + ":" + split[1] : str;
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

    public void d() {
        if (this.e != null) {
            this.e.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterShowItemData a(String str, ImMessageCenterPojo imMessageCenterPojo) {
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (!TextUtils.isEmpty(str) && imMessageCenterPojo != null) {
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
            if (imMessageCenterShowItemData == null) {
                if (imMessageCenterPojo.getIs_hidden() == 1) {
                    return null;
                }
                imMessageCenterShowItemData = new ImMessageCenterShowItemData();
                this.e.add(imMessageCenterShowItemData);
            } else if (imMessageCenterPojo.getIs_hidden() == 1) {
                this.e.remove(imMessageCenterShowItemData);
                return null;
            }
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
                return imMessageCenterShowItemData;
            }
            imMessageCenterShowItemData.setMsgContent(imMessageCenterPojo.getLast_content());
            return imMessageCenterShowItemData;
        }
        return null;
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
            if (!az.a().d(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                imMessageCenterShowItemData.setUnReadCount(0);
                return imMessageCenterShowItemData;
            }
            return imMessageCenterShowItemData;
        }
        return null;
    }

    private static void a(UpdatesItemData updatesItemData, String str) {
        if (!TextUtils.isEmpty(str) && str.equals("group_name_change")) {
            String groupId = updatesItemData.getGroupId();
            if (!TextUtils.isEmpty(groupId)) {
                BdLog.d("update msg group name" + updatesItemData.getGroupName());
                com.baidu.tieba.im.e.i.a(groupId, updatesItemData.getGroupName());
            }
        }
    }

    public static void b(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.i.a(new k(), aVar);
    }

    public static void e() {
        BdLog.d("begin");
        int a2 = com.baidu.tieba.im.db.d.a().a("apply_join_group", 1);
        BdLog.d("unReadCount" + a2);
        if (-1 == a2) {
            f().g = null;
            return;
        }
        if (f().g == null) {
            f().g = new ImMessageCenterShowItemData();
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData = f().g;
        imMessageCenterShowItemData.setUnReadCount(a2);
        List<ValidateItemData> a3 = com.baidu.tieba.im.validate.n.a(com.baidu.tieba.im.db.d.a().a(0L, 1, 0, "apply_join_group"));
        if (a3 == null || a3.isEmpty()) {
            BdLog.d("convertValidate is null");
            f().g = null;
            return;
        }
        BdLog.d("convertValidate is not null");
        ValidateItemData validateItemData = a3.get(0);
        String str = String.valueOf(validateItemData.getUserName()) + TbadkApplication.m252getInst().getApp().getApplicationContext().getString(y.validate_im_apply_prefix1) + validateItemData.getGroupName();
        imMessageCenterShowItemData.setFriendId(String.valueOf(2));
        imMessageCenterShowItemData.setFriendName(TbadkApplication.m252getInst().getApp().getApplicationContext().getString(y.valicate));
        imMessageCenterShowItemData.setMsgContent(str);
        imMessageCenterShowItemData.setOwnerName(String.valueOf(2));
        imMessageCenterShowItemData.setOwnerId(TbadkApplication.getCurrentAccount());
        imMessageCenterShowItemData.setServerTime(validateItemData.getApplyTime());
        f().f(str);
        com.baidu.tbadk.core.sharedPref.b.a().b("is_show_validate", true);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ImSystemShowNotifyMessage(validateItemData.getNotice_id()));
        BdLog.d(" new validate data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(String str) {
        ImMessageCenterPojo a2;
        if (!TextUtils.isEmpty(str)) {
            boolean z = true;
            try {
                a2 = com.baidu.tieba.im.b.e.a(p.a().e());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (a2 != null) {
                long parseLong = Long.parseLong(str);
                BdLog.d("curMid:" + parseLong + " p.getLast_rid():" + a2.getLast_rid());
                if (a2 != null) {
                    if (parseLong <= a2.getLast_rid()) {
                        z = false;
                    }
                }
                f().b(z, new c());
            }
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

    public void d(String str) {
        this.c = str;
    }

    public String h() {
        return this.d;
    }

    public void e(String str) {
        this.d = str;
    }

    public String i() {
        return this.b;
    }

    public void f(String str) {
        this.b = str;
    }

    public LinkedList<ImMessageCenterShowItemData> j() {
        return this.e;
    }

    public ImMessageCenterShowItemData k() {
        return this.g;
    }

    public List<GroupUpdateMessage> l() {
        return this.l;
    }

    public LinkedList<ImMessageCenterShowItemData> m() {
        return this.f;
    }

    public void a(List<GroupUpdateMessage> list) {
        if (list != null) {
            if (this.l == null) {
                this.l = new LinkedList();
            }
            this.l.clear();
            this.l.addAll(list);
        }
    }

    public void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.g = imMessageCenterShowItemData;
    }

    public ImMessageCenterShowItemData n() {
        return this.h;
    }

    public ImMessageCenterShowItemData o() {
        return this.i;
    }

    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.i = imMessageCenterShowItemData;
    }

    public void d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.h = imMessageCenterShowItemData;
    }

    public ImMessageCenterShowItemData p() {
        return this.j;
    }

    public void q() {
        this.j = null;
    }

    public boolean r() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("is_show_validate", true);
    }

    public boolean s() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("is_show_updates", true);
    }

    public boolean t() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("is_show_live_notify", true);
    }
}
