package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aQE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aQE = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aQE;
        z = this.aQE.isSelected;
        eVar.setSelected(!z);
        aVar = this.aQE.aQC;
        if (aVar != null) {
            aVar2 = this.aQE.aQC;
            aVar3 = this.aQE.aQw;
            i = this.aQE.position;
            z2 = this.aQE.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
