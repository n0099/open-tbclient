package com.baidu.tieba.b.b;

import com.baidu.tieba.b.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends b.c {
    final /* synthetic */ b brd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.brd = bVar;
    }

    @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
    public boolean b(float f, float f2, float f3, int i) {
        boolean z;
        z = this.brd.brb;
        return z && f % 360.0f == 0.0f;
    }

    @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
    public void d(float f, float f2, float f3, int i) {
        this.brd.Sz();
    }
}
