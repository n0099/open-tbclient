package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bwN;
    private final /* synthetic */ x.b bwO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, x.b bVar) {
        this.bwN = xVar;
        this.bwO = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x.a aVar;
        x.a aVar2;
        aVar = this.bwN.bwJ;
        if (aVar != null) {
            aVar2 = this.bwN.bwJ;
            aVar2.gl(this.bwO.bwP);
        }
        this.bwN.dismiss();
    }
}
