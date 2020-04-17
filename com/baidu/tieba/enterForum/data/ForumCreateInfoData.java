package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes9.dex */
public class ForumCreateInfoData extends OrmObject {
    private int gzQ = 0;
    private int gzR = 0;
    private int gzS = 0;
    private String gzT = null;

    public boolean bHE() {
        return this.gzQ != 0;
    }

    public boolean bHF() {
        return this.gzR != 0;
    }

    public int bHG() {
        return this.gzS;
    }

    public String bHH() {
        return this.gzT;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.gzQ = forumCreateInfo.is_show_create.intValue();
            this.gzR = forumCreateInfo.is_can_create.intValue();
            this.gzS = forumCreateInfo.can_create_errno.intValue();
            this.gzT = forumCreateInfo.can_create_errdata;
        }
    }
}
