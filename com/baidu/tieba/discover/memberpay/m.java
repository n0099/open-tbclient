package com.baidu.tieba.discover.memberpay;

import com.baidu.tbadk.core.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements q {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // com.baidu.tbadk.core.view.q
    public void a(boolean z) {
        MemberPayActivity memberPayActivity;
        if (z) {
            memberPayActivity = this.a.j;
            memberPayActivity.a();
        }
    }
}
