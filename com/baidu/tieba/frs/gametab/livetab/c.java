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
    private b cDx = new b();

    public c() {
        EV().aGU = this.cDx;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EU() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.aGV = d.l.ala_live;
        cVar.aHc = com.baidu.tbadk.mainTab.c.aHa;
        return cVar;
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.jd(2)) {
            adVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aZ(Context context) {
        this.aGL = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.aGL.setTextSize(2.0f);
        return this.aGL;
    }

    public void setForumId(String str) {
        if (this.cDx != null) {
            this.cDx.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.cDx != null) {
            this.cDx.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.cDx != null) {
            this.cDx.setForumGameLabel(str);
        }
    }
}
