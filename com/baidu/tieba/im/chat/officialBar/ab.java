package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ aa aTh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.aTh = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        OfficialBarHistoryActivity officialBarHistoryActivity;
        af afVar;
        OfficialBarHistoryActivity officialBarHistoryActivity2;
        officialBarHistoryActivity = this.aTh.aTg;
        afVar = officialBarHistoryActivity.aTb;
        if (!afVar.KE()) {
            officialBarHistoryActivity2 = this.aTh.aTg;
            officialBarHistoryActivity2.KD();
        }
    }
}
