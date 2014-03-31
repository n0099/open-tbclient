package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dg implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ df a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(df dfVar) {
        this.a = dfVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.h.a().c(0);
            com.baidu.tbadk.core.h.a().a(true);
        } else {
            com.baidu.tbadk.core.h.a().a(false);
        }
        this.a.l = true;
    }
}
