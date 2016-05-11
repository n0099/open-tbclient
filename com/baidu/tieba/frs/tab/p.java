package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.ft;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ n btn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.btn = nVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        BaseAdapter baseAdapter;
        j.b bVar;
        List<ft> list;
        BaseAdapter baseAdapter2;
        j.b bVar2;
        j jVar2;
        jVar = this.btn.btl;
        if (jVar != null) {
            jVar2 = this.btn.btl;
            jVar2.Tx();
        }
        baseAdapter = this.btn.btm;
        if (baseAdapter != null) {
            bVar = this.btn.bsQ;
            if (bVar != null) {
                list = this.btn.aIe;
                for (ft ftVar : list) {
                    if (ftVar != null) {
                        ftVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.btn.btm;
                ft ftVar2 = (ft) baseAdapter2.getItem(i);
                if (ftVar2 != null) {
                    ftVar2.isSelected = true;
                    bVar2 = this.btn.bsQ;
                    bVar2.gN(ftVar2.blZ);
                }
            }
        }
    }
}
