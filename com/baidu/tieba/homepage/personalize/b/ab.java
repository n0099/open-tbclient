package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.homepage.personalize.b.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ y.a czV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y.a aVar) {
        this.czV = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.personalize.data.h hVar;
        com.baidu.tieba.homepage.personalize.data.h hVar2;
        hVar = this.czV.czQ;
        if (hVar != null) {
            y.a aVar = this.czV;
            hVar2 = this.czV.czQ;
            aVar.a(hVar2.cAA, view, 2);
        }
    }
}
