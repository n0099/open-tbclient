package com.baidu.tieba.ala.gamefrslivetab.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    private AlaGameFrsLiveTabVideoFragment ezo = new AlaGameFrsLiveTabVideoFragment();

    public a() {
        aNy().frag = this.ezo;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c aNx() {
        c cVar = new c();
        cVar.type = 3;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = c.SHOWTEXT;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator dW(Context context) {
        this.dxc = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.dxc.setTextSize(2.0f);
        return this.dxc;
    }

    public void setForumId(String str) {
        if (this.ezo != null) {
            this.ezo.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.ezo != null) {
            this.ezo.setForumName(str);
        }
    }

    public void is(boolean z) {
        if (this.ezo != null) {
            this.ezo.is(z);
        }
    }
}
