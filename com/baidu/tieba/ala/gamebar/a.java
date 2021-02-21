package com.baidu.tieba.ala.gamebar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ai;
/* loaded from: classes10.dex */
public class a extends b {
    private AlaGameFrsLiveTabFragment gXf = new AlaGameFrsLiveTabFragment();

    public a() {
        getFragmentTabStructure().frag = this.gXf;
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

    public void a(ai aiVar) {
        if (aiVar != null && aiVar.zb(2)) {
            aiVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    public void setForumId(String str) {
        if (this.gXf != null) {
            this.gXf.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.gXf != null) {
            this.gXf.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.gXf != null) {
            this.gXf.setForumGameLabel(str);
        }
    }
}
