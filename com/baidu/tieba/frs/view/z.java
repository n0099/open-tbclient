package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.frs.view.x;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnLongClickListener {
    final /* synthetic */ x chT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.chT = xVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.widget.ListView.x xVar;
        List list;
        com.baidu.adp.widget.ListView.x xVar2;
        xVar = this.chT.chR;
        if (xVar == null || !(view.getTag() instanceof x.a)) {
            return false;
        }
        x.a aVar = (x.a) view.getTag();
        list = this.chT.aSU;
        xVar2 = this.chT.chR;
        return xVar2.b(view, (bi) com.baidu.tbadk.core.util.y.c(list, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
    }
}
