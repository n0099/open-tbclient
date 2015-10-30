package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eg implements BdSwitchView.a {
    final /* synthetic */ ef aZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(ef efVar) {
        this.aZz = efVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.m.qU().bq(0);
            com.baidu.tbadk.core.m.qU().ae(true);
        } else {
            com.baidu.tbadk.core.m.qU().ae(false);
        }
        this.aZz.aZx = true;
    }
}
