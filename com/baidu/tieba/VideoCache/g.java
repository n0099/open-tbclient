package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
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
public class g implements Runnable {
    private static final String TAG = g.class.getSimpleName();
    private String mVideoUrl;

    public synchronized void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Kw();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0140, code lost:
        if (r10 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0143, code lost:
        if (r10.length == 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0145, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0147, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0148, code lost:
        if (r1 >= r10.length) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0156, code lost:
        r4 = java.lang.Long.parseLong(r10[r1].getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x017a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x017b, code lost:
        r0.printStackTrace();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x019a, code lost:
        if (a(r7.getAbsolutePath(), r10) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019c, code lost:
        r7.renameTo(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0176 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void Kw() {
        File file;
        long hp;
        File[] fileArr;
        int i;
        long j;
        long fileSize;
        long j2;
        j.log(TAG, "merge ...");
        String hv = m.hv(this.mVideoUrl);
        if (hv != null && !hv.isEmpty() && ((file = new File(i.aWB + hv + "/completed")) == null || !file.exists())) {
            File file2 = new File(i.aWB + hv + "/completed.temp");
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
            File file3 = new File(i.aWB + hv + "/segments");
            if (file3 != null && file3.exists()) {
                hp = hp(hv);
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
                                j.log(TAG, "delete file " + file4.getAbsolutePath());
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
                        j.log(TAG, "file name " + fileArr[i2].getName());
                        i2++;
                    }
                }
            }
        }
        if (j + fileSize == j2) {
        }
        int i3 = i + 1;
        fileSize = m.getFileSize(fileArr[i]);
        j2 = 0;
        if (i + 1 < fileArr.length) {
            try {
                j2 = Integer.parseInt(fileArr[i + 1].getName());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (j + fileSize == j2) {
            }
        } else if (m.getFileSize(fileArr[i]) + j == hp) {
            int i32 = i + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0057 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(String str, File[] fileArr) {
        FileChannel fileChannel;
        long j;
        long j2;
        FileChannel fileChannel2 = null;
        if (fileArr == null || fileArr.length == 0) {
            return false;
        }
        try {
            FileChannel channel = new FileOutputStream(str).getChannel();
            try {
                try {
                    j2 = 0;
                    for (File file : fileArr) {
                        try {
                            if (file != null) {
                                fileChannel2 = new FileInputStream(file.getAbsolutePath()).getChannel();
                                ByteBuffer allocate = ByteBuffer.allocate(8192);
                                while (fileChannel2.read(allocate) != -1) {
                                    allocate.flip();
                                    j = channel.write(allocate) + j2;
                                    try {
                                        allocate.clear();
                                        j2 = j;
                                    } catch (Exception e) {
                                        e = e;
                                        fileChannel = channel;
                                        try {
                                            TiebaStatic.log(new aj("c12027").aa("errormsg", "合并文件出现异常").aa("error", e.getMessage()).aa("url", this.mVideoUrl));
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
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                    j2 = j;
                                                }
                                            }
                                            j2 = j;
                                            if (j2 <= 0) {
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            if (fileChannel != null) {
                                            }
                                            if (fileChannel2 != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                }
                                continue;
                            }
                        } catch (Exception e4) {
                            j = j2;
                            e = e4;
                            fileChannel = channel;
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
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
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (fileChannel2 != null) {
                        try {
                            fileChannel2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                j = 0;
                fileChannel = channel;
            }
        } catch (Exception e10) {
            e = e10;
            j = 0;
            fileChannel = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
        return j2 <= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long hp(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        File file = new File(i.aWB + str + "/content_length");
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
