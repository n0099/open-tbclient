package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements PopupWindow.OnDismissListener {
    final /* synthetic */ j btf;
    private final /* synthetic */ TabItemView btg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, TabItemView tabItemView) {
        this.btf = jVar;
        this.btg = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        j.a aVar;
        j.a aVar2;
        aVar = this.btf.bsR;
        if (aVar != null) {
            aVar2 = this.btf.bsR;
            aVar2.a(this.btg);
        }
    }
}
