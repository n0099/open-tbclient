package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.vc.f;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.b {
    private float aSU = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, l lVar) {
        if (fVar != null && lVar != null) {
            ArrayList<h> threadList = lVar.getThreadList();
            if (!v.I(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<h> it = threadList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.getType() == bb.atf) {
                        arrayList.add(next);
                    }
                }
                lVar.dM(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean my(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, k kVar, l lVar) {
        if (fVar != null && kVar != null && lVar != null) {
            fVar.aHg();
            if (lVar != null && lVar.bgi() != null) {
                kVar.a(lVar.bgi().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return g.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void aM(View view) {
        view.setVisibility(8);
    }
}
