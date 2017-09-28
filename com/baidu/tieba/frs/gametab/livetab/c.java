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
    private b cEq = new b();

    public c() {
        EA().aGv = this.cEq;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Ez() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.aGw = d.l.ala_live;
        cVar.aGD = com.baidu.tbadk.mainTab.c.aGB;
        return cVar;
    }

    public void a(ae aeVar) {
        if (aeVar != null && aeVar.jl(2)) {
            aeVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aZ(Context context) {
        this.aGm = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.aGm.setTextSize(2.0f);
        return this.aGm;
    }

    public void setForumId(String str) {
        if (this.cEq != null) {
            this.cEq.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.cEq != null) {
            this.cEq.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.cEq != null) {
            this.cEq.setForumGameLabel(str);
        }
    }
}
