package com.baidu.tbadk.widget;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends Thread {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063 A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:3:0x0001, B:14:0x003d, B:16:0x0047, B:27:0x0090, B:19:0x0057, B:21:0x0063, B:22:0x0068, B:24:0x007e, B:26:0x008a, B:18:0x0051, B:8:0x002a, B:13:0x0037, B:4:0x0011), top: B:29:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:3:0x0001, B:14:0x003d, B:16:0x0047, B:27:0x0090, B:19:0x0057, B:21:0x0063, B:22:0x0068, B:24:0x007e, B:26:0x008a, B:18:0x0051, B:8:0x002a, B:13:0x0037, B:4:0x0011), top: B:29:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int i;
        h hVar;
        byte[] bArr;
        h hVar2;
        h hVar3;
        boolean z;
        h hVar4;
        h hVar5;
        try {
            a aVar = this.a;
            i = this.a.n;
            aVar.C = new h(i);
            try {
                try {
                    hVar = this.a.C;
                    bArr = this.a.m;
                    if (hVar.a(new ByteArrayInputStream(bArr)) == 0) {
                        hVar2 = this.a.C;
                        if (hVar2.c != 0) {
                            hVar5 = this.a.C;
                            if (hVar5.d != 0) {
                                this.a.B = 1;
                                hVar3 = this.a.C;
                                if (!hVar3.c()) {
                                    this.a.postInvalidate();
                                }
                                this.a.F = System.currentTimeMillis();
                                this.a.a = 2;
                                z = this.a.H;
                                if (!z) {
                                    hVar4 = this.a.C;
                                    if (!hVar4.a()) {
                                        this.a.postInvalidate();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        this.a.B = 0;
                        hVar3 = this.a.C;
                        if (!hVar3.c()) {
                        }
                        this.a.F = System.currentTimeMillis();
                        this.a.a = 2;
                        z = this.a.H;
                        if (!z) {
                        }
                    }
                } catch (OutOfMemoryError e) {
                    this.a.c();
                }
            } catch (Exception e2) {
                this.a.c();
            }
        } catch (Exception e3) {
            this.a.a = 0;
        }
    }
}
