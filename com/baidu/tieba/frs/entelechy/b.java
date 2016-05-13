package com.baidu.tieba.frs.entelechy;

import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.frs.view.af;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b extends com.baidu.tieba.frs.view.c {
    protected w bhh;
    protected x bhi;
    protected AdapterLinearLayout bnS;
    protected TextView bnT;
    protected af bnU;

    public void Sc() {
        this.bnS = (AdapterLinearLayout) this.bve.findViewById(t.g.top_layout);
        this.bnT = (TextView) this.bve.findViewById(t.g.top_item_type);
        this.bnT.setText(TbadkCoreApplication.m11getInst().getString(t.j.game));
        this.bnU = new af(this.Do.getPageActivity());
    }

    public void b(w wVar) {
        this.bhh = wVar;
    }

    public void b(x xVar) {
        this.bhi = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Sd() {
        if (this.bjB != null && this.bjB.PZ() != null && this.bnU != null) {
            ArrayList arrayList = new ArrayList();
            List<v> aSX = this.bjB.PZ().aSX();
            if (aSX != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= y.r(aSX)) {
                        break;
                    }
                    v vVar = (v) y.c(aSX, i2);
                    if (vVar instanceof ax) {
                        arrayList.add((ax) vVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bnS.setAdapter(this.bnU);
            this.bnU.c(this.bhh);
            this.bnU.c(this.bhi);
            this.bnU.setData(arrayList);
            this.bnU.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Se() {
        if (this.bnU != null) {
            this.bnU.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void Sf() {
        if (this.bnU != null) {
            this.bnU.notifyDataSetChanged();
        }
    }
}
