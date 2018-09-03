package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad;
/* loaded from: classes2.dex */
public class e extends com.baidu.tbadk.mainTab.b {
    public e(FrsFragment frsFragment) {
        Jo().aRI = frsFragment;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Jn() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 1;
        cVar.aRJ = f.j.chosen_pb_title;
        cVar.aRQ = com.baidu.tbadk.mainTab.c.aRN;
        return cVar;
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.kI(1)) {
            adVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRu = (FragmentTabIndicator) LayoutInflater.from(context).inflate(f.h.fragmenttabindicator, (ViewGroup) null);
        this.aRu.setTextSize(2.0f);
        return this.aRu;
    }
}
