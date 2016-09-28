package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ x bXo;
    private final /* synthetic */ LinkedList bas;
    private final /* synthetic */ bi bat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(x xVar, LinkedList linkedList, bi biVar) {
        this.bXo = xVar;
        this.bas = linkedList;
        this.bat = biVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bi biVar;
        bi biVar2;
        cd<bi> onSubCardOnClickListenner = this.bXo.getOnSubCardOnClickListenner();
        if (z) {
            if (onSubCardOnClickListenner != null) {
                onSubCardOnClickListenner.bbE = true;
                biVar2 = this.bXo.adW;
                onSubCardOnClickListenner.a(view, biVar2);
            }
            this.bXo.Of();
            return;
        }
        if (onSubCardOnClickListenner != null) {
            onSubCardOnClickListenner.bbE = false;
            biVar = this.bXo.adW;
            onSubCardOnClickListenner.a(view, biVar);
        }
        this.bXo.a(this.bas, i, this.bat);
    }
}
