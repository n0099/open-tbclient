package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aBX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aBX = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aBX;
        z = this.aBX.isSelected;
        eVar.setSelected(!z);
        aVar = this.aBX.aBV;
        if (aVar != null) {
            aVar2 = this.aBX.aBV;
            aVar3 = this.aBX.aBO;
            i = this.aBX.position;
            z2 = this.aBX.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
