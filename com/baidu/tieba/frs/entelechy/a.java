package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.frs.view.q;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected w bPl;
    protected AdapterLinearLayout bRF;
    protected q bRG;
    protected TextView bRH;
    protected ViewGroup bRI;

    public void aah() {
        this.bRF = (AdapterLinearLayout) this.cce.findViewById(w.h.top_layout);
        this.bRH = (TextView) this.cce.findViewById(w.h.top_item_type);
        this.bRH.setText(TbadkCoreApplication.m9getInst().getString(w.l.game));
        this.bRG = new q(this.aat.getPageActivity());
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bPl = wVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aai() {
        if (this.bPw != null && this.bPw.Zq() != null && this.bRG != null) {
            ArrayList arrayList = new ArrayList();
            List<v> bfO = this.bPw.Zq().bfO();
            if (bfO != null) {
                for (int i = 0; i < x.q(bfO); i++) {
                    v vVar = (v) x.c(bfO, i);
                    if (vVar instanceof bk) {
                        arrayList.add((bk) vVar);
                    }
                }
            }
            this.bRF.setAdapter(this.bRG);
            if (this.bRG instanceof com.baidu.tieba.frs.c.e) {
                q qVar = this.bRG;
                if (com.baidu.tieba.frs.c.e.bZb != null && this.bPw.Zq() != null) {
                    if (this.bPw.Zq().frQ == 1) {
                        com.baidu.tieba.frs.c.e.bZb.bYR = true;
                    } else {
                        com.baidu.tieba.frs.c.e.bZb.bYR = false;
                    }
                    if (this.bPw.Zq().aHE() != null) {
                        com.baidu.tieba.frs.c.e.bZb.bYT = this.bPw.Zq().aHE().getId();
                    }
                }
            }
            this.bRG.b(this.bPl);
            this.bRG.setData(arrayList);
            this.bRG.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaj() {
        if (this.bRG != null) {
            this.bRG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aak() {
        if (this.bRG != null) {
            this.bRG.notifyDataSetChanged();
        }
    }
}
