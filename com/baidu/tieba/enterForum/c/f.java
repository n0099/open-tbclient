package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.tbadkCore.u;
import java.util.Comparator;
/* loaded from: classes.dex */
class f implements Comparator<u> {
    final /* synthetic */ c aMX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.aMX = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(u uVar, u uVar2) {
        if (uVar == null || uVar2 == null) {
            return 0;
        }
        return uVar2.getLevel() - uVar.getLevel();
    }
}
