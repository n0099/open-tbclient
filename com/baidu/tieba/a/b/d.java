package com.baidu.tieba.a.b;

import com.baidu.tieba.a.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends b.c {
    final /* synthetic */ b aMA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aMA = bVar;
    }

    @Override // com.baidu.tieba.a.a.b.c, com.baidu.tieba.a.a.a
    public boolean b(float f, float f2, float f3, int i) {
        boolean z;
        z = this.aMA.aMy;
        return z && f % 360.0f == 0.0f;
    }

    @Override // com.baidu.tieba.a.a.b.c, com.baidu.tieba.a.a.a
    public void d(float f, float f2, float f3, int i) {
        this.aMA.Jb();
    }
}
