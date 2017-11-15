package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.f;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mainTab.b {
    public d(f fVar) {
        ES().aHa = fVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c ER() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 1;
        cVar.aHb = d.j.chosen_pb_title;
        cVar.aHi = com.baidu.tbadk.mainTab.c.aHg;
        return cVar;
    }

    public void a(ae aeVar) {
        if (aeVar != null && aeVar.jz(1)) {
            aeVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aY(Context context) {
        this.aGR = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.aGR.setTextSize(2.0f);
        return this.aGR;
    }
}
