package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements BdSwitchView.a {
    final /* synthetic */ dm aZy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dm dmVar) {
        this.aZy = dmVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            com.baidu.tbadk.core.m.rb().bq(0);
            com.baidu.tbadk.core.m.rb().ae(true);
        } else {
            com.baidu.tbadk.core.m.rb().ae(false);
        }
        this.aZy.aZw = true;
    }
}
