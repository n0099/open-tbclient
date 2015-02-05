package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ dc aHC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(dc dcVar) {
        this.aHC = dcVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.l.lV().bl(0);
            com.baidu.tbadk.core.l.lV().ac(true);
        } else {
            com.baidu.tbadk.core.l.lV().ac(false);
        }
        this.aHC.aHA = true;
    }
}
