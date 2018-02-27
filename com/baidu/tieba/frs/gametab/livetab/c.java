package com.baidu.tieba.frs.gametab.livetab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.af;
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.mainTab.b {
    private b dRg = new b();

    public c() {
        MU().bxM = this.dRg;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c MT() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.bxN = d.j.ala_live;
        cVar.bxU = com.baidu.tbadk.mainTab.c.bxS;
        return cVar;
    }

    public void a(af afVar) {
        if (afVar != null && afVar.nb(2)) {
            afVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e bi(Context context) {
        this.bxD = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.bxD.setTextSize(2.0f);
        return this.bxD;
    }

    public void setForumId(String str) {
        if (this.dRg != null) {
            this.dRg.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.dRg != null) {
            this.dRg.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.dRg != null) {
            this.dRg.setForumGameLabel(str);
        }
    }
}
