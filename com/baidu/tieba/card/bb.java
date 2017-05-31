package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ au bBu;
    private final /* synthetic */ LinkedList bBv;
    private final /* synthetic */ com.baidu.tbadk.core.data.bl bBw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(au auVar, LinkedList linkedList, com.baidu.tbadk.core.data.bl blVar) {
        this.bBu = auVar;
        this.bBv = linkedList;
        this.bBw = blVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        com.baidu.tieba.card.data.l lVar;
        ci<com.baidu.tieba.card.data.l> Ud = this.bBu.Ud();
        if (Ud != null) {
            view.setTag("1");
            lVar = this.bBu.bzH;
            Ud.a(view, lVar);
        }
        if (!z) {
            this.bBu.a(this.bBv, i, this.bBw);
        } else {
            this.bBu.Ur();
        }
    }
}
