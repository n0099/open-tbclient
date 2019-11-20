package com.baidu.tieba.ala.gamefrslivetab.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    private AlaGameFrsLiveTabVideoFragment dJN = new AlaGameFrsLiveTabVideoFragment();

    public a() {
        avx().frag = this.dJN;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c avw() {
        c cVar = new c();
        cVar.type = 3;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = c.SHOWTEXT;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cB(Context context) {
        this.cJk = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.cJk.setTextSize(2.0f);
        return this.cJk;
    }

    public void setForumId(String str) {
        if (this.dJN != null) {
            this.dJN.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.dJN != null) {
            this.dJN.setForumName(str);
        }
    }

    public void hb(boolean z) {
        if (this.dJN != null) {
            this.dJN.hb(z);
        }
    }
}
