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
    private b dRl = new b();

    public c() {
        MV().bxP = this.dRl;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c MU() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.bxQ = d.j.ala_live;
        cVar.bxX = com.baidu.tbadk.mainTab.c.bxV;
        return cVar;
    }

    public void a(af afVar) {
        if (afVar != null && afVar.nb(2)) {
            afVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e bi(Context context) {
        this.bxG = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.bxG.setTextSize(2.0f);
        return this.bxG;
    }

    public void setForumId(String str) {
        if (this.dRl != null) {
            this.dRl.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.dRl != null) {
            this.dRl.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.dRl != null) {
            this.dRl.setForumGameLabel(str);
        }
    }
}
