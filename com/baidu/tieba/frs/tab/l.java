package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements PopupWindow.OnDismissListener {
    final /* synthetic */ i buj;
    private final /* synthetic */ TabItemView buk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, TabItemView tabItemView) {
        this.buj = iVar;
        this.buk = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        i.a aVar;
        i.a aVar2;
        aVar = this.buj.btU;
        if (aVar != null) {
            aVar2 = this.buj.btU;
            aVar2.a(this.buk);
        }
    }
}
