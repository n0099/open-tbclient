package com.baidu.tbadk.coreExtra.d;

import android.util.SparseArray;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* loaded from: classes.dex */
public final class g extends com.baidu.adp.framework.c.d {
    private static g e = new g();
    private boolean a;
    private int b;
    private long c;
    private SparseArray<h> d;

    public static g d() {
        return e;
    }

    private g() {
        super(1001);
        this.b = 3;
        this.c = 300000L;
        this.d = new SparseArray<>();
        com.baidu.adp.framework.c.a().a(0, this);
    }

    public final void a(boolean z) {
        this.a = z;
    }

    public final void a(int[] iArr) {
        this.d.clear();
        if (iArr != null) {
            for (int i : iArr) {
                this.d.put(i, new h((byte) 0));
            }
        }
    }

    public final void b(int i) {
        this.b = i;
    }

    public final void a(long j) {
        this.c = j;
    }

    @Override // com.baidu.adp.framework.c.d
    public final void a(com.baidu.adp.framework.message.f<?> fVar) {
        if ((fVar instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) fVar).e() == 0) {
            for (int i = 0; i < this.d.size(); i++) {
                h hVar = this.d.get(i);
                hVar.a = 0;
                if (hVar.b) {
                    hVar.b = false;
                    hVar.c = 0L;
                }
            }
        }
    }
}
