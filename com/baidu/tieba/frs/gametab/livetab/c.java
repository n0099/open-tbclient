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
    private b cEe = new b();

    public c() {
        Eu().aGi = this.cEe;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Et() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.aGj = d.l.ala_live;
        cVar.aGq = com.baidu.tbadk.mainTab.c.aGo;
        return cVar;
    }

    public void a(ae aeVar) {
        if (aeVar != null && aeVar.jk(2)) {
            aeVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aY(Context context) {
        this.aFZ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.aFZ.setTextSize(2.0f);
        return this.aFZ;
    }

    public void setForumId(String str) {
        if (this.cEe != null) {
            this.cEe.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.cEe != null) {
            this.cEe.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.cEe != null) {
            this.cEe.setForumGameLabel(str);
        }
    }
}
