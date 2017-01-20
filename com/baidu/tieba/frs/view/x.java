package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.frs.view.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w bYH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bYH = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.w wVar;
        List list;
        com.baidu.adp.widget.ListView.w wVar2;
        view.setPressed(false);
        wVar = this.bYH.bYC;
        if (wVar != null && (view.getTag() instanceof w.a)) {
            w.a aVar = (w.a) view.getTag();
            list = this.bYH.aPE;
            bh bhVar = (bh) com.baidu.tbadk.core.util.w.c(list, aVar.position);
            if (bhVar != null) {
                wVar2 = this.bYH.bYC;
                wVar2.a(view, bhVar, BdUniqueId.gen(), null, aVar.position, 0L);
            }
        }
    }
}
