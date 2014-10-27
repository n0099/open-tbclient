package com.baidu.tbadk.pluginArch;

import com.baidu.adp.lib.util.commonsio.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class Decompress {
    private String mLocation;
    private InputStream mZipFile;

    public Decompress(InputStream inputStream, String str) {
        this.mZipFile = inputStream;
        this.mLocation = str;
    }

    public void unzip() {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(this.mZipFile);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (!nextEntry.isDirectory()) {
                        byte[] bArr = new byte[1024];
                        File file = new File(String.valueOf(this.mLocation) + File.separator + nextEntry.getName());
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                            file.createNewFile();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read != -1 && read != 0) {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        fileOutputStream.close();
                        zipInputStream.closeEntry();
                    } else {
                        File file2 = new File(String.valueOf(this.mLocation) + File.separator + nextEntry.getName());
                        if (!file2.exists()) {
                            a.i(file2);
                        }
                    }
                } else {
                    zipInputStream.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
