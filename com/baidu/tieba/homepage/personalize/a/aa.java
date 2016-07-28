package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.homepage.personalize.a.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ y.a cuJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y.a aVar) {
        this.cuJ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.personalize.data.j jVar;
        com.baidu.tieba.homepage.personalize.data.j jVar2;
        jVar = this.cuJ.cuE;
        if (jVar != null) {
            y.a aVar = this.cuJ;
            jVar2 = this.cuJ.cuE;
            aVar.a(jVar2.cvm, view, 1);
        }
    }
}
