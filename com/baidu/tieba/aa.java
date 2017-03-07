package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ y aTM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.aTM = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        y.a aVar;
        boolean z2;
        z = this.aTM.aTL;
        if (z) {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10001");
        } else {
            com.baidu.tbadk.core.util.TiebaStatic.log("c10009");
        }
        textView = this.aTM.aTy;
        textView.setEnabled(false);
        aVar = this.aTM.aTH;
        z2 = this.aTM.aTm;
        aVar.cj(z2);
    }
}
