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
    private FrsGameRecommendFragment dXZ;

    public a(String str, String str2) {
        this.dXZ = FrsGameRecommendFragment.bE(str, str2);
        Oh().bez = this.dXZ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c Og() {
        c cVar = new c();
        cVar.type = 11;
        cVar.aFU = e.j.frs_game_recommend_tab_title;
        cVar.beF = c.beC;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bR(Context context) {
        this.bek = (FragmentTabIndicator) LayoutInflater.from(context).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        this.bek.setTextSize(2.0f);
        return this.bek;
    }
}
