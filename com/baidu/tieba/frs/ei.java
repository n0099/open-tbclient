package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei implements BdSwitchView.a {
    final /* synthetic */ eh aZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(eh ehVar) {
        this.aZL = ehVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.m.qV().bq(0);
            com.baidu.tbadk.core.m.qV().ae(true);
        } else {
            com.baidu.tbadk.core.m.qV().ae(false);
        }
        this.aZL.aZJ = true;
    }
}
