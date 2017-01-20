package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements PopupWindow.OnDismissListener {
    final /* synthetic */ j bTK;
    private final /* synthetic */ TabItemView bTL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, TabItemView tabItemView) {
        this.bTK = jVar;
        this.bTL = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        j.a aVar;
        j.a aVar2;
        aVar = this.bTK.bTv;
        if (aVar != null) {
            aVar2 = this.bTK.bTv;
            aVar2.a(this.bTL);
        }
    }
}
