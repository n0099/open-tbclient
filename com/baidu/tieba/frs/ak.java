package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tieba.model.bd {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.baidu.tieba.model.bd
    public void d(String str, long j) {
        String str2;
        b bVar;
        String str3;
        String str4;
        bu buVar;
        bu buVar2;
        a EX = a.EX();
        str2 = this.aBu.aAx;
        EX.u(str2, false);
        bVar = this.aBu.azN;
        bVar.zL().setLike(0);
        str3 = this.aBu.mPageType;
        if (str3.equals("normal_page")) {
            buVar2 = this.aBu.aAF;
            buVar2.eT(0);
        } else {
            str4 = this.aBu.mPageType;
            if (str4.equals("frs_page")) {
                buVar = this.aBu.aAF;
                buVar.eU(0);
            }
        }
        com.baidu.tieba.aj.wm().dX(str);
    }

    @Override // com.baidu.tieba.model.bd
    public void e(String str, long j) {
    }
}
