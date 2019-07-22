package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {
    private int eWh = 0;
    private int eWi = 0;
    private int eWj = 0;
    private String eWk = null;

    public boolean bfj() {
        return this.eWh != 0;
    }

    public boolean bfk() {
        return this.eWi != 0;
    }

    public int bfl() {
        return this.eWj;
    }

    public String bfm() {
        return this.eWk;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.eWh = forumCreateInfo.is_show_create.intValue();
            this.eWi = forumCreateInfo.is_can_create.intValue();
            this.eWj = forumCreateInfo.can_create_errno.intValue();
            this.eWk = forumCreateInfo.can_create_errdata;
        }
    }
}
