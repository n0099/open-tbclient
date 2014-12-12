package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements b {
    final /* synthetic */ q VO;
    private final /* synthetic */ String VP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, String str) {
        this.VO = qVar;
        this.VP = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void tP() {
        List list;
        this.VO.currentIndex = 0;
        this.VO.Vc = a.tJ().tM();
        list = this.VO.Vc;
        if (list == null) {
            this.VO.VM = false;
        } else {
            this.VO.dQ(this.VP);
        }
    }
}
