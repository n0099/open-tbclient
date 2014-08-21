package com.baidu.tieba.discover.memberprivilege;

import com.baidu.tbadk.core.view.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements r {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.tbadk.core.view.r
    public void a(boolean z) {
        MemberPrivilegeActivity memberPrivilegeActivity;
        if (z) {
            memberPrivilegeActivity = this.a.a;
            memberPrivilegeActivity.a();
        }
    }
}
