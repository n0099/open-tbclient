package com.baidu.tieba.im.groupActivity;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.message.RequestCreateGroupActivityMessage;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    RequestCreateGroupActivityMessage a;
    private GroupActivityData b;
    private BaseFragmentActivity c;

    public d(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity);
        this.b = new GroupActivityData();
        this.c = baseFragmentActivity;
    }

    public GroupActivityData a() {
        return this.b;
    }

    public void a(boolean z) {
        if (this.b != null) {
            this.a = new RequestCreateGroupActivityMessage();
            this.a.setCommitType(z ? 1 : 0);
            if (z) {
                this.a.setActivityId(this.b.getActivityId());
            }
            this.a.setgActivityArea(this.b.getgActivityArea());
            this.a.setgActivityContent(this.b.getgActivityContent());
            this.a.setgActivityTime(this.b.getgActivityTime());
            this.a.setgActivityTitle(this.b.getgActivityTitle());
            this.a.setGroupId(this.b.getGroupId());
            this.c.a(this.a);
        }
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
