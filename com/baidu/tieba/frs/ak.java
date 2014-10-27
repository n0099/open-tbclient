package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tieba.model.bd {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.tieba.model.bd
    public void d(String str, long j) {
        String str2;
        b bVar;
        String str3;
        String str4;
        bu buVar;
        bu buVar2;
        a EV = a.EV();
        str2 = this.aBk.aAn;
        EV.u(str2, false);
        bVar = this.aBk.azE;
        bVar.zJ().setLike(0);
        str3 = this.aBk.mPageType;
        if (str3.equals("normal_page")) {
            buVar2 = this.aBk.aAv;
            buVar2.eT(0);
        } else {
            str4 = this.aBk.mPageType;
            if (str4.equals("frs_page")) {
                buVar = this.aBk.aAv;
                buVar.eU(0);
            }
        }
        com.baidu.tieba.aj.wk().dX(str);
    }

    @Override // com.baidu.tieba.model.bd
    public void e(String str, long j) {
    }
}
