package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class aq implements Runnable {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ax axVar;
        ax axVar2;
        axVar = this.a.b;
        BdListView a = axVar.a();
        axVar2 = this.a.b;
        com.baidu.tbadk.core.util.ae.a(a, axVar2.b().a(), 0, -1);
    }
}
