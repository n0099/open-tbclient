package com.baidu.tieba.im.codec;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, h> f1481a = new HashMap();

    static {
        f1481a.put("int", new i());
        f1481a.put(Integer.class.getName(), new i());
        f1481a.put("boolean", new a());
        f1481a.put(Boolean.class.getName(), new a());
        f1481a.put("long", new k());
        f1481a.put(Long.class.getName(), new k());
        f1481a.put("float", new g());
        f1481a.put(Float.class.getName(), new g());
        f1481a.put("double", new f());
        f1481a.put(Double.class.getName(), new f());
        f1481a.put(String.class.getName(), new r());
    }

    public static h a(String str) {
        return f1481a.get(str);
    }
}
