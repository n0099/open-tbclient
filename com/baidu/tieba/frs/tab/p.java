package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ n cbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.cbe = nVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        BaseAdapter baseAdapter;
        j.b bVar;
        List<ct> list;
        BaseAdapter baseAdapter2;
        j.b bVar2;
        j jVar2;
        jVar = this.cbe.cbc;
        if (jVar != null) {
            jVar2 = this.cbe.cbc;
            jVar2.adz();
        }
        baseAdapter = this.cbe.cbd;
        if (baseAdapter != null) {
            bVar = this.cbe.caG;
            if (bVar != null) {
                list = this.cbe.aVq;
                for (ct ctVar : list) {
                    if (ctVar != null) {
                        ctVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.cbe.cbd;
                ct ctVar2 = (ct) baseAdapter2.getItem(i);
                if (ctVar2 != null) {
                    ctVar2.isSelected = true;
                    bVar2 = this.cbe.caG;
                    bVar2.iy(ctVar2.bPZ);
                }
            }
        }
    }
}
