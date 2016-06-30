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
    final /* synthetic */ n bQR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bQR = nVar;
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
        jVar = this.bQR.bQP;
        if (jVar != null) {
            jVar2 = this.bQR.bQP;
            jVar2.ZO();
        }
        baseAdapter = this.bQR.bQQ;
        if (baseAdapter != null) {
            bVar = this.bQR.bQu;
            if (bVar != null) {
                list = this.bQR.aLB;
                for (dy dyVar : list) {
                    if (dyVar != null) {
                        dyVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bQR.bQQ;
                dy dyVar2 = (dy) baseAdapter2.getItem(i);
                if (dyVar2 != null) {
                    dyVar2.isSelected = true;
                    bVar2 = this.bQR.bQu;
                    bVar2.hR(dyVar2.bGN);
                }
            }
        }
    }
}
