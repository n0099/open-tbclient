package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements g.a {
    final /* synthetic */ d bqg;
    private final /* synthetic */ h bqh;
    private final /* synthetic */ int bqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, h hVar, int i) {
        this.bqg = dVar;
        this.bqh = hVar;
        this.bqi = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void cD(boolean z) {
        d.a aVar;
        d.a aVar2;
        if (z) {
            this.bqh.setVisibility(8);
            this.bqh.setClickable(false);
            return;
        }
        this.bqh.setVisibility(0);
        this.bqh.setClickable(true);
        aVar = this.bqg.bqf;
        if (aVar != null) {
            aVar2 = this.bqg.bqf;
            aVar2.k(this.bqi, true);
        }
    }
}
