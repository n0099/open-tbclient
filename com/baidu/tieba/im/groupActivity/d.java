package com.baidu.tieba.im.groupActivity;

import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.ah;
/* loaded from: classes.dex */
public class d {
    ah a;
    private GroupActivityData b = new GroupActivityData();

    public GroupActivityData a() {
        return this.b;
    }

    public void a(boolean z) {
        if (this.b != null) {
            this.a = new ah();
            this.a.c(z ? 1 : 0);
            if (z) {
                this.a.b(this.b.getActivityId());
            }
            this.a.c(this.b.getgActivityArea());
            this.a.b(this.b.getgActivityContent());
            this.a.a(this.b.getgActivityTime());
            this.a.a(this.b.getgActivityTitle());
            this.a.a(this.b.getGroupId());
            com.baidu.tieba.im.messageCenter.e.a().a(this.a);
        }
    }

    public void b() {
        if (this.a != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.a);
        }
    }
}
