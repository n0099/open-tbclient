package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aCS = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aCS;
        z = this.aCS.isSelected;
        eVar.setSelected(!z);
        aVar = this.aCS.aCQ;
        if (aVar != null) {
            aVar2 = this.aCS.aCQ;
            aVar3 = this.aCS.aCJ;
            i = this.aCS.position;
            z2 = this.aCS.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
