package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements BdSwitchView.a {
    final /* synthetic */ dg aZf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(dg dgVar) {
        this.aZf = dgVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.m.rd().bq(0);
            com.baidu.tbadk.core.m.rd().ae(true);
        } else {
            com.baidu.tbadk.core.m.rd().ae(false);
        }
        this.aZf.aZd = true;
    }
}
