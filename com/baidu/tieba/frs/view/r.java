package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.view.p;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnLongClickListener {
    final /* synthetic */ p cke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.cke = pVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        y yVar;
        List list;
        y yVar2;
        yVar = this.cke.ckc;
        if (yVar == null || !(view.getTag() instanceof p.a)) {
            return false;
        }
        p.a aVar = (p.a) view.getTag();
        list = this.cke.aTD;
        yVar2 = this.cke.ckc;
        return yVar2.b(view, (bl) x.c(list, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
    }
}
