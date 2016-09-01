package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.homepage.personalize.a.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x.a cGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x.a aVar) {
        this.cGn = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.personalize.data.j jVar;
        com.baidu.tieba.homepage.personalize.data.j jVar2;
        jVar = this.cGn.cGi;
        if (jVar != null) {
            x.a aVar = this.cGn;
            jVar2 = this.cGn.cGi;
            aVar.a(jVar2.cGQ, view, 1);
        }
    }
}
