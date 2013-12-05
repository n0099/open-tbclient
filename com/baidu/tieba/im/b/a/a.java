package com.baidu.tieba.im.b.a;

import org.msgpack.type.ArrayValue;
import org.msgpack.type.MapValue;
import org.msgpack.type.r;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayValue f1514a;

    public a(ArrayValue arrayValue) {
        this.f1514a = null;
        this.f1514a = arrayValue;
    }

    public int a() {
        if (this.f1514a != null) {
            return this.f1514a.size();
        }
        return 0;
    }

    public d a(int i) {
        r rVar;
        if (this.f1514a == null || i < 0 || i >= a() || (rVar = this.f1514a.get(i)) == null || !(rVar instanceof MapValue)) {
            return null;
        }
        return new d((MapValue) rVar);
    }

    public ArrayValue b() {
        return this.f1514a;
    }
}
