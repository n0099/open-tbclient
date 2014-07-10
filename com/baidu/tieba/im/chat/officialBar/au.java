package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class au implements Runnable {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bb bbVar;
        bb bbVar2;
        bbVar = this.a.c;
        BdListView a = bbVar.a();
        bbVar2 = this.a.c;
        com.baidu.tbadk.core.util.aj.a(a, bbVar2.b().a(), 0, -1);
    }
}
