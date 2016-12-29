package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.frs.view.y;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnLongClickListener {
    final /* synthetic */ y bSk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.bSk = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.widget.ListView.x xVar;
        List list;
        com.baidu.adp.widget.ListView.x xVar2;
        xVar = this.bSk.bSi;
        if (xVar == null || !(view.getTag() instanceof y.a)) {
            return false;
        }
        y.a aVar = (y.a) view.getTag();
        list = this.bSk.aUm;
        xVar2 = this.bSk.bSi;
        return xVar2.b(view, (bg) com.baidu.tbadk.core.util.x.c(list, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
    }
}
