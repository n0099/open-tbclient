package com.baidu.tieba.im;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    public static ImMessageCenterPojo d(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != -8 || imMessageCenterPojo.getUnread_count() <= 0) ? imMessageCenterPojo : a(imMessageCenterPojo, com.baidu.tieba.im.memorycache.b.bTW().bUc());
    }

    private static ImMessageCenterPojo a(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setGid(imMessageCenterPojo.getGid());
        imMessageCenterPojo2.setGroup_name(imMessageCenterPojo.getGroup_name());
        imMessageCenterPojo2.setNameShow(imMessageCenterPojo.getNameShow());
        imMessageCenterPojo2.setGroup_head(imMessageCenterPojo.getGroup_head());
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
        for (ImMessageCenterPojo imMessageCenterPojo3 : list) {
            if (imMessageCenterPojo3 != null && imMessageCenterPojo3.getCustomGroupType() == 4) {
                if (!com.baidu.tieba.im.settingcache.d.bVp().dv(currentAccount, imMessageCenterPojo3.getGid())) {
                    imMessageCenterPojo2.setUnread_count(imMessageCenterPojo2.getUnread_count() - imMessageCenterPojo3.getUnread_count());
                } else {
                    com.baidu.tieba.im.settingcache.c.bVo().setAcceptNotify(true);
                }
            }
        }
        if (imMessageCenterPojo2.getUnread_count() <= 0) {
            imMessageCenterPojo2.setUnread_count(1);
            com.baidu.tieba.im.settingcache.c.bVo().setAcceptNotify(false);
        }
        return imMessageCenterPojo2;
    }
}
