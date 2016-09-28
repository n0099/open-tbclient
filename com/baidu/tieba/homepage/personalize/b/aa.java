package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.homepage.personalize.b.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ x.a cHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x.a aVar) {
        this.cHb = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.personalize.data.j jVar;
        com.baidu.tieba.homepage.personalize.data.j jVar2;
        jVar = this.cHb.cGW;
        if (jVar != null) {
            x.a aVar = this.cHb;
            jVar2 = this.cHb.cGW;
            aVar.a(jVar2.cHG, view, 2);
        }
    }
}
