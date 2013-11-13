package com.baidu.tieba.im.codec.a;

import org.msgpack.type.ArrayValue;
import org.msgpack.type.MapValue;
import org.msgpack.type.r;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayValue f1566a;

    public a(ArrayValue arrayValue) {
        this.f1566a = null;
        this.f1566a = arrayValue;
    }

    public int a() {
        if (this.f1566a != null) {
            return this.f1566a.size();
        }
        return 0;
    }

    public c a(int i) {
        r rVar;
        if (this.f1566a == null || i < 0 || i >= a() || (rVar = this.f1566a.get(i)) == null || !(rVar instanceof MapValue)) {
            return null;
        }
        return new c((MapValue) rVar);
    }
}
