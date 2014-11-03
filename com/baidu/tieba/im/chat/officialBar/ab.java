package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ aa aRB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.aRB = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        OfficialBarHistoryActivity officialBarHistoryActivity;
        af afVar;
        OfficialBarHistoryActivity officialBarHistoryActivity2;
        officialBarHistoryActivity = this.aRB.aRA;
        afVar = officialBarHistoryActivity.aRv;
        if (!afVar.Kv()) {
            officialBarHistoryActivity2 = this.aRB.aRA;
            officialBarHistoryActivity2.Ku();
        }
    }
}
