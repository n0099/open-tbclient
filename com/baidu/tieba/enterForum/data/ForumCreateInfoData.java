package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes16.dex */
public class ForumCreateInfoData extends OrmObject {
    private int hhj = 0;
    private int hhk = 0;
    private int hhl = 0;
    private String hhm = null;

    public boolean bUr() {
        return this.hhj != 0;
    }

    public boolean bUs() {
        return this.hhk != 0;
    }

    public int bUt() {
        return this.hhl;
    }

    public String bUu() {
        return this.hhm;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.hhj = forumCreateInfo.is_show_create.intValue();
            this.hhk = forumCreateInfo.is_can_create.intValue();
            this.hhl = forumCreateInfo.can_create_errno.intValue();
            this.hhm = forumCreateInfo.can_create_errdata;
        }
    }
}
