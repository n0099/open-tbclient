package com.baidu.tieba.game;

import java.util.Comparator;
/* loaded from: classes.dex */
class af implements Comparator<com.baidu.tbadk.game.b> {
    final /* synthetic */ ae a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.a = aeVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(com.baidu.tbadk.game.b bVar, com.baidu.tbadk.game.b bVar2) {
        if (bVar.m() < bVar2.m()) {
            return -1;
        }
        if (bVar.m() > bVar2.m()) {
            return 1;
        }
        return 0;
    }
}
