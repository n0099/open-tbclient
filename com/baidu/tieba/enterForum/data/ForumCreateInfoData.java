package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes9.dex */
public class ForumCreateInfoData extends OrmObject {
    private int fUr = 0;
    private int fUs = 0;
    private int fUt = 0;
    private String fUu = null;

    public boolean bxL() {
        return this.fUr != 0;
    }

    public boolean bxM() {
        return this.fUs != 0;
    }

    public int bxN() {
        return this.fUt;
    }

    public String bxO() {
        return this.fUu;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.fUr = forumCreateInfo.is_show_create.intValue();
            this.fUs = forumCreateInfo.is_can_create.intValue();
            this.fUt = forumCreateInfo.can_create_errno.intValue();
            this.fUu = forumCreateInfo.can_create_errdata;
        }
    }
}
