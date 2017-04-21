package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ y aUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.aUd = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        y.a aVar;
        boolean z2;
        z = this.aUd.aUc;
        if (z) {
            TiebaStatic.log("c10001");
        } else {
            TiebaStatic.log("c10009");
        }
        textView = this.aUd.aTP;
        textView.setEnabled(false);
        aVar = this.aUd.aTY;
        z2 = this.aUd.aTD;
        aVar.cl(z2);
    }
}
