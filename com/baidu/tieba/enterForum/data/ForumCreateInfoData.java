package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes2.dex */
public class ForumCreateInfoData extends OrmObject {
    private int iBV = 0;
    private int iBW = 0;
    private int iBX = 0;
    private String iBY = null;

    public boolean ctQ() {
        return this.iBV != 0;
    }

    public boolean ctR() {
        return this.iBW != 0;
    }

    public int ctS() {
        return this.iBX;
    }

    public String ctT() {
        return this.iBY;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.iBV = forumCreateInfo.is_show_create.intValue();
            this.iBW = forumCreateInfo.is_can_create.intValue();
            this.iBX = forumCreateInfo.can_create_errno.intValue();
            this.iBY = forumCreateInfo.can_create_errdata;
        }
    }
}
