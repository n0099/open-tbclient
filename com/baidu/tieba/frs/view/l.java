package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.frs.view.k;
import com.baidu.tieba.tbadkCore.util.r;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k crV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.crV = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        k.a aVar;
        List list;
        x xVar2;
        view.setPressed(false);
        xVar = this.crV.crQ;
        if (xVar != null && (view.getTag() instanceof k.a) && (aVar = (k.a) view.getTag()) != null) {
            list = this.crV.aUW;
            bm bmVar = (bm) z.c(list, aVar.position);
            if (bmVar != null) {
                r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                if (readThreadHistory != null) {
                    readThreadHistory.rt(bmVar.getId());
                    as.i(aVar.crY, w.e.cp_cont_c);
                }
                xVar2 = this.crV.crQ;
                xVar2.a(view, bmVar, BdUniqueId.gen(), null, aVar.position, 0L);
            }
        }
    }
}
