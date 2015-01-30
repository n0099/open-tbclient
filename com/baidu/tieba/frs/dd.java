package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ dc aHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(dc dcVar) {
        this.aHF = dcVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.l.mc().bl(0);
            com.baidu.tbadk.core.l.mc().ac(true);
        } else {
            com.baidu.tbadk.core.l.mc().ac(false);
        }
        this.aHF.aHD = true;
    }
}
