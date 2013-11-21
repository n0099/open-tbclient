package com.baidu.tieba.im.codec;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, h> f1563a = new HashMap();

    static {
        f1563a.put("int", new i());
        f1563a.put(Integer.class.getName(), new i());
        f1563a.put("boolean", new a());
        f1563a.put(Boolean.class.getName(), new a());
        f1563a.put("long", new k());
        f1563a.put(Long.class.getName(), new k());
        f1563a.put("float", new g());
        f1563a.put(Float.class.getName(), new g());
        f1563a.put("double", new f());
        f1563a.put(Double.class.getName(), new f());
        f1563a.put(String.class.getName(), new r());
    }

    public static h a(String str) {
        return f1563a.get(str);
    }
}
