package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ft implements BdSwitchView.a {
    final /* synthetic */ fs brP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft(fs fsVar) {
        this.brP = fsVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.adp.base.h hVar3;
        com.baidu.adp.base.h hVar4;
        if (switchState == BdSwitchView.SwitchState.ON) {
            hVar3 = this.brP.mContext;
            StringBuilder sb = new StringBuilder(String.valueOf(hVar3.getString(t.j.image_show_setting)));
            hVar4 = this.brP.mContext;
            view.setContentDescription(sb.append(hVar4.getString(t.j.now_state_on)).toString());
            com.baidu.tbadk.core.l.qE().bA(0);
            com.baidu.tbadk.core.l.qE().ad(true);
        } else {
            hVar = this.brP.mContext;
            StringBuilder sb2 = new StringBuilder(String.valueOf(hVar.getString(t.j.image_show_setting)));
            hVar2 = this.brP.mContext;
            view.setContentDescription(sb2.append(hVar2.getString(t.j.now_state_off)).toString());
            com.baidu.tbadk.core.l.qE().ad(false);
        }
        this.brP.brM = true;
    }
}
