package com.baidu.tieba.homepage.framework.indicator;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.homepage.framework.d {
    final /* synthetic */ a cCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cCV = aVar;
    }

    @Override // com.baidu.tieba.homepage.framework.d
    public void h(long j, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        if (i >= 0) {
            arrayList = this.cCV.cCN;
            if (arrayList != null) {
                arrayList2 = this.cCV.cCN;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.cCV.cCN;
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) it.next();
                        if (aVar != null && aVar.anf() != null && j == aVar.anf().tag_code.longValue()) {
                            aVar.ko(i);
                            return;
                        }
                    }
                }
            }
        }
    }
}
