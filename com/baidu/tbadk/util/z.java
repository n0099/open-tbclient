package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class z {
    private static final Object b(Class<?> cls, HashSet<Class<?>> hashSet) {
        Type[] actualTypeArguments;
        if (hashSet == null || hashSet.contains(cls)) {
            return null;
        }
        hashSet.add(cls);
        try {
            Class<?> cls2 = Class.forName(cls.getName() + "$Builder");
            Method declaredMethod = cls2.getDeclaredMethod("build", Boolean.TYPE);
            Object newInstance = cls2.newInstance();
            Field[] declaredFields = cls2.getDeclaredFields();
            for (Field field : declaredFields) {
                Class<?> type = field.getType();
                if (type != null) {
                    if (com.baidu.adp.lib.OrmObject.a.a.d(type, Message.class)) {
                        Object b = b(type, hashSet);
                        if (b != null) {
                            if (com.baidu.adp.lib.OrmObject.a.a.d(b.getClass(), Message.class)) {
                                field.setAccessible(true);
                                field.set(newInstance, b);
                            } else {
                                BdLog.e("");
                            }
                        }
                    } else if (com.baidu.adp.lib.OrmObject.a.a.d(type, List.class)) {
                        Type genericType = field.getGenericType();
                        if ((genericType instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) != null && actualTypeArguments.length > 0) {
                            try {
                                Class cls3 = (Class) actualTypeArguments[0];
                                if (com.baidu.adp.lib.OrmObject.a.a.d(cls3, Message.class)) {
                                    ArrayList arrayList = new ArrayList();
                                    Object b2 = b(cls3, hashSet);
                                    if (b2 != null) {
                                        if (com.baidu.adp.lib.OrmObject.a.a.d(b2.getClass(), Message.class)) {
                                            arrayList.add(b2);
                                        } else {
                                            BdLog.e("");
                                        }
                                        field.setAccessible(true);
                                        field.set(newInstance, arrayList);
                                    }
                                }
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
            }
            return declaredMethod.invoke(newInstance, true);
        } catch (Throwable th2) {
            BdLog.detailException(th2);
            return null;
        }
    }

    public static final void a(Wire wire, Class<? extends Message> cls) {
        File[] listFiles;
        String name;
        if (wire != null && cls != null) {
            String str = "wire_" + cls.getName();
            File file = new File(TbadkCoreApplication.getInst().getCacheDir(), str + "_" + TbConfig.getVersion());
            byte[] bArr = null;
            try {
                if (file.exists() && (bArr = A(file)) != null) {
                    wire.parseFrom(bArr, cls);
                }
                if (bArr == null) {
                    byte[] bArr2 = (byte[]) com.baidu.adp.lib.OrmObject.a.a.b(cls, "toByteArray", new Object[0]).invoke(b(cls, new HashSet()), new Object[0]);
                    wire.parseFrom(bArr2, cls);
                    a(file, bArr2);
                }
            } catch (Throwable th) {
                BdLog.detailException(th);
                try {
                    file.delete();
                } catch (Throwable th2) {
                }
            }
            File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
            if (cacheDir != null && (listFiles = cacheDir.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && (name = file2.getName()) != null && name.startsWith(str) && !file.getName().equals(name)) {
                        try {
                            file2.delete();
                        } catch (Throwable th3) {
                        }
                    }
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [173=4, 174=4] */
    private static byte[] A(java.io.File r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L4
        L3:
            return r0
        L4:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4e
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L4e
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L52
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L52
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L23
        L14:
            r4 = 0
            r5 = 1024(0x400, float:1.435E-42)
            int r4 = r3.read(r1, r4, r5)     // Catch: java.lang.Throwable -> L23
            r5 = -1
            if (r4 == r5) goto L32
            r5 = 0
            r2.write(r1, r5, r4)     // Catch: java.lang.Throwable -> L23
            goto L14
        L23:
            r1 = move-exception
        L24:
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L4c
            com.baidu.adp.lib.util.BdLog.e(r1)     // Catch: java.lang.Throwable -> L4c
            com.baidu.adp.lib.util.m.d(r3)
            com.baidu.adp.lib.util.m.b(r2)
            goto L3
        L32:
            byte[] r0 = r2.toByteArray()     // Catch: java.lang.Throwable -> L23
            com.baidu.adp.lib.util.m.d(r3)
            com.baidu.adp.lib.util.m.b(r2)
            goto L3
        L3d:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r0 = r1
        L41:
            com.baidu.adp.lib.util.m.d(r3)
            com.baidu.adp.lib.util.m.b(r2)
            throw r0
        L48:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L41
        L4c:
            r0 = move-exception
            goto L41
        L4e:
            r1 = move-exception
            r2 = r0
            r3 = r0
            goto L24
        L52:
            r1 = move-exception
            r2 = r0
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.util.z.A(java.io.File):byte[]");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [200=5] */
    private static final boolean a(File file, byte[] bArr) {
        if (file == null || bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists() || file.delete()) {
                if (file.createNewFile()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr, 0, bArr.length);
                        fileOutputStream2.flush();
                        com.baidu.adp.lib.util.m.b((OutputStream) fileOutputStream2);
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        try {
                            BdLog.e(th.getMessage());
                            return false;
                        } finally {
                            com.baidu.adp.lib.util.m.b((OutputStream) fileOutputStream);
                        }
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
