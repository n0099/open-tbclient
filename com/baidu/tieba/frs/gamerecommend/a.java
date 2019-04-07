package com.baidu.tieba.frs.gamerecommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a extends b {
    private FrsGameRecommendFragment flo;

    public a(String str, String str2) {
        this.flo = FrsGameRecommendFragment.cK(str, str2);
        anH().cof = this.flo;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c anG() {
        c cVar = new c();
        cVar.type = 11;
        cVar.bOg = d.j.frs_game_recommend_tab_title;
        cVar.col = c.coi;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator di(Context context) {
        this.cnR = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.cnR.setTextSize(2.0f);
        return this.cnR;
    }
}
