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
    final /* synthetic */ i bbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bbw = iVar;
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
        morePopupWindow = this.bbw.mPopWindow;
        if (morePopupWindow != null) {
            morePopupWindow2 = this.bbw.mPopWindow;
            com.baidu.adp.lib.g.j.a(morePopupWindow2);
        }
        baseAdapter = this.bbw.bbv;
        if (baseAdapter != null) {
            aVar = this.bbw.bbj;
            if (aVar != null) {
                list = this.bbw.mData;
                for (h hVar : list) {
                    if (hVar != null) {
                        hVar.isSelected = false;
                    }
                }
                baseAdapter2 = this.bbw.bbv;
                h hVar2 = (h) baseAdapter2.getItem(i);
                if (hVar2 != null) {
                    hVar2.isSelected = true;
                    aVar2 = this.bbw.bbj;
                    aVar2.fM(hVar2.aYK);
                }
            }
        }
    }
}
