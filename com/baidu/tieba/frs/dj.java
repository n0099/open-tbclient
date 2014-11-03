package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ di aES;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(di diVar) {
        this.aES = diVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.l.js().aK(0);
            com.baidu.tbadk.core.l.js().M(true);
        } else {
            com.baidu.tbadk.core.l.js().M(false);
        }
        this.aES.aEQ = true;
    }
}
