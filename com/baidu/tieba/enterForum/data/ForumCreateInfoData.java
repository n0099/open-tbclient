package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes2.dex */
public class ForumCreateInfoData extends OrmObject {
    private int iJC = 0;
    private int iJD = 0;
    private int iJE = 0;
    private String iJF = null;

    public boolean cvp() {
        return this.iJC != 0;
    }

    public boolean cvq() {
        return this.iJD != 0;
    }

    public int cvr() {
        return this.iJE;
    }

    public String cvs() {
        return this.iJF;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.iJC = forumCreateInfo.is_show_create.intValue();
            this.iJD = forumCreateInfo.is_can_create.intValue();
            this.iJE = forumCreateInfo.can_create_errno.intValue();
            this.iJF = forumCreateInfo.can_create_errdata;
        }
    }
}
