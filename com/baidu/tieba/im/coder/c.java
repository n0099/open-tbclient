package com.baidu.tieba.im.coder;

import android.util.SparseArray;
import com.baidu.tieba.im.k;
import com.baidu.tieba.im.message.q;
import com.baidu.tieba.util.ak;
import com.baidu.tieba.util.p;
import com.google.protobuf.MessageLite;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c a = null;
    private SparseArray<Class<?>> b;

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    private c() {
        this.b = null;
        this.b = new SparseArray<>();
    }

    public byte[] a(q qVar, int i, boolean z) {
        MessageLite messageLite = null;
        try {
            if (qVar instanceof g) {
                messageLite = ((g) qVar).a();
            }
            byte[] byteArray = messageLite.toByteArray();
            if (byteArray != null && z) {
                byteArray = b(byteArray, 0, byteArray.length);
            }
            boolean b = e.a().b(qVar.w());
            if (byteArray != null && b) {
                byteArray = com.baidu.tieba.im.d.f.a(e.a().c(), byteArray);
            }
            return b.a(b, z, qVar.w(), i, byteArray);
        } catch (Exception e) {
            throw new CoderException(k.l);
        }
    }

    public d a(d dVar) {
        if (dVar == null || dVar.a == null || dVar.b == null) {
            throw new CoderException(k.b);
        }
        b bVar = dVar.a;
        if (bVar.d()) {
            if (e.a().c() == null) {
                throw new CoderException(k.i);
            }
            try {
                dVar.b = com.baidu.tieba.im.d.f.a(e.a().c(), dVar.b, dVar.c, dVar.d);
                dVar.c = 0;
                dVar.d = dVar.b.length;
            } catch (Exception e) {
                throw new CoderException(k.k);
            }
        }
        if (bVar.b()) {
            try {
                dVar.b = a(dVar.b, dVar.c, dVar.d);
                dVar.c = 0;
                dVar.d = dVar.b.length;
            } catch (Exception e2) {
                throw new CoderException(k.h);
            }
        }
        return dVar;
    }

    public d a(byte[] bArr) {
        int a2 = b.a();
        if (bArr == null || bArr.length < a2) {
            throw new CoderException(k.b);
        }
        b a3 = b.a(bArr);
        if (a3 == null) {
            throw new CoderException(k.b);
        }
        d dVar = new d();
        dVar.a = a3;
        dVar.b = bArr;
        dVar.c = a2;
        dVar.d = bArr.length - a2;
        return dVar;
    }

    public List<q> a(int i, byte[] bArr, int i2, int i3) {
        Class<?> cls = this.b.get(i);
        if (cls == null) {
            throw new CoderException(k.c);
        }
        if (i2 != 0 || i3 != bArr.length) {
            bArr = ByteBuffer.wrap(bArr, i2, i3).array();
        }
        try {
            LinkedList<q> linkedList = new LinkedList<>();
            com.baidu.adp.lib.g.e.d("decode cmd:" + i);
            ((f) cls.newInstance()).a(linkedList, bArr, i);
            return linkedList;
        } catch (Exception e) {
            throw new CoderException(k.e);
        }
    }

    protected byte[] a(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ak.b(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            p.a((OutputStream) byteArrayOutputStream);
            p.a((InputStream) byteArrayInputStream);
        }
    }

    protected byte[] b(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ak.a(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            p.a((OutputStream) byteArrayOutputStream);
            p.a((InputStream) byteArrayInputStream);
        }
    }

    public void a(int i, Class<?> cls) {
        if (cls != null) {
            this.b.put(i, cls);
        }
    }
}
