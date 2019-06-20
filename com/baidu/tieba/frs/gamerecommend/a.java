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
    private FrsGameRecommendFragment fBK;

    public a(String str, String str2) {
        this.fBK = FrsGameRecommendFragment.cX(str, str2);
        asK().cwo = this.fBK;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c asJ() {
        c cVar = new c();
        cVar.type = 11;
        cVar.bVW = R.string.frs_game_recommend_tab_title;
        cVar.cwu = c.cwr;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cO(Context context) {
        this.cwa = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.cwa.setTextSize(2.0f);
        return this.cwa;
    }
}
