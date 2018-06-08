package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ab;
/* loaded from: classes2.dex */
public class e extends com.baidu.tbadk.mainTab.b {
    public e(FrsFragment frsFragment) {
        Jb().aQP = frsFragment;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Ja() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 1;
        cVar.aQQ = d.k.chosen_pb_title;
        cVar.aQW = com.baidu.tbadk.mainTab.c.aQU;
        return cVar;
    }

    public void a(ab abVar) {
        if (abVar != null && abVar.ks(1)) {
            abVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aQB = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        this.aQB.setTextSize(2.0f);
        return this.aQB;
    }
}
