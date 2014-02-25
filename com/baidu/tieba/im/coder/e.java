package com.baidu.tieba.im.coder;

import android.util.SparseBooleanArray;
import com.baidu.tieba.im.util.n;
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

    public void a(int i) {
        this.d.put(i, true);
    }

    private e() {
        this.b = null;
        this.c = null;
        this.d = null;
        try {
            this.d = new SparseBooleanArray();
            PublicKey a2 = n.a(com.baidu.tieba.im.g.a());
            String a3 = n.a(32);
            byte[] bArr = new byte[a3.length()];
            for (int i = 0; i < a3.length(); i++) {
                bArr[i] = (byte) a3.charAt(i);
            }
            this.b = n.a(a3);
            this.c = n.a(a2, bArr);
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b(th.getMessage());
            this.b = null;
            this.c = new byte[0];
        }
    }

    public byte[] b() {
        return this.c;
    }

    public SecretKey c() {
        return this.b;
    }

    public boolean b(int i) {
        return (this.b == null || this.d.get(i, false)) ? false : true;
    }
}
