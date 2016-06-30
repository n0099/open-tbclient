package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.homepage.personalize.a.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ y.a crZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y.a aVar) {
        this.crZ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.personalize.data.j jVar;
        com.baidu.tieba.homepage.personalize.data.j jVar2;
        jVar = this.crZ.crU;
        if (jVar != null) {
            y.a aVar = this.crZ;
            jVar2 = this.crZ.crU;
            aVar.a(jVar2.csD, view, 2);
        }
    }
}
