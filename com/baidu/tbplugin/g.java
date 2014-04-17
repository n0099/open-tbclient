package com.baidu.tbplugin;

import android.content.Context;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Field a(Class<?> cls, String str) {
        Field[] declaredFields;
        for (Field field : cls.getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            if (field.getName().equals(str)) {
                return field;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, String str2) {
        com.baidu.adp.lib.stats.i.a().a("plugin", "install", 1, "failed", str2, str);
        com.baidu.adp.lib.util.f.b("Plugin install failed: " + str + ": " + str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        com.baidu.adp.lib.stats.i.a().a("plugin", "general", 1, "failed", str);
        com.baidu.adp.lib.util.f.b("Plugin general failed: " + str);
    }
}
