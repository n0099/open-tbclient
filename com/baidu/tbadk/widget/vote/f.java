package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aPn = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aPn;
        z = this.aPn.isSelected;
        eVar.setSelected(!z);
        aVar = this.aPn.aPl;
        if (aVar != null) {
            aVar2 = this.aPn.aPl;
            aVar3 = this.aPn.aPf;
            i = this.aPn.position;
            z2 = this.aPn.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
