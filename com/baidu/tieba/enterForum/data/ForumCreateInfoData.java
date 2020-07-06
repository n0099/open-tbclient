package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes9.dex */
public class ForumCreateInfoData extends OrmObject {
    private int hbD = 0;
    private int hbE = 0;
    private int hbF = 0;
    private String hbG = null;

    public boolean bRf() {
        return this.hbD != 0;
    }

    public boolean bRg() {
        return this.hbE != 0;
    }

    public int bRh() {
        return this.hbF;
    }

    public String bRi() {
        return this.hbG;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.hbD = forumCreateInfo.is_show_create.intValue();
            this.hbE = forumCreateInfo.is_can_create.intValue();
            this.hbF = forumCreateInfo.can_create_errno.intValue();
            this.hbG = forumCreateInfo.can_create_errdata;
        }
    }
}
