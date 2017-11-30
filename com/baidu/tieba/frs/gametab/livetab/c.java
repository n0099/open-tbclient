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
    private b cWT = new b();

    public c() {
        EZ().aHC = this.cWT;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EY() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.aHD = d.j.ala_live;
        cVar.aHK = com.baidu.tbadk.mainTab.c.aHI;
        return cVar;
    }

    public void a(ae aeVar) {
        if (aeVar != null && aeVar.jX(2)) {
            aeVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e bd(Context context) {
        this.aHt = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.aHt.setTextSize(2.0f);
        return this.aHt;
    }

    public void setForumId(String str) {
        if (this.cWT != null) {
            this.cWT.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.cWT != null) {
            this.cWT.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.cWT != null) {
            this.cWT.setForumGameLabel(str);
        }
    }
}
