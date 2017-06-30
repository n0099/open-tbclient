package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ y aTt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.aTt = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y.a aVar;
        aVar = this.aTt.aTo;
        aVar.JU();
    }
}
