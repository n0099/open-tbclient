package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.card.bx;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.widget.layout.h {
    private final /* synthetic */ LinkedList aTT;
    private final /* synthetic */ az aTU;
    final /* synthetic */ u bKt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, LinkedList linkedList, az azVar) {
        this.bKt = uVar;
        this.aTT = linkedList;
        this.aTU = azVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        az azVar;
        bx<az> KO = this.bKt.KO();
        if (KO != null) {
            view.setTag("1");
            azVar = this.bKt.aas;
            KO.a(view, azVar);
        }
        if (!z) {
            this.bKt.a(this.aTT, i, this.aTU);
        } else {
            this.bKt.Ld();
        }
    }
}
