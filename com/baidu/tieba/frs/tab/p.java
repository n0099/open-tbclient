package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ n bZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bZF = nVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        BaseAdapter baseAdapter;
        j.b bVar;
        List<cv> list;
        BaseAdapter baseAdapter2;
        j.b bVar2;
        j jVar2;
        jVar = this.bZF.bZD;
        if (jVar != null) {
            jVar2 = this.bZF.bZD;
            jVar2.adt();
        }
        baseAdapter = this.bZF.bZE;
        if (baseAdapter != null) {
            bVar = this.bZF.bZh;
            if (bVar != null) {
                list = this.bZF.aVD;
                for (cv cvVar : list) {
                    if (cvVar != null) {
                        cvVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bZF.bZE;
                cv cvVar2 = (cv) baseAdapter2.getItem(i);
                if (cvVar2 != null) {
                    cvVar2.isSelected = true;
                    bVar2 = this.bZF.bZh;
                    bVar2.iz(cvVar2.bPO);
                }
            }
        }
    }
}
