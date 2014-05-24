package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ dq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(dq dqVar) {
        this.a = dqVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.g.a().c(0);
            com.baidu.tbadk.core.g.a().a(true);
        } else {
            com.baidu.tbadk.core.g.a().a(false);
        }
        this.a.k = true;
    }
}
