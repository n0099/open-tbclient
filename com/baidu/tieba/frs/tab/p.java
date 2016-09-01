package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ n cdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.cdV = nVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        BaseAdapter baseAdapter;
        j.b bVar;
        List<dt> list;
        BaseAdapter baseAdapter2;
        j.b bVar2;
        j jVar2;
        jVar = this.cdV.cdT;
        if (jVar != null) {
            jVar2 = this.cdV.cdT;
            jVar2.afb();
        }
        baseAdapter = this.cdV.cdU;
        if (baseAdapter != null) {
            bVar = this.cdV.cdy;
            if (bVar != null) {
                list = this.cdV.aRP;
                for (dt dtVar : list) {
                    if (dtVar != null) {
                        dtVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.cdV.cdU;
                dt dtVar2 = (dt) baseAdapter2.getItem(i);
                if (dtVar2 != null) {
                    dtVar2.isSelected = true;
                    bVar2 = this.cdV.cdy;
                    bVar2.iv(dtVar2.bTp);
                }
            }
        }
    }
}
