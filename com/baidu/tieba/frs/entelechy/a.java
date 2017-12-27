package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.tieba.frs.view.c {
    protected TextView dBA;
    protected ViewGroup dBB;
    protected g dBz;
    protected o dxL;

    public void auL() {
        this.dBA = (TextView) this.dOQ.findViewById(d.g.top_item_type);
        this.dBA.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.dOU = new com.baidu.tieba.frs.view.a(this.dxW.getContext());
        this.dOU.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dOU.setOrientation(1);
        this.dOU.setPadding(0, 0, 0, l.s(this.aQq.getPageActivity(), d.e.tbds16));
        this.dBz = new g(this.dxW);
        this.dBz.a(this.dPF);
        this.dOU.setAdapter(this.dBz);
    }

    public void a(o oVar) {
        this.dxL = oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bl(List<com.baidu.tieba.tbadkCore.g> list) {
        if (this.dxW != null && this.dxW.atn() != null && this.dBz != null) {
            ArrayList arrayList = new ArrayList();
            List<i> bBq = this.dxW.atn().bBq();
            if (bBq != null) {
                for (int i = 0; i < v.F(bBq) && arrayList.size() < 2; i++) {
                    i iVar = (i) v.f(bBq, i);
                    if (iVar instanceof be) {
                        arrayList.add(iVar);
                    }
                }
            }
            if (this.dBz instanceof com.baidu.tieba.frs.d.c) {
                g gVar = this.dBz;
                if (com.baidu.tieba.frs.d.c.dMh != null && this.dxW.atn() != null) {
                    if (this.dxW.atn().hgc == 1) {
                        com.baidu.tieba.frs.d.c.dMh.dLV = true;
                    } else {
                        com.baidu.tieba.frs.d.c.dMh.dLV = false;
                    }
                    if (this.dxW.atn().aYy() != null) {
                        com.baidu.tieba.frs.d.c.dMh.dLX = this.dxW.atn().aYy().getId();
                    }
                }
            }
            if (!v.G(list)) {
                arrayList.add(list.get(0));
            }
            this.dBz.c(this.dxL);
            this.dBz.setData(arrayList);
            this.dBz.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auM() {
        if (this.dBz != null) {
            this.dBz.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void auN() {
        if (this.dBz != null) {
            this.dBz.notifyDataSetChanged();
        }
    }
}
