package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes21.dex */
public class ForumCreateInfoData extends OrmObject {
    private int hBn = 0;
    private int hBo = 0;
    private int hBp = 0;
    private String hBq = null;

    public boolean chS() {
        return this.hBn != 0;
    }

    public boolean chT() {
        return this.hBo != 0;
    }

    public int chU() {
        return this.hBp;
    }

    public String chV() {
        return this.hBq;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.hBn = forumCreateInfo.is_show_create.intValue();
            this.hBo = forumCreateInfo.is_can_create.intValue();
            this.hBp = forumCreateInfo.can_create_errno.intValue();
            this.hBq = forumCreateInfo.can_create_errdata;
        }
    }
}
