package com.baidu.tieba.im.b;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.exception.IMCodecException;
import com.baidu.tieba.im.exception.IMException;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.util.ae;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class c {
    private static c b = new c();

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, b> f1518a = new HashMap<>();
    private SecretKey c;

    public boolean a() {
        return this.c != null;
    }

    public void a(SecretKey secretKey) {
        this.c = secretKey;
    }

    public static c b() {
        return b;
    }

    private c() {
        c();
    }

    protected void c() {
        this.f1518a.put(1, new com.baidu.tieba.im.b.a.b());
    }

    public byte[] a(Message message, int i, int i2, boolean z) {
        byte[] bArr;
        int i3;
        byte[] a2;
        if (message.getCmd() == 1001) {
            z = false;
        }
        byte[] a3 = a(1, message);
        if (i2 == 2) {
            try {
                bArr = b(a3, 0, a3.length);
                i3 = i2;
            } catch (Exception e) {
                bArr = a3;
                i3 = 1;
            }
        } else {
            bArr = a3;
            i3 = i2;
        }
        boolean z2 = this.c != null ? z : false;
        if (z2) {
            try {
                a2 = com.baidu.tieba.im.e.e.a(this.c, bArr);
            } catch (Exception e2) {
                throw new IMCodecException(com.baidu.tieba.im.k.j, message, e2);
            }
        } else {
            a2 = bArr;
        }
        return o.a(1, z2 ? 2 : 1, i3, message.getCmd(), i, a2);
    }

    private byte[] a(int i, Message message) {
        if (message == null) {
            throw new IMCodecException(com.baidu.tieba.im.k.b, null);
        }
        b bVar = this.f1518a.get(Integer.valueOf(i));
        if (bVar == null) {
            throw new IMCodecException(com.baidu.tieba.im.k.c, message);
        }
        if (message.getCmd() == 0 && TiebaApplication.h().b()) {
            throw new IMCodecException(com.baidu.tieba.im.k.b, message);
        }
        try {
            return bVar.a(message);
        } catch (Exception e) {
            throw new IMCodecException(com.baidu.tieba.im.k.d, message, e);
        }
    }

    protected byte[] a(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ae.b(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.tieba.util.o.a((OutputStream) byteArrayOutputStream);
            com.baidu.tieba.util.o.a((InputStream) byteArrayInputStream);
        }
    }

    protected byte[] b(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ae.a(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.tieba.util.o.a((OutputStream) byteArrayOutputStream);
            com.baidu.tieba.util.o.a((InputStream) byteArrayInputStream);
        }
    }

    public p a(p pVar) {
        if (pVar == null || pVar.f1524a == null || pVar.b == null) {
            throw new IMException(com.baidu.tieba.im.k.b);
        }
        o oVar = pVar.f1524a;
        if (oVar.e() == 2) {
            if (this.c == null) {
                throw new IMException(com.baidu.tieba.im.k.i);
            }
            try {
                pVar.b = com.baidu.tieba.im.e.e.a(this.c, pVar.b, pVar.c, pVar.d);
                pVar.c = 0;
                pVar.d = pVar.b.length;
            } catch (Exception e) {
                throw new IMException(com.baidu.tieba.im.k.k);
            }
        } else if (oVar.e() != 1) {
            throw new IMException(com.baidu.tieba.im.k.b);
        }
        if (oVar.c() == 2) {
            try {
                pVar.b = a(pVar.b, pVar.c, pVar.d);
                pVar.c = 0;
                pVar.d = pVar.b.length;
            } catch (Exception e2) {
                throw new IMException(com.baidu.tieba.im.k.h, e2);
            }
        }
        return pVar;
    }

    public p a(byte[] bArr) {
        int a2 = o.a();
        if (bArr == null || bArr.length < a2) {
            throw new IMException(com.baidu.tieba.im.k.b);
        }
        o a3 = o.a(bArr);
        if (a3 == null) {
            throw new IMException(com.baidu.tieba.im.k.b);
        }
        p pVar = new p();
        pVar.f1524a = a3;
        pVar.b = bArr;
        pVar.c = a2;
        pVar.d = bArr.length - a2;
        return pVar;
    }

    public List<Message> a(int i, boolean z, byte[] bArr, int i2, int i3) {
        b bVar = this.f1518a.get(Integer.valueOf(i));
        if (bVar == null) {
            throw new IMException(com.baidu.tieba.im.k.c);
        }
        try {
            return bVar.a(bArr, z, i2, i3);
        } catch (Exception e) {
            throw new IMException(com.baidu.tieba.im.k.e, e);
        }
    }

    public void a(int i, int i2, n<?> nVar) {
        b bVar = this.f1518a.get(Integer.valueOf(i2));
        if (bVar != null) {
            bVar.a(i, nVar);
        } else if (TiebaApplication.h().b()) {
            throw new RuntimeException("unknown packtype:" + i2);
        }
    }
}
