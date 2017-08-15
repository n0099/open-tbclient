package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.f;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mainTab.b {
    public c(f fVar) {
        EX().aHH = fVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EW() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 1;
        cVar.aHI = d.l.chosen_pb_title;
        cVar.aHN = com.baidu.tbadk.mainTab.c.aHL;
        return cVar;
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.iP(1)) {
            adVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aT(Context context) {
        this.aHu = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.aHu.setTextSize(2.0f);
        return this.aHu;
    }
}
