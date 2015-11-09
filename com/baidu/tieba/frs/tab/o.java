package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tieba.frs.ek;
import com.baidu.tieba.frs.tab.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ m bcf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.bcf = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        i iVar;
        BaseAdapter baseAdapter;
        i.a aVar;
        List<ek> list;
        BaseAdapter baseAdapter2;
        i.a aVar2;
        i iVar2;
        iVar = this.bcf.bcd;
        if (iVar != null) {
            iVar2 = this.bcf.bcd;
            iVar2.ND();
        }
        baseAdapter = this.bcf.bce;
        if (baseAdapter != null) {
            aVar = this.bcf.bbI;
            if (aVar != null) {
                list = this.bcf.mData;
                for (ek ekVar : list) {
                    if (ekVar != null) {
                        ekVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bcf.bce;
                ek ekVar2 = (ek) baseAdapter2.getItem(i);
                if (ekVar2 != null) {
                    ekVar2.isSelected = true;
                    aVar2 = this.bcf.bbI;
                    aVar2.ga(ekVar2.aYG);
                }
            }
        }
    }
}
