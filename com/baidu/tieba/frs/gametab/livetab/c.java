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
    private b dNW = new b();

    public c() {
        Mn().bvG = this.dNW;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Mm() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.bvH = d.j.ala_live;
        cVar.bvO = com.baidu.tbadk.mainTab.c.bvM;
        return cVar;
    }

    public void a(af afVar) {
        if (afVar != null && afVar.nd(2)) {
            afVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e bm(Context context) {
        this.bvx = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.bvx.setTextSize(2.0f);
        return this.bvx;
    }

    public void setForumId(String str) {
        if (this.dNW != null) {
            this.dNW.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.dNW != null) {
            this.dNW.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.dNW != null) {
            this.dNW.setForumGameLabel(str);
        }
    }
}
