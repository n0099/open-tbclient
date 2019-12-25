package com.baidu.tieba.ala.personcenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ac;
/* loaded from: classes2.dex */
public class a extends b {
    private AlaPersonCenterFragment fnS = new AlaPersonCenterFragment();

    public a() {
        aNf().frag = this.fnS;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c aNe() {
        c cVar = new c();
        cVar.type = 5;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = c.SHOWTEXT;
        return cVar;
    }

    public void a(ac acVar) {
        if (acVar != null && acVar.sR(5)) {
            acVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator dW(Context context) {
        this.dwU = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.dwU.setTextSize(2.0f);
        return this.dwU;
    }

    public void setForumId(String str) {
        if (this.fnS != null) {
            this.fnS.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.fnS != null) {
            this.fnS.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.fnS != null) {
            this.fnS.setForumGameLabel(str);
        }
    }
}
