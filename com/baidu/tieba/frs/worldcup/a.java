package com.baidu.tieba.frs.worldcup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mainTab.b {
    private TalkBallFragment dFg = new TalkBallFragment();

    public a() {
        Jb().aQP = this.dFg;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Ja() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 12;
        cVar.aQQ = d.k.frs_tab_talkball;
        cVar.aQW = com.baidu.tbadk.mainTab.c.aQV;
        return cVar;
    }

    public void a(ab abVar) {
        if (abVar != null && abVar.ks(12)) {
            abVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aQB = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        return this.aQB;
    }
}
