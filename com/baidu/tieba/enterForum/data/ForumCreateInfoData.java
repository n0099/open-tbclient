package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {
    private int eBN = 0;
    private int eBO = 0;
    private int eBP = 0;
    private String eBQ = null;

    public boolean aWe() {
        return this.eBN != 0;
    }

    public boolean aWf() {
        return this.eBO != 0;
    }

    public int aWg() {
        return this.eBP;
    }

    public String aWh() {
        return this.eBQ;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.eBN = forumCreateInfo.is_show_create.intValue();
            this.eBO = forumCreateInfo.is_can_create.intValue();
            this.eBP = forumCreateInfo.can_create_errno.intValue();
            this.eBQ = forumCreateInfo.can_create_errdata;
        }
    }
}
