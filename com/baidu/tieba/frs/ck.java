package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements com.baidu.adp.widget.BdSwitchView.b {
    final /* synthetic */ cj aMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar) {
        this.aMS = cjVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.n.px().bk(0);
            com.baidu.tbadk.core.n.px().Y(true);
        } else {
            com.baidu.tbadk.core.n.px().Y(false);
        }
        this.aMS.aMQ = true;
    }
}
