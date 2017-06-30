package com.baidu.tieba.homepage.personalize.model;

import com.baidu.tieba.card.data.r;
import java.util.Comparator;
/* loaded from: classes.dex */
class b implements Comparator<r> {
    final /* synthetic */ a cKR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cKR = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(r rVar, r rVar2) {
        if (rVar == null || rVar2 == null) {
            return 0;
        }
        if (rVar.getPosition() > rVar2.getPosition()) {
            return 1;
        }
        return rVar.getPosition() < rVar2.getPosition() ? -1 : 0;
    }
}
