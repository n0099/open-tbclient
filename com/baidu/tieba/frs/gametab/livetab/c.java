package com.baidu.tieba.frs.gametab.livetab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ad;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mainTab.b {
    private b cwb = new b();

    public c() {
        EX().aHI = this.cwb;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EW() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.aHJ = d.l.frs_live;
        cVar.aHO = com.baidu.tbadk.mainTab.c.aHM;
        return cVar;
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.iP(2)) {
            adVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aT(Context context) {
        this.aHv = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.aHv.setTextSize(2.0f);
        return this.aHv;
    }

    public void setForumId(String str) {
        if (this.cwb != null) {
            this.cwb.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.cwb != null) {
            this.cwb.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.cwb != null) {
            this.cwb.setForumGameLabel(str);
        }
    }
}
