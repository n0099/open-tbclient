package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes2.dex */
public class ForumCreateInfoData extends OrmObject {
    private int iHT = 0;
    private int iHU = 0;
    private int iHV = 0;
    private String iHW = null;

    public boolean cvj() {
        return this.iHT != 0;
    }

    public boolean cvk() {
        return this.iHU != 0;
    }

    public int cvl() {
        return this.iHV;
    }

    public String cvm() {
        return this.iHW;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.iHT = forumCreateInfo.is_show_create.intValue();
            this.iHU = forumCreateInfo.is_can_create.intValue();
            this.iHV = forumCreateInfo.can_create_errno.intValue();
            this.iHW = forumCreateInfo.can_create_errdata;
        }
    }
}
