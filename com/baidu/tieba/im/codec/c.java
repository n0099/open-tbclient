package com.baidu.tieba.im.codec;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.exception.IMCodecException;
import com.baidu.tieba.im.exception.IMException;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.util.ah;
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
    private HashMap<Integer, b> f1569a = new HashMap<>();
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
        this.f1569a.put(1, new com.baidu.tieba.im.codec.a.b());
    }

    public byte[] a(NetworkMessage networkMessage, int i, boolean z) {
        if (networkMessage.getCmd() == 1001) {
            z = false;
        }
        byte[] a2 = a(1, networkMessage);
        if (i == 2) {
            try {
                a2 = b(a2, 0, a2.length);
            } catch (Exception e) {
                i = 1;
            }
        }
        boolean z2 = this.c != null ? z : false;
        if (z2) {
            try {
                a2 = com.baidu.tieba.im.d.d.a(this.c, a2);
            } catch (Exception e2) {
                throw new IMCodecException(com.baidu.tieba.im.k.j, networkMessage.getData(), e2);
            }
        }
        return o.a(1, z2 ? 2 : 1, i, networkMessage.getCmd(), a2);
    }

    private byte[] a(int i, NetworkMessage networkMessage) {
        if (networkMessage == null) {
            throw new IMCodecException(com.baidu.tieba.im.k.b, null);
        }
        b bVar = this.f1569a.get(Integer.valueOf(i));
        if (bVar == null) {
            throw new IMCodecException(com.baidu.tieba.im.k.c, networkMessage.getData());
        }
        if (networkMessage.getCmd() == 0 && TiebaApplication.g().b()) {
            throw new IMCodecException(com.baidu.tieba.im.k.b, networkMessage.getData());
        }
        try {
            return bVar.a(networkMessage);
        } catch (Exception e) {
            throw new IMCodecException(com.baidu.tieba.im.k.d, networkMessage.getData(), e);
        }
    }

    protected byte[] a(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ah.b(byteArrayInputStream, byteArrayOutputStream);
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
            ah.a(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            com.baidu.tieba.util.o.a((OutputStream) byteArrayOutputStream);
            com.baidu.tieba.util.o.a((InputStream) byteArrayInputStream);
        }
    }

    public p a(byte[] bArr) {
        int i = 0;
        int a2 = o.a();
        if (bArr == null || bArr.length < a2) {
            throw new IMException(com.baidu.tieba.im.k.b);
        }
        o a3 = o.a(bArr);
        if (a3 == null) {
            throw new IMException(com.baidu.tieba.im.k.b);
        }
        int length = bArr.length - a2;
        if (length == 0) {
            p pVar = new p();
            pVar.f1575a = a3;
            pVar.b = bArr;
            pVar.c = a2;
            pVar.d = length;
            return pVar;
        }
        if (a3.e() == 2) {
            if (this.c == null) {
                throw new IMException(com.baidu.tieba.im.k.i);
            }
            try {
                bArr = com.baidu.tieba.im.d.d.a(this.c, bArr, a2, length);
                length = bArr.length;
                a2 = 0;
            } catch (Exception e) {
                throw new IMException(com.baidu.tieba.im.k.k);
            }
        } else if (a3.e() != 1) {
            throw new IMException(com.baidu.tieba.im.k.b);
        }
        if (a3.c() == 2) {
            try {
                bArr = a(bArr, a2, length);
                length = bArr.length;
            } catch (Exception e2) {
                throw new IMException(com.baidu.tieba.im.k.h, e2);
            }
        } else {
            i = a2;
        }
        p pVar2 = new p();
        pVar2.f1575a = a3;
        pVar2.b = bArr;
        pVar2.c = i;
        pVar2.d = length;
        return pVar2;
    }

    public List<Message> a(int i, boolean z, byte[] bArr, int i2, int i3) {
        b bVar = this.f1569a.get(Integer.valueOf(i));
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
        b bVar = this.f1569a.get(Integer.valueOf(i2));
        if (bVar != null) {
            bVar.a(i, nVar);
        } else if (TiebaApplication.g().b()) {
            throw new RuntimeException("unknown packtype:" + i2);
        }
    }
}
