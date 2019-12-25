package com.baidu.tieba.ala.frsgamelive.mvc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    private boolean ewm;
    private AlaFrsLiveFragment eww = new AlaFrsLiveFragment();

    public a(boolean z) {
        this.ewm = z;
        this.eww.ig(z);
        aNf().frag = this.eww;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c aNe() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.textResId = R.string.ala_live;
        cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator dW(Context context) {
        this.dwU = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.dwU.setTextSize(2.0f);
        return this.dwU;
    }

    public void setForumId(String str) {
        if (this.eww != null) {
            this.eww.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.eww != null) {
            this.eww.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.eww != null) {
            this.eww.setForumGameLabel(str);
        }
    }

    public void setFromType(int i) {
        if (this.eww != null) {
            this.eww.setFromType(i);
        }
    }

    public void ih(boolean z) {
        if (this.eww != null) {
            this.eww.ih(z);
        }
    }
}
