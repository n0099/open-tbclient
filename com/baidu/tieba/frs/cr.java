package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements BdSwitchView.a {
    final /* synthetic */ cq bWf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cq cqVar) {
        this.bWf = cqVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.adp.base.h hVar3;
        com.baidu.adp.base.h hVar4;
        if (switchState == BdSwitchView.SwitchState.ON) {
            hVar3 = this.bWf.mContext;
            StringBuilder sb = new StringBuilder(String.valueOf(hVar3.getString(r.j.image_show_setting)));
            hVar4 = this.bWf.mContext;
            view.setContentDescription(sb.append(hVar4.getString(r.j.now_state_on)).toString());
            com.baidu.tbadk.core.l.oJ().bD(0);
            com.baidu.tbadk.core.l.oJ().ak(true);
        } else {
            hVar = this.bWf.mContext;
            StringBuilder sb2 = new StringBuilder(String.valueOf(hVar.getString(r.j.image_show_setting)));
            hVar2 = this.bWf.mContext;
            view.setContentDescription(sb2.append(hVar2.getString(r.j.now_state_off)).toString());
            com.baidu.tbadk.core.l.oJ().ak(false);
        }
        TiebaStatic.log("c11672");
        this.bWf.bWc = true;
    }
}
