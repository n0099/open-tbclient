package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fa implements BdSwitchView.a {
    final /* synthetic */ ez bfO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(ez ezVar) {
        this.bfO = ezVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.m.rh().bt(0);
            com.baidu.tbadk.core.m.rh().ag(true);
        } else {
            com.baidu.tbadk.core.m.rh().ag(false);
        }
        this.bfO.bfM = true;
    }
}
