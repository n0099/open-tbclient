package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes21.dex */
public class ForumCreateInfoData extends OrmObject {
    private int iju = 0;
    private int ijv = 0;
    private int ijw = 0;
    private String ijx = null;

    public boolean cqz() {
        return this.iju != 0;
    }

    public boolean cqA() {
        return this.ijv != 0;
    }

    public int cqB() {
        return this.ijw;
    }

    public String cqC() {
        return this.ijx;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.iju = forumCreateInfo.is_show_create.intValue();
            this.ijv = forumCreateInfo.is_can_create.intValue();
            this.ijw = forumCreateInfo.can_create_errno.intValue();
            this.ijx = forumCreateInfo.can_create_errdata;
        }
    }
}
