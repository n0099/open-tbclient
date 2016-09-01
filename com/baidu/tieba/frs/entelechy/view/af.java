package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cf;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ x bXt;
    private final /* synthetic */ LinkedList baa;
    private final /* synthetic */ bg bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(x xVar, LinkedList linkedList, bg bgVar) {
        this.bXt = xVar;
        this.baa = linkedList;
        this.bab = bgVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bg bgVar;
        bg bgVar2;
        cf<bg> onSubCardOnClickListenner = this.bXt.getOnSubCardOnClickListenner();
        if (z) {
            if (onSubCardOnClickListenner != null) {
                onSubCardOnClickListenner.bbn = true;
                bgVar2 = this.bXt.adL;
                onSubCardOnClickListenner.a(view, bgVar2);
            }
            this.bXt.NF();
            return;
        }
        if (onSubCardOnClickListenner != null) {
            onSubCardOnClickListenner.bbn = false;
            bgVar = this.bXt.adL;
            onSubCardOnClickListenner.a(view, bgVar);
        }
        this.bXt.a(this.baa, i, this.bab);
    }
}
