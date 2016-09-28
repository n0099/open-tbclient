package com.baidu.tieba.homepage.personalize.c;

import com.baidu.tieba.card.data.s;
import java.util.Comparator;
/* loaded from: classes.dex */
class b implements Comparator<s> {
    final /* synthetic */ a cHK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cHK = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return 0;
        }
        if (sVar.getPosition() > sVar2.getPosition()) {
            return 1;
        }
        return sVar.getPosition() < sVar2.getPosition() ? -1 : 0;
    }
}
