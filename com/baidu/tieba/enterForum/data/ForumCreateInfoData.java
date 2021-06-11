package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f14439e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f14440f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f14441g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f14442h = null;

    public void A(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.f14439e = forumCreateInfo.is_show_create.intValue();
            this.f14440f = forumCreateInfo.is_can_create.intValue();
            this.f14441g = forumCreateInfo.can_create_errno.intValue();
            this.f14442h = forumCreateInfo.can_create_errdata;
        }
    }

    public String w() {
        return this.f14442h;
    }

    public int x() {
        return this.f14441g;
    }

    public boolean y() {
        return this.f14440f != 0;
    }

    public boolean z() {
        return this.f14439e != 0;
    }
}
