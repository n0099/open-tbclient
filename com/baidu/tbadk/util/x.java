package com.baidu.tbadk.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public class x implements Thread.UncaughtExceptionHandler {
    private static final String aWL = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private final Thread.UncaughtExceptionHandler aWJ = Thread.getDefaultUncaughtExceptionHandler();
    private ExceptionData aWK = null;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String str = "";
        if (th != null && th.getStackTrace() != null && th.getStackTrace().length > 0) {
            str = th.getStackTrace()[0].toString();
        }
        if (thread.getId() == Looper.getMainLooper().getThread().getId() || StringUtils.isNull(str) || StringUtils.isNull(th.getMessage()) || !th.getMessage().contains("Results have already been set") || !str.contains("com.google.android.gms")) {
            a(thread, th, false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [136=4] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Thread thread, Throwable th, boolean z) {
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (TbConfig.getDebugSwitch() && k(th)) {
            LA();
        }
        int LB = LB();
        if (LD()) {
            return;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                printStream = new PrintStream(byteArrayOutputStream);
                try {
                    th.printStackTrace(printStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    this.aWK = new ExceptionData();
                    if (z) {
                        this.aWK.info = th.getMessage();
                    } else {
                        this.aWK.info = new String(byteArray);
                        this.aWK.mExcep = th;
                    }
                    Lz();
                    if (!z) {
                        a(thread, th);
                    }
                    com.baidu.adp.lib.b.d.hv().crash(this.aWK.info);
                    if (!TextUtils.isEmpty(this.aWK.info)) {
                        BdLog.e(this.aWK.info);
                    }
                    BdLog.e("hourCrash = " + LB);
                    if (LB >= LC()) {
                        b(thread, th);
                    }
                    com.baidu.adp.lib.util.n.b((OutputStream) printStream);
                    com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream);
                    if (z) {
                        return;
                    }
                    if (!TbConfig.getDebugSwitch() || this.aWJ == null) {
                        Process.killProcess(Process.myPid());
                    } else {
                        this.aWJ.uncaughtException(thread, th);
                    }
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    try {
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.b((OutputStream) printStream);
                        com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream2);
                        if (z) {
                            return;
                        }
                        if (!TbConfig.getDebugSwitch() || this.aWJ == null) {
                            Process.killProcess(Process.myPid());
                        } else {
                            this.aWJ.uncaughtException(thread, th);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.baidu.adp.lib.util.n.b((OutputStream) printStream);
                        com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream);
                        if (!z) {
                            if (!TbConfig.getDebugSwitch() || this.aWJ == null) {
                                Process.killProcess(Process.myPid());
                            } else {
                                this.aWJ.uncaughtException(thread, th);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.util.n.b((OutputStream) printStream);
                    com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream);
                    if (!z) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                printStream = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
            } catch (Throwable th4) {
                th = th4;
                printStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            printStream = null;
        } catch (Throwable th5) {
            th = th5;
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
            BdLog.e(e.getMessage());
        }
    }

    private void Lz() {
        if (this.aWK != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016301, this.aWK));
            if (this.aWK.appendInfo != null) {
                for (String str : this.aWK.appendInfo.keySet()) {
                    StringBuilder sb = new StringBuilder();
                    ExceptionData exceptionData = this.aWK;
                    exceptionData.info = sb.append(exceptionData.info).append("\n").append(this.aWK.appendInfo.get(str)).toString();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x027b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tbadk.core.data.ExceptionData] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Writer] */
    /* JADX WARN: Type inference failed for: r1v3 */
    private void a(Thread thread, Throwable th, String str) {
        FileWriter fileWriter;
        Exception e;
        byte[] w;
        FileWriter fileWriter2 = null;
        ?? r1 = this.aWK;
        try {
            if (r1 != 0) {
                try {
                    File ed = com.baidu.tbadk.core.util.l.ed(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str);
                    if (ed != null && ed.length() < TbConfig.FATAL_ERROR_FILE_MAX_SIZE) {
                        fileWriter = new FileWriter(ed, true);
                        try {
                            a(fileWriter, ap.zt(), (String) null);
                            a(fileWriter, "tieba_crash_new_info", (String) null);
                            a(fileWriter, "version", TbConfig.getVersion());
                            a(fileWriter, "model", Build.MODEL);
                            a(fileWriter, "android_version", Build.VERSION.RELEASE);
                            a(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                            a(fileWriter, "from", TbConfig.getFrom());
                            a(fileWriter, "current_from", TbConfig.getCurrentFrom());
                            a(fileWriter, "uid", TbadkCoreApplication.getCurrentAccount());
                            a(fileWriter, "client_id", TbadkCoreApplication.getClientId());
                            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                                a(fileWriter, "subapp_type", TbConfig.getSubappType());
                            }
                            a(fileWriter, "imei", TbadkCoreApplication.getInst().getImei());
                            a(fileWriter, "uname", TbadkCoreApplication.getCurrentAccountName());
                            a(fileWriter, PushConstants.INTENT_ACTIVITY_NAME, ax.zJ());
                            a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                            a(fileWriter, "crash_type", th.getClass().getName());
                            StringBuilder sb = new StringBuilder();
                            try {
                                if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                                    Iterator<Plugin> it = PluginCenter.getInstance().getAllPlugins().iterator();
                                    while (it.hasNext()) {
                                        Plugin next = it.next();
                                        if (next != null) {
                                            PluginSetting bD = PluginPackageManager.lN().bD(next.getPackageName());
                                            sb.append(next.getPackageName());
                                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                            sb.append(next.getCurrentPluginMode());
                                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                            if (bD != null) {
                                                sb.append(new File(bD.apkPath).exists());
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb.append(next.getVersionCode());
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb.append(bD.tempVersionCode);
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                if (bD.enable) {
                                                    sb.append("true");
                                                } else {
                                                    sb.append("false");
                                                }
                                            } else {
                                                sb.append("null");
                                            }
                                            sb.append(",");
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                            }
                            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.getInst().getApp().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
                            int myPid = Process.myPid();
                            if (runningAppProcesses != null) {
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= runningAppProcesses.size()) {
                                        break;
                                    } else if (runningAppProcesses.get(i2).pid != myPid) {
                                        i = i2 + 1;
                                    } else {
                                        a(fileWriter, "process_name", runningAppProcesses.get(i2).processName);
                                        break;
                                    }
                                }
                            }
                            a(fileWriter, "error", this.aWK.info + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.ew().eA());
                            if (this.aWK.info != null && this.aWK.info.contains("java.lang.ArrayIndexOutOfBoundsException: src.length=8192 srcPos=1 dst.length=8192 dstPos=0 length=-1")) {
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
                                            if (w(file) == null) {
                                                a(fileWriter, "--errorFile-", file.getAbsolutePath());
                                            } else {
                                                a(fileWriter, "--errorFile-", file.getAbsolutePath() + " - " + com.baidu.adp.lib.util.c.encodeBytes(w));
                                            }
                                        }
                                        file.delete();
                                    }
                                } catch (Exception e3) {
                                    if (nextInt < 5) {
                                        a(fileWriter, "--errorFile-", e3.toString());
                                    }
                                }
                            }
                            a(fileWriter, "tieba_crash_new_info_end", (String) null);
                            fileWriter.append("\n");
                            fileWriter.flush();
                            fileWriter2 = fileWriter;
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.b((Writer) fileWriter);
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.n.b((Writer) fileWriter2);
                } catch (Exception e5) {
                    fileWriter = null;
                    e = e5;
                } catch (Throwable th2) {
                    r1 = 0;
                    th = th2;
                    com.baidu.adp.lib.util.n.b((Writer) r1);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void a(Thread thread, Throwable th) {
        String str;
        if (this.aWK != null) {
            if (TbConfig.getDebugSwitch()) {
                str = TbConfig.FATAL_ERROR_DEBUG_FILE;
            } else {
                str = TbConfig.FATAL_ERROR_FILE;
            }
            a(thread, th, str);
        }
    }

    private void b(Thread thread, Throwable th) {
        BdLog.i("writeToFileForAlertLog = fatal_error_alert.log");
        a(thread, th, TbConfig.FATAL_ERROR_ALERT_FILE);
    }

    public static boolean k(Throwable th) {
        if ("java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            return true;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            return k(cause);
        }
        return false;
    }

    private void LA() {
        try {
            File file = new File(aWL);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(aWL + System.currentTimeMillis());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private int LB() {
        int i;
        long j = 0;
        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log";
        byte[] ej = com.baidu.tbadk.core.util.l.ej(str);
        String str2 = null;
        if (ej != null) {
            str2 = new String(ej);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str2)) {
            i = 0;
        } else {
            String[] split = str2.split(SystemInfoUtil.COLON);
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.g.b.g(split[0], 0);
                j = com.baidu.adp.lib.g.b.c(split[1], j2);
            }
        }
        int i2 = j != j2 ? 1 : i + 1;
        com.baidu.tbadk.core.util.l.h(str, (i2 + SystemInfoUtil.COLON + j2).getBytes());
        return i2;
    }

    private int LC() {
        return com.baidu.adp.lib.stats.switchs.a.iW().getMaxAlertCount("alert_crash", 5);
    }

    private boolean LD() {
        int i;
        int i2;
        int i3 = 10;
        try {
            int i4 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("crash_limit_count", 100);
            if (i4 >= 10) {
                i3 = i4;
            }
        } catch (Throwable th) {
            i3 = 100;
        }
        int zu = ap.zu();
        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_upload_info.log";
        byte[] ej = com.baidu.tbadk.core.util.l.ej(str);
        String str2 = null;
        if (ej != null) {
            str2 = new String(ej);
        }
        if (TextUtils.isEmpty(str2)) {
            i = zu;
            i2 = 0;
        } else {
            String[] split = str2.split(SystemInfoUtil.COLON);
            if (split == null || split.length != 2) {
                i = zu;
                i2 = 0;
            } else {
                int g = com.baidu.adp.lib.g.b.g(split[0], 0);
                int g2 = com.baidu.adp.lib.g.b.g(split[1], zu);
                i2 = g;
                i = g2;
            }
        }
        if (i != zu) {
            i2 = 0;
        }
        if (i2 > i3) {
            return true;
        }
        com.baidu.tbadk.core.util.l.h(str, ((i2 + 1) + SystemInfoUtil.COLON + zu).getBytes());
        return false;
    }

    public static byte[] w(File file) {
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
                            com.baidu.adp.lib.util.n.f(fileInputStream);
                            return bArr;
                        }
                    }
                    com.baidu.adp.lib.util.n.f(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.f(fileInputStream);
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
            com.baidu.adp.lib.util.n.f(fileInputStream);
            throw th;
        }
        return bArr;
    }
}
