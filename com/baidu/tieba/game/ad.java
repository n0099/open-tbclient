package com.baidu.tieba.game;

import java.util.Comparator;
/* loaded from: classes.dex */
class ad implements Comparator<ab> {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ab abVar, ab abVar2) {
        if (abVar.m() < abVar2.m()) {
            return -1;
        }
        if (abVar.m() > abVar2.m()) {
            return 1;
        }
        return 0;
    }
}
