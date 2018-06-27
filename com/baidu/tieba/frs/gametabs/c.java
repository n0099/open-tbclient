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
        this.aRw.type = i;
        SpecialFrsWebFragment specialFrsWebFragment = (SpecialFrsWebFragment) this.aRw.aRL;
        specialFrsWebFragment.lc(i);
        specialFrsWebFragment.setUrl(str);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Js() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aRL = new SpecialFrsWebFragment();
        cVar.type = 101;
        cVar.aRS = com.baidu.tbadk.mainTab.c.aRQ;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRx = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        this.aRx.setTextSize(2.0f);
        return this.aRx;
    }
}
