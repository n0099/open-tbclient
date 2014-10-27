package com.baidu.tbadk.widget;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {
    final /* synthetic */ a aaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aaq = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063 A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:3:0x0001, B:14:0x003d, B:16:0x0047, B:27:0x0090, B:19:0x0057, B:21:0x0063, B:22:0x0068, B:24:0x007e, B:26:0x008a, B:18:0x0051, B:8:0x002a, B:13:0x0037, B:4:0x0011), top: B:29:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:3:0x0001, B:14:0x003d, B:16:0x0047, B:27:0x0090, B:19:0x0057, B:21:0x0063, B:22:0x0068, B:24:0x007e, B:26:0x008a, B:18:0x0051, B:8:0x002a, B:13:0x0037, B:4:0x0011), top: B:29:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        g gVar;
        byte[] bArr;
        g gVar2;
        g gVar3;
        boolean z;
        g gVar4;
        g gVar5;
        try {
            a aVar = this.aaq;
            i = this.aaq.NX;
            aVar.aaf = new g(i);
            try {
                try {
                    gVar = this.aaq.aaf;
                    bArr = this.aaq.ZU;
                    if (gVar.d(new ByteArrayInputStream(bArr)) == 0) {
                        gVar2 = this.aaq.aaf;
                        if (gVar2.width != 0) {
                            gVar5 = this.aaq.aaf;
                            if (gVar5.height != 0) {
                                this.aaq.aae = 1;
                                gVar3 = this.aaq.aaf;
                                if (!gVar3.dk()) {
                                    this.aaq.postInvalidate();
                                }
                                this.aaq.time = System.currentTimeMillis();
                                this.aaq.aad = 2;
                                z = this.aaq.aai;
                                if (!z) {
                                    gVar4 = this.aaq.aaf;
                                    if (!gVar4.isInterrupted()) {
                                        this.aaq.postInvalidate();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        this.aaq.aae = 0;
                        gVar3 = this.aaq.aaf;
                        if (!gVar3.dk()) {
                        }
                        this.aaq.time = System.currentTimeMillis();
                        this.aaq.aad = 2;
                        z = this.aaq.aai;
                        if (!z) {
                        }
                    }
                } catch (OutOfMemoryError e) {
                    this.aaq.vf();
                }
            } catch (Exception e2) {
                this.aaq.vf();
            }
        } catch (Exception e3) {
            this.aaq.aad = 0;
        }
    }
}
