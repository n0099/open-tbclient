package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {
    private int eRg = 0;
    private int eRh = 0;
    private int eRi = 0;
    private String eRj = null;

    public boolean bde() {
        return this.eRg != 0;
    }

    public boolean bdf() {
        return this.eRh != 0;
    }

    public int bdg() {
        return this.eRi;
    }

    public String bdh() {
        return this.eRj;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.eRg = forumCreateInfo.is_show_create.intValue();
            this.eRh = forumCreateInfo.is_can_create.intValue();
            this.eRi = forumCreateInfo.can_create_errno.intValue();
            this.eRj = forumCreateInfo.can_create_errdata;
        }
    }
}
