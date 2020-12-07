package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes22.dex */
public class ForumCreateInfoData extends OrmObject {
    private int iun = 0;
    private int iuo = 0;
    private int iup = 0;
    private String iuq = null;

    public boolean cuN() {
        return this.iun != 0;
    }

    public boolean cuO() {
        return this.iuo != 0;
    }

    public int cuP() {
        return this.iup;
    }

    public String cuQ() {
        return this.iuq;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.iun = forumCreateInfo.is_show_create.intValue();
            this.iuo = forumCreateInfo.is_can_create.intValue();
            this.iup = forumCreateInfo.can_create_errno.intValue();
            this.iuq = forumCreateInfo.can_create_errdata;
        }
    }
}
