package com.baidu.tieba.ala.gamebar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ac;
/* loaded from: classes3.dex */
public class a extends b {
    private AlaGameFrsLiveTabFragment eDE = new AlaGameFrsLiveTabFragment();

    public a() {
        getFragmentTabStructure().frag = this.eDE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.type = 2;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = c.SHOWTEXT;
        return cVar;
    }

    public void a(ac acVar) {
        if (acVar != null && acVar.tc(2)) {
            acVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    public void setForumId(String str) {
        if (this.eDE != null) {
            this.eDE.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.eDE != null) {
            this.eDE.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.eDE != null) {
            this.eDE.setForumGameLabel(str);
        }
    }
}
