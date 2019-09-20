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
    private FrsGameRecommendFragment fJl;

    public a(String str, String str2) {
        this.fJl = FrsGameRecommendFragment.cZ(str, str2);
        aug().cyG = this.fJl;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c auf() {
        c cVar = new c();
        cVar.type = 11;
        cVar.bXX = R.string.frs_game_recommend_tab_title;
        cVar.cyM = c.cyJ;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cP(Context context) {
        this.cys = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.cys.setTextSize(2.0f);
        return this.cys;
    }
}
