package com.baidu.tbadk.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.s;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public class n implements Thread.UncaughtExceptionHandler {
    public static final String[] ahX = {"com.baidu.android.systemmonitor", "com.baidu.android.defense", "com.baidu.android.moplus", "com.baidu.android.nebula", "com.baidu.android.a."};
    public static final String[] ahY = {"com.baidu.lightapp", "com.baidu.channelrtc"};
    public static final String[] ahZ = {"cn.myhug.baobao.sdk", "com.nostra13.universalimageloader"};
    public static final String[] aia = {"com.baidu.batsdk"};
    public static final String[] aib = {"com.xiaomi.push", "com.xiaomi.channel", "com.xiaomi.common", "com.xiaomi.kenai", "com.xiaomi.measite", "com.xiaomi.mipush", "com.xiaomi.network", "com.xiaomi.smack", "com.xiaomi.xmpush"};
    private static final String aid = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private final Thread.UncaughtExceptionHandler aic = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX WARN: Removed duplicated region for block: B:128:0x0312 A[Catch: Exception -> 0x03cf, TryCatch #0 {Exception -> 0x03cf, blocks: (B:126:0x030d, B:128:0x0312, B:130:0x0317), top: B:189:0x030d }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0317 A[Catch: Exception -> 0x03cf, TRY_LEAVE, TryCatch #0 {Exception -> 0x03cf, blocks: (B:126:0x030d, B:128:0x0312, B:130:0x0317), top: B:189:0x030d }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x030d A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        byte[] s;
        FileWriter fileWriter2 = null;
        if (TbConfig.getDebugSwitch() && d(th)) {
            zN();
        }
        zO();
        if (!zP()) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    printStream = new PrintStream(byteArrayOutputStream);
                    try {
                        try {
                            th.printStackTrace(printStream);
                            String str2 = new String(byteArrayOutputStream.toByteArray());
                            if (TbConfig.getDebugSwitch()) {
                                str = TbConfig.FATAL_ERROR_DEBUG_FILE;
                            } else {
                                str = TbConfig.FATAL_ERROR_FILE;
                            }
                            File ch = s.ch(str);
                            if (ch != null && ch.length() < TbConfig.FATAL_ERROR_FILE_MAX_SIZE && str2 != null) {
                                fileWriter = new FileWriter(ch, true);
                                try {
                                    try {
                                        a(fileWriter, bf.pz(), null);
                                        a(fileWriter, "tieba_crash_new_info", null);
                                        a(fileWriter, "version", TbConfig.getVersion());
                                        a(fileWriter, "model", Build.MODEL);
                                        a(fileWriter, "android_version", Build.VERSION.RELEASE);
                                        a(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                                        a(fileWriter, "from", TbConfig.getFrom());
                                        a(fileWriter, "current_from", TbConfig.getCurrentFrom());
                                        a(fileWriter, SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                                        a(fileWriter, "client_id", TbadkCoreApplication.getClientId());
                                        a(fileWriter, "imei", TbadkCoreApplication.m255getInst().getImei());
                                        a(fileWriter, "uname", TbadkCoreApplication.getCurrentAccountName());
                                        a(fileWriter, "activity", bk.pN());
                                        a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                                        a(fileWriter, "crash_type", th.getClass().getName());
                                        StringBuilder sb = new StringBuilder();
                                        try {
                                            if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                                                Iterator<com.baidu.adp.plugin.b> it = PluginCenter.getInstance().getAllPlugins().iterator();
                                                while (it.hasNext()) {
                                                    com.baidu.adp.plugin.b next = it.next();
                                                    if (next != null) {
                                                        sb.append(next.getPackageName());
                                                        sb.append("-");
                                                        sb.append(next.gJ());
                                                        sb.append(",");
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                        }
                                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.m255getInst().getApp().getSystemService("activity")).getRunningAppProcesses();
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
                                        a(fileWriter, "error", String.valueOf(str2) + "--pluginInfo-" + sb.toString());
                                        if (str2 != null && str2.contains("java.lang.ArrayIndexOutOfBoundsException: src.length=8192 srcPos=1 dst.length=8192 dstPos=0 length=-1")) {
                                            int nextInt = new Random().nextInt(100);
                                            try {
                                                Field declaredField = thread.getClass().getDeclaredField("this$0");
                                                declaredField.setAccessible(true);
                                                Object obj = declaredField.get(thread);
                                                Field declaredField2 = obj.getClass().getDeclaredField("mFile");
                                                declaredField2.setAccessible(true);
                                                Object obj2 = declaredField2.get(obj);
                                                if (obj2 instanceof File) {
                                                    File file = (File) obj2;
                                                    if (nextInt < 5) {
                                                        if (s(file) == null) {
                                                            a(fileWriter, "--errorFile-", file.getAbsolutePath());
                                                        } else {
                                                            a(fileWriter, "--errorFile-", String.valueOf(file.getAbsolutePath()) + " - " + bf.base64Encode(s));
                                                        }
                                                    }
                                                    file.delete();
                                                }
                                            } catch (Exception e2) {
                                                if (nextInt < 5) {
                                                    a(fileWriter, "--errorFile-", e2.toString());
                                                }
                                            }
                                        }
                                        a(fileWriter, "tieba_crash_new_info_end", null);
                                        fileWriter.append("\n");
                                        fileWriter.flush();
                                        fileWriter2 = fileWriter;
                                    } catch (Exception e3) {
                                        e = e3;
                                        fileWriter2 = fileWriter;
                                        printStream2 = printStream;
                                        byteArrayOutputStream2 = byteArrayOutputStream;
                                        try {
                                            e.printStackTrace();
                                            if (printStream2 != null) {
                                                try {
                                                    printStream2.close();
                                                } catch (Exception e4) {
                                                    e4.printStackTrace();
                                                    if (!TbConfig.getDebugSwitch()) {
                                                    }
                                                    Process.killProcess(Process.myPid());
                                                    return;
                                                }
                                            }
                                            if (byteArrayOutputStream2 != null) {
                                                byteArrayOutputStream2.close();
                                            }
                                            if (fileWriter2 != null) {
                                                fileWriter2.close();
                                            }
                                            if (!TbConfig.getDebugSwitch() && this.aic != null) {
                                                this.aic.uncaughtException(thread, th);
                                                return;
                                            } else {
                                                Process.killProcess(Process.myPid());
                                                return;
                                            }
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
                                            if (!TbConfig.getDebugSwitch()) {
                                            }
                                            Process.killProcess(Process.myPid());
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (printStream != null) {
                                        try {
                                            printStream.close();
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                            if (!TbConfig.getDebugSwitch() && this.aic != null) {
                                                this.aic.uncaughtException(thread, th);
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
                                    if (!TbConfig.getDebugSwitch()) {
                                    }
                                    Process.killProcess(Process.myPid());
                                    throw th;
                                }
                            }
                            if (str2 != null) {
                                try {
                                    if (str2.contains("java.lang.SecurityException: No permission to modify given thread")) {
                                        TbadkCoreApplication.m255getInst().setWebviewCrashCount(TbadkCoreApplication.m255getInst().getWebviewCrashCount() + 1);
                                    } else if (str2.contains("com.baidu.location")) {
                                        TbadkCoreApplication.m255getInst().addBDLocCrashCount();
                                    } else if (str2.contains("Couldn't load mtprocessor-jni")) {
                                        com.baidu.adp.lib.b.f.da().d("motu_sdk", 1);
                                    }
                                    if (str2.contains("com.baidu.sapi2")) {
                                        TbadkCoreApplication.m255getInst().incPassportV6CrashCount();
                                    }
                                    if (str2.contains("com.baidu.dq")) {
                                        TbadkCoreApplication.m255getInst().incDQCrashCount();
                                    }
                                    if (str2.contains("com.baidu.sumeru.sso")) {
                                        TbadkCoreApplication.m255getInst().incSSOYihaozhidaCrashCount();
                                    }
                                    String[] strArr = ahX;
                                    int length = strArr.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= length) {
                                            break;
                                        } else if (!str2.contains(strArr[i2])) {
                                            i2++;
                                        } else {
                                            TbadkCoreApplication.m255getInst().incMoPlusCrashCount();
                                            break;
                                        }
                                    }
                                    String[] strArr2 = ahY;
                                    int length2 = strArr2.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length2) {
                                            break;
                                        } else if (!str2.contains(strArr2[i3])) {
                                            i3++;
                                        } else {
                                            TbadkCoreApplication.m255getInst().incLiveSdkCrashCount();
                                            break;
                                        }
                                    }
                                    String[] strArr3 = ahZ;
                                    int length3 = strArr3.length;
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= length3) {
                                            break;
                                        } else if (!str2.contains(strArr3[i4])) {
                                            i4++;
                                        } else {
                                            TbadkCoreApplication.m255getInst().incBaobaoCrashCount();
                                            break;
                                        }
                                    }
                                    String[] strArr4 = aia;
                                    int length4 = strArr4.length;
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= length4) {
                                            break;
                                        } else if (!str2.contains(strArr4[i5])) {
                                            i5++;
                                        } else {
                                            TbadkCoreApplication.m255getInst().incCrabSdkCrashCount();
                                            break;
                                        }
                                    }
                                    String[] strArr5 = aib;
                                    int length5 = strArr5.length;
                                    int i6 = 0;
                                    while (true) {
                                        if (i6 >= length5) {
                                            break;
                                        } else if (!str2.contains(strArr5[i6])) {
                                            i6++;
                                        } else {
                                            TbadkCoreApplication.m255getInst().incXiaomiPushSdkCrashCount();
                                            break;
                                        }
                                    }
                                    if (bk.pM() != null && bk.pM().indexOf("NewVcode") != -1) {
                                        TbadkCoreApplication.m255getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m255getInst().getNewVcodeWebviewCrashCount() + 1);
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileWriter = fileWriter2;
                                    if (printStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (fileWriter != null) {
                                    }
                                    if (!TbConfig.getDebugSwitch()) {
                                    }
                                    Process.killProcess(Process.myPid());
                                    throw th;
                                }
                            }
                            com.baidu.adp.lib.b.f.da().crash(str2);
                            if (!TextUtils.isEmpty(str2)) {
                                BdLog.e(str2);
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
                            if (fileWriter2 != null) {
                                fileWriter2.close();
                            }
                            if (TbConfig.getDebugSwitch() && this.aic != null) {
                                this.aic.uncaughtException(thread, th);
                            } else {
                                Process.killProcess(Process.myPid());
                            }
                        } catch (Exception e7) {
                            e = e7;
                            printStream2 = printStream;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileWriter = null;
                    }
                } catch (Exception e8) {
                    e = e8;
                    printStream2 = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (Throwable th6) {
                    th = th6;
                    fileWriter = null;
                    printStream = null;
                }
            } catch (Exception e9) {
                e = e9;
                printStream2 = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th7) {
                th = th7;
                fileWriter = null;
                printStream = null;
                byteArrayOutputStream = null;
            }
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
            BdLog.e(e.getMessage());
        }
    }

    public static boolean d(Throwable th) {
        if ("java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            return true;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            return d(cause);
        }
        return false;
    }

    private void zN() {
        try {
            File file = new File(aid);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(String.valueOf(aid) + System.currentTimeMillis());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private void zO() {
        int i;
        long j = 0;
        byte[] aw = com.baidu.adp.lib.util.d.aw("crash_hour_record.log");
        String str = null;
        if (aw != null) {
            str = new String(aw);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.g.c.toInt(split[0], 0);
                j = com.baidu.adp.lib.g.c.a(split[1], j2);
            }
        }
        com.baidu.adp.lib.util.d.d("crash_hour_record.log", (String.valueOf(j != j2 ? 1 : i + 1) + ":" + j2).getBytes());
    }

    private boolean zP() {
        int i;
        int i2;
        int i3 = 10;
        try {
            int i4 = com.baidu.tbadk.core.sharedPref.b.oc().getInt("crash_limit_count", 100);
            if (i4 >= 10) {
                i3 = i4;
            }
        } catch (Throwable th) {
            i3 = 100;
        }
        int pA = bf.pA();
        byte[] aw = com.baidu.adp.lib.util.d.aw("crash_upload_info.log");
        String str = null;
        if (aw != null) {
            str = new String(aw);
        }
        if (TextUtils.isEmpty(str)) {
            i = pA;
            i2 = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = pA;
                i2 = 0;
            } else {
                int i5 = com.baidu.adp.lib.g.c.toInt(split[0], 0);
                int i6 = com.baidu.adp.lib.g.c.toInt(split[1], pA);
                i2 = i5;
                i = i6;
            }
        }
        if (i != pA) {
            i2 = 0;
        }
        if (i2 > i3) {
            return true;
        }
        com.baidu.adp.lib.util.d.d("crash_upload_info.log", (String.valueOf(i2 + 1) + ":" + pA).getBytes());
        return false;
    }

    public static byte[] s(File file) {
        FileInputStream fileInputStream;
        Exception e;
        byte[] bArr;
        int read;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    bArr = new byte[(int) file.length()];
                    int i = 0;
                    while (i < bArr.length && (read = fileInputStream.read(bArr, i, bArr.length - i)) >= 0) {
                        try {
                            i += read;
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e.toString());
                            t.d(fileInputStream);
                            return bArr;
                        }
                    }
                    t.d(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    t.d(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                bArr = null;
                e = e3;
            }
        } catch (Exception e4) {
            fileInputStream = null;
            e = e4;
            bArr = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            t.d(fileInputStream);
            throw th;
        }
        return bArr;
    }
}
