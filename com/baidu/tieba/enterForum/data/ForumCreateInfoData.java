package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumCreateInfo;
/* loaded from: classes4.dex */
public class ForumCreateInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f14521e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f14522f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f14523g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f14524h = null;

    public void A(ForumCreateInfo forumCreateInfo) {
        if (forumCreateInfo != null) {
            this.f14521e = forumCreateInfo.is_show_create.intValue();
            this.f14522f = forumCreateInfo.is_can_create.intValue();
            this.f14523g = forumCreateInfo.can_create_errno.intValue();
            this.f14524h = forumCreateInfo.can_create_errdata;
        }
    }

    public String w() {
        return this.f14524h;
    }

    public int x() {
        return this.f14523g;
    }

    public boolean y() {
        return this.f14522f != 0;
    }

    public boolean z() {
        return this.f14521e != 0;
    }
}
