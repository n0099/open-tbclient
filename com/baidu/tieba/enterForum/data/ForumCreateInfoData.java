package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes9.dex */
public class ForumCreateInfoData extends OrmObject {
    private int fUe = 0;
    private int fUf = 0;
    private int fUg = 0;
    private String fUh = null;

    public boolean bxK() {
        return this.fUe != 0;
    }

    public boolean bxL() {
        return this.fUf != 0;
    }

    public int bxM() {
        return this.fUg;
    }

    public String bxN() {
        return this.fUh;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.fUe = forumCreateInfo.is_show_create.intValue();
            this.fUf = forumCreateInfo.is_can_create.intValue();
            this.fUg = forumCreateInfo.can_create_errno.intValue();
            this.fUh = forumCreateInfo.can_create_errdata;
        }
    }
}
