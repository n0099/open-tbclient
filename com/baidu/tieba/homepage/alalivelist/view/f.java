package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e czk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.czk = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d dVar;
        if (this.czk.Ud() != null) {
            ci<d> Ud = this.czk.Ud();
            dVar = this.czk.czj;
            Ud.a(view, dVar);
        }
    }
}
