package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fa implements BdSwitchView.a {
    final /* synthetic */ ez bjG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(ez ezVar) {
        this.bjG = ezVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.m.qQ().bm(0);
            com.baidu.tbadk.core.m.qQ().ad(true);
        } else {
            com.baidu.tbadk.core.m.qQ().ad(false);
        }
        this.bjG.bjE = true;
    }
}
