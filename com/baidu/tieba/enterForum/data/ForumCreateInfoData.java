package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes7.dex */
public class ForumCreateInfoData extends OrmObject {
    private int fRI = 0;
    private int fRJ = 0;
    private int fRK = 0;
    private String fRL = null;

    public boolean bwf() {
        return this.fRI != 0;
    }

    public boolean bwg() {
        return this.fRJ != 0;
    }

    public int bwh() {
        return this.fRK;
    }

    public String bwi() {
        return this.fRL;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.fRI = forumCreateInfo.is_show_create.intValue();
            this.fRJ = forumCreateInfo.is_can_create.intValue();
            this.fRK = forumCreateInfo.can_create_errno.intValue();
            this.fRL = forumCreateInfo.can_create_errdata;
        }
    }
}
