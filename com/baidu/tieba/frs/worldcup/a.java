package com.baidu.tieba.frs.worldcup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    public a() {
        NP().bdK = new TalkBallFragment();
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c NO() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 12;
        cVar.aFr = e.j.frs_tab_talkball;
        cVar.bdQ = com.baidu.tbadk.mainTab.c.bdO;
        return cVar;
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.mr(12)) {
            adVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bR(Context context) {
        this.bdw = (FragmentTabIndicator) LayoutInflater.from(context).inflate(e.h.fragmenttabindicator, (ViewGroup) null);
        return this.bdw;
    }
}
