package com.baidu.tieba.im.coder;

import android.util.SparseArray;
import com.baidu.tieba.im.h;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.util.n;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.r;
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

    public byte[] a(s sVar, int i, boolean z) {
        MessageLite messageLite = null;
        try {
            if (sVar instanceof g) {
                messageLite = ((g) sVar).a();
            }
            byte[] byteArray = messageLite.toByteArray();
            if (byteArray != null && z) {
                byteArray = b(byteArray, 0, byteArray.length);
            }
            boolean b = e.a().b(sVar.w());
            if (byteArray != null && b) {
                byteArray = n.a(e.a().c(), byteArray);
            }
            return b.a(b, z, sVar.w(), i, byteArray);
        } catch (Exception e) {
            throw new CoderException(h.l);
        }
    }

    public d a(d dVar) {
        if (dVar == null || dVar.a == null || dVar.b == null) {
            throw new CoderException(h.b);
        }
        b bVar = dVar.a;
        if (bVar.d()) {
            if (e.a().c() == null) {
                throw new CoderException(h.i);
            }
            try {
                dVar.b = n.a(e.a().c(), dVar.b, dVar.c, dVar.d);
                dVar.c = 0;
                dVar.d = dVar.b.length;
            } catch (Exception e) {
                throw new CoderException(h.k);
            }
        }
        if (bVar.b()) {
            try {
                dVar.b = a(dVar.b, dVar.c, dVar.d);
                dVar.c = 0;
                dVar.d = dVar.b.length;
            } catch (Exception e2) {
                throw new CoderException(h.h);
            }
        }
        return dVar;
    }

    public d a(byte[] bArr) {
        int a2 = b.a();
        if (bArr == null || bArr.length < a2) {
            throw new CoderException(h.b);
        }
        b a3 = b.a(bArr);
        if (a3 == null) {
            throw new CoderException(h.b);
        }
        d dVar = new d();
        dVar.a = a3;
        dVar.b = bArr;
        dVar.c = a2;
        dVar.d = bArr.length - a2;
        return dVar;
    }

    public List<s> a(int i, byte[] bArr, int i2, int i3) {
        Class<?> cls = this.b.get(i);
        if (cls == null) {
            throw new CoderException(h.c);
        }
        if (i2 != 0 || i3 != bArr.length) {
            bArr = ByteBuffer.wrap(bArr, i2, i3).array();
        }
        try {
            LinkedList<s> linkedList = new LinkedList<>();
            com.baidu.adp.lib.util.f.e("decode cmd:" + i);
            ((f) cls.newInstance()).a(linkedList, bArr, i);
            return linkedList;
        } catch (Exception e) {
            throw new CoderException(h.e);
        }
    }

    protected byte[] a(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            am.b(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            r.a((OutputStream) byteArrayOutputStream);
            r.a((InputStream) byteArrayInputStream);
        }
    }

    protected byte[] b(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            am.a(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            r.a((OutputStream) byteArrayOutputStream);
            r.a((InputStream) byteArrayInputStream);
        }
    }

    public void a(int i, Class<?> cls) {
        if (cls != null) {
            this.b.put(i, cls);
        }
    }
}
