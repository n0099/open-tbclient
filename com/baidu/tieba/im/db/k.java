package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
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
    public static void aJO() {
        OldUserData oldUserData;
        ImMessageCenterPojo imMessageCenterPojo;
        ImMessageCenterPojo imMessageCenterPojo2;
        ImMessageCenterPojo imMessageCenterPojo3;
        ImMessageCenterPojo imMessageCenterPojo4;
        ImMessageCenterPojo imMessageCenterPojo5;
        ImMessageCenterPojo imMessageCenterPojo6;
        ImMessageCenterPojo fromCommonMsg;
        LinkedList<ImMessageCenterPojo> aJK = j.aJJ().aJK();
        if (aJK != null && aJK.size() != 0) {
            BdLog.i("upgradeData");
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            long j = 0;
            boolean z = false;
            for (String str : m.aJR().aJv()) {
                if (!TextUtils.isEmpty(str)) {
                    long nX = m.aJR().nX(str);
                    if (j < nX) {
                        j = nX;
                    }
                    CommonMsgPojo nY = m.aJR().nY(str);
                    if (nY != null && (fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(nY)) != null) {
                        if (fromCommonMsg.getIsFriend() == 0 && fromCommonMsg.getUnread_count() > 0) {
                            z = true;
                        }
                        fromCommonMsg.setUnread_count(m.aJR().nW(str));
                        b(linkedList, fromCommonMsg);
                        z = z;
                    }
                }
            }
            boolean z2 = false;
            for (String str2 : l.aJP().aJv()) {
                if (!TextUtils.isEmpty(str2)) {
                    long nX2 = l.aJP().nX(str2);
                    if (j < nX2) {
                        j = nX2;
                    }
                    CommonMsgPojo nY2 = l.aJP().nY(str2);
                    if (nY2 != null) {
                        nY2.checkRidAndSelf();
                        ImMessageCenterPojo fromCommonMsg2 = ImMessageCenterPojo.fromCommonMsg(nY2);
                        if (fromCommonMsg2 != null) {
                            int nW = l.aJP().nW(str2);
                            fromCommonMsg2.setUnread_count(nW);
                            boolean z3 = nW > 0 ? true : z2;
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
            Iterator<ImMessageCenterPojo> it = aJK.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                if (next != null && next.getGid() != null) {
                    if (next.getGid().equals("-1000")) {
                        ImMessageCenterPojo imMessageCenterPojo13 = imMessageCenterPojo12;
                        imMessageCenterPojo2 = imMessageCenterPojo11;
                        imMessageCenterPojo3 = imMessageCenterPojo10;
                        imMessageCenterPojo4 = imMessageCenterPojo9;
                        imMessageCenterPojo5 = imMessageCenterPojo8;
                        imMessageCenterPojo6 = next;
                        next = imMessageCenterPojo13;
                    } else if (next.getGid().equals("-1001")) {
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
                imMessageCenterPojo7.setGid("-1000");
                imMessageCenterPojo7.setCustomGroupType(-8);
                imMessageCenterPojo7.setIs_hidden(1);
                imMessageCenterPojo7.setUnread_count(0);
            } else {
                imMessageCenterPojo7.setGid("-1000");
                imMessageCenterPojo7.setCustomGroupType(-8);
                imMessageCenterPojo7.setUnread_count(z2 ? 1 : 0);
                aJK.remove(imMessageCenterPojo7);
            }
            if (linkedList2 != null && linkedList2.size() > 0) {
                imMessageCenterPojo7.setLast_content(((ImMessageCenterPojo) linkedList2.get(0)).getLast_content());
                imMessageCenterPojo7.setLast_content_time(((ImMessageCenterPojo) linkedList2.get(0)).getLast_content_time());
                imMessageCenterPojo7.setLast_rid(((ImMessageCenterPojo) linkedList2.get(0)).getLast_rid());
                imMessageCenterPojo7.setLast_user_name(((ImMessageCenterPojo) linkedList2.get(0)).getLast_user_name());
            }
            j.aJJ().b(imMessageCenterPojo7, 2);
            if (linkedList2 != null && linkedList2.size() > 0) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo18 = (ImMessageCenterPojo) it2.next();
                    imMessageCenterPojo18.setCustomGroupType(4);
                    Iterator<ImMessageCenterPojo> it3 = aJK.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            ImMessageCenterPojo next2 = it3.next();
                            if (next2.getGid() != null && next2.getGid().equals(imMessageCenterPojo18.getGid())) {
                                imMessageCenterPojo18.setIs_hidden(next2.getIs_hidden());
                                break;
                            }
                        }
                    }
                    j.aJJ().b(imMessageCenterPojo18, 2);
                }
            }
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it4 = linkedList.iterator();
                while (it4.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo19 = (ImMessageCenterPojo) it4.next();
                    imMessageCenterPojo19.setCustomGroupType(2);
                    Iterator<ImMessageCenterPojo> it5 = aJK.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            ImMessageCenterPojo next3 = it5.next();
                            if (next3.getGid() != null && next3.getGid().equals(imMessageCenterPojo19.getGid())) {
                                imMessageCenterPojo19.setIs_hidden(next3.getIs_hidden());
                                break;
                            }
                        }
                    }
                    j.aJJ().b(imMessageCenterPojo19, 2);
                }
            }
            if (imMessageCenterPojo8 == null) {
                imMessageCenterPojo8 = new ImMessageCenterPojo();
                imMessageCenterPojo8.setGid("-1001");
                imMessageCenterPojo8.setCustomGroupType(-7);
                imMessageCenterPojo8.setIs_hidden(1);
                imMessageCenterPojo8.setUnread_count(0);
            } else {
                imMessageCenterPojo8.setGid("-1001");
                imMessageCenterPojo8.setCustomGroupType(-7);
                imMessageCenterPojo8.setUnread_count(z ? 1 : 0);
                aJK.remove(imMessageCenterPojo8);
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
            j.aJJ().b(imMessageCenterPojo8, 2);
            if (imMessageCenterPojo9 == null) {
                imMessageCenterPojo9 = new ImMessageCenterPojo();
            } else {
                j.aJJ().ai(imMessageCenterPojo9.getGid(), 0);
            }
            imMessageCenterPojo9.setCustomGroupType(-2);
            imMessageCenterPojo9.setIs_hidden(1);
            imMessageCenterPojo9.setPulled_msgId(c.aJz().nX(imMessageCenterPojo9.getGid()));
            j.aJJ().b(imMessageCenterPojo9, 2);
            if (imMessageCenterPojo10 == null) {
                imMessageCenterPojo10 = new ImMessageCenterPojo();
            }
            imMessageCenterPojo10.setCustomGroupType(5);
            imMessageCenterPojo10.setIs_hidden(1);
            imMessageCenterPojo10.setPulled_msgId(c.aJz().nX(imMessageCenterPojo10.getGid()));
            j.aJJ().b(imMessageCenterPojo10, 2);
            if (imMessageCenterPojo11 == null) {
                imMessageCenterPojo11 = new ImMessageCenterPojo();
            }
            imMessageCenterPojo11.setCustomGroupType(6);
            imMessageCenterPojo11.setIs_hidden(1);
            imMessageCenterPojo11.setPulled_msgId(c.aJz().nX(imMessageCenterPojo11.getGid()));
            j.aJJ().b(imMessageCenterPojo11, 2);
            if (imMessageCenterPojo12 == null) {
                imMessageCenterPojo12 = new ImMessageCenterPojo();
            } else {
                j.aJJ().ai(imMessageCenterPojo12.getGid(), 2);
            }
            imMessageCenterPojo12.setCustomGroupType(-1);
            imMessageCenterPojo12.setIs_hidden(1);
            imMessageCenterPojo12.setPulled_msgId(j);
            j.aJJ().b(imMessageCenterPojo12, 2);
            ImMessageCenterPojo imMessageCenterPojo20 = new ImMessageCenterPojo();
            imMessageCenterPojo20.setGid("-1002");
            imMessageCenterPojo20.setCustomGroupType(-3);
            imMessageCenterPojo20.setIs_hidden(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_show_updates", true) ? 0 : 1);
            imMessageCenterPojo20.setUnread_count(d.aJA().ad("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change", 1));
            LinkedList<GroupNewsPojo> a = d.aJA().a(0L, 1, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change");
            if (a != null && a.size() > 0) {
                imMessageCenterPojo20.setLast_content(a.get(0).getContent());
                imMessageCenterPojo20.setLast_content_time(a.get(0).getTime());
            }
            j.aJJ().b(imMessageCenterPojo20, 2);
            ImMessageCenterPojo imMessageCenterPojo21 = new ImMessageCenterPojo();
            imMessageCenterPojo21.setGid("-1003");
            imMessageCenterPojo21.setCustomGroupType(-4);
            imMessageCenterPojo21.setIs_hidden(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_show_validate", true) ? 0 : 1);
            imMessageCenterPojo21.setUnread_count(d.aJA().ad("apply_join_group", 1));
            LinkedList<GroupNewsPojo> a2 = d.aJA().a(0L, 1, 0, "apply_join_group");
            if (a2 != null && a2.size() > 0) {
                imMessageCenterPojo21.setLast_content(a2.get(0).getContent());
                imMessageCenterPojo21.setLast_content_time(a2.get(0).getTime());
            }
            j.aJJ().b(imMessageCenterPojo21, 2);
            Iterator<ImMessageCenterPojo> it7 = aJK.iterator();
            while (it7.hasNext()) {
                ImMessageCenterPojo next4 = it7.next();
                if (next4 != null && next4.getGid() != null && next4.getCustomGroupType() == 1) {
                    next4.setUnread_count(c.aJz().nW(next4.getGid()));
                    next4.setPulled_msgId(c.aJz().nX(next4.getGid()));
                    CommonMsgPojo nY3 = c.aJz().nY(next4.getGid());
                    if (nY3 != null) {
                        nY3.checkRidAndSelf();
                        String W = com.baidu.tieba.im.util.e.W(nY3.getMsg_type(), nY3.getContent());
                        UserData userData = new UserData();
                        try {
                            userData = (UserData) OrmObject.objectWithJsonStr(nY3.getUser_info(), UserData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String str3 = "";
                        if (userData != null) {
                            if (com.baidu.adp.lib.util.k.isEmpty(userData.getUserId())) {
                                OldUserData oldUserData2 = new OldUserData();
                                try {
                                    oldUserData = (OldUserData) OrmObject.objectWithJsonStr(nY3.getUser_info(), OldUserData.class);
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
                        next4.setLast_content(W);
                        next4.setLast_user_name(str3);
                        next4.setLast_rid(nY3.getRid());
                        next4.setLast_content_time(nY3.getCreate_time() * 1000);
                    }
                    j.aJJ().b(next4, 2);
                }
            }
            h.aJG().om("delete from tb_message_center where custom_group_type is null or custom_group_type=0 or gid in (0,2,3,6,11,12)");
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
