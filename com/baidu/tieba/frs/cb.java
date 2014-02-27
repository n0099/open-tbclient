package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cb implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ ca a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar) {
        this.a = caVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tieba.h.a.a().c(0);
            com.baidu.tieba.h.a.a().a(true);
        } else {
            com.baidu.tieba.h.a.a().a(false);
        }
        this.a.s = true;
    }
}
