package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {
    private int eBv = 0;
    private int eBw = 0;
    private int eBx = 0;
    private String eBy = null;

    public boolean aWc() {
        return this.eBv != 0;
    }

    public boolean aWd() {
        return this.eBw != 0;
    }

    public int aWe() {
        return this.eBx;
    }

    public String aWf() {
        return this.eBy;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.eBv = forumCreateInfo.is_show_create.intValue();
            this.eBw = forumCreateInfo.is_can_create.intValue();
            this.eBx = forumCreateInfo.can_create_errno.intValue();
            this.eBy = forumCreateInfo.can_create_errdata;
        }
    }
}
