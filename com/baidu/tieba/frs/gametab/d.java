package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.i;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.mainTab.b {
    public d(i iVar) {
        MV().bxZ = iVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c MU() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 1;
        cVar.bya = d.j.chosen_pb_title;
        cVar.byh = com.baidu.tbadk.mainTab.c.byf;
        return cVar;
    }

    public void a(af afVar) {
        if (afVar != null && afVar.nb(1)) {
            afVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e bi(Context context) {
        this.bxQ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.bxQ.setTextSize(2.0f);
        return this.bxQ;
    }
}
