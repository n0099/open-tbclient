package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.ci;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.widget.layout.g {
    private final /* synthetic */ LinkedList bBv;
    private final /* synthetic */ bl bBw;
    final /* synthetic */ x bZy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(x xVar, LinkedList linkedList, bl blVar) {
        this.bZy = xVar;
        this.bBv = linkedList;
        this.bBw = blVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bl blVar;
        bl blVar2;
        ci<bl> Ud = this.bZy.Ud();
        if (z) {
            if (Ud != null) {
                Ud.aQf = true;
                blVar2 = this.bZy.ahM;
                Ud.a(view, blVar2);
            }
            this.bZy.Ur();
            return;
        }
        if (Ud != null) {
            Ud.aQf = false;
            blVar = this.bZy.ahM;
            Ud.a(view, blVar);
        }
        this.bZy.a(this.bBv, i, this.bBw);
    }
}
