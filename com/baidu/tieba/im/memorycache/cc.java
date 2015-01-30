package com.baidu.tieba.im.memorycache;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
public class cc {
    public static ImMessageCenterPojo t(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != -7 || imMessageCenterPojo.getUnread_count() <= 0) ? imMessageCenterPojo : b(imMessageCenterPojo, c.QO().QW());
    }

    private static ImMessageCenterPojo b(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
        imMessageCenterPojo2.setGid(imMessageCenterPojo.getGid());
        imMessageCenterPojo2.setGroup_name(imMessageCenterPojo.getGroup_name());
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
        imMessageCenterPojo2.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        boolean z = true;
        for (ImMessageCenterPojo imMessageCenterPojo3 : list) {
            if (imMessageCenterPojo3 != null && imMessageCenterPojo3.getCustomGroupType() == 2 && imMessageCenterPojo3.getIsFriend() == 0) {
                if (!com.baidu.tieba.im.settingcache.j.Tu().aH(currentAccount, imMessageCenterPojo3.getGid())) {
                    imMessageCenterPojo2.setUnread_count(imMessageCenterPojo2.getUnread_count() - imMessageCenterPojo3.getUnread_count());
                } else {
                    com.baidu.tieba.im.settingcache.l.Tv().setAcceptNotify(true);
                    z = false;
                }
            }
        }
        if (z) {
            imMessageCenterPojo2.setUnread_count(1);
            com.baidu.tieba.im.settingcache.l.Tv().setAcceptNotify(false);
        }
        return imMessageCenterPojo2;
    }
}
