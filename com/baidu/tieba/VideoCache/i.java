package com.baidu.tieba.VideoCache;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
public class i implements Runnable {
    private static final String TAG = i.class.getSimpleName();
    private String aMC;

    public void setVideoUrl(String str) {
        this.aMC = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        JA();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ca, code lost:
        if (r12 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cd, code lost:
        if (r12.length == 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d0, code lost:
        if (r1 < r12.length) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (a(r9.getAbsolutePath(), r12) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dc, code lost:
        r9.renameTo(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0151, code lost:
        r6 = java.lang.Long.parseLong(r12[r1].getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0174, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0175, code lost:
        r0.printStackTrace();
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void JA() {
        File file;
        long gR;
        File[] fileArr;
        long j;
        long fileSize;
        long j2;
        int i = 0;
        synchronized (this) {
            m.log(TAG, "merge ...");
            String gX = q.gX(this.aMC);
            if (gX != null && !gX.isEmpty() && ((file = new File(String.valueOf(l.aNl) + gX + "/completed")) == null || !file.exists())) {
                File file2 = new File(String.valueOf(l.aNl) + gX + "/completed.temp");
                if (file2 != null && file2.exists()) {
                    file2.delete();
                }
                File file3 = new File(String.valueOf(l.aNl) + gX + "/segments");
                if (file3 != null && file3.exists()) {
                    gR = gR(gX);
                    File[] listFiles = file3.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (File file4 : listFiles) {
                            if (file4 != null && file4.exists()) {
                                try {
                                    Long.parseLong(file4.getName());
                                    arrayList.add(file4);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    file4.delete();
                                    m.log(TAG, "delete file " + file4.getAbsolutePath());
                                }
                            }
                        }
                        Collections.sort(arrayList, new k());
                        fileArr = new File[arrayList.size()];
                        int i2 = 0;
                        while (true) {
                            if (i2 >= fileArr.length) {
                                break;
                            }
                            fileArr[i2] = (File) arrayList.get(i2);
                            if (fileArr[i2] == null) {
                                break;
                            }
                            m.log(TAG, "file name " + fileArr[i2].getName());
                            i2++;
                        }
                    }
                }
            }
        }
        return;
        fileSize = q.getFileSize(fileArr[i]);
        if (i + 1 < fileArr.length) {
            try {
                j2 = Integer.parseInt(fileArr[i + 1].getName());
            } catch (Exception e2) {
                e2.printStackTrace();
                j2 = 0;
            }
            if (j + fileSize == j2) {
                return;
            }
            i++;
        } else if (q.getFileSize(fileArr[i]) + j != gR) {
            return;
        } else {
            i++;
        }
        if (j + fileSize == j2) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [156=4] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(String str, File[] fileArr) {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        long j;
        if (fileArr == null || fileArr.length == 0) {
            return false;
        }
        FileChannel fileChannel3 = null;
        FileChannel fileChannel4 = null;
        long j2 = 0;
        try {
            fileChannel2 = new FileOutputStream(str).getChannel();
            try {
                j = 0;
                fileChannel = null;
                for (File file : fileArr) {
                    try {
                        try {
                            if (file != null) {
                                fileChannel = new FileInputStream(file.getAbsolutePath()).getChannel();
                                ByteBuffer allocate = ByteBuffer.allocate(8192);
                                while (fileChannel.read(allocate) != -1) {
                                    allocate.flip();
                                    long write = fileChannel2.write(allocate) + j;
                                    try {
                                        allocate.clear();
                                        j = write;
                                    } catch (Exception e) {
                                        e = e;
                                        fileChannel4 = fileChannel;
                                        fileChannel3 = fileChannel2;
                                        j2 = write;
                                        try {
                                            e.printStackTrace();
                                            if (fileChannel3 != null) {
                                                try {
                                                    fileChannel3.close();
                                                } catch (Exception e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                            if (fileChannel4 != null) {
                                                try {
                                                    fileChannel4.close();
                                                    j = j2;
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                    j = j2;
                                                }
                                            } else {
                                                j = j2;
                                            }
                                            if (j <= 0) {
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            fileChannel = fileChannel4;
                                            fileChannel2 = fileChannel3;
                                            if (fileChannel2 != null) {
                                            }
                                            if (fileChannel != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                }
                                continue;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileChannel2 != null) {
                                try {
                                    fileChannel2.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        fileChannel3 = fileChannel2;
                        long j3 = j;
                        e = e6;
                        fileChannel4 = fileChannel;
                        j2 = j3;
                    }
                }
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
            } catch (Exception e9) {
                e = e9;
                fileChannel3 = fileChannel2;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
            }
        } catch (Exception e10) {
            e = e10;
        } catch (Throwable th4) {
            th = th4;
            fileChannel = null;
            fileChannel2 = null;
        }
        return j <= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gR(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        DataInputStream dataInputStream = null;
        File file = new File(String.valueOf(l.aNl) + str + "/content_length");
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    DataInputStream dataInputStream2 = new DataInputStream(fileInputStream);
                    try {
                        long parseLong = Long.parseLong(dataInputStream2.readLine());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (dataInputStream2 != null) {
                            try {
                                dataInputStream2.close();
                                return parseLong;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return parseLong;
                            }
                        }
                        return parseLong;
                    } catch (Exception e3) {
                        e = e3;
                        dataInputStream = dataInputStream2;
                        fileInputStream2 = fileInputStream;
                        try {
                            e.printStackTrace();
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            return 0L;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataInputStream = dataInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (dataInputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e9) {
                e = e9;
                fileInputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
            }
        }
        return 0L;
    }
}
