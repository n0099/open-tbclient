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
    final /* synthetic */ m biK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.biK = mVar;
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
        iVar = this.biK.biI;
        if (iVar != null) {
            iVar2 = this.biK.biI;
            iVar2.Pj();
        }
        baseAdapter = this.biK.biJ;
        if (baseAdapter != null) {
            aVar = this.biK.bin;
            if (aVar != null) {
                list = this.biK.mData;
                for (fc fcVar : list) {
                    if (fcVar != null) {
                        fcVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.biK.biJ;
                fc fcVar2 = (fc) baseAdapter2.getItem(i);
                if (fcVar2 != null) {
                    fcVar2.isSelected = true;
                    aVar2 = this.biK.bin;
                    aVar2.gw(fcVar2.beF);
                }
            }
        }
    }
}
