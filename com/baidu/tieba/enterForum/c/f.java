package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.tbadkCore.v;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Comparator<v> {
    final /* synthetic */ c bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bbT = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(v vVar, v vVar2) {
        if (vVar == null || vVar2 == null) {
            return 0;
        }
        return vVar2.getLevel() - vVar.getLevel();
    }
}
