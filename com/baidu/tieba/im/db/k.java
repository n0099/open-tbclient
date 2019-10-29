package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import com.tencent.connect.common.Constants;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class k {
    public static void bAC() {
        OldUserData oldUserData;
        ImMessageCenterPojo imMessageCenterPojo;
        ImMessageCenterPojo imMessageCenterPojo2;
        ImMessageCenterPojo imMessageCenterPojo3;
        ImMessageCenterPojo imMessageCenterPojo4;
        ImMessageCenterPojo imMessageCenterPojo5;
        ImMessageCenterPojo imMessageCenterPojo6;
        ImMessageCenterPojo fromCommonMsg;
        LinkedList<ImMessageCenterPojo> bAy = j.bAx().bAy();
        if (bAy != null && bAy.size() != 0) {
            BdLog.i("upgradeData");
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            long j = 0;
            boolean z = false;
            for (String str : m.bAF().bAh()) {
                if (!TextUtils.isEmpty(str)) {
                    long xA = m.bAF().xA(str);
                    if (j < xA) {
                        j = xA;
                    }
                    CommonMsgPojo xB = m.bAF().xB(str);
                    if (xB != null && (fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(xB)) != null) {
                        if (fromCommonMsg.getIsFriend() == 0 && fromCommonMsg.getUnread_count() > 0) {
                            z = true;
                        }
                        fromCommonMsg.setUnread_count(m.bAF().xz(str));
                        b(linkedList, fromCommonMsg);
                        z = z;
                    }
                }
            }
            boolean z2 = false;
            for (String str2 : l.bAD().bAh()) {
                if (!TextUtils.isEmpty(str2)) {
                    long xA2 = l.bAD().xA(str2);
                    if (j < xA2) {
                        j = xA2;
                    }
                    CommonMsgPojo xB2 = l.bAD().xB(str2);
                    if (xB2 != null) {
                        xB2.checkRidAndSelf();
                        ImMessageCenterPojo fromCommonMsg2 = ImMessageCenterPojo.fromCommonMsg(xB2);
                        if (fromCommonMsg2 != null) {
                            int xz = l.bAD().xz(str2);
                            fromCommonMsg2.setUnread_count(xz);
                            boolean z3 = xz > 0 ? true : z2;
                            b(linkedList2, fromCommonMsg2);
                            z2 = z3;
                        }
                    }
                }
            }
            ImMessageCenterPojo imMessageCenterPojo7 = null;
            ImMessageCenterPojo imMessageCenterPojo8 = null;
            ImMessageCenterPojo imMessageCenterPojo9 = null;
            ImMessageCenterPojo imMessageCenterPojo10 = null;
            ImMessageCenterPojo imMessageCenterPojo11 = null;
            ImMessageCenterPojo imMessageCenterPojo12 = null;
            Iterator<ImMessageCenterPojo> it = bAy.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                if (next != null && next.getGid() != null) {
                    if (next.getGid().equals(TbEnum.CustomGroupId.OFFICIAL_MERGE)) {
                        ImMessageCenterPojo imMessageCenterPojo13 = imMessageCenterPojo12;
                        imMessageCenterPojo2 = imMessageCenterPojo11;
                        imMessageCenterPojo3 = imMessageCenterPojo10;
                        imMessageCenterPojo4 = imMessageCenterPojo9;
                        imMessageCenterPojo5 = imMessageCenterPojo8;
                        imMessageCenterPojo6 = next;
                        next = imMessageCenterPojo13;
                    } else if (next.getGid().equals(TbEnum.CustomGroupId.STRANGE_MERGE)) {
                        imMessageCenterPojo6 = imMessageCenterPojo7;
                        ImMessageCenterPojo imMessageCenterPojo14 = imMessageCenterPojo11;
                        imMessageCenterPojo3 = imMessageCenterPojo10;
                        imMessageCenterPojo4 = imMessageCenterPojo9;
                        imMessageCenterPojo5 = next;
                        next = imMessageCenterPojo12;
                        imMessageCenterPojo2 = imMessageCenterPojo14;
                    } else if (next.getCustomGroupType() == 0 && next.getGroup_name() != null && next.getGroup_name().equals("系统消息群")) {
                        imMessageCenterPojo5 = imMessageCenterPojo8;
                        imMessageCenterPojo6 = imMessageCenterPojo7;
                        ImMessageCenterPojo imMessageCenterPojo15 = imMessageCenterPojo10;
                        imMessageCenterPojo4 = next;
                        next = imMessageCenterPojo12;
                        imMessageCenterPojo2 = imMessageCenterPojo11;
                        imMessageCenterPojo3 = imMessageCenterPojo15;
                    } else if (next.getGid().equals("9") && next.getCustomGroupType() == 5) {
                        imMessageCenterPojo4 = imMessageCenterPojo9;
                        imMessageCenterPojo5 = imMessageCenterPojo8;
                        imMessageCenterPojo6 = imMessageCenterPojo7;
                        ImMessageCenterPojo imMessageCenterPojo16 = imMessageCenterPojo12;
                        imMessageCenterPojo2 = imMessageCenterPojo11;
                        imMessageCenterPojo3 = next;
                        next = imMessageCenterPojo16;
                    } else if (next.getGid().equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) && next.getCustomGroupType() == 6) {
                        imMessageCenterPojo3 = imMessageCenterPojo10;
                        imMessageCenterPojo4 = imMessageCenterPojo9;
                        imMessageCenterPojo5 = imMessageCenterPojo8;
                        imMessageCenterPojo6 = imMessageCenterPojo7;
                        ImMessageCenterPojo imMessageCenterPojo17 = imMessageCenterPojo12;
                        imMessageCenterPojo2 = next;
                        next = imMessageCenterPojo17;
                    } else if (next.getGroup_name() != null && next.getGroup_name().equals("我的私聊") && next.getCustomGroupType() == 2) {
                        imMessageCenterPojo2 = imMessageCenterPojo11;
                        imMessageCenterPojo3 = imMessageCenterPojo10;
                        imMessageCenterPojo4 = imMessageCenterPojo9;
                        imMessageCenterPojo5 = imMessageCenterPojo8;
                        imMessageCenterPojo6 = imMessageCenterPojo7;
                    } else {
                        next = imMessageCenterPojo12;
                        imMessageCenterPojo2 = imMessageCenterPojo11;
                        imMessageCenterPojo3 = imMessageCenterPojo10;
                        imMessageCenterPojo4 = imMessageCenterPojo9;
                        imMessageCenterPojo5 = imMessageCenterPojo8;
                        imMessageCenterPojo6 = imMessageCenterPojo7;
                    }
                    imMessageCenterPojo7 = imMessageCenterPojo6;
                    imMessageCenterPojo8 = imMessageCenterPojo5;
                    imMessageCenterPojo9 = imMessageCenterPojo4;
                    imMessageCenterPojo10 = imMessageCenterPojo3;
                    imMessageCenterPojo11 = imMessageCenterPojo2;
                    imMessageCenterPojo12 = next;
                }
            }
            if (imMessageCenterPojo7 == null) {
                imMessageCenterPojo7 = new ImMessageCenterPojo();
                imMessageCenterPojo7.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                imMessageCenterPojo7.setCustomGroupType(-8);
                imMessageCenterPojo7.setIs_hidden(1);
                imMessageCenterPojo7.setUnread_count(0);
            } else {
                imMessageCenterPojo7.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                imMessageCenterPojo7.setCustomGroupType(-8);
                imMessageCenterPojo7.setUnread_count(z2 ? 1 : 0);
                bAy.remove(imMessageCenterPojo7);
            }
            if (linkedList2 != null && linkedList2.size() > 0) {
                imMessageCenterPojo7.setLast_content(((ImMessageCenterPojo) linkedList2.get(0)).getLast_content());
                imMessageCenterPojo7.setLast_content_time(((ImMessageCenterPojo) linkedList2.get(0)).getLast_content_time());
                imMessageCenterPojo7.setLast_rid(((ImMessageCenterPojo) linkedList2.get(0)).getLast_rid());
                imMessageCenterPojo7.setLast_user_name(((ImMessageCenterPojo) linkedList2.get(0)).getLast_user_name());
            }
            j.bAx().b(imMessageCenterPojo7, 2);
            if (linkedList2 != null && linkedList2.size() > 0) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo18 = (ImMessageCenterPojo) it2.next();
                    imMessageCenterPojo18.setCustomGroupType(4);
                    Iterator<ImMessageCenterPojo> it3 = bAy.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            ImMessageCenterPojo next2 = it3.next();
                            if (next2.getGid() != null && next2.getGid().equals(imMessageCenterPojo18.getGid())) {
                                imMessageCenterPojo18.setIs_hidden(next2.getIs_hidden());
                                break;
                            }
                        }
                    }
                    j.bAx().b(imMessageCenterPojo18, 2);
                }
            }
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it4 = linkedList.iterator();
                while (it4.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo19 = (ImMessageCenterPojo) it4.next();
                    imMessageCenterPojo19.setCustomGroupType(2);
                    Iterator<ImMessageCenterPojo> it5 = bAy.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            ImMessageCenterPojo next3 = it5.next();
                            if (next3.getGid() != null && next3.getGid().equals(imMessageCenterPojo19.getGid())) {
                                imMessageCenterPojo19.setIs_hidden(next3.getIs_hidden());
                                break;
                            }
                        }
                    }
                    j.bAx().b(imMessageCenterPojo19, 2);
                }
            }
            if (imMessageCenterPojo8 == null) {
                imMessageCenterPojo8 = new ImMessageCenterPojo();
                imMessageCenterPojo8.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                imMessageCenterPojo8.setCustomGroupType(-7);
                imMessageCenterPojo8.setIs_hidden(1);
                imMessageCenterPojo8.setUnread_count(0);
            } else {
                imMessageCenterPojo8.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                imMessageCenterPojo8.setCustomGroupType(-7);
                imMessageCenterPojo8.setUnread_count(z ? 1 : 0);
                bAy.remove(imMessageCenterPojo8);
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
                    imMessageCenterPojo8.setLast_content(imMessageCenterPojo.getLast_content());
                    imMessageCenterPojo8.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                    imMessageCenterPojo8.setLast_rid(imMessageCenterPojo.getLast_rid());
                    imMessageCenterPojo8.setLast_user_name(imMessageCenterPojo.getLast_user_name());
                }
            }
            j.bAx().b(imMessageCenterPojo8, 2);
            if (imMessageCenterPojo9 == null) {
                imMessageCenterPojo9 = new ImMessageCenterPojo();
            } else {
                j.bAx().aI(imMessageCenterPojo9.getGid(), 0);
            }
            imMessageCenterPojo9.setCustomGroupType(-2);
            imMessageCenterPojo9.setIs_hidden(1);
            imMessageCenterPojo9.setPulled_msgId(c.bAl().xA(imMessageCenterPojo9.getGid()));
            j.bAx().b(imMessageCenterPojo9, 2);
            if (imMessageCenterPojo10 == null) {
                imMessageCenterPojo10 = new ImMessageCenterPojo();
            }
            imMessageCenterPojo10.setCustomGroupType(5);
            imMessageCenterPojo10.setIs_hidden(1);
            imMessageCenterPojo10.setPulled_msgId(c.bAl().xA(imMessageCenterPojo10.getGid()));
            j.bAx().b(imMessageCenterPojo10, 2);
            if (imMessageCenterPojo11 == null) {
                imMessageCenterPojo11 = new ImMessageCenterPojo();
            }
            imMessageCenterPojo11.setCustomGroupType(6);
            imMessageCenterPojo11.setIs_hidden(1);
            imMessageCenterPojo11.setPulled_msgId(c.bAl().xA(imMessageCenterPojo11.getGid()));
            j.bAx().b(imMessageCenterPojo11, 2);
            if (imMessageCenterPojo12 == null) {
                imMessageCenterPojo12 = new ImMessageCenterPojo();
            } else {
                j.bAx().aI(imMessageCenterPojo12.getGid(), 2);
            }
            imMessageCenterPojo12.setCustomGroupType(-1);
            imMessageCenterPojo12.setIs_hidden(1);
            imMessageCenterPojo12.setPulled_msgId(j);
            j.bAx().b(imMessageCenterPojo12, 2);
            ImMessageCenterPojo imMessageCenterPojo20 = new ImMessageCenterPojo();
            imMessageCenterPojo20.setGid(TbEnum.CustomGroupId.GROUP_UPDATE);
            imMessageCenterPojo20.setCustomGroupType(-3);
            imMessageCenterPojo20.setIs_hidden(com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.IS_SHOW_UPDATES, true) ? 0 : 1);
            imMessageCenterPojo20.setUnread_count(d.bAm().aD("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change", 1));
            LinkedList<GroupNewsPojo> a = d.bAm().a(0L, 1, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change");
            if (a != null && a.size() > 0) {
                imMessageCenterPojo20.setLast_content(a.get(0).getContent());
                imMessageCenterPojo20.setLast_content_time(a.get(0).getTime());
            }
            j.bAx().b(imMessageCenterPojo20, 2);
            ImMessageCenterPojo imMessageCenterPojo21 = new ImMessageCenterPojo();
            imMessageCenterPojo21.setGid(TbEnum.CustomGroupId.GROUP_VALIDATION);
            imMessageCenterPojo21.setCustomGroupType(-4);
            imMessageCenterPojo21.setIs_hidden(com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.IS_SHOW_VALIDATE, true) ? 0 : 1);
            imMessageCenterPojo21.setUnread_count(d.bAm().aD("apply_join_group", 1));
            LinkedList<GroupNewsPojo> a2 = d.bAm().a(0L, 1, 0, "apply_join_group");
            if (a2 != null && a2.size() > 0) {
                imMessageCenterPojo21.setLast_content(a2.get(0).getContent());
                imMessageCenterPojo21.setLast_content_time(a2.get(0).getTime());
            }
            j.bAx().b(imMessageCenterPojo21, 2);
            Iterator<ImMessageCenterPojo> it7 = bAy.iterator();
            while (it7.hasNext()) {
                ImMessageCenterPojo next4 = it7.next();
                if (next4 != null && next4.getGid() != null && next4.getCustomGroupType() == 1) {
                    next4.setUnread_count(c.bAl().xz(next4.getGid()));
                    next4.setPulled_msgId(c.bAl().xA(next4.getGid()));
                    CommonMsgPojo xB3 = c.bAl().xB(next4.getGid());
                    if (xB3 != null) {
                        xB3.checkRidAndSelf();
                        String aq = com.baidu.tieba.im.util.e.aq(xB3.getMsg_type(), xB3.getContent());
                        UserData userData = new UserData();
                        try {
                            userData = (UserData) OrmObject.objectWithJsonStr(xB3.getUser_info(), UserData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String str3 = "";
                        if (userData != null) {
                            if (com.baidu.adp.lib.util.k.isEmpty(userData.getUserId())) {
                                OldUserData oldUserData2 = new OldUserData();
                                try {
                                    oldUserData = (OldUserData) OrmObject.objectWithJsonStr(xB3.getUser_info(), OldUserData.class);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    oldUserData = oldUserData2;
                                }
                                if (oldUserData != null) {
                                    oldUserData.setToUserData(userData);
                                }
                            }
                            str3 = userData.getName_show();
                        }
                        next4.setLast_content(aq);
                        next4.setLast_user_name(str3);
                        next4.setLast_rid(xB3.getRid());
                        next4.setLast_content_time(xB3.getCreate_time() * 1000);
                    }
                    j.bAx().b(next4, 2);
                }
            }
            h.bAs().xO("delete from tb_message_center where custom_group_type is null or custom_group_type=0 or gid in (0,2,3,6,11,12)");
        }
    }

    private static void b(LinkedList<ImMessageCenterPojo> linkedList, ImMessageCenterPojo imMessageCenterPojo) {
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
