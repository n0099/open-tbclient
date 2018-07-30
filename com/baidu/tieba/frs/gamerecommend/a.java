package com.baidu.tieba.frs.gamerecommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends b {
    private FrsGameRecommendFragment dyq;

    public a(String str, String str2) {
        this.dyq = FrsGameRecommendFragment.be(str, str2);
        Jo().aRL = this.dyq;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c Jn() {
        c cVar = new c();
        cVar.type = 11;
        cVar.aRM = d.j.frs_game_recommend_tab_title;
        cVar.aRS = c.aRQ;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator be(Context context) {
        this.aRx = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.aRx.setTextSize(2.0f);
        return this.aRx;
    }
}
