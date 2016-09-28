package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.frs.view.x;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x chT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.chT = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.w wVar;
        List list;
        com.baidu.adp.widget.ListView.w wVar2;
        view.setPressed(false);
        wVar = this.chT.chP;
        if (wVar != null && (view.getTag() instanceof x.a)) {
            x.a aVar = (x.a) view.getTag();
            list = this.chT.aSU;
            bi biVar = (bi) com.baidu.tbadk.core.util.y.c(list, aVar.position);
            if (biVar != null) {
                wVar2 = this.chT.chP;
                wVar2.a(view, biVar, BdUniqueId.gen(), null, aVar.position, 0L);
            }
        }
    }
}
