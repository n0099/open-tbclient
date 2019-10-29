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
    private AlaGameFrsLiveTabVideoFragment dKE = new AlaGameFrsLiveTabVideoFragment();

    public a() {
        avz().frag = this.dKE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c avy() {
        c cVar = new c();
        cVar.type = 3;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = c.SHOWTEXT;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cB(Context context) {
        this.cKb = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.cKb.setTextSize(2.0f);
        return this.cKb;
    }

    public void setForumId(String str) {
        if (this.dKE != null) {
            this.dKE.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.dKE != null) {
            this.dKE.setForumName(str);
        }
    }

    public void hb(boolean z) {
        if (this.dKE != null) {
            this.dKE.hb(z);
        }
    }
}
