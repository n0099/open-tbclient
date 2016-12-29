package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.homepage.personalize.b.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ w.a crw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w.a aVar) {
        this.crw = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.personalize.data.h hVar;
        com.baidu.tieba.homepage.personalize.data.h hVar2;
        hVar = this.crw.crr;
        if (hVar != null) {
            w.a aVar = this.crw;
            hVar2 = this.crw.crr;
            aVar.a(hVar2.crX, view, 1);
        }
    }
}
