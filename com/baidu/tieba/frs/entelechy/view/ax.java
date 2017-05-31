package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ aw bZX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar) {
        this.bZX = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ThreadGodReplyLayout threadGodReplyLayout;
        bl blVar;
        if (this.bZX.Ud() != null) {
            ci<bl> Ud = this.bZX.Ud();
            blVar = this.bZX.ahM;
            Ud.a(view, blVar);
        }
        aw awVar = this.bZX;
        threadGodReplyLayout = this.bZX.bzD;
        awVar.dr(view == threadGodReplyLayout);
    }
}
