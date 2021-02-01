package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes2.dex */
public class ForumCreateInfoData extends OrmObject {
    private int iHF = 0;
    private int iHG = 0;
    private int iHH = 0;
    private String iHI = null;

    public boolean cvc() {
        return this.iHF != 0;
    }

    public boolean cvd() {
        return this.iHG != 0;
    }

    public int cve() {
        return this.iHH;
    }

    public String cvf() {
        return this.iHI;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.iHF = forumCreateInfo.is_show_create.intValue();
            this.iHG = forumCreateInfo.is_can_create.intValue();
            this.iHH = forumCreateInfo.can_create_errno.intValue();
            this.iHI = forumCreateInfo.can_create_errdata;
        }
    }
}
