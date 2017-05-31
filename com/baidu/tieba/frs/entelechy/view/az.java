package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ aw bZX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(aw awVar) {
        this.bZX = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        if (this.bZX.Ud() != null) {
            ci<bl> Ud = this.bZX.Ud();
            blVar = this.bZX.ahM;
            Ud.a(view, blVar);
        }
    }
}
