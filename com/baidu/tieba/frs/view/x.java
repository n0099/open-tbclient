package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.frs.view.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w cgd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.cgd = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.w wVar;
        List list;
        com.baidu.adp.widget.ListView.w wVar2;
        view.setPressed(false);
        wVar = this.cgd.cfY;
        if (wVar != null && (view.getTag() instanceof w.a)) {
            w.a aVar = (w.a) view.getTag();
            list = this.cgd.aVq;
            bj bjVar = (bj) com.baidu.tbadk.core.util.x.c(list, aVar.position);
            if (bjVar != null) {
                wVar2 = this.cgd.cfY;
                wVar2.a(view, bjVar, BdUniqueId.gen(), null, aVar.position, 0L);
            }
        }
    }
}
