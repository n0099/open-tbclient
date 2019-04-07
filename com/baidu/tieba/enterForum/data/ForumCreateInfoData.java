package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {
    private int eBu = 0;
    private int eBv = 0;
    private int eBw = 0;
    private String eBx = null;

    public boolean aWc() {
        return this.eBu != 0;
    }

    public boolean aWd() {
        return this.eBv != 0;
    }

    public int aWe() {
        return this.eBw;
    }

    public String aWf() {
        return this.eBx;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.eBu = forumCreateInfo.is_show_create.intValue();
            this.eBv = forumCreateInfo.is_can_create.intValue();
            this.eBw = forumCreateInfo.can_create_errno.intValue();
            this.eBx = forumCreateInfo.can_create_errdata;
        }
    }
}
