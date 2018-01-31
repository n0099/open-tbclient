package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.tieba.frs.view.c {
    protected o dCH;
    protected g dGv;
    protected TextView dGw;
    protected ViewGroup dGx;

    public void avT() {
        this.dGw = (TextView) this.dTZ.findViewById(d.g.top_item_type);
        this.dGw.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.dUd = new com.baidu.tieba.frs.view.a(this.dCS.getContext());
        this.dUd.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dUd.setOrientation(1);
        this.dUd.setPadding(0, 0, 0, l.s(this.aQs.getPageActivity(), d.e.tbds16));
        this.dGv = new g(this.dCS);
        this.dGv.a(this.dUO);
        this.dUd.setAdapter(this.dGv);
    }

    public void a(o oVar) {
        this.dCH = oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bj(List<com.baidu.tieba.tbadkCore.g> list) {
        if (this.dCS != null && this.dCS.auv() != null && this.dGv != null) {
            ArrayList arrayList = new ArrayList();
            List<i> buO = this.dCS.auv().buO();
            if (buO != null) {
                for (int i = 0; i < v.D(buO) && arrayList.size() < 2; i++) {
                    i iVar = (i) v.f(buO, i);
                    if (iVar instanceof bd) {
                        arrayList.add(iVar);
                    }
                }
            }
            if (this.dGv instanceof com.baidu.tieba.frs.d.c) {
                g gVar = this.dGv;
                if (com.baidu.tieba.frs.d.c.dRe != null && this.dCS.auv() != null) {
                    if (this.dCS.auv().gVW == 1) {
                        com.baidu.tieba.frs.d.c.dRe.dQS = true;
                    } else {
                        com.baidu.tieba.frs.d.c.dRe.dQS = false;
                    }
                    if (this.dCS.auv().aYJ() != null) {
                        com.baidu.tieba.frs.d.c.dRe.dQU = this.dCS.auv().aYJ().getId();
                    }
                }
            }
            if (!v.E(list)) {
                arrayList.add(list.get(0));
            }
            this.dGv.c(this.dCH);
            this.dGv.setData(arrayList);
            this.dGv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avU() {
        if (this.dGv != null) {
            this.dGv.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void avV() {
        if (this.dGv != null) {
            this.dGv.notifyDataSetChanged();
        }
    }
}
