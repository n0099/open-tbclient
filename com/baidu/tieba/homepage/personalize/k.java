package com.baidu.tieba.homepage.personalize;

import com.baidu.tieba.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0053a {
    final /* synthetic */ a cqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.cqR = aVar;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0053a
    public void K(int i, int i2) {
        this.cqR.aKt = true;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0053a
    public void L(int i, int i2) {
        this.cqR.aKt = false;
    }
}
