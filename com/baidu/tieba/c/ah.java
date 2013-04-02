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
public class ah implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;

    public ah() {
        this.a = null;
        this.a = Thread.getDefaultUncaughtExceptionHandler();
    }

    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0196 A[Catch: Exception -> 0x01bf, TryCatch #1 {Exception -> 0x01bf, blocks: (B:63:0x0191, B:65:0x0196, B:67:0x019b), top: B:98:0x0191 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019b A[Catch: Exception -> 0x01bf, TRY_LEAVE, TryCatch #1 {Exception -> 0x01bf, blocks: (B:63:0x0191, B:65:0x0196, B:67:0x019b), top: B:98:0x0191 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        FileWriter fileWriter;
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        PrintStream printStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str;
        FileWriter fileWriter2 = null;
        try {
            if (com.baidu.tieba.a.i.n()) {
                str = "fatal_error_debug.log";
            } else {
                str = "fatal_error.log";
            }
            File f = o.f(str);
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
                        String str2 = new String(byteArrayOutputStream.toByteArray());
                        if (str2 != null) {
                            fileWriter = new FileWriter(f, true);
                            try {
                                a(fileWriter, af.a(), null);
                                a(fileWriter, "tieba_crash_new_info", null);
                                a(fileWriter, "version", com.baidu.tieba.a.i.h());
                                a(fileWriter, "model", Build.MODEL);
                                a(fileWriter, "android_version", Build.VERSION.RELEASE);
                                a(fileWriter, "from", com.baidu.tieba.a.i.a());
                                a(fileWriter, "uid", TiebaApplication.y());
                                a(fileWriter, "client_id", TiebaApplication.K());
                                a(fileWriter, "imei", TiebaApplication.b().i());
                                a(fileWriter, "uname", TiebaApplication.C());
                                a(fileWriter, "activity", TiebaApplication.b().c());
                                a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TiebaApplication.b().getSystemService("activity")).getRunningAppProcesses();
                                int myPid = Process.myPid();
                                if (runningAppProcesses != null) {
                                    int i = 0;
                                    while (true) {
                                        if (i >= runningAppProcesses.size()) {
                                            break;
                                        } else if (runningAppProcesses.get(i).pid != myPid) {
                                            i++;
                                        } else {
                                            a(fileWriter, "process_name", runningAppProcesses.get(i).processName);
                                            break;
                                        }
                                    }
                                }
                                a(fileWriter, "error", str2);
                                a(fileWriter, "tieba_crash_new_info_end", null);
                                fileWriter.append("\n");
                                fileWriter.flush();
                                if (str2.contains("java.lang.SecurityException: No permission to modify given thread")) {
                                    TiebaApplication.b().j(TiebaApplication.b().ai() + 1);
                                } else if (str2.contains("com.baidu.location")) {
                                    TiebaApplication.b().ak();
                                } else if (str2.contains("Couldn't load mtprocessor-jni")) {
                                    TiebaApplication.b().e(false);
                                }
                                if (TiebaApplication.b().c() != null && TiebaApplication.b().c().indexOf("NewVcodeActivity") != -1) {
                                    TiebaApplication.b().k(TiebaApplication.b().aj() + 1);
                                }
                            } catch (Exception e) {
                                e = e;
                                fileWriter2 = fileWriter;
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
                                    if (fileWriter2 != null) {
                                        fileWriter2.close();
                                    }
                                    if (this.a == null) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    printStream = printStream2;
                                    fileWriter = fileWriter2;
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
                        printStream2 = printStream;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                    } catch (Throwable th4) {
                        th = th4;
                        fileWriter = null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    printStream2 = null;
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
            printStream2 = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            fileWriter = null;
            printStream = null;
            byteArrayOutputStream = null;
        }
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
            ag.b(getClass().getName(), "addInfo", e.getMessage());
        }
    }
}
