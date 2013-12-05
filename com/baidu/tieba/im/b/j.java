package com.baidu.tieba.im.b;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, h> f1521a = new HashMap();

    static {
        f1521a.put("int", new i());
        f1521a.put(Integer.class.getName(), new i());
        f1521a.put("boolean", new a());
        f1521a.put(Boolean.class.getName(), new a());
        f1521a.put("long", new k());
        f1521a.put(Long.class.getName(), new k());
        f1521a.put("float", new g());
        f1521a.put(Float.class.getName(), new g());
        f1521a.put("double", new f());
        f1521a.put(Double.class.getName(), new f());
        f1521a.put(String.class.getName(), new r());
    }

    public static h a(String str) {
        return f1521a.get(str);
    }
}
