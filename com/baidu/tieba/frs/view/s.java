package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.frs.view.q;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnLongClickListener {
    final /* synthetic */ q cdQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.cdQ = qVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        x xVar;
        List list;
        x xVar2;
        xVar = this.cdQ.cdO;
        if (xVar == null || !(view.getTag() instanceof q.a)) {
            return false;
        }
        q.a aVar = (q.a) view.getTag();
        list = this.cdQ.aWb;
        xVar2 = this.cdQ.cdO;
        return xVar2.b(view, (bk) com.baidu.tbadk.core.util.x.c(list, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
    }
}
