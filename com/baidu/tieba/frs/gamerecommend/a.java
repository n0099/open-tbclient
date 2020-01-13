package com.baidu.tieba.frs.gamerecommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends b {
    private FrsGameRecommendFragment gzl;

    public a(String str, String str2) {
        this.gzl = FrsGameRecommendFragment.dg(str, str2);
        aNy().frag = this.gzl;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c aNx() {
        c cVar = new c();
        cVar.type = 11;
        cVar.textResId = R.string.frs_game_recommend_tab_title;
        cVar.showIconType = c.SHOWTEXT;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator dW(Context context) {
        this.dxc = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.dxc.setTextSize(2.0f);
        return this.dxc;
    }
}
