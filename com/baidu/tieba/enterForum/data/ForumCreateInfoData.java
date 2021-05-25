package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f14382e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f14383f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f14384g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f14385h = null;

    public String s() {
        return this.f14385h;
    }

    public int t() {
        return this.f14384g;
    }

    public boolean u() {
        return this.f14383f != 0;
    }

    public boolean v() {
        return this.f14382e != 0;
    }

    public void w(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.f14382e = forumCreateInfo.is_show_create.intValue();
            this.f14383f = forumCreateInfo.is_can_create.intValue();
            this.f14384g = forumCreateInfo.can_create_errno.intValue();
            this.f14385h = forumCreateInfo.can_create_errdata;
        }
    }
}
