package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class cr implements BdSwitchView.a {
    final /* synthetic */ cp bCp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cp cpVar) {
        this.bCp = cpVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = switchState == BdSwitchView.SwitchState.ON;
        com.baidu.tbadk.core.sharedPref.b.tW().putBoolean(com.baidu.tbadk.core.sharedPref.b.cR("frs_guess_like_switch"), z);
        this.bCp.dL(z);
    }
}
