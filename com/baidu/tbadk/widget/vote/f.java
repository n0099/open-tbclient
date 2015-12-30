package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aGj = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aGj;
        z = this.aGj.isSelected;
        eVar.setSelected(!z);
        aVar = this.aGj.aGh;
        if (aVar != null) {
            aVar2 = this.aGj.aGh;
            aVar3 = this.aGj.aGa;
            i = this.aGj.position;
            z2 = this.aGj.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
