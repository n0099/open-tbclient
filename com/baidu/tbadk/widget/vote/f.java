package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aLh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aLh = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aLh;
        z = this.aLh.isSelected;
        eVar.setSelected(!z);
        aVar = this.aLh.aLf;
        if (aVar != null) {
            aVar2 = this.aLh.aLf;
            aVar3 = this.aLh.aKZ;
            i = this.aLh.position;
            z2 = this.aLh.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
