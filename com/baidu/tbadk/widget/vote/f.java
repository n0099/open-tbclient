package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aHA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aHA = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aHA;
        z = this.aHA.isSelected;
        eVar.setSelected(!z);
        aVar = this.aHA.aHy;
        if (aVar != null) {
            aVar2 = this.aHA.aHy;
            aVar3 = this.aHA.aHr;
            i = this.aHA.position;
            z2 = this.aHA.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
