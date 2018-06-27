package com.baidu.tieba.frs.worldcup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    public a() {
        Jt().aRL = new TalkBallFragment();
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Js() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 12;
        cVar.aRM = d.k.frs_tab_talkball;
        cVar.aRS = com.baidu.tbadk.mainTab.c.aRR;
        return cVar;
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.ky(12)) {
            adVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRx = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        return this.aRx;
    }
}
