package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aHc = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aHc;
        z = this.aHc.isSelected;
        eVar.setSelected(!z);
        aVar = this.aHc.aHa;
        if (aVar != null) {
            aVar2 = this.aHc.aHa;
            aVar3 = this.aHc.aGT;
            i = this.aHc.position;
            z2 = this.aHc.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
