package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes22.dex */
public class ForumCreateInfoData extends OrmObject {
    private int hQi = 0;
    private int hQj = 0;
    private int hQk = 0;
    private String hQl = null;

    public boolean clo() {
        return this.hQi != 0;
    }

    public boolean clp() {
        return this.hQj != 0;
    }

    public int clq() {
        return this.hQk;
    }

    public String clr() {
        return this.hQl;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.hQi = forumCreateInfo.is_show_create.intValue();
            this.hQj = forumCreateInfo.is_can_create.intValue();
            this.hQk = forumCreateInfo.can_create_errno.intValue();
            this.hQl = forumCreateInfo.can_create_errdata;
        }
    }
}
