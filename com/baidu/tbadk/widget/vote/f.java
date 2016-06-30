package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aGJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aGJ = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aGJ;
        z = this.aGJ.isSelected;
        eVar.setSelected(!z);
        aVar = this.aGJ.aGH;
        if (aVar != null) {
            aVar2 = this.aGJ.aGH;
            aVar3 = this.aGJ.aGA;
            i = this.aGJ.position;
            z2 = this.aGJ.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
