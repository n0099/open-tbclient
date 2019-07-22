package com.baidu.tieba.frs.gamerecommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends b {
    private FrsGameRecommendFragment fGI;

    public a(String str, String str2) {
        this.fGI = FrsGameRecommendFragment.cY(str, str2);
        atS().cxD = this.fGI;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c atR() {
        c cVar = new c();
        cVar.type = 11;
        cVar.bWY = R.string.frs_game_recommend_tab_title;
        cVar.cxJ = c.cxG;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cP(Context context) {
        this.cxp = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.cxp.setTextSize(2.0f);
        return this.cxp;
    }
}
