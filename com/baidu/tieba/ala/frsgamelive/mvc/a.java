package com.baidu.tieba.ala.frsgamelive.mvc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    private AlaFrsLiveFragment gLE = new AlaFrsLiveFragment();
    private boolean gLu;

    public a(boolean z) {
        this.gLu = z;
        this.gLE.mI(z);
        getFragmentTabStructure().frag = this.gLE;
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
        if (this.gLE != null) {
            this.gLE.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.gLE != null) {
            this.gLE.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.gLE != null) {
            this.gLE.setForumGameLabel(str);
        }
    }

    public void setFromType(int i) {
        if (this.gLE != null) {
            this.gLE.setFromType(i);
        }
    }

    public void mJ(boolean z) {
        if (this.gLE != null) {
            this.gLE.mJ(z);
        }
    }
}
