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
    private FrsGameRecommendFragment fHw;

    public a(String str, String str2) {
        this.fHw = FrsGameRecommendFragment.cY(str, str2);
        atU().cxK = this.fHw;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c atT() {
        c cVar = new c();
        cVar.type = 11;
        cVar.bXe = R.string.frs_game_recommend_tab_title;
        cVar.cxQ = c.cxN;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cP(Context context) {
        this.cxw = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.cxw.setTextSize(2.0f);
        return this.cxw;
    }
}
