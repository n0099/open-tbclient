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
    private FrsGameRecommendFragment flC;

    public a(String str, String str2) {
        this.flC = FrsGameRecommendFragment.cJ(str, str2);
        anK().cod = this.flC;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c anJ() {
        c cVar = new c();
        cVar.type = 11;
        cVar.bOe = d.j.frs_game_recommend_tab_title;
        cVar.coj = c.cog;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator di(Context context) {
        this.cnP = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.cnP.setTextSize(2.0f);
        return this.cnP;
    }
}
