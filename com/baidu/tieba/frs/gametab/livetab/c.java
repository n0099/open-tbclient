package com.baidu.tieba.frs.gametab.livetab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ad;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mainTab.b {
    private b cCF = new b();

    public c() {
        EV().aGX = this.cCF;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EU() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.aGY = d.l.ala_live;
        cVar.aHf = com.baidu.tbadk.mainTab.c.aHd;
        return cVar;
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.jb(2)) {
            adVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aY(Context context) {
        this.aGO = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.aGO.setTextSize(2.0f);
        return this.aGO;
    }

    public void setForumId(String str) {
        if (this.cCF != null) {
            this.cCF.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.cCF != null) {
            this.cCF.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.cCF != null) {
            this.cCF.setForumGameLabel(str);
        }
    }
}
