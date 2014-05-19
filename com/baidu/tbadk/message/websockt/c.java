package com.baidu.tbadk.message.websockt;

import android.util.SparseBooleanArray;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.c.d;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class c {
    private static c a = null;
    private SecretKey b;
    private byte[] c;
    private SparseBooleanArray d;

    public static byte[] a() {
        return com.baidu.adp.lib.webSocket.a.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwQpwBZxXJV/JVRF/uNfyMSdu7YWwRNLM8+2xbniGp2iIQHOikPpTYQjlQgMi1uvq1kZpJ32rHo3hkwjy2l0lFwr3u4Hk2Wk7vnsqYQjAlYlK0TCzjpmiI+OiPOUNVtbWHQiLiVqFtzvpvi4AU7C1iKGvc/4IS45WjHxeScHhnZZ7njS4S1UgNP/GflRIbzgbBhyZ9kEW5/OO5YfG1fy6r4KSlDJw4o/mw5XhftyIpL+5ZBVBC6E1EIiP/dd9AbK62VV1PByfPMHMixpxI3GM2qwcmFsXcCcgvUXJBa9k6zP8dDQ3csCM2QNT+CQAOxthjtp/TFWaD7MzOdsIYb3THwIDAQAB");
    }

    public static c b() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public void a(int i) {
        this.d.put(i, true);
    }

    private c() {
        this.b = null;
        this.c = null;
        this.d = null;
        try {
            this.d = new SparseBooleanArray();
            PublicKey a2 = d.a(a());
            String a3 = d.a(32);
            byte[] bArr = new byte[a3.length()];
            for (int i = 0; i < a3.length(); i++) {
                bArr[i] = (byte) a3.charAt(i);
            }
            this.b = d.a(a3);
            this.c = d.a(a2, bArr);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.b = null;
            this.c = new byte[0];
        }
    }

    public byte[] c() {
        return this.c;
    }

    public SecretKey d() {
        return this.b;
    }

    public boolean b(int i) {
        return (this.b == null || this.d.get(i, false)) ? false : true;
    }
}
