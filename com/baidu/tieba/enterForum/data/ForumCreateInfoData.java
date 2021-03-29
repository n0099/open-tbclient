package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f15372e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f15373f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f15374g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f15375h = null;

    public String s() {
        return this.f15375h;
    }

    public int t() {
        return this.f15374g;
    }

    public boolean u() {
        return this.f15373f != 0;
    }

    public boolean v() {
        return this.f15372e != 0;
    }

    public void w(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.f15372e = forumCreateInfo.is_show_create.intValue();
            this.f15373f = forumCreateInfo.is_can_create.intValue();
            this.f15374g = forumCreateInfo.can_create_errno.intValue();
            this.f15375h = forumCreateInfo.can_create_errdata;
        }
    }
}
