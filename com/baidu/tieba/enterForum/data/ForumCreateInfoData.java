package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes2.dex */
public class ForumCreateInfoData extends OrmObject {
    private int iGC = 0;
    private int iGD = 0;
    private int iGE = 0;
    private String iGF = null;

    public boolean cxH() {
        return this.iGC != 0;
    }

    public boolean cxI() {
        return this.iGD != 0;
    }

    public int cxJ() {
        return this.iGE;
    }

    public String cxK() {
        return this.iGF;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.iGC = forumCreateInfo.is_show_create.intValue();
            this.iGD = forumCreateInfo.is_can_create.intValue();
            this.iGE = forumCreateInfo.can_create_errno.intValue();
            this.iGF = forumCreateInfo.can_create_errdata;
        }
    }
}
