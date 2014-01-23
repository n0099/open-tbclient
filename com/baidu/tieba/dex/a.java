package com.baidu.tieba.dex;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.lib.g.e;
import com.baidu.tieba.dex.wrapper.BdBrowserDelegate;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private Context a;
    private DexClassLoader b;
    private boolean c;
    private BdBrowserDelegate d;

    public a(Context context) {
        this.a = context;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [73=5, 74=4, 76=4, 77=4, 107=4, 108=4, 110=4, 111=4, 113=4] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3 A[Catch: IOException -> 0x00ba, TryCatch #0 {IOException -> 0x00ba, blocks: (B:4:0x0056, B:26:0x00b1, B:19:0x009d, B:21:0x00a3, B:23:0x00a9, B:28:0x00b6, B:42:0x00d8, B:44:0x00dd, B:45:0x00e0, B:16:0x0095, B:18:0x009a, B:36:0x00c8, B:38:0x00cd), top: B:105:0x0056 }] */
    /* JADX WARN: Type inference failed for: r1v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v26, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private File a(String str, String str2) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Throwable th;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        InputStream inputStream2;
        Throwable th2;
        FileOutputStream fileOutputStream4;
        InputStream inputStream3 = null;
        File file = new File(this.a.getFilesDir() + "/" + str2 + "_back");
        File file2 = new File(this.a.getFilesDir() + "/" + str2);
        byte[] bArr = new byte[65536];
        ?? exists = file2.exists();
        try {
            if (exists != 0) {
                try {
                    ?? equals = Arrays.equals(a(file2), a(this.a.getAssets().open(str, 2)));
                    try {
                        if (equals == 0) {
                            try {
                                fileOutputStream4 = new FileOutputStream(file);
                                try {
                                    try {
                                        InputStream open = this.a.getAssets().open(str, 2);
                                        while (true) {
                                            int read = open.read(bArr, 0, 65536);
                                            if (read == -1) {
                                                break;
                                            }
                                            fileOutputStream4.write(bArr, 0, read);
                                        }
                                        if (fileOutputStream4 != null) {
                                            fileOutputStream4.close();
                                        }
                                        if (open != null) {
                                            open.close();
                                        }
                                    } catch (Throwable th3) {
                                        fileOutputStream3 = fileOutputStream4;
                                        inputStream2 = null;
                                        th2 = th3;
                                        if (fileOutputStream3 != null) {
                                            fileOutputStream3.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        throw th2;
                                    }
                                } catch (FileNotFoundException e) {
                                    e.d("load bd browser failed: FileNotFoundException");
                                    if (fileOutputStream4 != null) {
                                        fileOutputStream4.close();
                                    }
                                    if (0 != 0) {
                                        inputStream3.close();
                                    }
                                    if (file2.delete()) {
                                        e.d("load bd browser failed: renameFile");
                                    }
                                    return file2;
                                } catch (IOException e2) {
                                    e.d("load bd browser failed: IOException");
                                    if (fileOutputStream4 != null) {
                                        fileOutputStream4.close();
                                    }
                                    if (0 != 0) {
                                        inputStream3.close();
                                    }
                                    if (file2.delete()) {
                                    }
                                    return file2;
                                }
                            } catch (FileNotFoundException e3) {
                                fileOutputStream4 = null;
                            } catch (IOException e4) {
                                fileOutputStream4 = null;
                            } catch (Throwable th4) {
                                fileOutputStream3 = null;
                                th2 = th4;
                                inputStream2 = null;
                            }
                            if (file2.delete() && file.renameTo(file2)) {
                                e.d("load bd browser failed: renameFile");
                            }
                        }
                    } catch (Throwable th5) {
                        fileOutputStream3 = equals;
                        inputStream2 = null;
                        th2 = th5;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            } else {
                try {
                    fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        try {
                            InputStream open2 = this.a.getAssets().open(str, 2);
                            while (true) {
                                int read2 = open2.read(bArr, 0, 65536);
                                if (read2 == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read2);
                            }
                            open2.close();
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e6) {
                                }
                            }
                            if (open2 != null) {
                                open2.close();
                            }
                        } catch (Throwable th6) {
                            fileOutputStream = fileOutputStream2;
                            inputStream = null;
                            th = th6;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e8) {
                        e.a("load bd browser failed: FileNotFoundException");
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (0 != 0) {
                            inputStream3.close();
                        }
                        return file2;
                    } catch (IOException e10) {
                        e.a("load bd browser failed: IOException");
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e11) {
                            }
                        }
                        if (0 != 0) {
                            inputStream3.close();
                        }
                        return file2;
                    }
                } catch (FileNotFoundException e12) {
                    fileOutputStream2 = null;
                } catch (IOException e13) {
                    fileOutputStream2 = null;
                } catch (Throwable th7) {
                    fileOutputStream = null;
                    th = th7;
                    inputStream = null;
                }
            }
            return file2;
        } catch (Throwable th8) {
            fileOutputStream = exists;
            inputStream = null;
            th = th8;
        }
    }

    private byte[] a(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[131072];
            while (true) {
                int read = fileInputStream.read(bArr, 0, 131072);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return messageDigest.digest();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private byte[] a(InputStream inputStream) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[131072];
            while (true) {
                int read = inputStream.read(bArr, 0, 131072);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    inputStream.close();
                    return messageDigest.digest();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void a() {
        this.b = new DexClassLoader(a("browser_wrapper.jar", "browser_wrapper_optimised.jar").getAbsolutePath(), this.a.getFilesDir().getAbsolutePath(), null, this.a.getClassLoader());
    }

    private Field a(Class<?> cls, String str) {
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

    private void a(Activity activity, ClassLoader classLoader) {
        try {
            Object obj = a(Activity.class, "mMainThread").get(activity);
            Object obj2 = ((WeakReference) ((Map) a(obj.getClass(), "mPackages").get(obj)).get(this.a.getPackageName())).get();
            a(obj2.getClass(), "mClassLoader").set(obj2, classLoader);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            e.a("load bd browser failed: IllegalAccessException");
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            e.a("load bd browser failed: IllegalArgumentException");
        }
    }

    private void b(Activity activity) {
        if (!this.c) {
            try {
                a();
                a(activity, this.b);
                this.c = true;
            } catch (Throwable th) {
                e.a("load dex class failed: Exception: " + th.getMessage());
            }
        }
    }

    public BdBrowserDelegate a(Activity activity) {
        if (!this.c) {
            b(activity);
        }
        try {
            this.d = (BdBrowserDelegate) this.b.loadClass("com.baidu.tieba.dex.wrapper.BdBrowserDelegateImpl").getConstructor(Activity.class).newInstance(activity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            e.a("load bd browser failed: ClassNotFoundException");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            e.a("load bd browser failed: IllegalAccessException");
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            e.a("load bd browser failed: InstantiationException");
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            e.a("load bd browser failed: NoSuchMethodException");
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            e.a("load bd browser failed: InvocationTargetException");
        } catch (Throwable th) {
            th.printStackTrace();
            e.a("Throwable e: " + th.getMessage());
        }
        return this.d;
    }
}
