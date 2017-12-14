package com.baidu.tieba.frs.gametab.livetab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.af;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mainTab.b {
    private b cXe = new b();

    public c() {
        Fa().aHG = this.cXe;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EZ() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.aHH = d.j.ala_live;
        cVar.aHO = com.baidu.tbadk.mainTab.c.aHM;
        return cVar;
    }

    public void a(af afVar) {
        if (afVar != null && afVar.jZ(2)) {
            afVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e ba(Context context) {
        this.aHx = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.aHx.setTextSize(2.0f);
        return this.aHx;
    }

    public void setForumId(String str) {
        if (this.cXe != null) {
            this.cXe.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.cXe != null) {
            this.cXe.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.cXe != null) {
            this.cXe.setForumGameLabel(str);
        }
    }
}
