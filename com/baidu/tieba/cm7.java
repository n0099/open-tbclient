package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes3.dex */
public class cm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ImMessageCenterPojo a(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7) {
                if (imMessageCenterPojo.getUnread_count() <= 0) {
                    return imMessageCenterPojo;
                }
                return b(imMessageCenterPojo, to7.n().l());
            }
            return imMessageCenterPojo;
        }
        return (ImMessageCenterPojo) invokeL.objValue;
    }

    public static ImMessageCenterPojo b(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, imMessageCenterPojo, list)) == null) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setGid(imMessageCenterPojo.getGid());
            imMessageCenterPojo2.setGroup_name(imMessageCenterPojo.getGroup_name());
            imMessageCenterPojo2.setNameShow(imMessageCenterPojo.getNameShow());
            imMessageCenterPojo2.setGroup_head(imMessageCenterPojo.getGroup_head());
            imMessageCenterPojo2.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
            imMessageCenterPojo2.setIs_hidden(imMessageCenterPojo.getIs_hidden());
            imMessageCenterPojo2.setUnread_count(imMessageCenterPojo.getUnread_count());
            imMessageCenterPojo2.setLast_rid(imMessageCenterPojo.getLast_rid());
            imMessageCenterPojo2.setLast_user_name(imMessageCenterPojo.getLast_user_name());
            imMessageCenterPojo2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
            imMessageCenterPojo2.setLast_content(imMessageCenterPojo.getLast_content());
            imMessageCenterPojo2.setSend_status(imMessageCenterPojo.getSend_status());
            imMessageCenterPojo2.setType(imMessageCenterPojo.getType());
            imMessageCenterPojo2.setSelf(imMessageCenterPojo.isSelf());
            imMessageCenterPojo2.setIsFriend(imMessageCenterPojo.getIsFriend());
            imMessageCenterPojo2.setFollowStatus(imMessageCenterPojo.getFollowStatus());
            imMessageCenterPojo2.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            boolean z = true;
            for (ImMessageCenterPojo imMessageCenterPojo3 : list) {
                if (imMessageCenterPojo3 != null && imMessageCenterPojo3.getCustomGroupType() == 2 && imMessageCenterPojo3.getIsFriend() == 0) {
                    if (!up7.j().c(currentAccount, imMessageCenterPojo3.getGid())) {
                        imMessageCenterPojo2.setUnread_count(imMessageCenterPojo2.getUnread_count() - imMessageCenterPojo3.getUnread_count());
                    } else {
                        vp7.a().c(true);
                        z = false;
                    }
                }
            }
            if (z) {
                imMessageCenterPojo2.setUnread_count(1);
                vp7.a().c(false);
            }
            return imMessageCenterPojo2;
        }
        return (ImMessageCenterPojo) invokeLL.objValue;
    }
}
