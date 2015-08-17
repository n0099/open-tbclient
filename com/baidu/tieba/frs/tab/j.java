package com.baidu.tieba.frs.tab;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.tab.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemClickListener {
    final /* synthetic */ i bbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bbc = iVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MorePopupWindow morePopupWindow;
        BaseAdapter baseAdapter;
        i.a aVar;
        List<h> list;
        BaseAdapter baseAdapter2;
        i.a aVar2;
        MorePopupWindow morePopupWindow2;
        morePopupWindow = this.bbc.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bbc.mPopWindow;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
        baseAdapter = this.bbc.bbb;
        if (baseAdapter != null) {
            aVar = this.bbc.baP;
            if (aVar != null) {
                list = this.bbc.mData;
                for (h hVar : list) {
                    if (hVar != null) {
                        hVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bbc.bbb;
                h hVar2 = (h) baseAdapter2.getItem(i);
                if (hVar2 != null) {
                    hVar2.isSelected = true;
                    aVar2 = this.bbc.baP;
                    aVar2.fD(hVar2.aYt);
                }
            }
        }
    }
}
