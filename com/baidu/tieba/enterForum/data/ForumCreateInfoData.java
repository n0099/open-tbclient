package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes16.dex */
public class ForumCreateInfoData extends OrmObject {
    private int huc = 0;
    private int hud = 0;
    private int hue = 0;
    private String huf = null;

    public boolean ceC() {
        return this.huc != 0;
    }

    public boolean ceD() {
        return this.hud != 0;
    }

    public int ceE() {
        return this.hue;
    }

    public String ceF() {
        return this.huf;
    }

    public void a(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.huc = forumCreateInfo.is_show_create.intValue();
            this.hud = forumCreateInfo.is_can_create.intValue();
            this.hue = forumCreateInfo.can_create_errno.intValue();
            this.huf = forumCreateInfo.can_create_errdata;
        }
    }
}
