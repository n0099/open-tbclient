package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ aa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.a = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        OfficialBarHistoryActivity officialBarHistoryActivity;
        af afVar;
        OfficialBarHistoryActivity officialBarHistoryActivity2;
        officialBarHistoryActivity = this.a.a;
        afVar = officialBarHistoryActivity.b;
        if (!afVar.a()) {
            officialBarHistoryActivity2 = this.a.a;
            officialBarHistoryActivity2.d();
        }
    }
}
