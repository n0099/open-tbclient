package com.baidu.tieba.im.b.a;

import com.baidu.adp.lib.h.e;
import java.util.Map;
import org.msgpack.type.ArrayValue;
import org.msgpack.type.MapValue;
import org.msgpack.type.RawValue;
import org.msgpack.type.r;
import org.msgpack.type.s;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private MapValue f1517a;

    public d(MapValue mapValue) {
        this.f1517a = null;
        this.f1517a = mapValue;
    }

    public d(byte[] bArr, int i, int i2) {
        this.f1517a = null;
        try {
            MapValue asMapValue = new org.msgpack.a().b(bArr, i, i2).asMapValue();
            if (asMapValue instanceof MapValue) {
                this.f1517a = asMapValue;
            }
        } catch (Exception e) {
            if (e != null) {
                e.a(e.getMessage());
            }
        }
    }

    public String a(String str) {
        return a(str, (String) null);
    }

    public String a(String str, String str2) {
        r rVar;
        try {
            if (this.f1517a != null && (rVar = this.f1517a.get(g(str))) != null && rVar.isRawValue()) {
                return rVar.asRawValue().c();
            }
            return str2;
        } catch (Exception e) {
            if (e != null) {
                e.a(e.getMessage());
                return str2;
            }
            return str2;
        }
    }

    public int b(String str) {
        return a(str, 0);
    }

    public int a(String str, int i) {
        r rVar;
        try {
            if (this.f1517a != null && (rVar = this.f1517a.get(g(str))) != null) {
                if (rVar.isIntegerValue()) {
                    i = rVar.asIntegerValue().getInt();
                } else if (rVar.isFloatValue()) {
                    i = rVar.asFloatValue().intValue();
                } else if (rVar.isRawValue()) {
                    i = Integer.parseInt(rVar.asRawValue().c());
                }
            }
        } catch (Exception e) {
            if (e != null) {
                e.a(e.getMessage());
            }
        }
        return i;
    }

    public long c(String str) {
        return a(str, 0L);
    }

    public long a(String str, long j) {
        r rVar;
        try {
            if (this.f1517a != null && (rVar = this.f1517a.get(g(str))) != null) {
                if (rVar.isIntegerValue()) {
                    j = rVar.asIntegerValue().longValue();
                } else if (rVar.isFloatValue()) {
                    j = rVar.asFloatValue().longValue();
                } else if (rVar.isRawValue()) {
                    j = Long.parseLong(rVar.asRawValue().c());
                }
            }
        } catch (Exception e) {
            if (e != null) {
                e.a(e.getMessage());
            }
        }
        return j;
    }

    public c d(String str) {
        r rVar;
        c cVar = new c();
        if (this.f1517a != null && (rVar = this.f1517a.get(g(str))) != null && (rVar instanceof MapValue)) {
            for (Map.Entry<r, r> entry : ((MapValue) rVar).entrySet()) {
                r key = entry.getKey();
                r value = entry.getValue();
                a aVar = null;
                if (value != null && value.isArrayValue()) {
                    aVar = new a((ArrayValue) value);
                }
                cVar.a(key.asRawValue().c(), aVar);
            }
        }
        return cVar;
    }

    public a e(String str) {
        a aVar;
        r rVar;
        ArrayValue asArrayValue;
        try {
            if (this.f1517a == null || (rVar = this.f1517a.get(g(str))) == null || !rVar.isArrayValue() || (asArrayValue = rVar.asArrayValue()) == null) {
                aVar = null;
            } else {
                aVar = new a(asArrayValue);
            }
            return aVar;
        } catch (Exception e) {
            if (e == null) {
                return null;
            }
            e.a(e.getMessage());
            return null;
        }
    }

    public d f(String str) {
        r rVar;
        if (this.f1517a == null || (rVar = this.f1517a.get(g(str))) == null || !(rVar instanceof MapValue)) {
            return null;
        }
        return new d((MapValue) rVar);
    }

    private RawValue g(String str) {
        return s.a(str);
    }
}
