package com.baidu.tieba.im.groupActivity;

import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.ab;
/* loaded from: classes.dex */
public final class d extends com.baidu.adp.a.e {
    ab a;
    private GroupActivityData b = new GroupActivityData();
    private com.baidu.tbadk.core.e c;

    public d(com.baidu.tbadk.core.e eVar) {
        this.c = eVar;
    }

    public final GroupActivityData a() {
        return this.b;
    }

    public final void a(boolean z) {
        if (this.b != null) {
            this.a = new ab();
            this.a.f(z ? 1 : 0);
            if (z) {
                this.a.e(this.b.getActivityId());
            }
            this.a.c(this.b.getgActivityArea());
            this.a.b(this.b.getgActivityContent());
            this.a.b(this.b.getgActivityTime());
            this.a.a(this.b.getgActivityTitle());
            this.a.d(this.b.getGroupId());
            this.c.a(this.a);
        }
    }

    @Override // com.baidu.adp.a.e
    public final void cancelMessage() {
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }
}
