package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fs implements BdSwitchView.a {
    final /* synthetic */ fr bnr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fs(fr frVar) {
        this.bnr = frVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.adp.base.h hVar3;
        com.baidu.adp.base.h hVar4;
        if (switchState == BdSwitchView.SwitchState.ON) {
            hVar3 = this.bnr.mContext;
            StringBuilder sb = new StringBuilder(String.valueOf(hVar3.getString(t.j.image_show_setting)));
            hVar4 = this.bnr.mContext;
            view.setContentDescription(sb.append(hVar4.getString(t.j.now_state_on)).toString());
            com.baidu.tbadk.core.l.ob().bm(0);
            com.baidu.tbadk.core.l.ob().ag(true);
        } else {
            hVar = this.bnr.mContext;
            StringBuilder sb2 = new StringBuilder(String.valueOf(hVar.getString(t.j.image_show_setting)));
            hVar2 = this.bnr.mContext;
            view.setContentDescription(sb2.append(hVar2.getString(t.j.now_state_off)).toString());
            com.baidu.tbadk.core.l.ob().ag(false);
        }
        this.bnr.bno = true;
    }
}
