package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes9.dex */
public class ForumCreateInfoData extends OrmObject {
    private int gOR = 0;
    private int gOS = 0;
    private int gOT = 0;
    private String gOU = null;

    public boolean bNY() {
        return this.gOR != 0;
    }

    public boolean bNZ() {
        return this.gOS != 0;
    }

    public int bOa() {
        return this.gOT;
    }

    public String bOb() {
        return this.gOU;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.gOR = forumCreateInfo.is_show_create.intValue();
            this.gOS = forumCreateInfo.is_can_create.intValue();
            this.gOT = forumCreateInfo.can_create_errno.intValue();
            this.gOU = forumCreateInfo.can_create_errdata;
        }
    }
}
