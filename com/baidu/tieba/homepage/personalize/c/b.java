package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cDd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cDd = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (this.cDd.Ud() != null) {
            ci<e> Ud = this.cDd.Ud();
            eVar = this.cDd.cDc;
            Ud.a(view, eVar);
        }
    }
}
