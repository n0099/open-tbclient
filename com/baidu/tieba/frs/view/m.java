package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ k cjV;
    private final /* synthetic */ k.b cjW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, k.b bVar) {
        this.cjV = kVar;
        this.cjW = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k.a aVar;
        k.a aVar2;
        aVar = this.cjV.cjQ;
        if (aVar != null) {
            aVar2 = this.cjV.cjQ;
            aVar2.iZ(this.cjW.cjX);
        }
        this.cjV.dismiss();
    }
}
