package com.baidu.tieba.ala.frsgamelive.mvc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    private AlaFrsLiveFragment exI = new AlaFrsLiveFragment();
    private boolean exy;

    public a(boolean z) {
        this.exy = z;
        this.exI.iq(z);
        aNy().frag = this.exI;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c aNx() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator dW(Context context) {
        this.dxc = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.dxc.setTextSize(2.0f);
        return this.dxc;
    }

    public void setForumId(String str) {
        if (this.exI != null) {
            this.exI.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.exI != null) {
            this.exI.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.exI != null) {
            this.exI.setForumGameLabel(str);
        }
    }

    public void setFromType(int i) {
        if (this.exI != null) {
            this.exI.setFromType(i);
        }
    }

    public void ir(boolean z) {
        if (this.exI != null) {
            this.exI.ir(z);
        }
    }
}
