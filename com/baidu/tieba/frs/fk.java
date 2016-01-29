package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fk implements BdSwitchView.a {
    final /* synthetic */ fj bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(fj fjVar) {
        this.bmC = fjVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.l.rn().bB(0);
            com.baidu.tbadk.core.l.rn().ae(true);
        } else {
            com.baidu.tbadk.core.l.rn().ae(false);
        }
        this.bmC.bmz = true;
    }
}
