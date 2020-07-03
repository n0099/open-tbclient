package com.baidu.tieba.ala.gamebar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ak;
/* loaded from: classes3.dex */
public class a extends b {
    private AlaGameFrsLiveTabFragment fHC = new AlaGameFrsLiveTabFragment();

    public a() {
        getFragmentTabStructure().frag = this.fHC;
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

    public void a(ak akVar) {
        if (akVar != null && akVar.uO(2)) {
            akVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    public void setForumId(String str) {
        if (this.fHC != null) {
            this.fHC.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.fHC != null) {
            this.fHC.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.fHC != null) {
            this.fHC.setForumGameLabel(str);
        }
    }
}
