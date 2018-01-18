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
    protected o dCm;
    protected g dGa;
    protected TextView dGb;
    protected ViewGroup dGc;

    public void avO() {
        this.dGb = (TextView) this.dTE.findViewById(d.g.top_item_type);
        this.dGb.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.dTI = new com.baidu.tieba.frs.view.a(this.dCx.getContext());
        this.dTI.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dTI.setOrientation(1);
        this.dTI.setPadding(0, 0, 0, l.s(this.aQp.getPageActivity(), d.e.tbds16));
        this.dGa = new g(this.dCx);
        this.dGa.a(this.dUt);
        this.dTI.setAdapter(this.dGa);
    }

    public void a(o oVar) {
        this.dCm = oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bj(List<com.baidu.tieba.tbadkCore.g> list) {
        if (this.dCx != null && this.dCx.auq() != null && this.dGa != null) {
            ArrayList arrayList = new ArrayList();
            List<i> buM = this.dCx.auq().buM();
            if (buM != null) {
                for (int i = 0; i < v.D(buM) && arrayList.size() < 2; i++) {
                    i iVar = (i) v.f(buM, i);
                    if (iVar instanceof bd) {
                        arrayList.add(iVar);
                    }
                }
            }
            if (this.dGa instanceof com.baidu.tieba.frs.d.c) {
                g gVar = this.dGa;
                if (com.baidu.tieba.frs.d.c.dQJ != null && this.dCx.auq() != null) {
                    if (this.dCx.auq().gVC == 1) {
                        com.baidu.tieba.frs.d.c.dQJ.dQx = true;
                    } else {
                        com.baidu.tieba.frs.d.c.dQJ.dQx = false;
                    }
                    if (this.dCx.auq().aYE() != null) {
                        com.baidu.tieba.frs.d.c.dQJ.dQz = this.dCx.auq().aYE().getId();
                    }
                }
            }
            if (!v.E(list)) {
                arrayList.add(list.get(0));
            }
            this.dGa.c(this.dCm);
            this.dGa.setData(arrayList);
            this.dGa.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avP() {
        if (this.dGa != null) {
            this.dGa.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void avQ() {
        if (this.dGa != null) {
            this.dGa.notifyDataSetChanged();
        }
    }
}
