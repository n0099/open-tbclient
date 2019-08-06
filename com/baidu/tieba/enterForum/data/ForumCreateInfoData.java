package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {
    private int eWr = 0;
    private int eWs = 0;
    private int eWt = 0;
    private String eWu = null;

    public boolean bfl() {
        return this.eWr != 0;
    }

    public boolean bfm() {
        return this.eWs != 0;
    }

    public int bfn() {
        return this.eWt;
    }

    public String bfo() {
        return this.eWu;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.eWr = forumCreateInfo.is_show_create.intValue();
            this.eWs = forumCreateInfo.is_can_create.intValue();
            this.eWt = forumCreateInfo.can_create_errno.intValue();
            this.eWu = forumCreateInfo.can_create_errdata;
        }
    }
}
