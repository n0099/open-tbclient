package com.baidu.tbadk.performanceLog;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Thread {
    private boolean aoy = false;
    final /* synthetic */ f aoz;
    private InputStream in;

    public g(f fVar, InputStream inputStream) {
        this.aoz = fVar;
        this.in = inputStream;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int read;
        byte[] bArr = new byte[8192];
        while (!this.aoy && (read = this.in.read(bArr)) != -1) {
            try {
                String str = new String(bArr, 0, read);
                if (str != null) {
                    this.aoz.eB(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public synchronized void finish() {
        this.aoy = true;
    }
}
