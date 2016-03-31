package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ac bxd;
    private final /* synthetic */ ac.b bxe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar, ac.b bVar) {
        this.bxd = acVar;
        this.bxe = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac.a aVar;
        ac.a aVar2;
        aVar = this.bxd.bwZ;
        if (aVar != null) {
            aVar2 = this.bxd.bwZ;
            aVar2.gF(this.bxe.bxf);
        }
        this.bxd.dismiss();
    }
}
