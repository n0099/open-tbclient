package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.g.f;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.m;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.b {
    private float blP = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, m mVar) {
        if (fVar != null && mVar != null) {
            ArrayList<i> threadList = mVar.getThreadList();
            if (!v.E(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<i> it = threadList.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if (next.getType() == bd.aOj) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                mVar.dx(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean nh(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, k kVar, m mVar) {
        if (fVar != null && kVar != null && mVar != null) {
            fVar.aAj();
            if (mVar != null && mVar.bas() != null) {
                kVar.a(mVar.bas().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return com.baidu.tieba.frs.f.f.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void bM(View view) {
        view.setVisibility(8);
    }
}
