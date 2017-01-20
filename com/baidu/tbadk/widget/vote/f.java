package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aJf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aJf = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aJf;
        z = this.aJf.isSelected;
        eVar.setSelected(!z);
        aVar = this.aJf.aJd;
        if (aVar != null) {
            aVar2 = this.aJf.aJd;
            aVar3 = this.aJf.aIX;
            i = this.aJf.position;
            z2 = this.aJf.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
