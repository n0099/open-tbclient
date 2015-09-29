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
    final /* synthetic */ i bbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bbq = iVar;
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
        morePopupWindow = this.bbq.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bbq.mPopWindow;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
        baseAdapter = this.bbq.bbp;
        if (baseAdapter != null) {
            aVar = this.bbq.bbc;
            if (aVar != null) {
                list = this.bbq.mData;
                for (h hVar : list) {
                    if (hVar != null) {
                        hVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bbq.bbp;
                h hVar2 = (h) baseAdapter2.getItem(i);
                if (hVar2 != null) {
                    hVar2.isSelected = true;
                    aVar2 = this.bbq.bbc;
                    aVar2.fR(hVar2.bbm);
                }
            }
        }
    }
}
