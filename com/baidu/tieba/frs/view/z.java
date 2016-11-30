package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.frs.view.y;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y cna;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.cna = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.w wVar;
        List list;
        com.baidu.adp.widget.ListView.w wVar2;
        view.setPressed(false);
        wVar = this.cna.cmW;
        if (wVar != null && (view.getTag() instanceof y.a)) {
            y.a aVar = (y.a) view.getTag();
            list = this.cna.aUV;
            bk bkVar = (bk) com.baidu.tbadk.core.util.x.c(list, aVar.position);
            if (bkVar != null) {
                wVar2 = this.cna.cmW;
                wVar2.a(view, bkVar, BdUniqueId.gen(), null, aVar.position, 0L);
            }
        }
    }
}
