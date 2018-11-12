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
    private FrsGameRecommendFragment dNZ;

    public a(String str, String str2) {
        this.dNZ = FrsGameRecommendFragment.by(str, str2);
        ML().bam = this.dNZ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c MK() {
        c cVar = new c();
        cVar.type = 11;
        cVar.aBR = e.j.frs_game_recommend_tab_title;
        cVar.bat = c.bap;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bO(Context context) {
        this.aZY = (FragmentTabIndicator) LayoutInflater.from(context).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        this.aZY.setTextSize(2.0f);
        return this.aZY;
    }
}
