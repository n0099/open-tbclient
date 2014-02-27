package com.baidu.tieba.im.coder;

import android.util.SparseBooleanArray;
import com.baidu.tieba.im.util.m;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class e {
    private static e a = null;
    private SecretKey b;
    private byte[] c;
    private SparseBooleanArray d;

    public static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    public final void a(int i) {
        this.d.put(1001, true);
    }

    private e() {
        this.b = null;
        this.c = null;
        this.d = null;
        try {
            this.d = new SparseBooleanArray();
            PublicKey a2 = m.a(com.baidu.tieba.im.f.a());
            String a3 = m.a(32);
            byte[] bArr = new byte[a3.length()];
            for (int i = 0; i < a3.length(); i++) {
                bArr[i] = (byte) a3.charAt(i);
            }
            this.b = m.a(a3);
            this.c = m.a(a2, bArr);
        } catch (Throwable th) {
            com.baidu.adp.lib.util.e.b(th.getMessage());
            this.b = null;
            this.c = new byte[0];
        }
    }

    public final byte[] b() {
        return this.c;
    }

    public final SecretKey c() {
        return this.b;
    }

    public final boolean b(int i) {
        return (this.b == null || this.d.get(i, false)) ? false : true;
    }
}
