package com.baidu.tieba.frs.gametab.livetab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ad;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mainTab.b {
    private b csM = new b();

    public c() {
        EP().aGr = this.csM;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EO() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.aGs = d.l.frs_live;
        cVar.aGx = com.baidu.tbadk.mainTab.c.aGv;
        return cVar;
    }

    public void a(ad adVar) {
        if (adVar != null && adVar.iN(2)) {
            adVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aGe = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.aGe.setTextSize(2.0f);
        return this.aGe;
    }

    public void setForumId(String str) {
        if (this.csM != null) {
            this.csM.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.csM != null) {
            this.csM.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.csM != null) {
            this.csM.setForumGameLabel(str);
        }
    }
}
