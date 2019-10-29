package com.baidu.tieba.ala.frsgamelive.mvc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    private boolean dIR;
    private AlaFrsLiveFragment dJa = new AlaFrsLiveFragment();

    public a(boolean z) {
        this.dIR = z;
        this.dJa.gZ(z);
        avz().frag = this.dJa;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c avy() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cB(Context context) {
        this.cKb = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.cKb.setTextSize(2.0f);
        return this.cKb;
    }

    public void setForumId(String str) {
        if (this.dJa != null) {
            this.dJa.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.dJa != null) {
            this.dJa.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.dJa != null) {
            this.dJa.setForumGameLabel(str);
        }
    }

    public void setFromType(int i) {
        if (this.dJa != null) {
            this.dJa.setFromType(i);
        }
    }

    public void ha(boolean z) {
        if (this.dJa != null) {
            this.dJa.ha(z);
        }
    }
}
