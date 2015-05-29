package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements com.baidu.adp.widget.BdSwitchView.b {
    final /* synthetic */ ci aPp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ci ciVar) {
        this.aPp = ciVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.n.qc().bh(0);
            com.baidu.tbadk.core.n.qc().ac(true);
        } else {
            com.baidu.tbadk.core.n.qc().ac(false);
        }
        this.aPp.aPn = true;
    }
}
