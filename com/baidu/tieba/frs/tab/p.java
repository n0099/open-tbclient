package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ n bSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bSP = nVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        BaseAdapter baseAdapter;
        j.b bVar;
        List<dy> list;
        BaseAdapter baseAdapter2;
        j.b bVar2;
        j jVar2;
        jVar = this.bSP.bSN;
        if (jVar != null) {
            jVar2 = this.bSP.bSN;
            jVar2.aaq();
        }
        baseAdapter = this.bSP.bSO;
        if (baseAdapter != null) {
            bVar = this.bSP.bSs;
            if (bVar != null) {
                list = this.bSP.aMv;
                for (dy dyVar : list) {
                    if (dyVar != null) {
                        dyVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bSP.bSO;
                dy dyVar2 = (dy) baseAdapter2.getItem(i);
                if (dyVar2 != null) {
                    dyVar2.isSelected = true;
                    bVar2 = this.bSP.bSs;
                    bVar2.hS(dyVar2.bIj);
                }
            }
        }
    }
}
