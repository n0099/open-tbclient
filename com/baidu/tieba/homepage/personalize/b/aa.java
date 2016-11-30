package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.homepage.personalize.b.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ x.a cMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x.a aVar) {
        this.cMm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.personalize.data.j jVar;
        com.baidu.tieba.homepage.personalize.data.j jVar2;
        jVar = this.cMm.cMh;
        if (jVar != null) {
            x.a aVar = this.cMm;
            jVar2 = this.cMm.cMh;
            aVar.a(jVar2.cMT, view, 2);
        }
    }
}
