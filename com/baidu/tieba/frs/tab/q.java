package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.tab.k;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ o cgb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.cgb = oVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        k kVar;
        BaseAdapter baseAdapter;
        k.b bVar;
        List<cn> list;
        BaseAdapter baseAdapter2;
        k.b bVar2;
        k kVar2;
        kVar = this.cgb.cfZ;
        if (kVar != null) {
            kVar2 = this.cgb.cfZ;
            kVar2.adA();
        }
        baseAdapter = this.cgb.cga;
        if (baseAdapter != null) {
            bVar = this.cgb.cfB;
            if (bVar != null) {
                list = this.cgb.aTD;
                for (cn cnVar : list) {
                    if (cnVar != null) {
                        cnVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.cgb.cga;
                cn cnVar2 = (cn) baseAdapter2.getItem(i);
                if (cnVar2 != null) {
                    cnVar2.isSelected = true;
                    bVar2 = this.cgb.cfB;
                    bVar2.iV(cnVar2.bWI);
                }
            }
        }
    }
}
