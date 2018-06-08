package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.vc.f;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.b {
    private float aFY = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, l lVar) {
        if (fVar != null && lVar != null) {
            ArrayList<h> threadList = lVar.getThreadList();
            if (!w.z(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<h> it = threadList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.getType() == bd.ahI) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                lVar.dv(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean kz(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, i iVar, l lVar) {
        if (fVar != null && iVar != null && lVar != null) {
            fVar.azn();
            if (lVar != null && lVar.bam() != null) {
                iVar.a(lVar.bam().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return g.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void ar(View view) {
        view.setVisibility(8);
    }
}
