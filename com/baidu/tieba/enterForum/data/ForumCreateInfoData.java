package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes9.dex */
public class ForumCreateInfoData extends OrmObject {
    private int fVa = 0;
    private int fVb = 0;
    private int fVc = 0;
    private String fVd = null;

    public boolean bxQ() {
        return this.fVa != 0;
    }

    public boolean bxR() {
        return this.fVb != 0;
    }

    public int bxS() {
        return this.fVc;
    }

    public String bxT() {
        return this.fVd;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.fVa = forumCreateInfo.is_show_create.intValue();
            this.fVb = forumCreateInfo.is_can_create.intValue();
            this.fVc = forumCreateInfo.can_create_errno.intValue();
            this.fVd = forumCreateInfo.can_create_errdata;
        }
    }
}
