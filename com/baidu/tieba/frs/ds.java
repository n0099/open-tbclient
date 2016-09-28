package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ds implements BdSwitchView.a {
    final /* synthetic */ dr bTV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(dr drVar) {
        this.bTV = drVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.adp.base.h hVar3;
        com.baidu.adp.base.h hVar4;
        if (switchState == BdSwitchView.SwitchState.ON) {
            hVar3 = this.bTV.mContext;
            StringBuilder sb = new StringBuilder(String.valueOf(hVar3.getString(r.j.image_show_setting)));
            hVar4 = this.bTV.mContext;
            view.setContentDescription(sb.append(hVar4.getString(r.j.now_state_on)).toString());
            com.baidu.tbadk.core.l.oH().bD(0);
            com.baidu.tbadk.core.l.oH().ai(true);
        } else {
            hVar = this.bTV.mContext;
            StringBuilder sb2 = new StringBuilder(String.valueOf(hVar.getString(r.j.image_show_setting)));
            hVar2 = this.bTV.mContext;
            view.setContentDescription(sb2.append(hVar2.getString(r.j.now_state_off)).toString());
            com.baidu.tbadk.core.l.oH().ai(false);
        }
        TiebaStatic.log("c11672");
        this.bTV.bTS = true;
    }
}
