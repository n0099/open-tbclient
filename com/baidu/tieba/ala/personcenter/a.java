package com.baidu.tieba.ala.personcenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ai;
/* loaded from: classes9.dex */
public class a extends b {
    private AlaPersonCenterFragment iaN = new AlaPersonCenterFragment();

    public a() {
        getFragmentTabStructure().frag = this.iaN;
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

    public void a(ai aiVar) {
        if (aiVar != null && aiVar.zc(5)) {
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
        if (this.iaN != null) {
            this.iaN.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.iaN != null) {
            this.iaN.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.iaN != null) {
            this.iaN.setForumGameLabel(str);
        }
    }

    public void Iw(String str) {
        if (this.iaN != null) {
            this.iaN.Iw(str);
        }
    }
}
