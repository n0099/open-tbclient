package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements PopupWindow.OnDismissListener {
    final /* synthetic */ j cdN;
    private final /* synthetic */ TabItemView cdO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, TabItemView tabItemView) {
        this.cdN = jVar;
        this.cdO = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        j.a aVar;
        j.a aVar2;
        aVar = this.cdN.cdz;
        if (aVar != null) {
            aVar2 = this.cdN.cdz;
            aVar2.a(this.cdO);
        }
    }
}
