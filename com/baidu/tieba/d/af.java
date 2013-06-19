package com.baidu.tieba.d;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.List;
/* loaded from: classes.dex */
public class af implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX WARN: Removed duplicated region for block: B:110:0x01b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b7 A[Catch: Exception -> 0x01ef, TryCatch #0 {Exception -> 0x01ef, blocks: (B:70:0x01b2, B:72:0x01b7, B:74:0x01bc), top: B:110:0x01b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bc A[Catch: Exception -> 0x01ef, TRY_LEAVE, TryCatch #0 {Exception -> 0x01ef, blocks: (B:70:0x01b2, B:72:0x01b7, B:74:0x01bc), top: B:110:0x01b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c5  */
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
        String str2;
        FileWriter fileWriter2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                printStream = new PrintStream(byteArrayOutputStream);
                try {
                    try {
                        th.printStackTrace(printStream);
                        str = new String(byteArrayOutputStream.toByteArray());
                        if (com.baidu.tieba.a.i.s()) {
                            str2 = "fatal_error_debug.log";
                        } else {
                            str2 = "fatal_error.log";
                        }
                        File f = o.f(str2);
                        if (f != null && f.length() < 204800 && str != null) {
                            fileWriter = new FileWriter(f, true);
                            try {
                                a(fileWriter, ad.a(), null);
                                a(fileWriter, "tieba_crash_new_info", null);
                                a(fileWriter, "version", com.baidu.tieba.a.i.i());
                                a(fileWriter, "model", Build.MODEL);
                                a(fileWriter, "android_version", Build.VERSION.RELEASE);
                                a(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                                a(fileWriter, "from", com.baidu.tieba.a.i.a());
                                a(fileWriter, "uid", TiebaApplication.C());
                                a(fileWriter, "client_id", TiebaApplication.O());
                                a(fileWriter, "imei", TiebaApplication.e().l());
                                a(fileWriter, "uname", TiebaApplication.G());
                                a(fileWriter, "activity", TiebaApplication.e().f());
                                a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TiebaApplication.e().getSystemService("activity")).getRunningAppProcesses();
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
                                a(fileWriter, "error", str);
                                a(fileWriter, "tieba_crash_new_info_end", null);
                                fileWriter.append("\n");
                                fileWriter.flush();
                                if (str.contains("java.lang.SecurityException: No permission to modify given thread")) {
                                    TiebaApplication.e().l(TiebaApplication.e().at() + 1);
                                } else if (str.contains("com.baidu.location")) {
                                    TiebaApplication.e().aw();
                                } else if (str.contains("Couldn't load mtprocessor-jni")) {
                                    TiebaApplication.e().e(false);
                                }
                                if (TiebaApplication.e().f() != null && TiebaApplication.e().f().indexOf("NewVcodeActivity") != -1) {
                                    TiebaApplication.e().n(TiebaApplication.e().av() + 1);
                                }
                                fileWriter2 = fileWriter;
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
                                            if (!com.baidu.tieba.a.i.s() && this.a != null) {
                                                this.a.uncaughtException(thread, th);
                                                return;
                                            } else {
                                                Process.killProcess(Process.myPid());
                                                return;
                                            }
                                        }
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    if (fileWriter2 != null) {
                                        fileWriter2.close();
                                    }
                                    if (!com.baidu.tieba.a.i.s()) {
                                    }
                                    Process.killProcess(Process.myPid());
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    printStream = printStream2;
                                    fileWriter = fileWriter2;
                                    if (printStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (fileWriter != null) {
                                    }
                                    if (!com.baidu.tieba.a.i.s()) {
                                    }
                                    Process.killProcess(Process.myPid());
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
                                if (!com.baidu.tieba.a.i.s()) {
                                }
                                Process.killProcess(Process.myPid());
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        printStream2 = printStream;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileWriter = null;
                }
                try {
                    if (!TextUtils.isEmpty(str)) {
                        ae.a(str);
                    }
                    if (printStream != null) {
                        try {
                            printStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                    }
                    if (com.baidu.tieba.a.i.s() && this.a != null) {
                        this.a.uncaughtException(thread, th);
                    } else {
                        Process.killProcess(Process.myPid());
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileWriter = fileWriter2;
                    if (printStream != null) {
                        try {
                            printStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            if (!com.baidu.tieba.a.i.s() && this.a != null) {
                                this.a.uncaughtException(thread, th);
                            } else {
                                Process.killProcess(Process.myPid());
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
                    if (!com.baidu.tieba.a.i.s()) {
                    }
                    Process.killProcess(Process.myPid());
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                printStream2 = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
            } catch (Throwable th6) {
                th = th6;
                fileWriter = null;
                printStream = null;
            }
        } catch (Exception e7) {
            e = e7;
            printStream2 = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th7) {
            th = th7;
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
            ae.b(getClass().getName(), "addInfo", e.getMessage());
        }
    }
}
