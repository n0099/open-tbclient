package com.baidu.tieba.ala.gamefrslivetab.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    private AlaGameFrsLiveTabVideoFragment gEC = new AlaGameFrsLiveTabVideoFragment();

    public a() {
        getFragmentTabStructure().frag = this.gEC;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.type = 3;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = c.SHOWTEXT;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    public void setForumId(String str) {
        if (this.gEC != null) {
            this.gEC.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.gEC != null) {
            this.gEC.setForumName(str);
        }
    }

    public void mo(boolean z) {
        if (this.gEC != null) {
            this.gEC.mo(z);
        }
    }
}
