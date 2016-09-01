package com.baidu.tieba.homepage.framework.indicator;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.homepage.framework.d {
    final /* synthetic */ a cCq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cCq = aVar;
    }

    @Override // com.baidu.tieba.homepage.framework.d
    public void h(long j, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        if (i >= 0) {
            arrayList = this.cCq.cCi;
            if (arrayList != null) {
                arrayList2 = this.cCq.cCi;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.cCq.cCi;
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) it.next();
                        if (aVar != null && aVar.amR() != null && j == aVar.amR().tag_code.longValue()) {
                            aVar.ki(i);
                            return;
                        }
                    }
                }
            }
        }
    }
}
