package com.baidu.tieba.VideoCache;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes6.dex */
public class g implements Runnable {
    private static final String TAG = g.class.getSimpleName();
    private String mVideoUrl;

    public synchronized void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        aUv();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0144, code lost:
        if (r13 == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0147, code lost:
        if (r13.length == 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0149, code lost:
        r8 = 0;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014f, code lost:
        if (r8 >= r13.length) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x015d, code lost:
        r6 = java.lang.Long.parseLong(r13[r8].getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0184, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0185, code lost:
        r2.printStackTrace();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x019f, code lost:
        if (r10 == r14) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01a1, code lost:
        com.baidu.tbadk.core.util.TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12027").cp("errormsg", "准备合并文件时文件片段错误").cp("url", r18.mVideoUrl));
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01cd, code lost:
        if (a(r12.getAbsolutePath(), r13) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01cf, code lost:
        r12.renameTo(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0180 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void aUv() {
        File file;
        long vY;
        File[] fileArr;
        int i;
        long j;
        long fileSize;
        long j2;
        j.aJ(TAG, "merge ...");
        String we = m.we(this.mVideoUrl);
        if (we != null && !we.isEmpty() && ((file = new File(i.dSQ + we + "/completed")) == null || !file.exists())) {
            File file2 = new File(i.dSQ + we + "/completed.temp");
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
            File file3 = new File(i.dSQ + we + "/segments");
            if (file3 != null && file3.exists()) {
                vY = vY(we);
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
                                j.aJ(TAG, "delete file " + file4.getAbsolutePath());
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
                        j.aJ(TAG, "file name " + fileArr[i2].getName());
                        i2++;
                    }
                }
            }
        }
        if (j + fileSize == j2) {
        }
        i++;
        fileSize = m.getFileSize(fileArr[i]);
        long j3 = j3 + fileSize;
        if (i + 1 < fileArr.length) {
            try {
                j2 = Integer.parseInt(fileArr[i + 1].getName());
            } catch (Exception e2) {
                e2.printStackTrace();
                j2 = 0;
            }
            if (j + fileSize == j2) {
            }
        } else if (m.getFileSize(fileArr[i]) + j == vY) {
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0084 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(String str, File[] fileArr) {
        FileChannel fileChannel;
        long j;
        FileChannel fileChannel2 = null;
        if (fileArr == null || fileArr.length == 0) {
            return false;
        }
        try {
            FileChannel channel = new FileOutputStream(str).getChannel();
            try {
                j = 0;
                for (File file : fileArr) {
                    if (file != null) {
                        fileChannel2 = new FileInputStream(file.getAbsolutePath()).getChannel();
                        ByteBuffer allocate = ByteBuffer.allocate(8192);
                        while (fileChannel2.read(allocate) != -1) {
                            allocate.flip();
                            j += channel.write(allocate);
                            allocate.clear();
                        }
                    }
                }
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileChannel = channel;
                try {
                    TiebaStatic.log(new an("c12027").cp("errormsg", "合并文件出现异常").cp(BdStatsConstant.StatsType.ERROR, e.getMessage()).cp("url", this.mVideoUrl));
                    e.printStackTrace();
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (fileChannel2 != null) {
                        try {
                            fileChannel2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            j = 0;
                        }
                    }
                    j = 0;
                    if (j <= 0) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileChannel2 != null) {
                        try {
                            fileChannel2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel = channel;
                if (fileChannel != null) {
                }
                if (fileChannel2 != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            fileChannel = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
        return j <= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long vY(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        File file = new File(i.dSQ + str + "/content_length");
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    dataInputStream = new DataInputStream(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            try {
                long parseLong = Long.parseLong(dataInputStream.readLine());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                        return parseLong;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return parseLong;
                    }
                }
                return parseLong;
            } catch (Exception e5) {
                e = e5;
                dataInputStream2 = dataInputStream;
                fileInputStream2 = fileInputStream;
                try {
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    return 0L;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                dataInputStream2 = dataInputStream;
                if (fileInputStream != null) {
                }
                if (dataInputStream2 != null) {
                }
                throw th;
            }
        }
        return 0L;
    }
}
