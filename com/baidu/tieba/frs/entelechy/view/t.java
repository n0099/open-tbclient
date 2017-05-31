package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q bZt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.bZt = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        if (this.bZt.Ud() != null) {
            ci<bl> Ud = this.bZt.Ud();
            blVar = this.bZt.ahM;
            Ud.a(view, blVar);
        }
    }
}
