package com.baidu.tbadk.widget.vote;

import android.view.View;
import com.baidu.tbadk.widget.vote.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aOU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aOU = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        e.a aVar;
        e.a aVar2;
        a aVar3;
        int i;
        boolean z2;
        e eVar = this.aOU;
        z = this.aOU.isSelected;
        eVar.setSelected(!z);
        aVar = this.aOU.aOS;
        if (aVar != null) {
            aVar2 = this.aOU.aOS;
            aVar3 = this.aOU.aOM;
            i = this.aOU.position;
            z2 = this.aOU.isSelected;
            aVar2.b(aVar3, i, z2);
        }
    }
}
