package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aEJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aEJ = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aEJ;
        z = this.aEJ.isSelected;
        eVar.setSelected(!z);
        aVar = this.aEJ.aEH;
        if (aVar != null) {
            aVar2 = this.aEJ.aEH;
            aVar3 = this.aEJ.aEA;
            i = this.aEJ.position;
            z2 = this.aEJ.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
