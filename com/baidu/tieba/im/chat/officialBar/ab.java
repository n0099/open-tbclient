package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ aa aUw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.aUw = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        OfficialBarHistoryActivity officialBarHistoryActivity;
        af afVar;
        OfficialBarHistoryActivity officialBarHistoryActivity2;
        officialBarHistoryActivity = this.aUw.aUv;
        afVar = officialBarHistoryActivity.aUq;
        if (!afVar.KU()) {
            officialBarHistoryActivity2 = this.aUw.aUv;
            officialBarHistoryActivity2.KT();
        }
    }
}
