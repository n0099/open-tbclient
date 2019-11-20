package com.baidu.tieba.ala.frsgamelive.mvc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    private boolean dIa;
    private AlaFrsLiveFragment dIj = new AlaFrsLiveFragment();

    public a(boolean z) {
        this.dIa = z;
        this.dIj.gZ(z);
        avx().frag = this.dIj;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c avw() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cB(Context context) {
        this.cJk = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.cJk.setTextSize(2.0f);
        return this.cJk;
    }

    public void setForumId(String str) {
        if (this.dIj != null) {
            this.dIj.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.dIj != null) {
            this.dIj.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.dIj != null) {
            this.dIj.setForumGameLabel(str);
        }
    }

    public void setFromType(int i) {
        if (this.dIj != null) {
            this.dIj.setFromType(i);
        }
    }

    public void ha(boolean z) {
        if (this.dIj != null) {
            this.dIj.ha(z);
        }
    }
}
