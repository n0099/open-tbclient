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
    private b cNl = new b();

    public c() {
        EG().aGS = this.cNl;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EF() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.aGT = d.j.ala_live;
        cVar.aHa = com.baidu.tbadk.mainTab.c.aGY;
        return cVar;
    }

    public void a(ae aeVar) {
        if (aeVar != null && aeVar.jA(2)) {
            aeVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aY(Context context) {
        this.aGJ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.aGJ.setTextSize(2.0f);
        return this.aGJ;
    }

    public void setForumId(String str) {
        if (this.cNl != null) {
            this.cNl.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.cNl != null) {
            this.cNl.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.cNl != null) {
            this.cNl.setForumGameLabel(str);
        }
    }
}
