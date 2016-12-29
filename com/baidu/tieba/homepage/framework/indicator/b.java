package com.baidu.tieba.homepage.framework.indicator;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.homepage.framework.d {
    final /* synthetic */ a cnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cnD = aVar;
    }

    @Override // com.baidu.tieba.homepage.framework.d
    public void g(long j, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        if (i >= 0) {
            arrayList = this.cnD.cnv;
            if (arrayList != null) {
                arrayList2 = this.cnD.cnv;
                if (arrayList2.size() > 0) {
                    arrayList3 = this.cnD.cnv;
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.homepage.recommendfrs.data.a aVar = (com.baidu.tieba.homepage.recommendfrs.data.a) it.next();
                        if (aVar != null && aVar.ajA() != null && j == aVar.ajA().tag_code.longValue()) {
                            aVar.jF(i);
                            return;
                        }
                    }
                }
            }
        }
    }
}
