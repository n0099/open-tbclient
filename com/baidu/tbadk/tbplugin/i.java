package com.baidu.tbadk.tbplugin;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public final class i {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Class<T extends java.lang.annotation.Annotation> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Annotation> T a(Class<?> cls, Class<T> cls2) {
        return (T) cls.getAnnotation(cls2);
    }

    public static int a(int i, int i2) {
        return (i << 8) | i2;
    }

    public static File a() {
        return m.a().b();
    }

    public static File b() {
        return m.a().c();
    }

    public static File c() {
        return m.a().d();
    }

    public static File d() {
        return m.a().e();
    }

    public static File e() {
        return m.a().f();
    }

    public static File f() {
        return m.a().g();
    }

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

    public static String g() {
        String substring = System.getProperty("os.arch", "arm").substring(0, 3);
        if (substring.equals("i68")) {
            return "x86";
        }
        return substring;
    }

    public static boolean a(Class<?> cls) {
        com.baidu.tbadk.tbplugin.a.c cVar = (com.baidu.tbadk.tbplugin.a.c) a(cls, com.baidu.tbadk.tbplugin.a.c.class);
        return cVar != null && FileUtils.getFile(d(), new StringBuilder().append(cVar).append(".xml").toString()).exists();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, String str2) {
        com.baidu.adp.lib.stats.h.a().a(context, "plugin", "install", 1, "failed", str2, str);
        BdLog.d("Plugin install failed: " + str + ": " + str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        com.baidu.adp.lib.stats.h.a().a(context, "plugin", "load", 1, "failed", str);
        BdLog.d("Plugin load failed: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str) {
        com.baidu.adp.lib.stats.h.a().a(context, "plugin", "general", 1, "failed", str);
        BdLog.d("Plugin general failed: " + str);
    }

    static PluginsConfig h() {
        return m.a().i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(s sVar) {
        return new x(h()).a(sVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(s sVar) {
        return new y(h()).a(sVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        try {
            return new z(h()).a(s.a(new File(d().getAbsoluteFile() + "/" + str + ".xml")));
        } catch (Exception e) {
            b(TbadkApplication.m252getInst(), "Check update failed: " + str);
            return false;
        }
    }
}
