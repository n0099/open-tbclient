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
    final /* synthetic */ n chV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.chV = nVar;
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
        jVar = this.chV.chT;
        if (jVar != null) {
            jVar2 = this.chV.chT;
            jVar2.agZ();
        }
        baseAdapter = this.chV.chU;
        if (baseAdapter != null) {
            bVar = this.chV.chx;
            if (bVar != null) {
                list = this.chV.aUV;
                for (cx cxVar : list) {
                    if (cxVar != null) {
                        cxVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.chV.chU;
                cx cxVar2 = (cx) baseAdapter2.getItem(i);
                if (cxVar2 != null) {
                    cxVar2.isSelected = true;
                    bVar2 = this.chV.chx;
                    bVar2.iF(cxVar2.bVo);
                }
            }
        }
    }
}
