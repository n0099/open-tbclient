package com.baidu.tieba.frs.gametabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.mainTab.b {
    public c(int i, String str) {
        this.aQA.type = i;
        SpecialFrsWebFragment specialFrsWebFragment = (SpecialFrsWebFragment) this.aQA.aQP;
        specialFrsWebFragment.kV(i);
        specialFrsWebFragment.setUrl(str);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Ja() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aQP = new SpecialFrsWebFragment();
        cVar.type = 101;
        cVar.aQW = com.baidu.tbadk.mainTab.c.aQU;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aQB = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        this.aQB.setTextSize(2.0f);
        return this.aQB;
    }
}
