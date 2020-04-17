package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.settingcache.f;
import java.util.List;
/* loaded from: classes13.dex */
public class e {
    public static ImMessageCenterPojo e(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != -7 || imMessageCenterPojo.getUnread_count() <= 0) ? imMessageCenterPojo : b(imMessageCenterPojo, com.baidu.tieba.im.memorycache.b.chC().chJ());
    }

    private static ImMessageCenterPojo b(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        boolean z;
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
        boolean z2 = true;
        for (ImMessageCenterPojo imMessageCenterPojo3 : list) {
            if (imMessageCenterPojo3 != null && imMessageCenterPojo3.getCustomGroupType() == 2 && imMessageCenterPojo3.getIsFriend() == 0) {
                if (!com.baidu.tieba.im.settingcache.e.ciW().dT(currentAccount, imMessageCenterPojo3.getGid())) {
                    imMessageCenterPojo2.setUnread_count(imMessageCenterPojo2.getUnread_count() - imMessageCenterPojo3.getUnread_count());
                    z = z2;
                } else {
                    f.ciX().setAcceptNotify(true);
                    z = false;
                }
                z2 = z;
            }
        }
        if (z2) {
            imMessageCenterPojo2.setUnread_count(1);
            f.ciX().setAcceptNotify(false);
        }
        return imMessageCenterPojo2;
    }
}
