package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {
    private int eBJ = 0;
    private int eBK = 0;
    private int eBL = 0;
    private String eBM = null;

    public boolean aWe() {
        return this.eBJ != 0;
    }

    public boolean aWf() {
        return this.eBK != 0;
    }

    public int aWg() {
        return this.eBL;
    }

    public String aWh() {
        return this.eBM;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.eBJ = forumCreateInfo.is_show_create.intValue();
            this.eBK = forumCreateInfo.is_can_create.intValue();
            this.eBL = forumCreateInfo.can_create_errno.intValue();
            this.eBM = forumCreateInfo.can_create_errdata;
        }
    }
}
