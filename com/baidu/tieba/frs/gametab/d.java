package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.g;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mainTab.b {
    public d(g gVar) {
        Fa().aHG = gVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EZ() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 1;
        cVar.aHH = d.j.chosen_pb_title;
        cVar.aHO = com.baidu.tbadk.mainTab.c.aHM;
        return cVar;
    }

    public void a(af afVar) {
        if (afVar != null && afVar.jZ(1)) {
            afVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e ba(Context context) {
        this.aHx = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.aHx.setTextSize(2.0f);
        return this.aHx;
    }
}
