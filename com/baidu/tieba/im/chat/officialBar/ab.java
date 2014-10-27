package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ aa aRn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.aRn = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        OfficialBarHistoryActivity officialBarHistoryActivity;
        af afVar;
        OfficialBarHistoryActivity officialBarHistoryActivity2;
        officialBarHistoryActivity = this.aRn.aRm;
        afVar = officialBarHistoryActivity.aRh;
        if (!afVar.Kr()) {
            officialBarHistoryActivity2 = this.aRn.aRm;
            officialBarHistoryActivity2.Kq();
        }
    }
}
