package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bZy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.bZy = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        if (this.bZy.Ud() != null) {
            ci<bl> Ud = this.bZy.Ud();
            blVar = this.bZy.ahM;
            Ud.a(view, blVar);
        }
        this.bZy.Ur();
    }
}
