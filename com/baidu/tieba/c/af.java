package com.baidu.tieba.c;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Process;
import com.baidu.tieba.TiebaApplication;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.List;
/* loaded from: classes.dex */
public class af implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;

    public af() {
        this.a = null;
        this.a = Thread.getDefaultUncaughtExceptionHandler();
    }

    private void a(FileWriter fileWriter, String str, String str2) {
        try {
            fileWriter.append((CharSequence) str);
            if (str2 != null) {
                fileWriter.append("=");
                fileWriter.append((CharSequence) str2);
            }
            fileWriter.append("\n");
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014f A[Catch: Exception -> 0x0166, TryCatch #7 {Exception -> 0x0166, blocks: (B:53:0x014a, B:55:0x014f, B:57:0x0154), top: B:86:0x014a }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0154 A[Catch: Exception -> 0x0166, TRY_LEAVE, TryCatch #7 {Exception -> 0x0166, blocks: (B:53:0x014a, B:55:0x014f, B:57:0x0154), top: B:86:0x014a }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        FileWriter fileWriter;
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        PrintStream printStream2 = null;
        try {
            File f = o.f("fatal_error.log");
            if (f == null || f.length() >= 204800) {
                fileWriter = null;
                printStream = null;
                byteArrayOutputStream = null;
            } else {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    printStream = new PrintStream(byteArrayOutputStream);
                    try {
                        th.printStackTrace(printStream);
                        String str = new String(byteArrayOutputStream.toByteArray());
                        byte[] bArr = null;
                        if (str != null) {
                            fileWriter = new FileWriter(f, true);
                            try {
                                a(fileWriter, ad.a(), null);
                                a(fileWriter, "tieba_crash_new_info", null);
                                a(fileWriter, "version", com.baidu.tieba.a.h.h());
                                a(fileWriter, "model", Build.MODEL);
                                a(fileWriter, "android_version", Build.VERSION.RELEASE);
                                a(fileWriter, "from", com.baidu.tieba.a.h.a());
                                a(fileWriter, "uid", TiebaApplication.u());
                                a(fileWriter, "client_id", TiebaApplication.E());
                                a(fileWriter, "imei", TiebaApplication.a().g());
                                a(fileWriter, "uname", TiebaApplication.x());
                                a(fileWriter, "activity", TiebaApplication.a().b());
                                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TiebaApplication.a().getSystemService("activity")).getRunningAppProcesses();
                                int myPid = Process.myPid();
                                if (runningAppProcesses != null) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= runningAppProcesses.size()) {
                                            break;
                                        } else if (runningAppProcesses.get(i2).pid == myPid) {
                                            a(fileWriter, "process_name", runningAppProcesses.get(i2).processName);
                                            break;
                                        } else {
                                            i = i2 + 1;
                                        }
                                    }
                                }
                                a(fileWriter, "error", str);
                                a(fileWriter, "tieba_crash_new_info_end", null);
                                fileWriter.append("\n");
                                fileWriter.flush();
                                if (str.contains("java.lang.SecurityException: No permission to modify given thread")) {
                                    TiebaApplication.a().h(TiebaApplication.a().ad() + 1);
                                } else if (str.contains("com.baidu.location")) {
                                    TiebaApplication.a().ae();
                                }
                            } catch (Exception e) {
                                e = e;
                                printStream2 = printStream;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    e.printStackTrace();
                                    if (printStream2 != null) {
                                        try {
                                            printStream2.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                            if (this.a == null) {
                                                this.a.uncaughtException(thread, th);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    if (fileWriter != null) {
                                        fileWriter.close();
                                    }
                                    if (this.a == null) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    printStream = printStream2;
                                    if (printStream != null) {
                                        try {
                                            printStream.close();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                            if (this.a != null) {
                                                this.a.uncaughtException(thread, th);
                                            }
                                            throw th;
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    if (fileWriter != null) {
                                        fileWriter.close();
                                    }
                                    if (this.a != null) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (printStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                if (fileWriter != null) {
                                }
                                if (this.a != null) {
                                }
                                throw th;
                            }
                        } else {
                            fileWriter = null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileWriter = null;
                        printStream2 = printStream;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                    } catch (Throwable th4) {
                        th = th4;
                        fileWriter = null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileWriter = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (Throwable th5) {
                    th = th5;
                    fileWriter = null;
                    printStream = null;
                }
            }
            if (printStream != null) {
                try {
                    printStream.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
            if (this.a != null) {
                this.a.uncaughtException(thread, th);
            }
        } catch (Exception e7) {
            e = e7;
            fileWriter = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            fileWriter = null;
            printStream = null;
            byteArrayOutputStream = null;
        }
    }
}
