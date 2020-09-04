package com.baidu.tieba.ala.frsgamelive.mvc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    private AlaFrsLiveFragment fXA = new AlaFrsLiveFragment();
    private boolean fXq;

    public a(boolean z) {
        this.fXq = z;
        this.fXA.ln(z);
        getFragmentTabStructure().frag = this.fXA;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    public void setForumId(String str) {
        if (this.fXA != null) {
            this.fXA.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.fXA != null) {
            this.fXA.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.fXA != null) {
            this.fXA.setForumGameLabel(str);
        }
    }

    public void setFromType(int i) {
        if (this.fXA != null) {
            this.fXA.setFromType(i);
        }
    }

    public void lo(boolean z) {
        if (this.fXA != null) {
            this.fXA.lo(z);
        }
    }
}
