package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes9.dex */
public class ForumCreateInfoData extends OrmObject {
    private int gzW = 0;
    private int gzX = 0;
    private int gzY = 0;
    private String gzZ = null;

    public boolean bHD() {
        return this.gzW != 0;
    }

    public boolean bHE() {
        return this.gzX != 0;
    }

    public int bHF() {
        return this.gzY;
    }

    public String bHG() {
        return this.gzZ;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.gzW = forumCreateInfo.is_show_create.intValue();
            this.gzX = forumCreateInfo.is_can_create.intValue();
            this.gzY = forumCreateInfo.can_create_errno.intValue();
            this.gzZ = forumCreateInfo.can_create_errdata;
        }
    }
}
