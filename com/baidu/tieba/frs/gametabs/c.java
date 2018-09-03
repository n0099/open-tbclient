package com.baidu.tieba.frs.gametabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.mainTab.b {
    public c(int i, String str) {
        this.aRt.type = i;
        SpecialFrsWebFragment specialFrsWebFragment = (SpecialFrsWebFragment) this.aRt.aRI;
        specialFrsWebFragment.ln(i);
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
    public com.baidu.tbadk.mainTab.c Jn() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aRI = new SpecialFrsWebFragment();
        cVar.type = 101;
        cVar.aRQ = com.baidu.tbadk.mainTab.c.aRN;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRu = (FragmentTabIndicator) LayoutInflater.from(context).inflate(f.h.fragmenttabindicator, (ViewGroup) null);
        this.aRu.setTextSize(2.0f);
        return this.aRu;
    }
}
