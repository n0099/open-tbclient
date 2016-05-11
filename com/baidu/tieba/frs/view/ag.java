package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.frs.view.af;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ af bxg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.bxg = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.w wVar;
        List list;
        com.baidu.adp.widget.ListView.w wVar2;
        view.setPressed(false);
        wVar = this.bxg.bxb;
        if (wVar != null && (view.getTag() instanceof af.a)) {
            af.a aVar = (af.a) view.getTag();
            list = this.bxg.aIe;
            ax axVar = (ax) com.baidu.tbadk.core.util.y.c(list, aVar.position);
            if (axVar != null) {
                wVar2 = this.bxg.bxb;
                wVar2.a(view, axVar, BdUniqueId.gen(), null, aVar.position, 0L);
            }
        }
    }
}
