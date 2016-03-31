package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aJY = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aJY;
        z = this.aJY.isSelected;
        eVar.setSelected(!z);
        aVar = this.aJY.aJW;
        if (aVar != null) {
            aVar2 = this.aJY.aJW;
            aVar3 = this.aJY.aJP;
            i = this.aJY.position;
            z2 = this.aJY.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
