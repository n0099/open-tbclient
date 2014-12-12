package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ db aGv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(db dbVar) {
        this.aGv = dbVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.l.mc().bg(0);
            com.baidu.tbadk.core.l.mc().ac(true);
        } else {
            com.baidu.tbadk.core.l.mc().ac(false);
        }
        this.aGv.aGt = true;
    }
}
