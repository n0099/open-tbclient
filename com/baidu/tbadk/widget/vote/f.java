package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aKp = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aKp;
        z = this.aKp.isSelected;
        eVar.setSelected(!z);
        aVar = this.aKp.aKn;
        if (aVar != null) {
            aVar2 = this.aKp.aKn;
            aVar3 = this.aKp.aKg;
            i = this.aKp.position;
            z2 = this.aKp.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
