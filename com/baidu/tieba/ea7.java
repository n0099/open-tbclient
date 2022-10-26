package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class ea7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LinkedList linkedList, ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, linkedList, imMessageCenterPojo) == null) && linkedList != null && imMessageCenterPojo != null) {
            int i = 0;
            int size = linkedList.size();
            while (i < size) {
                ImMessageCenterPojo imMessageCenterPojo2 = (ImMessageCenterPojo) linkedList.get(i);
                if (imMessageCenterPojo2 != null && imMessageCenterPojo.getLast_content_time() > imMessageCenterPojo2.getLast_content_time()) {
                    break;
                }
                i++;
            }
            linkedList.add(i, imMessageCenterPojo);
        }
    }

    public static void b() {
        LinkedList e;
        long j;
        String str;
        ImMessageCenterPojo imMessageCenterPojo;
        ImMessageCenterPojo fromCommonMsg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (e = da7.f().e()) != null && e.size() != 0) {
            BdLog.i("upgradeData");
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            long j2 = 0;
            int i = 0;
            for (String str2 : ga7.w().i()) {
                if (!TextUtils.isEmpty(str2)) {
                    long j3 = ga7.w().j(str2);
                    if (j2 < j3) {
                        j2 = j3;
                    }
                    CommonMsgPojo k = ga7.w().k(str2);
                    if (k != null && (fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(k)) != null) {
                        if (fromCommonMsg.getIsFriend() == 0 && fromCommonMsg.getUnread_count() > 0) {
                            i = 1;
                        }
                        fromCommonMsg.setUnread_count(ga7.w().m(str2));
                        a(linkedList, fromCommonMsg);
                    }
                }
            }
            int i2 = 0;
            for (String str3 : fa7.w().i()) {
                if (!TextUtils.isEmpty(str3)) {
                    long j4 = fa7.w().j(str3);
                    if (j2 < j4) {
                        j2 = j4;
                    }
                    CommonMsgPojo k2 = fa7.w().k(str3);
                    if (k2 != null) {
                        k2.checkRidAndSelf();
                        ImMessageCenterPojo fromCommonMsg2 = ImMessageCenterPojo.fromCommonMsg(k2);
                        if (fromCommonMsg2 != null) {
                            int m = fa7.w().m(str3);
                            fromCommonMsg2.setUnread_count(m);
                            if (m > 0) {
                                i2 = 1;
                            }
                            a(linkedList2, fromCommonMsg2);
                        }
                    }
                }
            }
            Iterator it = e.iterator();
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            ImMessageCenterPojo imMessageCenterPojo5 = null;
            ImMessageCenterPojo imMessageCenterPojo6 = null;
            ImMessageCenterPojo imMessageCenterPojo7 = null;
            while (it.hasNext()) {
                ImMessageCenterPojo imMessageCenterPojo8 = (ImMessageCenterPojo) it.next();
                if (imMessageCenterPojo8 != null && imMessageCenterPojo8.getGid() != null) {
                    if (imMessageCenterPojo8.getGid().equals(TbEnum.CustomGroupId.OFFICIAL_MERGE)) {
                        imMessageCenterPojo2 = imMessageCenterPojo8;
                    } else if (imMessageCenterPojo8.getGid().equals(TbEnum.CustomGroupId.STRANGE_MERGE)) {
                        imMessageCenterPojo3 = imMessageCenterPojo8;
                    } else if (imMessageCenterPojo8.getCustomGroupType() == 0 && imMessageCenterPojo8.getGroup_name() != null && imMessageCenterPojo8.getGroup_name().equals("系统消息群")) {
                        imMessageCenterPojo4 = imMessageCenterPojo8;
                    } else if (imMessageCenterPojo8.getGid().equals("9") && imMessageCenterPojo8.getCustomGroupType() == 5) {
                        imMessageCenterPojo5 = imMessageCenterPojo8;
                    } else if (imMessageCenterPojo8.getGid().equals("10") && imMessageCenterPojo8.getCustomGroupType() == 6) {
                        imMessageCenterPojo6 = imMessageCenterPojo8;
                    } else if (imMessageCenterPojo8.getGroup_name() != null && imMessageCenterPojo8.getGroup_name().equals("我的私聊") && imMessageCenterPojo8.getCustomGroupType() == 2) {
                        imMessageCenterPojo7 = imMessageCenterPojo8;
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
                j = j2;
                imMessageCenterPojo2.setLast_content_time(((ImMessageCenterPojo) linkedList2.get(0)).getLast_content_time());
                imMessageCenterPojo2.setLast_rid(((ImMessageCenterPojo) linkedList2.get(0)).getLast_rid());
                imMessageCenterPojo2.setLast_user_name(((ImMessageCenterPojo) linkedList2.get(0)).getLast_user_name());
            } else {
                j = j2;
            }
            da7.f().n(imMessageCenterPojo2, 2);
            if (linkedList2.size() > 0) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo9 = (ImMessageCenterPojo) it2.next();
                    imMessageCenterPojo9.setCustomGroupType(4);
                    Iterator it3 = e.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            ImMessageCenterPojo imMessageCenterPojo10 = (ImMessageCenterPojo) it3.next();
                            if (imMessageCenterPojo10.getGid() != null && imMessageCenterPojo10.getGid().equals(imMessageCenterPojo9.getGid())) {
                                imMessageCenterPojo9.setIs_hidden(imMessageCenterPojo10.getIs_hidden());
                                break;
                            }
                        }
                    }
                    da7.f().n(imMessageCenterPojo9, 2);
                }
            }
            if (linkedList.size() > 0) {
                Iterator it4 = linkedList.iterator();
                while (it4.hasNext()) {
                    ImMessageCenterPojo imMessageCenterPojo11 = (ImMessageCenterPojo) it4.next();
                    imMessageCenterPojo11.setCustomGroupType(2);
                    Iterator it5 = e.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            ImMessageCenterPojo imMessageCenterPojo12 = (ImMessageCenterPojo) it5.next();
                            if (imMessageCenterPojo12.getGid() != null && imMessageCenterPojo12.getGid().equals(imMessageCenterPojo11.getGid())) {
                                imMessageCenterPojo11.setIs_hidden(imMessageCenterPojo12.getIs_hidden());
                                break;
                            }
                        }
                    }
                    da7.f().n(imMessageCenterPojo11, 2);
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
                        ImMessageCenterPojo imMessageCenterPojo13 = (ImMessageCenterPojo) it6.next();
                        if (imMessageCenterPojo13.getIsFriend() == 0) {
                            imMessageCenterPojo = imMessageCenterPojo13;
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
            da7.f().n(imMessageCenterPojo3, 2);
            if (imMessageCenterPojo4 == null) {
                imMessageCenterPojo4 = new ImMessageCenterPojo();
            } else {
                da7.f().c(imMessageCenterPojo4.getGid(), 0);
            }
            imMessageCenterPojo4.setCustomGroupType(-2);
            imMessageCenterPojo4.setIs_hidden(1);
            imMessageCenterPojo4.setPulled_msgId(w97.h().i(imMessageCenterPojo4.getGid()));
            da7.f().n(imMessageCenterPojo4, 2);
            if (imMessageCenterPojo5 == null) {
                imMessageCenterPojo5 = new ImMessageCenterPojo();
            }
            imMessageCenterPojo5.setCustomGroupType(5);
            imMessageCenterPojo5.setIs_hidden(1);
            imMessageCenterPojo5.setPulled_msgId(w97.h().i(imMessageCenterPojo5.getGid()));
            da7.f().n(imMessageCenterPojo5, 2);
            if (imMessageCenterPojo6 == null) {
                imMessageCenterPojo6 = new ImMessageCenterPojo();
            }
            imMessageCenterPojo6.setCustomGroupType(6);
            imMessageCenterPojo6.setIs_hidden(1);
            imMessageCenterPojo6.setPulled_msgId(w97.h().i(imMessageCenterPojo6.getGid()));
            da7.f().n(imMessageCenterPojo6, 2);
            if (imMessageCenterPojo7 == null) {
                imMessageCenterPojo7 = new ImMessageCenterPojo();
            } else {
                da7.f().c(imMessageCenterPojo7.getGid(), 2);
            }
            ImMessageCenterPojo imMessageCenterPojo14 = imMessageCenterPojo7;
            imMessageCenterPojo14.setCustomGroupType(-1);
            imMessageCenterPojo14.setIs_hidden(1);
            imMessageCenterPojo14.setPulled_msgId(j);
            da7.f().n(imMessageCenterPojo14, 2);
            ImMessageCenterPojo imMessageCenterPojo15 = new ImMessageCenterPojo();
            imMessageCenterPojo15.setGid(TbEnum.CustomGroupId.GROUP_VALIDATION);
            imMessageCenterPojo15.setCustomGroupType(-4);
            imMessageCenterPojo15.setIs_hidden(!ux4.k().h("is_show_validate", true));
            imMessageCenterPojo15.setUnread_count(x97.c().d("apply_join_group", 1));
            LinkedList b = x97.c().b(0L, 1, 0, "apply_join_group");
            if (b != null && b.size() > 0) {
                imMessageCenterPojo15.setLast_content(((GroupNewsPojo) b.get(0)).getContent());
                imMessageCenterPojo15.setLast_content_time(((GroupNewsPojo) b.get(0)).getTime());
            }
            da7.f().n(imMessageCenterPojo15, 2);
            Iterator it7 = e.iterator();
            while (it7.hasNext()) {
                ImMessageCenterPojo imMessageCenterPojo16 = (ImMessageCenterPojo) it7.next();
                if (imMessageCenterPojo16 != null && imMessageCenterPojo16.getGid() != null && imMessageCenterPojo16.getCustomGroupType() == 1) {
                    imMessageCenterPojo16.setUnread_count(w97.h().k(imMessageCenterPojo16.getGid()));
                    imMessageCenterPojo16.setPulled_msgId(w97.h().i(imMessageCenterPojo16.getGid()));
                    CommonMsgPojo j5 = w97.h().j(imMessageCenterPojo16.getGid());
                    if (j5 != null) {
                        j5.checkRidAndSelf();
                        String A = bd7.A(j5.getMsg_type(), j5.getContent());
                        UserData userData = new UserData();
                        try {
                            userData = (UserData) OrmObject.objectWithJsonStr(j5.getUser_info(), UserData.class);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (userData != null) {
                            if (ej.isEmpty(userData.getUserId())) {
                                OldUserData oldUserData = new OldUserData();
                                try {
                                    oldUserData = (OldUserData) OrmObject.objectWithJsonStr(j5.getUser_info(), OldUserData.class);
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                                if (oldUserData != null) {
                                    oldUserData.setToUserData(userData);
                                }
                            }
                            str = userData.getName_show();
                        } else {
                            str = "";
                        }
                        imMessageCenterPojo16.setLast_content(A);
                        imMessageCenterPojo16.setLast_user_name(str);
                        imMessageCenterPojo16.setLast_rid(j5.getRid());
                        imMessageCenterPojo16.setLast_content_time(j5.getCreate_time() * 1000);
                    }
                    da7.f().n(imMessageCenterPojo16, 2);
                }
            }
            ba7.d().c("delete from tb_message_center where custom_group_type is null or custom_group_type=0 or gid in (0,2,3,6,11,12)");
        }
    }
}
