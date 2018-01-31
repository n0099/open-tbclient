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
    private b dOr = new b();

    public c() {
        Mp().bvP = this.dOr;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Mo() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.bvQ = d.j.ala_live;
        cVar.bvX = com.baidu.tbadk.mainTab.c.bvV;
        return cVar;
    }

    public void a(af afVar) {
        if (afVar != null && afVar.nd(2)) {
            afVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e bj(Context context) {
        this.bvG = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.bvG.setTextSize(2.0f);
        return this.bvG;
    }

    public void setForumId(String str) {
        if (this.dOr != null) {
            this.dOr.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.dOr != null) {
            this.dOr.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.dOr != null) {
            this.dOr.setForumGameLabel(str);
        }
    }
}
