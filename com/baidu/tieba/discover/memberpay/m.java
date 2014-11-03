package com.baidu.tieba.discover.memberpay;

import com.baidu.tbadk.core.view.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements u {
    final /* synthetic */ l apn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.apn = lVar;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        MemberPayActivity memberPayActivity;
        if (z) {
            memberPayActivity = this.apn.aoA;
            memberPayActivity.AS();
        }
    }
}
