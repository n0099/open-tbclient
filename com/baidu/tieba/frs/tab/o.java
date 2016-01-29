package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.fm;
import com.baidu.tieba.frs.tab.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ m bpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.bpq = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        i iVar;
        BaseAdapter baseAdapter;
        i.a aVar;
        List<fm> list;
        BaseAdapter baseAdapter2;
        i.a aVar2;
        i iVar2;
        iVar = this.bpq.bpn;
        if (iVar != null) {
            iVar2 = this.bpq.bpn;
            iVar2.RF();
        }
        baseAdapter = this.bpq.bpo;
        if (baseAdapter != null) {
            aVar = this.bpq.boS;
            if (aVar != null) {
                list = this.bpq.aIY;
                for (fm fmVar : list) {
                    if (fmVar != null) {
                        fmVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bpq.bpo;
                fm fmVar2 = (fm) baseAdapter2.getItem(i);
                if (fmVar2 != null) {
                    fmVar2.isSelected = true;
                    aVar2 = this.bpq.boS;
                    aVar2.gM(fmVar2.blu);
                }
            }
        }
    }
}
