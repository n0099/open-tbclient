package com.baidu.tieba.frs.entelechy;

import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b extends com.baidu.tieba.frs.view.c {
    protected w bDw;
    protected x bDx;
    protected AdapterLinearLayout bIo;
    protected TextView bIp;
    protected com.baidu.tieba.frs.view.x bIq;

    public void Xv() {
        this.bIo = (AdapterLinearLayout) this.bSP.findViewById(u.g.top_layout);
        this.bIp = (TextView) this.bSP.findViewById(u.g.top_item_type);
        this.bIp.setText(TbadkCoreApplication.m9getInst().getString(u.j.game));
        this.bIq = new com.baidu.tieba.frs.view.x(this.Dp.getPageActivity());
    }

    public void b(w wVar) {
        this.bDw = wVar;
    }

    public void b(x xVar) {
        this.bDx = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xw() {
        if (this.bET != null && this.bET.VC() != null && this.bIq != null) {
            ArrayList arrayList = new ArrayList();
            List<v> bbj = this.bET.VC().bbj();
            if (bbj != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= y.s(bbj)) {
                        break;
                    }
                    v vVar = (v) y.c(bbj, i2);
                    if (vVar instanceof az) {
                        arrayList.add((az) vVar);
                    }
                    i = i2 + 1;
                }
            }
            this.bIo.setAdapter(this.bIq);
            this.bIq.c(this.bDw);
            this.bIq.c(this.bDx);
            this.bIq.setData(arrayList);
            this.bIq.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xx() {
        if (this.bIq != null) {
            this.bIq.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void Xy() {
        if (this.bIq != null) {
            this.bIq.notifyDataSetChanged();
        }
    }
}
