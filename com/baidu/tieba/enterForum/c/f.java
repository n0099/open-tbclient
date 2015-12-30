package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.tbadkCore.w;
import java.util.Comparator;
/* loaded from: classes.dex */
class f implements Comparator<w> {
    final /* synthetic */ c aUY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.aUY = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(w wVar, w wVar2) {
        if (wVar == null || wVar2 == null) {
            return 0;
        }
        return wVar2.getLevel() - wVar.getLevel();
    }
}
