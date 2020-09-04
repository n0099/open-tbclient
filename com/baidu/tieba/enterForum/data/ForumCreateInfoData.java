package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes16.dex */
public class ForumCreateInfoData extends OrmObject {
    private int hui = 0;
    private int huj = 0;
    private int huk = 0;
    private String hul = null;

    public boolean ceD() {
        return this.hui != 0;
    }

    public boolean ceE() {
        return this.huj != 0;
    }

    public int ceF() {
        return this.huk;
    }

    public String ceG() {
        return this.hul;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.hui = forumCreateInfo.is_show_create.intValue();
            this.huj = forumCreateInfo.is_can_create.intValue();
            this.huk = forumCreateInfo.can_create_errno.intValue();
            this.hul = forumCreateInfo.can_create_errdata;
        }
    }
}
