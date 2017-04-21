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
    final /* synthetic */ n cbW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.cbW = nVar;
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
        jVar = this.cbW.cbU;
        if (jVar != null) {
            jVar2 = this.cbW.cbU;
            jVar2.aeu();
        }
        baseAdapter = this.cbW.cbV;
        if (baseAdapter != null) {
            bVar = this.cbW.cby;
            if (bVar != null) {
                list = this.cbW.aVF;
                for (cv cvVar : list) {
                    if (cvVar != null) {
                        cvVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.cbW.cbV;
                cv cvVar2 = (cv) baseAdapter2.getItem(i);
                if (cvVar2 != null) {
                    cvVar2.isSelected = true;
                    bVar2 = this.cbW.cby;
                    bVar2.iF(cvVar2.bSf);
                }
            }
        }
    }
}
