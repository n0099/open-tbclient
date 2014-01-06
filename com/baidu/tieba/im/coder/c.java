package com.baidu.tieba.im.coder;

import android.util.SparseArray;
import com.baidu.tieba.im.k;
import com.baidu.tieba.im.message.o;
import com.baidu.tieba.util.ah;
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

    public byte[] a(o oVar, int i, boolean z) {
        MessageLite messageLite = null;
        try {
            if (oVar instanceof g) {
                messageLite = ((g) oVar).a();
            }
            byte[] byteArray = messageLite.toByteArray();
            if (byteArray != null && z) {
                byteArray = b(byteArray, 0, byteArray.length);
            }
            boolean b = e.a().b(oVar.u());
            if (byteArray != null && b) {
                byteArray = com.baidu.tieba.im.d.e.a(e.a().c(), byteArray);
            }
            return b.a(b, z, oVar.u(), i, byteArray);
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
                dVar.b = com.baidu.tieba.im.d.e.a(e.a().c(), dVar.b, dVar.c, dVar.d);
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

    public List<o> a(int i, byte[] bArr, int i2, int i3) {
        Class<?> cls = this.b.get(i);
        if (cls == null) {
            throw new CoderException(k.c);
        }
        if (i2 != 0 || i3 != bArr.length) {
            bArr = ByteBuffer.wrap(bArr, i2, i3).array();
        }
        try {
            LinkedList<o> linkedList = new LinkedList<>();
            com.baidu.adp.lib.h.e.d("decode cmd:" + i);
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

    public void a(int i, Class<?> cls) {
        if (cls != null) {
            this.b.put(i, cls);
        }
    }
}
