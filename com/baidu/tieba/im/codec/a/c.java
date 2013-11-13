package com.baidu.tieba.im.codec.a;

import com.baidu.adp.lib.h.d;
import org.msgpack.type.ArrayValue;
import org.msgpack.type.MapValue;
import org.msgpack.type.RawValue;
import org.msgpack.type.r;
import org.msgpack.type.s;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private MapValue f1568a;

    public c(MapValue mapValue) {
        this.f1568a = null;
        this.f1568a = mapValue;
    }

    public c(byte[] bArr, int i, int i2) {
        this.f1568a = null;
        try {
            MapValue asMapValue = new org.msgpack.a().b(bArr, i, i2).asMapValue();
            if (asMapValue instanceof MapValue) {
                this.f1568a = asMapValue;
            }
        } catch (Exception e) {
            if (e != null) {
                d.a(e.getMessage());
            }
        }
    }

    public String a(String str) {
        return a(str, (String) null);
    }

    public String a(String str, String str2) {
        r rVar;
        try {
            if (this.f1568a != null && (rVar = this.f1568a.get(f(str))) != null && rVar.isRawValue()) {
                return rVar.asRawValue().c();
            }
            return str2;
        } catch (Exception e) {
            if (e != null) {
                d.a(e.getMessage());
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
            if (this.f1568a != null && (rVar = this.f1568a.get(f(str))) != null) {
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
                d.a(e.getMessage());
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
            if (this.f1568a != null && (rVar = this.f1568a.get(f(str))) != null) {
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
                d.a(e.getMessage());
            }
        }
        return j;
    }

    public a d(String str) {
        a aVar;
        r rVar;
        ArrayValue asArrayValue;
        try {
            if (this.f1568a == null || (rVar = this.f1568a.get(f(str))) == null || !rVar.isArrayValue() || (asArrayValue = rVar.asArrayValue()) == null) {
                aVar = null;
            } else {
                aVar = new a(asArrayValue);
            }
            return aVar;
        } catch (Exception e) {
            if (e == null) {
                return null;
            }
            d.a(e.getMessage());
            return null;
        }
    }

    public c e(String str) {
        r rVar;
        if (this.f1568a == null || (rVar = this.f1568a.get(f(str))) == null || !(rVar instanceof MapValue)) {
            return null;
        }
        return new c((MapValue) rVar);
    }

    private RawValue f(String str) {
        return s.a(str);
    }
}
