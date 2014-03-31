package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
final class as implements Runnable {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        az azVar;
        az azVar2;
        azVar = this.a.b;
        BdListView a = azVar.a();
        azVar2 = this.a.b;
        com.baidu.tbadk.core.util.ac.a(a, azVar2.d().a(), 0, -1);
    }
}
