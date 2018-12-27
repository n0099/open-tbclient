package com.baidu.tieba.frs.gamerecommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends b {
    private FrsGameRecommendFragment dXt;

    public a(String str, String str2) {
        this.dXt = FrsGameRecommendFragment.bD(str, str2);
        NQ().bdN = this.dXt;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c NP() {
        c cVar = new c();
        cVar.type = 11;
        cVar.aFs = e.j.frs_game_recommend_tab_title;
        cVar.bdT = c.bdQ;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bR(Context context) {
        this.bdz = (FragmentTabIndicator) LayoutInflater.from(context).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        this.bdz.setTextSize(2.0f);
        return this.bdz;
    }
}
