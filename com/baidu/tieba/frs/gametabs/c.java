package com.baidu.tieba.frs.gametabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.mainTab.b {
    public c(int i, String str) {
        this.bdv.type = i;
        SpecialFrsWebFragment specialFrsWebFragment = (SpecialFrsWebFragment) this.bdv.bdK;
        specialFrsWebFragment.mU(i);
        if (str != null && !str.contains("&_client_version=") && !str.contains("?_client_version=")) {
            if (str.contains("&ufanS=1")) {
                str = str + "&_client_version=" + TbConfig.getVersion();
            } else if (str.contains("?ufanS=1")) {
                str = str + "&_client_version=" + TbConfig.getVersion();
            }
        }
        specialFrsWebFragment.setUrl(str);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c NO() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.bdK = new SpecialFrsWebFragment();
        cVar.type = 101;
        cVar.bdQ = com.baidu.tbadk.mainTab.c.bdN;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bR(Context context) {
        this.bdw = (FragmentTabIndicator) LayoutInflater.from(context).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        this.bdw.setTextSize(2.0f);
        return this.bdw;
    }
}
