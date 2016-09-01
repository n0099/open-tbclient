package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aKQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aKQ = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aKQ;
        z = this.aKQ.isSelected;
        eVar.setSelected(!z);
        aVar = this.aKQ.aKO;
        if (aVar != null) {
            aVar2 = this.aKQ.aKO;
            aVar3 = this.aKQ.aKH;
            i = this.aKQ.position;
            z2 = this.aKQ.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
