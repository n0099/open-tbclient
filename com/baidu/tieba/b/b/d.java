package com.baidu.tieba.b.b;

import com.baidu.tieba.b.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends b.c {
    final /* synthetic */ b aYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aYL = bVar;
    }

    @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
    public boolean b(float f, float f2, float f3, int i) {
        boolean z;
        z = this.aYL.aYJ;
        return z && f % 360.0f == 0.0f;
    }

    @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
    public void d(float f, float f2, float f3, int i) {
        this.aYL.Nq();
    }
}
