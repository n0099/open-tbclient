package com.baidu.tieba;

import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes6.dex */
public interface id {
    Set<String> getKeys();

    Object getObjectByType(String str, Type type);

    void set(String str, Object obj);
}
