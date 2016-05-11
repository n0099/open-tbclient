package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aGh = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aGh;
        z = this.aGh.isSelected;
        eVar.setSelected(!z);
        aVar = this.aGh.aGf;
        if (aVar != null) {
            aVar2 = this.aGh.aGf;
            aVar3 = this.aGh.aFY;
            i = this.aGh.position;
            z2 = this.aGh.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
