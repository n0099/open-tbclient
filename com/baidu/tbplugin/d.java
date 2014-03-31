package com.baidu.tbplugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class d {
    private InputStream a;
    private String b;

    public d(InputStream inputStream, String str) {
        this.a = inputStream;
        this.b = str;
    }

    public final void a() {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(this.a);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (nextEntry.isDirectory()) {
                        FileUtils.forceMkdir(new File(String.valueOf(this.b) + File.separator + nextEntry.getName()));
                    } else {
                        FileUtils.touch(new File(String.valueOf(this.b) + File.separator + nextEntry.getName()));
                        FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(this.b) + File.separator + nextEntry.getName());
                        IOUtils.copy(zipInputStream, fileOutputStream);
                        zipInputStream.closeEntry();
                        IOUtils.closeQuietly((OutputStream) fileOutputStream);
                    }
                } else {
                    IOUtils.closeQuietly((InputStream) zipInputStream);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Generator Error: " + e.getMessage());
        }
    }
}
