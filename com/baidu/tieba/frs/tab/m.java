package com.baidu.tieba.frs.tab;

import android.widget.PopupWindow;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements PopupWindow.OnDismissListener {
    final /* synthetic */ j chN;
    private final /* synthetic */ TabItemView chO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, TabItemView tabItemView) {
        this.chN = jVar;
        this.chO = tabItemView;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        j.a aVar;
        j.a aVar2;
        aVar = this.chN.chy;
        if (aVar != null) {
            aVar2 = this.chN.chy;
            aVar2.a(this.chO);
        }
    }
}
