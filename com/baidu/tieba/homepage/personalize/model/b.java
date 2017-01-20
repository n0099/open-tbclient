package com.baidu.tieba.homepage.personalize.model;

import com.baidu.tieba.card.data.t;
import java.util.Comparator;
/* loaded from: classes.dex */
class b implements Comparator<t> {
    final /* synthetic */ a czi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.czi = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(t tVar, t tVar2) {
        if (tVar == null || tVar2 == null) {
            return 0;
        }
        if (tVar.getPosition() > tVar2.getPosition()) {
            return 1;
        }
        return tVar.getPosition() < tVar2.getPosition() ? -1 : 0;
    }
}
