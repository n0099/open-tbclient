package com.baidu.tieba.enterForum.c;

import com.baidu.tieba.tbadkCore.ae;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Comparator<ae> {
    final /* synthetic */ c aDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.aDv = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ae aeVar, ae aeVar2) {
        if (aeVar == null || aeVar2 == null) {
            return 0;
        }
        return aeVar2.getLevel() - aeVar.getLevel();
    }
}
