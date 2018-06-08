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
    private FrsGameRecommendFragment dsu;

    public a(String str, String str2) {
        this.dsu = FrsGameRecommendFragment.bc(str, str2);
        Jb().aQP = this.dsu;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c Ja() {
        c cVar = new c();
        cVar.type = 11;
        cVar.aQQ = d.k.frs_game_recommend_tab_title;
        cVar.aQW = c.aQU;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aQB = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        this.aQB.setTextSize(2.0f);
        return this.aQB;
    }
}
