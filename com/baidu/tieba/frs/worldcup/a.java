package com.baidu.tieba.frs.worldcup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    public a() {
        Jo().aRI = new TalkBallFragment();
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Jn() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 12;
        cVar.aRJ = f.j.frs_tab_talkball;
        cVar.aRQ = com.baidu.tbadk.mainTab.c.aRO;
        return cVar;
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.kI(12)) {
            adVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRu = (FragmentTabIndicator) LayoutInflater.from(context).inflate(f.h.fragmenttabindicator, (ViewGroup) null);
        return this.aRu;
    }
}
