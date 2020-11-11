package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes22.dex */
public class ForumCreateInfoData extends OrmObject {
    private int iiG = 0;
    private int iiH = 0;
    private int iiI = 0;
    private String iiJ = null;

    public boolean cqW() {
        return this.iiG != 0;
    }

    public boolean cqX() {
        return this.iiH != 0;
    }

    public int cqY() {
        return this.iiI;
    }

    public String cqZ() {
        return this.iiJ;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.iiG = forumCreateInfo.is_show_create.intValue();
            this.iiH = forumCreateInfo.is_can_create.intValue();
            this.iiI = forumCreateInfo.can_create_errno.intValue();
            this.iiJ = forumCreateInfo.can_create_errdata;
        }
    }
}
