package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes2.dex */
public class h implements Runnable {
    private static final String TAG = h.class.getSimpleName();
    private String mVideoUrl;

    public synchronized void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        KR();
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
    private synchronized void KR() {
        File file;
        long gM;
        File[] fileArr;
        long j;
        long fileSize;
        long j2;
        int i = 0;
        synchronized (this) {
            k.log(TAG, "merge ...");
            String gS = o.gS(this.mVideoUrl);
            if (gS != null && !gS.isEmpty() && ((file = new File(String.valueOf(j.aVr) + gS + "/completed")) == null || !file.exists())) {
                File file2 = new File(String.valueOf(j.aVr) + gS + "/completed.temp");
                if (file2 != null && file2.exists()) {
                    file2.delete();
                }
                File file3 = new File(String.valueOf(j.aVr) + gS + "/segments");
                if (file3 != null && file3.exists()) {
                    gM = gM(gS);
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
                                    k.log(TAG, "delete file " + file4.getAbsolutePath());
                                }
                            }
                        }
                        Collections.sort(arrayList, new StartPositionComparator());
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
                            k.log(TAG, "file name " + fileArr[i2].getName());
                            i2++;
                        }
                    }
                }
            }
        }
        return;
        fileSize = o.getFileSize(fileArr[i]);
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
        } else if (o.getFileSize(fileArr[i]) + j != gM) {
            return;
        } else {
            i++;
        }
        if (j + fileSize == j2) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [163=4] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bf A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(String str, File[] fileArr) {
        long j;
        if (fileArr == null || fileArr.length == 0) {
            return false;
        }
        FileChannel fileChannel = null;
        FileChannel fileChannel2 = null;
        long j2 = 0;
        try {
            try {
                FileChannel channel = new FileOutputStream(str).getChannel();
                try {
                    j = 0;
                    FileChannel fileChannel3 = null;
                    for (File file : fileArr) {
                        try {
                            try {
                                if (file != null) {
                                    fileChannel3 = new FileInputStream(file.getAbsolutePath()).getChannel();
                                    ByteBuffer allocate = ByteBuffer.allocate(8192);
                                    while (fileChannel3.read(allocate) != -1) {
                                        allocate.flip();
                                        long write = channel.write(allocate) + j;
                                        try {
                                            allocate.clear();
                                            j = write;
                                        } catch (Exception e) {
                                            e = e;
                                            fileChannel2 = fileChannel3;
                                            fileChannel = channel;
                                            j2 = write;
                                            TiebaStatic.log(new as("c12027").aa("errormsg", "合并文件出现异常").aa("error", e.getMessage()).aa("url", this.mVideoUrl));
                                            e.printStackTrace();
                                            if (fileChannel != null) {
                                                try {
                                                    fileChannel.close();
                                                } catch (Exception e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                            if (fileChannel2 != null) {
                                                try {
                                                    fileChannel2.close();
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
                                        }
                                    }
                                    continue;
                                }
                            } catch (Exception e4) {
                                fileChannel = channel;
                                long j3 = j;
                                e = e4;
                                fileChannel2 = fileChannel3;
                                j2 = j3;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileChannel2 = fileChannel3;
                            fileChannel = channel;
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (fileChannel2 != null) {
                                try {
                                    fileChannel2.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (fileChannel3 != null) {
                        try {
                            fileChannel3.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                } catch (Exception e9) {
                    e = e9;
                    fileChannel = channel;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                }
            } catch (Exception e10) {
                e = e10;
            }
            return j <= 0;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long gM(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        DataInputStream dataInputStream = null;
        File file = new File(String.valueOf(j.aVr) + str + "/content_length");
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
