package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ ab brV;
    private final /* synthetic */ ab.b brW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.b bVar) {
        this.brV = abVar;
        this.brW = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab.a aVar;
        ab.a aVar2;
        aVar = this.brV.brR;
        if (aVar != null) {
            aVar2 = this.brV.brR;
            aVar2.go(this.brW.brX);
        }
        this.brV.dismiss();
    }
}
