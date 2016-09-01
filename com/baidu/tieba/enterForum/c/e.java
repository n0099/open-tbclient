package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.tbadkCore.w;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Comparator<w> {
    final /* synthetic */ c bHy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bHy = cVar;
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
