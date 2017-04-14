package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aOS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aOS = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aOS;
        z = this.aOS.isSelected;
        eVar.setSelected(!z);
        aVar = this.aOS.aOQ;
        if (aVar != null) {
            aVar2 = this.aOS.aOQ;
            aVar3 = this.aOS.aOK;
            i = this.aOS.position;
            z2 = this.aOS.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
