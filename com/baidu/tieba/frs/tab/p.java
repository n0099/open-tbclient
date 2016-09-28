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
    final /* synthetic */ n cdU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.cdU = nVar;
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
        jVar = this.cdU.cdS;
        if (jVar != null) {
            jVar2 = this.cdU.cdS;
            jVar2.afp();
        }
        baseAdapter = this.cdU.cdT;
        if (baseAdapter != null) {
            bVar = this.cdU.cdw;
            if (bVar != null) {
                list = this.cdU.aSU;
                for (dt dtVar : list) {
                    if (dtVar != null) {
                        dtVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.cdU.cdT;
                dt dtVar2 = (dt) baseAdapter2.getItem(i);
                if (dtVar2 != null) {
                    dtVar2.isSelected = true;
                    bVar2 = this.cdU.cdw;
                    bVar2.iA(dtVar2.bTi);
                }
            }
        }
    }
}
