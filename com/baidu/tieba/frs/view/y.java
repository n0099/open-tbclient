package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.frs.view.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnLongClickListener {
    final /* synthetic */ w cgU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.cgU = wVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.widget.ListView.x xVar;
        List list;
        com.baidu.adp.widget.ListView.x xVar2;
        xVar = this.cgU.cgS;
        if (xVar == null || !(view.getTag() instanceof w.a)) {
            return false;
        }
        w.a aVar = (w.a) view.getTag();
        list = this.cgU.aVF;
        xVar2 = this.cgU.cgS;
        return xVar2.b(view, (bi) com.baidu.tbadk.core.util.x.c(list, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
    }
}
