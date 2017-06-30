package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.ci;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tbadk.widget.layout.g {
    private final /* synthetic */ LinkedList bCo;
    private final /* synthetic */ bm bCp;
    final /* synthetic */ aw cih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(aw awVar, LinkedList linkedList, bm bmVar) {
        this.cih = awVar;
        this.bCo = linkedList;
        this.bCp = bmVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bm bmVar;
        bm bmVar2;
        ci<bm> Vs = this.cih.Vs();
        if (z) {
            if (Vs != null) {
                view.setTag("1");
                Vs.aRx = true;
                bmVar2 = this.cih.aiu;
                Vs.a(view, bmVar2);
            }
            this.cih.du(false);
            return;
        }
        if (Vs != null) {
            view.setTag("1");
            Vs.aRx = false;
            bmVar = this.cih.aiu;
            Vs.a(view, bmVar);
        }
        this.cih.a(this.bCo, i, this.bCp);
    }
}
