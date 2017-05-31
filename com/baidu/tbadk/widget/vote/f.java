package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aPm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aPm = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aPm;
        z = this.aPm.isSelected;
        eVar.setSelected(!z);
        aVar = this.aPm.aPk;
        if (aVar != null) {
            aVar2 = this.aPm.aPk;
            aVar3 = this.aPm.aPe;
            i = this.aPm.position;
            z2 = this.aPm.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
