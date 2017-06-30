package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.frs.tab.k;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ o cor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.cor = oVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        k kVar;
        BaseAdapter baseAdapter;
        k.b bVar;
        List<co> list;
        BaseAdapter baseAdapter2;
        k.b bVar2;
        k kVar2;
        kVar = this.cor.cop;
        if (kVar != null) {
            kVar2 = this.cor.cop;
            kVar2.aht();
        }
        baseAdapter = this.cor.coq;
        if (baseAdapter != null) {
            bVar = this.cor.cnR;
            if (bVar != null) {
                list = this.cor.aUW;
                for (co coVar : list) {
                    if (coVar != null) {
                        coVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.cor.coq;
                co coVar2 = (co) baseAdapter2.getItem(i);
                if (coVar2 != null) {
                    coVar2.isSelected = true;
                    bVar2 = this.cor.cnR;
                    bVar2.jh(coVar2.ceQ);
                }
            }
        }
    }
}
