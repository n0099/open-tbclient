package com.baidu.tieba.frs.gamerecommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a extends b {
    private FrsGameRecommendFragment dyn;

    public a(String str, String str2) {
        this.dyn = FrsGameRecommendFragment.be(str, str2);
        Jo().aRI = this.dyn;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c Jn() {
        c cVar = new c();
        cVar.type = 11;
        cVar.aRJ = f.j.frs_game_recommend_tab_title;
        cVar.aRQ = c.aRN;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRu = (FragmentTabIndicator) LayoutInflater.from(context).inflate(f.h.fragmenttabindicator, (ViewGroup) null);
        this.aRu.setTextSize(2.0f);
        return this.aRu;
    }
}
