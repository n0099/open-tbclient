package com.baidu.tieba.ala.personcenter;

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
    private AlaPersonCenterFragment hDp = new AlaPersonCenterFragment();

    public a() {
        getFragmentTabStructure().frag = this.hDp;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.type = 5;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = c.SHOWTEXT;
        return cVar;
    }

    public void a(am amVar) {
        if (amVar != null && amVar.zi(5)) {
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
        if (this.hDp != null) {
            this.hDp.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.hDp != null) {
            this.hDp.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.hDp != null) {
            this.hDp.setForumGameLabel(str);
        }
    }

    public void IG(String str) {
        if (this.hDp != null) {
            this.hDp.IG(str);
        }
    }
}
