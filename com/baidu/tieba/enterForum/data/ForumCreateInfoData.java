package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes6.dex */
public class ForumCreateInfoData extends OrmObject {
    private int fOz = 0;
    private int fOA = 0;
    private int fOB = 0;
    private String fOC = null;

    public boolean bvd() {
        return this.fOz != 0;
    }

    public boolean bve() {
        return this.fOA != 0;
    }

    public int bvf() {
        return this.fOB;
    }

    public String bvg() {
        return this.fOC;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.fOz = forumCreateInfo.is_show_create.intValue();
            this.fOA = forumCreateInfo.is_can_create.intValue();
            this.fOB = forumCreateInfo.can_create_errno.intValue();
            this.fOC = forumCreateInfo.can_create_errdata;
        }
    }
}
