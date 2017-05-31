package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.view.p;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p cke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.cke = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        p.a aVar;
        List list;
        x xVar2;
        view.setPressed(false);
        xVar = this.cke.cjZ;
        if (xVar != null && (view.getTag() instanceof p.a) && (aVar = (p.a) view.getTag()) != null) {
            list = this.cke.aTD;
            bl blVar = (bl) com.baidu.tbadk.core.util.x.c(list, aVar.position);
            if (blVar != null) {
                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null) {
                    readThreadHistory.qv(blVar.getId());
                    aq.i(aVar.ckh, w.e.cp_cont_c);
                }
                xVar2 = this.cke.cjZ;
                xVar2.a(view, blVar, BdUniqueId.gen(), null, aVar.position, 0L);
            }
        }
    }
}
