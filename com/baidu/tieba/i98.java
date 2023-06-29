package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class i98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LinkedList<ImMessageCenterPojo> linkedList, ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, linkedList, imMessageCenterPojo) == null) && linkedList != null && imMessageCenterPojo != null) {
            int i = 0;
            int size = linkedList.size();
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

    public static void b() {
        LinkedList<ImMessageCenterPojo> e;
        ImMessageCenterPojo imMessageCenterPojo;
        ImMessageCenterPojo fromCommonMsg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (e = h98.f().e()) != null && e.size() != 0) {
            BdLog.i("upgradeData");
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            long j = 0;
            int i = 0;
            for (String str : k98.w().i()) {
                if (!TextUtils.isEmpty(str)) {
                    long j2 = k98.w().j(str);
                    if (j < j2) {
                        j = j2;
                    }
                    CommonMsgPojo k = k98.w().k(str);
                    if (k != null && (fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(k)) != null) {
                        if (fromCommonMsg.getIsFriend() == 0 && fromCommonMsg.getUnread_count() > 0) {
                            i = 1;
                        }
                        fromCommonMsg.setUnread_count(k98.w().m(str));
                        a(linkedList, fromCommonMsg);
                    }
                }
            }
            int i2 = 0;
            for (String str2 : j98.w().i()) {
                if (!TextUtils.isEmpty(str2)) {
                    long j3 = j98.w().j(str2);
                    if (j < j3) {
                        j = j3;
                    }
                    CommonMsgPojo k2 = j98.w().k(str2);
                    if (k2 != null) {
                        k2.checkRidAndSelf();
                        ImMessageCenterPojo fromCommonMsg2 = ImMessageCenterPojo.fromCommonMsg(k2);
                        if (fromCommonMsg2 != null) {
                            int m = j98.w().m(str2);
                            fromCommonMsg2.setUnread_count(m);
                            if (m > 0) {
                                i2 = 1;
                            }
                            a(linkedList2, fromCommonMsg2);
                        }
                    }
                }
            }
            Iterator<ImMessageCenterPojo> it = e.iterator();
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            ImMessageCenterPojo imMessageCenterPojo5 = null;
            ImMessageCenterPojo imMessageCenterPojo6 = null;
            ImMessageCenterPojo imMessageCenterPojo7 = null;
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                if (next != null && next.getGid() != null) {
                    if (next.getGid().equals(TbEnum.CustomGroupId.OFFICIAL_MERGE)) {
                        imMessageCenterPojo2 = next;
                    } else if (next.getGid().equals(TbEnum.CustomGroupId.STRANGE_MERGE)) {
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
                imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                imMessageCenterPojo2.setCustomGroupType(-8);
                imMessageCenterPojo2.setIs_hidden(1);
                imMessageCenterPojo2.setUnread_count(0);
            } else {
                imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                imMessageCenterPojo2.setCustomGroupType(-8);
                imMessageCenterPojo2.setUnread_count(i2);
                e.remove(imMessageCenterPojo2);
            }
            if (linkedList2.size() > 0) {
                imMessageCenterPojo2.setLast_content(((ImMessageCenterPojo) linkedList2.get(0)).getLast_content());
                imMessageCenterPojo2.setLast_content_time(((ImMessageCenterPojo) linkedList2.get(0)).getLast_content_time());
                imMessageCenterPojo2.setLast_rid(((ImMessageCenterPojo) linkedList2.get(0)).getLast_rid());
                imMessageCenterPojo2.setLast_user_name(((ImMessageCenterPojo) linkedList2.get(0)).getLast_user_name());
            }
            h98.f().n(imMessageCenterPojo2, 2);
            if (linkedList2.size() > 0) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo8 = (ImMessageCenterPojo) it2.next();
                    imMessageCenterPojo8.setCustomGroupType(4);
                    Iterator<ImMessageCenterPojo> it3 = e.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            ImMessageCenterPojo next2 = it3.next();
                            if (next2.getGid() != null && next2.getGid().equals(imMessageCenterPojo8.getGid())) {
                                imMessageCenterPojo8.setIs_hidden(next2.getIs_hidden());
                                break;
                            }
                        }
                    }
                    h98.f().n(imMessageCenterPojo8, 2);
                }
            }
            if (linkedList.size() > 0) {
                Iterator it4 = linkedList.iterator();
                while (it4.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo9 = (ImMessageCenterPojo) it4.next();
                    imMessageCenterPojo9.setCustomGroupType(2);
                    Iterator<ImMessageCenterPojo> it5 = e.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            ImMessageCenterPojo next3 = it5.next();
                            if (next3.getGid() != null && next3.getGid().equals(imMessageCenterPojo9.getGid())) {
                                imMessageCenterPojo9.setIs_hidden(next3.getIs_hidden());
                                break;
                            }
                        }
                    }
                    h98.f().n(imMessageCenterPojo9, 2);
                }
            }
            if (imMessageCenterPojo3 == null) {
                imMessageCenterPojo3 = new ImMessageCenterPojo();
                imMessageCenterPojo3.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                imMessageCenterPojo3.setCustomGroupType(-7);
                imMessageCenterPojo3.setIs_hidden(1);
                imMessageCenterPojo3.setUnread_count(0);
            } else {
                imMessageCenterPojo3.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                imMessageCenterPojo3.setCustomGroupType(-7);
                imMessageCenterPojo3.setUnread_count(i);
                e.remove(imMessageCenterPojo3);
            }
            if (linkedList.size() > 0) {
                Iterator it6 = linkedList.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        imMessageCenterPojo = (ImMessageCenterPojo) it6.next();
                        if (imMessageCenterPojo.getIsFriend() == 0) {
                            break;
                        }
                    } else {
                        imMessageCenterPojo = null;
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
            h98.f().n(imMessageCenterPojo3, 2);
            if (imMessageCenterPojo4 == null) {
                imMessageCenterPojo4 = new ImMessageCenterPojo();
            } else {
                h98.f().c(imMessageCenterPojo4.getGid(), 0);
            }
            imMessageCenterPojo4.setCustomGroupType(-2);
            imMessageCenterPojo4.setIs_hidden(1);
            imMessageCenterPojo4.setPulled_msgId(0L);
            h98.f().n(imMessageCenterPojo4, 2);
            if (imMessageCenterPojo5 == null) {
                imMessageCenterPojo5 = new ImMessageCenterPojo();
            }
            ImMessageCenterPojo imMessageCenterPojo10 = imMessageCenterPojo5;
            imMessageCenterPojo10.setCustomGroupType(5);
            imMessageCenterPojo10.setIs_hidden(1);
            imMessageCenterPojo10.setPulled_msgId(0L);
            h98.f().n(imMessageCenterPojo10, 2);
            if (imMessageCenterPojo6 == null) {
                imMessageCenterPojo6 = new ImMessageCenterPojo();
            }
            ImMessageCenterPojo imMessageCenterPojo11 = imMessageCenterPojo6;
            imMessageCenterPojo11.setCustomGroupType(6);
            imMessageCenterPojo11.setIs_hidden(1);
            imMessageCenterPojo11.setPulled_msgId(0L);
            h98.f().n(imMessageCenterPojo11, 2);
            if (imMessageCenterPojo7 == null) {
                imMessageCenterPojo7 = new ImMessageCenterPojo();
            } else {
                h98.f().c(imMessageCenterPojo7.getGid(), 2);
            }
            ImMessageCenterPojo imMessageCenterPojo12 = imMessageCenterPojo7;
            imMessageCenterPojo12.setCustomGroupType(-1);
            imMessageCenterPojo12.setIs_hidden(1);
            imMessageCenterPojo12.setPulled_msgId(j);
            h98.f().n(imMessageCenterPojo12, 2);
            ImMessageCenterPojo imMessageCenterPojo13 = new ImMessageCenterPojo();
            imMessageCenterPojo13.setGid(TbEnum.CustomGroupId.GROUP_VALIDATION);
            imMessageCenterPojo13.setCustomGroupType(-4);
            imMessageCenterPojo13.setIs_hidden(!r95.p().l("is_show_validate", true));
            imMessageCenterPojo13.setUnread_count(b98.c().d("apply_join_group", 1));
            LinkedList<GroupNewsPojo> b = b98.c().b(0L, 1, 0, "apply_join_group");
            if (b != null && b.size() > 0) {
                imMessageCenterPojo13.setLast_content(b.get(0).getContent());
                imMessageCenterPojo13.setLast_content_time(b.get(0).getTime());
            }
            h98.f().n(imMessageCenterPojo13, 2);
            f98.d().c("delete from tb_message_center where custom_group_type is null or custom_group_type=0 or gid in (0,2,3,6,11,12)");
        }
    }
}
