package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eg implements BdSwitchView.a {
    final /* synthetic */ ef aZo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(ef efVar) {
        this.aZo = efVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.m.qX().bq(0);
            com.baidu.tbadk.core.m.qX().ae(true);
        } else {
            com.baidu.tbadk.core.m.qX().ae(false);
        }
        this.aZo.aZm = true;
    }
}
