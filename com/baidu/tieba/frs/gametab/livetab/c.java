package com.baidu.tieba.frs.gametab.livetab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ae;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mainTab.b {
    private b cNE = new b();

    public c() {
        ES().aHa = this.cNE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c ER() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.aHb = d.j.ala_live;
        cVar.aHi = com.baidu.tbadk.mainTab.c.aHg;
        return cVar;
    }

    public void a(ae aeVar) {
        if (aeVar != null && aeVar.jz(2)) {
            aeVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aY(Context context) {
        this.aGR = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.aGR.setTextSize(2.0f);
        return this.aGR;
    }

    public void setForumId(String str) {
        if (this.cNE != null) {
            this.cNE.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.cNE != null) {
            this.cNE.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.cNE != null) {
            this.cNE.setForumGameLabel(str);
        }
    }
}
