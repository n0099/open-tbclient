package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w bpM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bpM = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        axVar = this.bpM.aab;
        if (axVar != null) {
            axVar3 = this.bpM.aab;
            if (axVar3.getAuthor() != null) {
                axVar4 = this.bpM.aab;
                if (axVar4.getAuthor().getGodInfo() != null) {
                    aw s = new aw("c10806").s("obj_locate", 3);
                    axVar5 = this.bpM.aab;
                    TiebaStatic.log(s.ac("tid", axVar5.getId()));
                }
            }
        }
        if (this.bpM.JO() != null) {
            by<ax> JO = this.bpM.JO();
            axVar2 = this.bpM.aab;
            JO.a(view, axVar2);
        }
        this.bpM.Kf();
    }
}
