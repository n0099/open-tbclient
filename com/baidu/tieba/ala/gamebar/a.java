package com.baidu.tieba.ala.gamebar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ab;
/* loaded from: classes6.dex */
public class a extends b {
    private AlaGameFrsLiveTabFragment dKz = new AlaGameFrsLiveTabFragment();

    public a() {
        avz().frag = this.dKz;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c avy() {
        c cVar = new c();
        cVar.type = 2;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = c.SHOWTEXT;
        return cVar;
    }

    public void a(ab abVar) {
        if (abVar != null && abVar.qM(2)) {
            abVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cB(Context context) {
        this.cKb = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.cKb.setTextSize(2.0f);
        return this.cKb;
    }

    public void setForumId(String str) {
        if (this.dKz != null) {
            this.dKz.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.dKz != null) {
            this.dKz.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.dKz != null) {
            this.dKz.setForumGameLabel(str);
        }
    }
}
