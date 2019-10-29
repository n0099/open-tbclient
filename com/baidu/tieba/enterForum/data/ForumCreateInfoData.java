package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {
    private int faJ = 0;
    private int faK = 0;
    private int faL = 0;
    private String faM = null;

    public boolean bdJ() {
        return this.faJ != 0;
    }

    public boolean bdK() {
        return this.faK != 0;
    }

    public int bdL() {
        return this.faL;
    }

    public String bdM() {
        return this.faM;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.faJ = forumCreateInfo.is_show_create.intValue();
            this.faK = forumCreateInfo.is_can_create.intValue();
            this.faL = forumCreateInfo.can_create_errno.intValue();
            this.faM = forumCreateInfo.can_create_errdata;
        }
    }
}
