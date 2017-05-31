package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.ci;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tbadk.widget.layout.g {
    private final /* synthetic */ LinkedList bBv;
    private final /* synthetic */ bl bBw;
    final /* synthetic */ aw bZX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(aw awVar, LinkedList linkedList, bl blVar) {
        this.bZX = awVar;
        this.bBv = linkedList;
        this.bBw = blVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bl blVar;
        bl blVar2;
        ci<bl> Ud = this.bZX.Ud();
        if (z) {
            if (Ud != null) {
                view.setTag("1");
                Ud.aQf = true;
                blVar2 = this.bZX.ahM;
                Ud.a(view, blVar2);
            }
            this.bZX.dr(false);
            return;
        }
        if (Ud != null) {
            view.setTag("1");
            Ud.aQf = false;
            blVar = this.bZX.ahM;
            Ud.a(view, blVar);
        }
        this.bZX.a(this.bBv, i, this.bBw);
    }
}
