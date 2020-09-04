package com.baidu.tieba.ala.gamebar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.am;
/* loaded from: classes4.dex */
public class a extends b {
    private AlaGameFrsLiveTabFragment fYZ = new AlaGameFrsLiveTabFragment();

    public a() {
        getFragmentTabStructure().frag = this.fYZ;
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

    public void a(am amVar) {
        if (amVar != null && amVar.xx(2)) {
            amVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    public void setForumId(String str) {
        if (this.fYZ != null) {
            this.fYZ.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.fYZ != null) {
            this.fYZ.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.fYZ != null) {
            this.fYZ.setForumGameLabel(str);
        }
    }
}
