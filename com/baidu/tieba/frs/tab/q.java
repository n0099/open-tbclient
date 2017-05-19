package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.tab.k;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ o bZP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.bZP = oVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        k kVar;
        BaseAdapter baseAdapter;
        k.b bVar;
        List<cm> list;
        BaseAdapter baseAdapter2;
        k.b bVar2;
        k kVar2;
        kVar = this.bZP.bZN;
        if (kVar != null) {
            kVar2 = this.bZP.bZN;
            kVar2.acx();
        }
        baseAdapter = this.bZP.bZO;
        if (baseAdapter != null) {
            bVar = this.bZP.bZp;
            if (bVar != null) {
                list = this.bZP.aWb;
                for (cm cmVar : list) {
                    if (cmVar != null) {
                        cmVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bZP.bZO;
                cm cmVar2 = (cm) baseAdapter2.getItem(i);
                if (cmVar2 != null) {
                    cmVar2.isSelected = true;
                    bVar2 = this.bZP.bZp;
                    bVar2.ix(cmVar2.bQR);
                }
            }
        }
    }
}
