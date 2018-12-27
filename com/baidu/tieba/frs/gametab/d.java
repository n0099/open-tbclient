package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad;
/* loaded from: classes6.dex */
public class d extends com.baidu.tbadk.mainTab.b {
    public d(FrsFragment frsFragment) {
        NQ().bdN = frsFragment;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c NP() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 1;
        cVar.aFs = e.j.chosen_pb_title;
        cVar.bdT = com.baidu.tbadk.mainTab.c.bdQ;
        return cVar;
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.mE(1)) {
            adVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bR(Context context) {
        this.bdz = (FragmentTabIndicator) LayoutInflater.from(context).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        this.bdz.setTextSize(2.0f);
        return this.bdz;
    }
}
