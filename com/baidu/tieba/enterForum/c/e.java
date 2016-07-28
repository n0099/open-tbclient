package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.tbadkCore.x;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Comparator<x> {
    final /* synthetic */ c bwk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bwk = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(x xVar, x xVar2) {
        if (xVar == null || xVar2 == null) {
            return 0;
        }
        return xVar2.getLevel() - xVar.getLevel();
    }
}
