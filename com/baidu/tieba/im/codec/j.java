package com.baidu.tieba.im.codec;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, h> f1572a = new HashMap();

    static {
        f1572a.put("int", new i());
        f1572a.put(Integer.class.getName(), new i());
        f1572a.put("boolean", new a());
        f1572a.put(Boolean.class.getName(), new a());
        f1572a.put("long", new k());
        f1572a.put(Long.class.getName(), new k());
        f1572a.put("float", new g());
        f1572a.put(Float.class.getName(), new g());
        f1572a.put("double", new f());
        f1572a.put(Double.class.getName(), new f());
        f1572a.put(String.class.getName(), new r());
    }

    public static h a(String str) {
        return f1572a.get(str);
    }
}
