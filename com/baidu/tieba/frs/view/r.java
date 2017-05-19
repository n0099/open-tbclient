package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.view.q;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q cdQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cdQ = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        q.a aVar;
        List list;
        w wVar2;
        view.setPressed(false);
        wVar = this.cdQ.cdL;
        if (wVar != null && (view.getTag() instanceof q.a) && (aVar = (q.a) view.getTag()) != null) {
            list = this.cdQ.aWb;
            bk bkVar = (bk) x.c(list, aVar.position);
            if (bkVar != null) {
                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null) {
                    readThreadHistory.qh(bkVar.getId());
                    aq.i(aVar.cdT, w.e.cp_cont_c);
                }
                wVar2 = this.cdQ.cdL;
                wVar2.a(view, bkVar, BdUniqueId.gen(), null, aVar.position, 0L);
            }
        }
    }
}
