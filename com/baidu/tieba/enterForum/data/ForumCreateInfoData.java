package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes9.dex */
public class ForumCreateInfoData extends OrmObject {
    private int gOG = 0;
    private int gOH = 0;
    private int gOI = 0;
    private String gOJ = null;

    public boolean bNW() {
        return this.gOG != 0;
    }

    public boolean bNX() {
        return this.gOH != 0;
    }

    public int bNY() {
        return this.gOI;
    }

    public String bNZ() {
        return this.gOJ;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.gOG = forumCreateInfo.is_show_create.intValue();
            this.gOH = forumCreateInfo.is_can_create.intValue();
            this.gOI = forumCreateInfo.can_create_errno.intValue();
            this.gOJ = forumCreateInfo.can_create_errdata;
        }
    }
}
