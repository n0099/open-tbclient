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
    private b dJu = new b();

    public c() {
        Mz().bvx = this.dJu;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c My() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.type = 2;
        cVar.bvy = d.j.ala_live;
        cVar.bvF = com.baidu.tbadk.mainTab.c.bvD;
        return cVar;
    }

    public void a(af afVar) {
        if (afVar != null && afVar.na(2)) {
            afVar.b(this);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e bm(Context context) {
        this.bvo = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.bvo.setTextSize(2.0f);
        return this.bvo;
    }

    public void setForumId(String str) {
        if (this.dJu != null) {
            this.dJu.setForumId(str);
        }
    }

    public void setForumName(String str) {
        if (this.dJu != null) {
            this.dJu.setForumName(str);
        }
    }

    public void setForumGameLabel(String str) {
        if (this.dJu != null) {
            this.dJu.setForumGameLabel(str);
        }
    }
}
