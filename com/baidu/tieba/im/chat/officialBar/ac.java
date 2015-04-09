package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ ab aZw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.aZw = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        OfficialBarHistoryActivity officialBarHistoryActivity;
        ag agVar;
        OfficialBarHistoryActivity officialBarHistoryActivity2;
        officialBarHistoryActivity = this.aZw.aZv;
        agVar = officialBarHistoryActivity.aZr;
        if (!agVar.On()) {
            officialBarHistoryActivity2 = this.aZw.aZv;
            officialBarHistoryActivity2.Om();
        }
    }
}
