package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.i;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.mainTab.b {
    public d(i iVar) {
        Mz().bvx = iVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c My() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 1;
        cVar.bvy = d.j.chosen_pb_title;
        cVar.bvF = com.baidu.tbadk.mainTab.c.bvD;
        return cVar;
    }

    public void a(af afVar) {
        if (afVar != null && afVar.na(1)) {
            afVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e bm(Context context) {
        this.bvo = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.bvo.setTextSize(2.0f);
        return this.bvo;
    }
}
