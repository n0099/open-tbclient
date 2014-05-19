package com.baidu.tieba.im.live.livelist;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ FrsLiveListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsLiveListActivity frsLiveListActivity) {
        this.a = frsLiveListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a.d();
    }
}
