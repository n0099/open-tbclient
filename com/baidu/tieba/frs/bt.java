package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar) {
        this.a = bsVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tieba.d.a.a().c(0);
            com.baidu.tieba.d.a.a().a(true);
        } else {
            com.baidu.tieba.d.a.a().a(false);
        }
        this.a.p = true;
    }
}
