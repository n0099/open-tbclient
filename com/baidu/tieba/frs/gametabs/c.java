package com.baidu.tieba.frs.gametabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c extends com.baidu.tbadk.mainTab.b {
    public c(int i, String str) {
        this.cnR.type = i;
        SpecialFrsWebFragment specialFrsWebFragment = (SpecialFrsWebFragment) this.cnR.cog;
        specialFrsWebFragment.qS(i);
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
    public com.baidu.tbadk.mainTab.c anG() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.cog = new SpecialFrsWebFragment();
        cVar.type = 101;
        cVar.f5com = com.baidu.tbadk.mainTab.c.coj;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator di(Context context) {
        this.cnS = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.cnS.setTextSize(2.0f);
        return this.cnS;
    }
}
