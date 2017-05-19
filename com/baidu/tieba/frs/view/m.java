package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ k cdH;
    private final /* synthetic */ k.b cdI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, k.b bVar) {
        this.cdH = kVar;
        this.cdI = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k.a aVar;
        k.a aVar2;
        aVar = this.cdH.cdC;
        if (aVar != null) {
            aVar2 = this.cdH.cdC;
            aVar2.iB(this.cdI.cdJ);
        }
        this.cdH.dismiss();
    }
}
