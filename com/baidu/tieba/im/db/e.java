package com.baidu.tieba.im.db;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class e {
    private ConcurrentHashMap<String, ImMessageCenterPojo> a = new ConcurrentHashMap<>();
    private final Object b = new Object();

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [53=4, 54=4] */
    public void a(File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        synchronized (this.b) {
            try {
            } catch (Exception e) {
                e = e;
                fileOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            if (TbadkApplication.getCurrentAccount() == null || file == null) {
                com.baidu.tbadk.core.util.m.a((OutputStream) null);
                com.baidu.tbadk.core.util.m.a((OutputStream) null);
                return;
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                objectOutputStream.writeObject(this.a);
                objectOutputStream.close();
                com.baidu.tbadk.core.util.m.a((OutputStream) fileOutputStream);
                com.baidu.tbadk.core.util.m.a((OutputStream) objectOutputStream);
            } catch (Exception e3) {
                e = e3;
                objectOutputStream2 = objectOutputStream;
                fileOutputStream2 = fileOutputStream;
                try {
                    e.printStackTrace();
                    com.baidu.tbadk.core.util.m.a((OutputStream) fileOutputStream2);
                    com.baidu.tbadk.core.util.m.a((OutputStream) objectOutputStream2);
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    com.baidu.tbadk.core.util.m.a((OutputStream) fileOutputStream);
                    com.baidu.tbadk.core.util.m.a((OutputStream) objectOutputStream2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream2 = objectOutputStream;
                com.baidu.tbadk.core.util.m.a((OutputStream) fileOutputStream);
                com.baidu.tbadk.core.util.m.a((OutputStream) objectOutputStream2);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [85=4, 86=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.io.ObjectInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        InputStream inputStream;
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream3 = null;
        synchronized (this.b) {
            try {
            } catch (Exception e) {
                e = e;
                fileInputStream2 = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            if (TbadkApplication.getCurrentAccount() == null || file == null) {
                com.baidu.tbadk.core.util.m.a((InputStream) null);
                com.baidu.tbadk.core.util.m.a((InputStream) null);
                return;
            }
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = null;
                    fileInputStream3 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    this.a = (ConcurrentHashMap) objectInputStream.readObject();
                    objectInputStream.close();
                    inputStream = objectInputStream;
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream3 = fileInputStream;
                    fileInputStream2 = objectInputStream;
                    try {
                        e.printStackTrace();
                        com.baidu.tbadk.core.util.m.a((InputStream) fileInputStream3);
                        com.baidu.tbadk.core.util.m.a((InputStream) fileInputStream2);
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream3;
                        fileInputStream3 = fileInputStream2;
                        com.baidu.tbadk.core.util.m.a((InputStream) fileInputStream);
                        com.baidu.tbadk.core.util.m.a((InputStream) fileInputStream3);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream3 = objectInputStream;
                    com.baidu.tbadk.core.util.m.a((InputStream) fileInputStream);
                    com.baidu.tbadk.core.util.m.a((InputStream) fileInputStream3);
                    throw th;
                }
            } else {
                inputStream = null;
                fileInputStream = null;
            }
            com.baidu.tbadk.core.util.m.a((InputStream) fileInputStream);
            com.baidu.tbadk.core.util.m.a(inputStream);
        }
    }

    public void a(com.baidu.tieba.im.b.d dVar) {
        synchronized (this.b) {
            for (ImMessageCenterPojo imMessageCenterPojo : this.a.values()) {
                dVar.a(imMessageCenterPojo);
            }
        }
    }

    public void a() {
        synchronized (this.b) {
            this.a.clear();
        }
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            synchronized (this.b) {
                this.a.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
            }
        }
    }

    public ImMessageCenterPojo a(String str) {
        return this.a.get(str);
    }

    public boolean b(String str) {
        if (str != null) {
            synchronized (this.b) {
                r0 = this.a.remove(str) != null;
            }
        }
        return r0;
    }
}
