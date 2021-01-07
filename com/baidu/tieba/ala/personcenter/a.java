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
/* loaded from: classes10.dex */
public class a extends b {
    private AlaPersonCenterFragment hZc = new AlaPersonCenterFragment();

    public a() {
        getFragmentTabStructure().frag = this.hZc;
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
        if (aiVar != null && aiVar.Ax(5)) {
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
        if (this.hZc != null) {
            this.hZc.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.hZc != null) {
            this.hZc.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.hZc != null) {
            this.hZc.setForumGameLabel(str);
        }
    }

    public void IT(String str) {
        if (this.hZc != null) {
            this.hZc.IT(str);
        }
    }
}
