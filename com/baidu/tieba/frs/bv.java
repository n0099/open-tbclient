package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar) {
        this.a = buVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tieba.e.a.a().c(0);
            com.baidu.tieba.e.a.a().a(true);
        } else {
            com.baidu.tieba.e.a.a().a(false);
        }
        this.a.p = true;
    }
}
