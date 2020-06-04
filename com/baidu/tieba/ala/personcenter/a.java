package com.baidu.tieba.ala.personcenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ag;
/* loaded from: classes3.dex */
public class a extends b {
    private AlaPersonCenterFragment gnZ = new AlaPersonCenterFragment();

    public a() {
        getFragmentTabStructure().frag = this.gnZ;
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

    public void a(ag agVar) {
        if (agVar != null && agVar.uj(5)) {
            agVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator.setTextSize(2.0f);
        return this.mIndicator;
    }

    public void setForumId(String str) {
        if (this.gnZ != null) {
            this.gnZ.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.gnZ != null) {
            this.gnZ.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.gnZ != null) {
            this.gnZ.setForumGameLabel(str);
        }
    }

    public void CX(String str) {
        if (this.gnZ != null) {
            this.gnZ.CX(str);
        }
    }
}
