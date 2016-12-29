package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aKy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aKy = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aKy;
        z = this.aKy.isSelected;
        eVar.setSelected(!z);
        aVar = this.aKy.aKw;
        if (aVar != null) {
            aVar2 = this.aKy.aKw;
            aVar3 = this.aKy.aKq;
            i = this.aKy.position;
            z2 = this.aKy.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
