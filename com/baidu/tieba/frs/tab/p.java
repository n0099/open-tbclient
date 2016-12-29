package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ n bNE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bNE = nVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        BaseAdapter baseAdapter;
        j.b bVar;
        List<cx> list;
        BaseAdapter baseAdapter2;
        j.b bVar2;
        j jVar2;
        jVar = this.bNE.bNC;
        if (jVar != null) {
            jVar2 = this.bNE.bNC;
            jVar2.abu();
        }
        baseAdapter = this.bNE.bND;
        if (baseAdapter != null) {
            bVar = this.bNE.bNg;
            if (bVar != null) {
                list = this.bNE.aUm;
                for (cx cxVar : list) {
                    if (cxVar != null) {
                        cxVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bNE.bND;
                cx cxVar2 = (cx) baseAdapter2.getItem(i);
                if (cxVar2 != null) {
                    cxVar2.isSelected = true;
                    bVar2 = this.bNE.bNg;
                    bVar2.hP(cxVar2.bBw);
                }
            }
        }
    }
}
