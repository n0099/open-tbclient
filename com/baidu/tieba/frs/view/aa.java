package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.frs.view.y;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnLongClickListener {
    final /* synthetic */ y cna;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.cna = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.widget.ListView.x xVar;
        List list;
        com.baidu.adp.widget.ListView.x xVar2;
        xVar = this.cna.cmY;
        if (xVar == null || !(view.getTag() instanceof y.a)) {
            return false;
        }
        y.a aVar = (y.a) view.getTag();
        list = this.cna.aUV;
        xVar2 = this.cna.cmY;
        return xVar2.b(view, (bk) com.baidu.tbadk.core.util.x.c(list, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
    }
}
