package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aOC = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aOC;
        z = this.aOC.isSelected;
        eVar.setSelected(!z);
        aVar = this.aOC.aOA;
        if (aVar != null) {
            aVar2 = this.aOC.aOA;
            aVar3 = this.aOC.aOu;
            i = this.aOC.position;
            z2 = this.aOC.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
