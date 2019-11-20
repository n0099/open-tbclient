package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {
    private int eZS = 0;
    private int eZT = 0;
    private int eZU = 0;
    private String eZV = null;

    public boolean bdH() {
        return this.eZS != 0;
    }

    public boolean bdI() {
        return this.eZT != 0;
    }

    public int bdJ() {
        return this.eZU;
    }

    public String bdK() {
        return this.eZV;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.eZS = forumCreateInfo.is_show_create.intValue();
            this.eZT = forumCreateInfo.is_can_create.intValue();
            this.eZU = forumCreateInfo.can_create_errno.intValue();
            this.eZV = forumCreateInfo.can_create_errdata;
        }
    }
}
