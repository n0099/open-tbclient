package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements b {
    final /* synthetic */ q ahF;
    private final /* synthetic */ String ahG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, String str) {
        this.ahF = qVar;
        this.ahG = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void yl() {
        List list;
        this.ahF.currentIndex = 0;
        this.ahF.agT = a.yf().yi();
        list = this.ahF.agT;
        if (list == null) {
            this.ahF.ahD = false;
        } else {
            this.ahF.ep(this.ahG);
        }
    }
}
