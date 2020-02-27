package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes9.dex */
public class ForumCreateInfoData extends OrmObject {
    private int fUc = 0;
    private int fUd = 0;
    private int fUe = 0;
    private String fUf = null;

    public boolean bxI() {
        return this.fUc != 0;
    }

    public boolean bxJ() {
        return this.fUd != 0;
    }

    public int bxK() {
        return this.fUe;
    }

    public String bxL() {
        return this.fUf;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.fUc = forumCreateInfo.is_show_create.intValue();
            this.fUd = forumCreateInfo.is_can_create.intValue();
            this.fUe = forumCreateInfo.can_create_errno.intValue();
            this.fUf = forumCreateInfo.can_create_errdata;
        }
    }
}
