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
    private FrsGameRecommendFragment dhZ;

    public a(String str, String str2) {
        this.dhZ = FrsGameRecommendFragment.aU(str, str2);
        Fy().aIm = this.dhZ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c Fx() {
        c cVar = new c();
        cVar.type = 11;
        cVar.aIn = d.k.frs_game_recommend_tab_title;
        cVar.aIu = c.aIs;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator aT(Context context) {
        this.aId = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        this.aId.setTextSize(2.0f);
        return this.aId;
    }
}
