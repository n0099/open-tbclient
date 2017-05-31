package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bZs = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        blVar = this.bZs.ahM;
        if (blVar != null && this.bZs.Ud() != null) {
            ci<bl> Ud = this.bZs.Ud();
            blVar2 = this.bZs.ahM;
            Ud.a(view, blVar2);
        }
    }
}
