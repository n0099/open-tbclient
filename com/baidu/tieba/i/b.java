package com.baidu.tieba.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tieba.i.c;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes.dex */
final class b {
    private static Method eng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<File> a(Context context, ApplicationInfo applicationInfo, File file, boolean z) throws IOException {
        List<File> c;
        Log.i("MultiDex", "MultiDexExtractor.load(" + applicationInfo.sourceDir + ", " + z + ")");
        File file2 = new File(applicationInfo.sourceDir);
        long D = D(file2);
        if (!z && !a(context, file2, D)) {
            try {
                c = a(context, file2, file);
            } catch (IOException e) {
                Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                if (context instanceof c.a) {
                    ((c.a) context).getSplash().aKh();
                }
                c = c(file2, file);
                b(context, C(file2), D, c.size() + 1);
            }
        } else {
            Log.i("MultiDex", "Detected that extraction must be performed.");
            if (context instanceof c.a) {
                ((c.a) context).getSplash().aKh();
            }
            c = c(file2, file);
            b(context, C(file2), D, c.size() + 1);
        }
        Log.i("MultiDex", "load found " + c.size() + " secondary dex files");
        return c;
    }

    private static List<File> a(Context context, File file, File file2) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str = file.getName() + ".classes";
        int i = aw(context).getInt("dex.number", 1);
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 2; i2 <= i; i2++) {
            File file3 = new File(file2, str + i2 + ".zip");
            if (!file3.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
            }
            arrayList.add(file3);
            if (!F(file3)) {
                Log.i("MultiDex", "Invalid zip file: " + file3);
                throw new IOException("Invalid ZIP file.");
            }
        }
        return arrayList;
    }

    private static boolean a(Context context, File file, long j) {
        SharedPreferences aw = aw(context);
        return (aw.getLong("timestamp", -1L) == C(file) && aw.getLong("crc", -1L) == j) ? false : true;
    }

    private static long C(File file) {
        long lastModified = file.lastModified();
        if (lastModified == -1) {
            return lastModified - 1;
        }
        return lastModified;
    }

    private static long D(File file) throws IOException {
        long D = d.D(file);
        if (D == -1) {
            return D - 1;
        }
        return D;
    }

    private static List<File> c(File file, File file2) throws IOException {
        String str = file.getName() + ".classes";
        f(file2, str);
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i = 2;
            while (entry != null) {
                File file3 = new File(file2, str + i + ".zip");
                arrayList.add(file3);
                Log.i("MultiDex", "Extraction is needed for file " + file3);
                boolean z = false;
                int i2 = 0;
                while (i2 < 3 && !z) {
                    int i3 = i2 + 1;
                    a(zipFile, entry, file3, str);
                    boolean F = F(file3);
                    Log.i("MultiDex", "Extraction " + (F ? ImagesInvalidReceiver.SUCCESS : "failed") + " - length " + file3.getAbsolutePath() + ": " + file3.length());
                    if (!F) {
                        file3.delete();
                        if (file3.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + file3.getPath() + "'");
                            z = F;
                            i2 = i3;
                        }
                    }
                    z = F;
                    i2 = i3;
                }
                if (!z) {
                    throw new IOException("Could not create zip file " + file3.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
                int i4 = i + 1;
                entry = zipFile.getEntry("classes" + i4 + ".dex");
                i = i4;
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException e) {
                Log.w("MultiDex", "Failed to close resource", e);
            }
        }
    }

    private static void b(Context context, long j, long j2, int i) {
        SharedPreferences.Editor edit = aw(context).edit();
        edit.putLong("timestamp", j);
        edit.putLong("crc", j2);
        edit.putInt("dex.number", i);
        apply(edit);
    }

    private static SharedPreferences aw(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static void f(File file, final String str) throws IOException {
        E(file.getParentFile());
        E(file);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.i.b.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return !file2.getName().startsWith(str);
            }
        });
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
            return;
        }
        for (File file2 : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
            } else {
                Log.i("MultiDex", "Deleted old file " + file2.getPath());
            }
        }
    }

    private static void E(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create cache directory " + file.getPath());
        }
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            Log.i("MultiDex", "Renaming to " + file.getPath());
            if (!createTempFile.renameTo(file)) {
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
        } finally {
            c(inputStream);
            createTempFile.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean F(File file) {
        try {
            try {
                new ZipFile(file).close();
                return true;
            } catch (IOException e) {
                Log.w("MultiDex", "Failed to close zip file: " + file.getAbsolutePath());
                return false;
            }
        } catch (ZipException e2) {
            Log.w("MultiDex", "File " + file.getAbsolutePath() + " is not a valid zip file.", e2);
        } catch (IOException e3) {
            Log.w("MultiDex", "Got an IOException trying to open zip file: " + file.getAbsolutePath(), e3);
        }
    }

    private static void c(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    private static void apply(SharedPreferences.Editor editor) {
        if (eng != null) {
            try {
                eng.invoke(editor, new Object[0]);
                return;
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
        }
        editor.commit();
    }

    static {
        try {
            eng = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
        } catch (NoSuchMethodException e) {
            eng = null;
        }
    }
}
