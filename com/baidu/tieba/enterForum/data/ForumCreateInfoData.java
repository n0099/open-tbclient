package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {
    private int eRh = 0;
    private int eRi = 0;
    private int eRj = 0;
    private String eRk = null;

    public boolean bdh() {
        return this.eRh != 0;
    }

    public boolean bdi() {
        return this.eRi != 0;
    }

    public int bdj() {
        return this.eRj;
    }

    public String bdk() {
        return this.eRk;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.eRh = forumCreateInfo.is_show_create.intValue();
            this.eRi = forumCreateInfo.is_can_create.intValue();
            this.eRj = forumCreateInfo.can_create_errno.intValue();
            this.eRk = forumCreateInfo.can_create_errdata;
        }
    }
}
