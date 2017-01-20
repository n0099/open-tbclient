package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.frs.view.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnLongClickListener {
    final /* synthetic */ w bYH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.bYH = wVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.widget.ListView.x xVar;
        List list;
        com.baidu.adp.widget.ListView.x xVar2;
        xVar = this.bYH.bYF;
        if (xVar == null || !(view.getTag() instanceof w.a)) {
            return false;
        }
        w.a aVar = (w.a) view.getTag();
        list = this.bYH.aPE;
        xVar2 = this.bYH.bYF;
        return xVar2.b(view, (bh) com.baidu.tbadk.core.util.w.c(list, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
    }
}
