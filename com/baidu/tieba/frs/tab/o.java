package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.fu;
import com.baidu.tieba.frs.tab.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ m bur;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.bur = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        i iVar;
        BaseAdapter baseAdapter;
        i.b bVar;
        List<fu> list;
        BaseAdapter baseAdapter2;
        i.b bVar2;
        i iVar2;
        iVar = this.bur.bup;
        if (iVar != null) {
            iVar2 = this.bur.bup;
            iVar2.Tt();
        }
        baseAdapter = this.bur.buq;
        if (baseAdapter != null) {
            bVar = this.bur.btT;
            if (bVar != null) {
                list = this.bur.aLU;
                for (fu fuVar : list) {
                    if (fuVar != null) {
                        fuVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bur.buq;
                fu fuVar2 = (fu) baseAdapter2.getItem(i);
                if (fuVar2 != null) {
                    fuVar2.isSelected = true;
                    bVar2 = this.bur.btT;
                    bVar2.he(fuVar2.bqM);
                }
            }
        }
    }
}
