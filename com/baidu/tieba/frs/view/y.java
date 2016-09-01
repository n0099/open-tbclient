package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.frs.view.x;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x chV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.chV = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.w wVar;
        List list;
        com.baidu.adp.widget.ListView.w wVar2;
        view.setPressed(false);
        wVar = this.chV.chR;
        if (wVar != null && (view.getTag() instanceof x.a)) {
            x.a aVar = (x.a) view.getTag();
            list = this.chV.aRP;
            bg bgVar = (bg) com.baidu.tbadk.core.util.y.c(list, aVar.position);
            if (bgVar != null) {
                wVar2 = this.chV.chR;
                wVar2.a(view, bgVar, BdUniqueId.gen(), null, aVar.position, 0L);
            }
        }
    }
}
