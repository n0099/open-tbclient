package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {
    private int eXX = 0;
    private int eXY = 0;
    private int eXZ = 0;
    private String eYa = null;

    public boolean bfP() {
        return this.eXX != 0;
    }

    public boolean bfQ() {
        return this.eXY != 0;
    }

    public int bfR() {
        return this.eXZ;
    }

    public String bfS() {
        return this.eYa;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.eXX = forumCreateInfo.is_show_create.intValue();
            this.eXY = forumCreateInfo.is_can_create.intValue();
            this.eXZ = forumCreateInfo.can_create_errno.intValue();
            this.eYa = forumCreateInfo.can_create_errdata;
        }
    }
}
