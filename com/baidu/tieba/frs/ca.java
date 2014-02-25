package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ bz a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar) {
        this.a = bzVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tieba.h.a.a().c(0);
            com.baidu.tieba.h.a.a().a(true);
        } else {
            com.baidu.tieba.h.a.a().a(false);
        }
        this.a.s = true;
    }
}
