package com.baidu.tieba.frs.gametabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tbadk.mainTab.b {
    public d(int i, String str) {
        this.bxF.type = i;
        ((c) this.bxF.bxP).setUrl(str);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c MU() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.bxP = new c();
        cVar.type = 101;
        cVar.bxX = com.baidu.tbadk.mainTab.c.bxV;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.e bi(Context context) {
        this.bxG = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.bxG.setTextSize(2.0f);
        return this.bxG;
    }
}
