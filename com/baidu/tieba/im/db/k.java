package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class k {
    public static void apH() {
        OldUserData oldUserData;
        ImMessageCenterPojo imMessageCenterPojo;
        ImMessageCenterPojo fromCommonMsg;
        LinkedList<ImMessageCenterPojo> apE = j.apD().apE();
        if (apE != null && apE.size() != 0) {
            BdLog.i("upgradeData");
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            long j = 0;
            boolean z = false;
            for (String str : m.apJ().apq()) {
                if (!TextUtils.isEmpty(str)) {
                    long kh = m.apJ().kh(str);
                    if (j < kh) {
                        j = kh;
                    }
                    CommonMsgPojo ki = m.apJ().ki(str);
                    if (ki != null && (fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(ki)) != null) {
                        if (fromCommonMsg.getIsFriend() == 0 && fromCommonMsg.getUnread_count() > 0) {
                            z = true;
                        }
                        fromCommonMsg.setUnread_count(m.apJ().kg(str));
                        a(linkedList, fromCommonMsg);
                        z = z;
                    }
                }
            }
            boolean z2 = false;
            for (String str2 : l.apI().apq()) {
                if (!TextUtils.isEmpty(str2)) {
                    long kh2 = l.apI().kh(str2);
                    if (j < kh2) {
                        j = kh2;
                    }
                    CommonMsgPojo ki2 = l.apI().ki(str2);
                    if (ki2 != null) {
                        ki2.checkRidAndSelf();
                        ImMessageCenterPojo fromCommonMsg2 = ImMessageCenterPojo.fromCommonMsg(ki2);
                        if (fromCommonMsg2 != null) {
                            int kg = l.apI().kg(str2);
                            fromCommonMsg2.setUnread_count(kg);
                            boolean z3 = kg > 0 ? true : z2;
                            a(linkedList2, fromCommonMsg2);
                            z2 = z3;
                        }
                    }
                }
            }
            Iterator<ImMessageCenterPojo> it = apE.iterator();
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            ImMessageCenterPojo imMessageCenterPojo5 = null;
            ImMessageCenterPojo imMessageCenterPojo6 = null;
            ImMessageCenterPojo imMessageCenterPojo7 = null;
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                if (next != null && next.getGid() != null) {
                    if (next.getGid().equals("-1000")) {
                        imMessageCenterPojo2 = next;
                    } else if (next.getGid().equals("-1001")) {
                        imMessageCenterPojo3 = next;
                    } else if (next.getCustomGroupType() == 0 && next.getGroup_name() != null && next.getGroup_name().equals("系统消息群")) {
                        imMessageCenterPojo4 = next;
                    } else if (next.getGid().equals("9") && next.getCustomGroupType() == 5) {
                        imMessageCenterPojo5 = next;
                    } else if (next.getGid().equals("10") && next.getCustomGroupType() == 6) {
                        imMessageCenterPojo6 = next;
                    } else if (next.getGroup_name() != null && next.getGroup_name().equals("我的私聊") && next.getCustomGroupType() == 2) {
                        imMessageCenterPojo7 = next;
                    }
                }
            }
            if (imMessageCenterPojo2 == null) {
                imMessageCenterPojo2 = new ImMessageCenterPojo();
                imMessageCenterPojo2.setGid("-1000");
                imMessageCenterPojo2.setCustomGroupType(-8);
                imMessageCenterPojo2.setIs_hidden(1);
                imMessageCenterPojo2.setUnread_count(0);
            } else {
                imMessageCenterPojo2.setGid("-1000");
                imMessageCenterPojo2.setCustomGroupType(-8);
                imMessageCenterPojo2.setUnread_count(z2 ? 1 : 0);
                apE.remove(imMessageCenterPojo2);
            }
            if (linkedList2 != null && linkedList2.size() > 0) {
                imMessageCenterPojo2.setLast_content(((ImMessageCenterPojo) linkedList2.get(0)).getLast_content());
                imMessageCenterPojo2.setLast_content_time(((ImMessageCenterPojo) linkedList2.get(0)).getLast_content_time());
                imMessageCenterPojo2.setLast_rid(((ImMessageCenterPojo) linkedList2.get(0)).getLast_rid());
                imMessageCenterPojo2.setLast_user_name(((ImMessageCenterPojo) linkedList2.get(0)).getLast_user_name());
            }
            j.apD().b(imMessageCenterPojo2, 2);
            if (linkedList2 != null && linkedList2.size() > 0) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo8 = (ImMessageCenterPojo) it2.next();
                    imMessageCenterPojo8.setCustomGroupType(4);
                    Iterator<ImMessageCenterPojo> it3 = apE.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        ImMessageCenterPojo next2 = it3.next();
                        if (next2.getGid() != null && next2.getGid().equals(imMessageCenterPojo8.getGid())) {
                            imMessageCenterPojo8.setIs_hidden(next2.getIs_hidden());
                            break;
                        }
                    }
                    j.apD().b(imMessageCenterPojo8, 2);
                }
            }
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it4 = linkedList.iterator();
                while (it4.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo9 = (ImMessageCenterPojo) it4.next();
                    imMessageCenterPojo9.setCustomGroupType(2);
                    Iterator<ImMessageCenterPojo> it5 = apE.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        ImMessageCenterPojo next3 = it5.next();
                        if (next3.getGid() != null && next3.getGid().equals(imMessageCenterPojo9.getGid())) {
                            imMessageCenterPojo9.setIs_hidden(next3.getIs_hidden());
                            break;
                        }
                    }
                    j.apD().b(imMessageCenterPojo9, 2);
                }
            }
            if (imMessageCenterPojo3 == null) {
                imMessageCenterPojo3 = new ImMessageCenterPojo();
                imMessageCenterPojo3.setGid("-1001");
                imMessageCenterPojo3.setCustomGroupType(-7);
                imMessageCenterPojo3.setIs_hidden(1);
                imMessageCenterPojo3.setUnread_count(0);
            } else {
                imMessageCenterPojo3.setGid("-1001");
                imMessageCenterPojo3.setCustomGroupType(-7);
                imMessageCenterPojo3.setUnread_count(z ? 1 : 0);
                apE.remove(imMessageCenterPojo3);
            }
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it6 = linkedList.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        imMessageCenterPojo = null;
                        break;
                    }
                    imMessageCenterPojo = (ImMessageCenterPojo) it6.next();
                    if (imMessageCenterPojo.getIsFriend() == 0) {
                        break;
                    }
                }
                if (imMessageCenterPojo != null) {
                    imMessageCenterPojo3.setLast_content(imMessageCenterPojo.getLast_content());
                    imMessageCenterPojo3.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                    imMessageCenterPojo3.setLast_rid(imMessageCenterPojo.getLast_rid());
                    imMessageCenterPojo3.setLast_user_name(imMessageCenterPojo.getLast_user_name());
                }
            }
            j.apD().b(imMessageCenterPojo3, 2);
            if (imMessageCenterPojo4 == null) {
                imMessageCenterPojo4 = new ImMessageCenterPojo();
            } else {
                j.apD().T(imMessageCenterPojo4.getGid(), 0);
            }
            imMessageCenterPojo4.setCustomGroupType(-2);
            imMessageCenterPojo4.setIs_hidden(1);
            imMessageCenterPojo4.setPulled_msgId(c.apu().kh(imMessageCenterPojo4.getGid()));
            j.apD().b(imMessageCenterPojo4, 2);
            if (imMessageCenterPojo5 == null) {
                imMessageCenterPojo5 = new ImMessageCenterPojo();
            }
            imMessageCenterPojo5.setCustomGroupType(5);
            imMessageCenterPojo5.setIs_hidden(1);
            imMessageCenterPojo5.setPulled_msgId(c.apu().kh(imMessageCenterPojo5.getGid()));
            j.apD().b(imMessageCenterPojo5, 2);
            if (imMessageCenterPojo6 == null) {
                imMessageCenterPojo6 = new ImMessageCenterPojo();
            }
            imMessageCenterPojo6.setCustomGroupType(6);
            imMessageCenterPojo6.setIs_hidden(1);
            imMessageCenterPojo6.setPulled_msgId(c.apu().kh(imMessageCenterPojo6.getGid()));
            j.apD().b(imMessageCenterPojo6, 2);
            if (imMessageCenterPojo7 == null) {
                imMessageCenterPojo7 = new ImMessageCenterPojo();
            } else {
                j.apD().T(imMessageCenterPojo7.getGid(), 2);
            }
            imMessageCenterPojo7.setCustomGroupType(-1);
            imMessageCenterPojo7.setIs_hidden(1);
            imMessageCenterPojo7.setPulled_msgId(j);
            j.apD().b(imMessageCenterPojo7, 2);
            ImMessageCenterPojo imMessageCenterPojo10 = new ImMessageCenterPojo();
            imMessageCenterPojo10.setGid("-1002");
            imMessageCenterPojo10.setCustomGroupType(-3);
            imMessageCenterPojo10.setIs_hidden(com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("is_show_updates", true) ? 0 : 1);
            imMessageCenterPojo10.setUnread_count(d.apv().R("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change", 1));
            LinkedList<GroupNewsPojo> a = d.apv().a(0L, 1, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change");
            if (a != null && a.size() > 0) {
                imMessageCenterPojo10.setLast_content(a.get(0).getContent());
                imMessageCenterPojo10.setLast_content_time(a.get(0).getTime());
            }
            j.apD().b(imMessageCenterPojo10, 2);
            ImMessageCenterPojo imMessageCenterPojo11 = new ImMessageCenterPojo();
            imMessageCenterPojo11.setGid("-1003");
            imMessageCenterPojo11.setCustomGroupType(-4);
            imMessageCenterPojo11.setIs_hidden(com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("is_show_validate", true) ? 0 : 1);
            imMessageCenterPojo11.setUnread_count(d.apv().R("apply_join_group", 1));
            LinkedList<GroupNewsPojo> a2 = d.apv().a(0L, 1, 0, "apply_join_group");
            if (a2 != null && a2.size() > 0) {
                imMessageCenterPojo11.setLast_content(a2.get(0).getContent());
                imMessageCenterPojo11.setLast_content_time(a2.get(0).getTime());
            }
            j.apD().b(imMessageCenterPojo11, 2);
            ImMessageCenterPojo imMessageCenterPojo12 = new ImMessageCenterPojo();
            imMessageCenterPojo12.setGid("-1004");
            imMessageCenterPojo12.setCustomGroupType(-5);
            imMessageCenterPojo12.setIs_hidden(com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("is_show_live_notify", true) ? 0 : 1);
            imMessageCenterPojo12.setUnread_count(d.apv().R("live_notify", 1));
            LinkedList<GroupNewsPojo> a3 = d.apv().a(0L, 1, 0, "live_notify");
            if (a3 != null && a3.size() > 0) {
                imMessageCenterPojo12.setLast_content(a3.get(0).getContent());
                imMessageCenterPojo12.setLast_content_time(a3.get(0).getTime());
            }
            j.apD().b(imMessageCenterPojo12, 2);
            Iterator<ImMessageCenterPojo> it7 = apE.iterator();
            while (it7.hasNext()) {
                ImMessageCenterPojo next4 = it7.next();
                if (next4 != null && next4.getGid() != null && next4.getCustomGroupType() == 1) {
                    next4.setUnread_count(c.apu().kg(next4.getGid()));
                    next4.setPulled_msgId(c.apu().kh(next4.getGid()));
                    CommonMsgPojo ki3 = c.apu().ki(next4.getGid());
                    if (ki3 != null) {
                        ki3.checkRidAndSelf();
                        String C = com.baidu.tieba.im.util.h.C(ki3.getMsg_type(), ki3.getContent());
                        UserData userData = new UserData();
                        try {
                            userData = (UserData) OrmObject.objectWithJsonStr(ki3.getUser_info(), UserData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String str3 = "";
                        if (userData != null) {
                            if (com.baidu.adp.lib.util.j.isEmpty(userData.getUserId())) {
                                OldUserData oldUserData2 = new OldUserData();
                                try {
                                    oldUserData = (OldUserData) OrmObject.objectWithJsonStr(ki3.getUser_info(), OldUserData.class);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    oldUserData = oldUserData2;
                                }
                                if (oldUserData != null) {
                                    oldUserData.setToUserData(userData);
                                }
                            }
                            str3 = userData.getUserName();
                        }
                        next4.setLast_content(C);
                        next4.setLast_user_name(str3);
                        next4.setLast_rid(ki3.getRid());
                        next4.setLast_content_time(ki3.getCreate_time() * 1000);
                    }
                    j.apD().b(next4, 2);
                }
            }
            g.apy().ks("delete from tb_message_center where custom_group_type is null or custom_group_type=0 or gid in (0,2,3,6,11,12)");
        }
    }

    private static void a(LinkedList<ImMessageCenterPojo> linkedList, ImMessageCenterPojo imMessageCenterPojo) {
        if (linkedList != null && imMessageCenterPojo != null) {
            int size = linkedList.size();
            int i = 0;
            while (i < size) {
                ImMessageCenterPojo imMessageCenterPojo2 = linkedList.get(i);
                if (imMessageCenterPojo2 != null && imMessageCenterPojo.getLast_content_time() > imMessageCenterPojo2.getLast_content_time()) {
                    break;
                }
                i++;
            }
            linkedList.add(i, imMessageCenterPojo);
        }
    }
}
