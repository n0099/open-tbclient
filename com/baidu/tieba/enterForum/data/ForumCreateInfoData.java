package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes22.dex */
public class ForumCreateInfoData extends OrmObject {
    private int iup = 0;
    private int iuq = 0;
    private int iur = 0;
    private String ius = null;

    public boolean cuO() {
        return this.iup != 0;
    }

    public boolean cuP() {
        return this.iuq != 0;
    }

    public int cuQ() {
        return this.iur;
    }

    public String cuR() {
        return this.ius;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.iup = forumCreateInfo.is_show_create.intValue();
            this.iuq = forumCreateInfo.is_can_create.intValue();
            this.iur = forumCreateInfo.can_create_errno.intValue();
            this.ius = forumCreateInfo.can_create_errdata;
        }
    }
}
