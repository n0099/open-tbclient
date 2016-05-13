package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ av aQv;
    private final /* synthetic */ LinkedList aQw;
    private final /* synthetic */ com.baidu.tbadk.core.data.ax aQx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(av avVar, LinkedList linkedList, com.baidu.tbadk.core.data.ax axVar) {
        this.aQv = avVar;
        this.aQw = linkedList;
        this.aQx = axVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.a.l lVar;
        by<com.baidu.tieba.card.a.l> JO = this.aQv.JO();
        if (JO != null) {
            view.setTag("1");
            lVar = this.aQv.aQq;
            JO.a(view, lVar);
        }
        if (!z) {
            this.aQv.a(this.aQw, i, this.aQx);
        } else {
            this.aQv.Kf();
        }
    }
}
