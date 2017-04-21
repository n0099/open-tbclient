package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.homepage.personalize.b.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ y.a cAM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y.a aVar) {
        this.cAM = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.personalize.data.h hVar;
        com.baidu.tieba.homepage.personalize.data.h hVar2;
        hVar = this.cAM.cAH;
        if (hVar != null) {
            y.a aVar = this.cAM;
            hVar2 = this.cAM.cAH;
            aVar.a(hVar2.cBq, view, 1);
        }
    }
}
