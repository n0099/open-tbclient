package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ ab aZg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.aZg = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        OfficialBarHistoryActivity officialBarHistoryActivity;
        ag agVar;
        OfficialBarHistoryActivity officialBarHistoryActivity2;
        officialBarHistoryActivity = this.aZg.aZf;
        agVar = officialBarHistoryActivity.aZb;
        if (!agVar.Oa()) {
            officialBarHistoryActivity2 = this.aZg.aZf;
            officialBarHistoryActivity2.NZ();
        }
    }
}
