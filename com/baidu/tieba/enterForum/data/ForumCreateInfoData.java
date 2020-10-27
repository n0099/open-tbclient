package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes22.dex */
public class ForumCreateInfoData extends OrmObject {
    private int icF = 0;
    private int icG = 0;
    private int icH = 0;
    private String icI = null;

    public boolean cov() {
        return this.icF != 0;
    }

    public boolean cow() {
        return this.icG != 0;
    }

    public int cox() {
        return this.icH;
    }

    public String coy() {
        return this.icI;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.icF = forumCreateInfo.is_show_create.intValue();
            this.icG = forumCreateInfo.is_can_create.intValue();
            this.icH = forumCreateInfo.can_create_errno.intValue();
            this.icI = forumCreateInfo.can_create_errdata;
        }
    }
}
