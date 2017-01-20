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
    final /* synthetic */ n bTS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bTS = nVar;
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
        jVar = this.bTS.bTQ;
        if (jVar != null) {
            jVar2 = this.bTS.bTQ;
            jVar2.acB();
        }
        baseAdapter = this.bTS.bTR;
        if (baseAdapter != null) {
            bVar = this.bTS.bTu;
            if (bVar != null) {
                list = this.bTS.aPE;
                for (ct ctVar : list) {
                    if (ctVar != null) {
                        ctVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bTS.bTR;
                ct ctVar2 = (ct) baseAdapter2.getItem(i);
                if (ctVar2 != null) {
                    ctVar2.isSelected = true;
                    bVar2 = this.bTS.bTu;
                    bVar2.iC(ctVar2.bIQ);
                }
            }
        }
    }
}
