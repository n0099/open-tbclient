package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.frs.view.x;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x bUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bUL = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.w wVar;
        List list;
        com.baidu.adp.widget.ListView.w wVar2;
        view.setPressed(false);
        wVar = this.bUL.bUH;
        if (wVar != null && (view.getTag() instanceof x.a)) {
            x.a aVar = (x.a) view.getTag();
            list = this.bUL.aLB;
            az azVar = (az) com.baidu.tbadk.core.util.y.c(list, aVar.position);
            if (azVar != null) {
                wVar2 = this.bUL.bUH;
                wVar2.a(view, azVar, BdUniqueId.gen(), null, aVar.position, 0L);
            }
        }
    }
}
