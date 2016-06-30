package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dx implements BdSwitchView.a {
    final /* synthetic */ dw bHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(dw dwVar) {
        this.bHF = dwVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.adp.base.h hVar3;
        com.baidu.adp.base.h hVar4;
        if (switchState == BdSwitchView.SwitchState.ON) {
            hVar3 = this.bHF.mContext;
            StringBuilder sb = new StringBuilder(String.valueOf(hVar3.getString(u.j.image_show_setting)));
            hVar4 = this.bHF.mContext;
            view.setContentDescription(sb.append(hVar4.getString(u.j.now_state_on)).toString());
            com.baidu.tbadk.core.l.nW().bn(0);
            com.baidu.tbadk.core.l.nW().ae(true);
        } else {
            hVar = this.bHF.mContext;
            StringBuilder sb2 = new StringBuilder(String.valueOf(hVar.getString(u.j.image_show_setting)));
            hVar2 = this.bHF.mContext;
            view.setContentDescription(sb2.append(hVar2.getString(u.j.now_state_off)).toString());
            com.baidu.tbadk.core.l.nW().ae(false);
        }
        this.bHF.bHC = true;
    }
}
