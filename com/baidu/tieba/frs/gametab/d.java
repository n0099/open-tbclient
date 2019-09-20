package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ab;
/* loaded from: classes4.dex */
public class d extends com.baidu.tbadk.mainTab.b {
    public d(FrsFragment frsFragment) {
        aug().cyG = frsFragment;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c auf() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 1;
        cVar.bXX = R.string.chosen_pb_title;
        cVar.cyM = com.baidu.tbadk.mainTab.c.cyJ;
        return cVar;
    }

    public void a(ab abVar) {
        if (abVar != null && abVar.rT(1)) {
            abVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cP(Context context) {
        this.cys = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.cys.setTextSize(2.0f);
        return this.cys;
    }
}
