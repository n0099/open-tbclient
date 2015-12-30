package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.frs.tab.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ m bmB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.bmB = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        i iVar;
        BaseAdapter baseAdapter;
        i.a aVar;
        List<fc> list;
        BaseAdapter baseAdapter2;
        i.a aVar2;
        i iVar2;
        iVar = this.bmB.bmz;
        if (iVar != null) {
            iVar2 = this.bmB.bmz;
            iVar2.PB();
        }
        baseAdapter = this.bmB.bmA;
        if (baseAdapter != null) {
            aVar = this.bmB.bmd;
            if (aVar != null) {
                list = this.bmB.mData;
                for (fc fcVar : list) {
                    if (fcVar != null) {
                        fcVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bmB.bmA;
                fc fcVar2 = (fc) baseAdapter2.getItem(i);
                if (fcVar2 != null) {
                    fcVar2.isSelected = true;
                    aVar2 = this.bmB.bmd;
                    aVar2.gp(fcVar2.biz);
                }
            }
        }
    }
}
