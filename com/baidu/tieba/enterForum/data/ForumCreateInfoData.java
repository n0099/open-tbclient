package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f14479e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f14480f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f14481g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f14482h = null;

    public String s() {
        return this.f14482h;
    }

    public int t() {
        return this.f14481g;
    }

    public boolean u() {
        return this.f14480f != 0;
    }

    public boolean v() {
        return this.f14479e != 0;
    }

    public void w(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.f14479e = forumCreateInfo.is_show_create.intValue();
            this.f14480f = forumCreateInfo.is_can_create.intValue();
            this.f14481g = forumCreateInfo.can_create_errno.intValue();
            this.f14482h = forumCreateInfo.can_create_errdata;
        }
    }
}
