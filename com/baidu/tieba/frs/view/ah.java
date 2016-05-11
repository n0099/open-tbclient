package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.frs.view.af;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnLongClickListener {
    final /* synthetic */ af bxg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.bxg = afVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.widget.ListView.x xVar;
        List list;
        com.baidu.adp.widget.ListView.x xVar2;
        xVar = this.bxg.bxe;
        if (xVar == null || !(view.getTag() instanceof af.a)) {
            return false;
        }
        af.a aVar = (af.a) view.getTag();
        list = this.bxg.aIe;
        xVar2 = this.bxg.bxe;
        return xVar2.b(view, (ax) com.baidu.tbadk.core.util.y.c(list, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
    }
}
