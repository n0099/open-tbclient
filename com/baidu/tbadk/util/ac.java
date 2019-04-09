package com.baidu.tbadk.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public class ac implements Thread.UncaughtExceptionHandler {
    private static final String ctQ = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private final Thread.UncaughtExceptionHandler ctO = Thread.getDefaultUncaughtExceptionHandler();
    private ExceptionData ctP = null;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Log.e("Tieba", "Crash", th);
        String str = "";
        if (th != null && th.getStackTrace() != null && th.getStackTrace().length > 0) {
            str = th.getStackTrace()[0].toString();
        }
        if (thread.getId() == Looper.getMainLooper().getThread().getId() || StringUtils.isNull(str) || StringUtils.isNull(th.getMessage()) || !th.getMessage().contains("Results have already been set") || !str.contains("com.google.android.gms")) {
            a(thread, th, false);
        }
    }

    public static String pQ(String str) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            Process exec = Runtime.getRuntime().exec(str);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (ap.isEmpty(readLine)) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.b((Reader) bufferedReader);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.b((Reader) bufferedReader);
                    throw th;
                }
            }
            exec.destroy();
            com.baidu.adp.lib.util.n.b((Reader) bufferedReader);
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            com.baidu.adp.lib.util.n.b((Reader) bufferedReader);
            throw th;
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [143=4, 194=4] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Thread thread, Throwable th, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        PrintStream printStream;
        PrintStream printStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        PrintStream printStream3 = null;
        if (TbConfig.getDebugSwitch() && l(th)) {
            aqo();
        }
        if (l(th)) {
            try {
                Exception exc = new Exception(((th.getMessage() + pQ("cat proc/" + Process.myPid() + "/status")) + "\n===========================\n") + pQ("cat proc/" + Process.myPid() + "/maps"));
                this.ctP = new ExceptionData();
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    printStream = new PrintStream(byteArrayOutputStream);
                    try {
                        exc.printStackTrace(printStream);
                        this.ctP.info = new String(byteArrayOutputStream.toByteArray());
                        this.ctP.mExcep = exc;
                        a(thread, exc);
                        this.ctP = null;
                        com.baidu.adp.lib.util.n.b((OutputStream) printStream);
                        com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream);
                    } catch (Exception e) {
                        com.baidu.adp.lib.util.n.b((OutputStream) printStream);
                        com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream);
                        int aqp = aqp();
                        if (!aqr()) {
                        }
                    } catch (Throwable th2) {
                        printStream3 = printStream;
                        th = th2;
                        com.baidu.adp.lib.util.n.b((OutputStream) printStream3);
                        com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    printStream = null;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e3) {
                printStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
        }
        int aqp2 = aqp();
        if (!aqr()) {
            return;
        }
        try {
            byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                printStream2 = new PrintStream(byteArrayOutputStream2);
                try {
                    th.printStackTrace(printStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    this.ctP = new ExceptionData();
                    if (z) {
                        this.ctP.info = th.getMessage();
                    } else {
                        this.ctP.info = new String(byteArray);
                        this.ctP.mExcep = th;
                    }
                    aqn();
                    if (!z) {
                        a(thread, th);
                    }
                    com.baidu.adp.lib.b.d.iQ().crash(this.ctP.info);
                    if (!TextUtils.isEmpty(this.ctP.info)) {
                        BdLog.e(this.ctP.info);
                    }
                    BdLog.e("hourCrash = " + aqp2);
                    if (aqp2 >= aqq()) {
                        b(thread, th);
                    }
                    com.baidu.adp.lib.util.n.b((OutputStream) printStream2);
                    com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream2);
                    if (z) {
                        return;
                    }
                    if (!TbConfig.getDebugSwitch() || this.ctO == null) {
                        Process.killProcess(Process.myPid());
                    } else {
                        this.ctO.uncaughtException(thread, th);
                    }
                } catch (Exception e4) {
                    e = e4;
                    printStream3 = printStream2;
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    try {
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.b((OutputStream) printStream3);
                        com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream3);
                        if (z) {
                            return;
                        }
                        if (!TbConfig.getDebugSwitch() || this.ctO == null) {
                            Process.killProcess(Process.myPid());
                        } else {
                            this.ctO.uncaughtException(thread, th);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayOutputStream2 = byteArrayOutputStream3;
                        printStream2 = printStream3;
                        com.baidu.adp.lib.util.n.b((OutputStream) printStream2);
                        com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream2);
                        if (!z) {
                            if (!TbConfig.getDebugSwitch() || this.ctO == null) {
                                Process.killProcess(Process.myPid());
                            } else {
                                this.ctO.uncaughtException(thread, th);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    com.baidu.adp.lib.util.n.b((OutputStream) printStream2);
                    com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream2);
                    if (!z) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                byteArrayOutputStream3 = byteArrayOutputStream2;
            } catch (Throwable th7) {
                th = th7;
                printStream2 = null;
            }
        } catch (Exception e6) {
            e = e6;
            byteArrayOutputStream3 = null;
        } catch (Throwable th8) {
            th = th8;
            printStream2 = null;
            byteArrayOutputStream2 = null;
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

    private void aqn() {
        if (this.ctP != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016301, this.ctP));
            if (this.ctP.appendInfo != null) {
                for (String str : this.ctP.appendInfo.keySet()) {
                    StringBuilder sb = new StringBuilder();
                    ExceptionData exceptionData = this.ctP;
                    exceptionData.info = sb.append(exceptionData.info).append("\n").append(this.ctP.appendInfo.get(str)).toString();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x01b2, code lost:
        if (r10.ctP.info.contains("java.lang.NoClassDefFoundError") != false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0265 A[Catch: all -> 0x0362, Exception -> 0x03bb, LOOP:2: B:50:0x0265->B:85:0x0382, LOOP_START, PHI: r2 
      PHI: (r2v22 int) = (r2v0 int), (r2v23 int) binds: [B:49:0x0263, B:85:0x0382] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0362, blocks: (B:10:0x0044, B:12:0x00ab, B:13:0x00b5, B:14:0x00fc, B:16:0x0102, B:18:0x010c, B:19:0x0118, B:21:0x011e, B:23:0x0126, B:25:0x014e, B:27:0x017e, B:28:0x0184, B:74:0x035a, B:79:0x0367, B:31:0x018c, B:32:0x0194, B:34:0x019a, B:36:0x01a7, B:38:0x01b4, B:40:0x01be, B:41:0x01e4, B:43:0x01ea, B:45:0x01f2, B:82:0x0375, B:48:0x024a, B:50:0x0265, B:52:0x026b, B:54:0x0275, B:55:0x0283, B:57:0x02b8, B:58:0x02df, B:60:0x02eb, B:62:0x02f8, B:63:0x0303, B:65:0x032d, B:67:0x0331, B:69:0x0337, B:86:0x0386, B:70:0x0341, B:90:0x03b0, B:71:0x0344, B:81:0x036f, B:93:0x03bc), top: B:102:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02b8 A[Catch: all -> 0x0362, Exception -> 0x03bb, TryCatch #0 {all -> 0x0362, blocks: (B:10:0x0044, B:12:0x00ab, B:13:0x00b5, B:14:0x00fc, B:16:0x0102, B:18:0x010c, B:19:0x0118, B:21:0x011e, B:23:0x0126, B:25:0x014e, B:27:0x017e, B:28:0x0184, B:74:0x035a, B:79:0x0367, B:31:0x018c, B:32:0x0194, B:34:0x019a, B:36:0x01a7, B:38:0x01b4, B:40:0x01be, B:41:0x01e4, B:43:0x01ea, B:45:0x01f2, B:82:0x0375, B:48:0x024a, B:50:0x0265, B:52:0x026b, B:54:0x0275, B:55:0x0283, B:57:0x02b8, B:58:0x02df, B:60:0x02eb, B:62:0x02f8, B:63:0x0303, B:65:0x032d, B:67:0x0331, B:69:0x0337, B:86:0x0386, B:70:0x0341, B:90:0x03b0, B:71:0x0344, B:81:0x036f, B:93:0x03bc), top: B:102:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x032d A[Catch: all -> 0x0362, Exception -> 0x03ad, TryCatch #0 {all -> 0x0362, blocks: (B:10:0x0044, B:12:0x00ab, B:13:0x00b5, B:14:0x00fc, B:16:0x0102, B:18:0x010c, B:19:0x0118, B:21:0x011e, B:23:0x0126, B:25:0x014e, B:27:0x017e, B:28:0x0184, B:74:0x035a, B:79:0x0367, B:31:0x018c, B:32:0x0194, B:34:0x019a, B:36:0x01a7, B:38:0x01b4, B:40:0x01be, B:41:0x01e4, B:43:0x01ea, B:45:0x01f2, B:82:0x0375, B:48:0x024a, B:50:0x0265, B:52:0x026b, B:54:0x0275, B:55:0x0283, B:57:0x02b8, B:58:0x02df, B:60:0x02eb, B:62:0x02f8, B:63:0x0303, B:65:0x032d, B:67:0x0331, B:69:0x0337, B:86:0x0386, B:70:0x0341, B:90:0x03b0, B:71:0x0344, B:81:0x036f, B:93:0x03bc), top: B:102:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Thread thread, Throwable th, String str) {
        FileWriter fileWriter;
        Exception e;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object obj;
        byte[] M;
        String str2;
        boolean z;
        int i = 0;
        FileWriter fileWriter2 = null;
        boolean z2 = true;
        try {
            if (this.ctP != null) {
                try {
                    File ma = com.baidu.tbadk.core.util.m.ma(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str);
                    if (ma != null && ma.length() < TbConfig.FATAL_ERROR_FILE_MAX_SIZE) {
                        fileWriter = new FileWriter(ma, true);
                        try {
                            a(fileWriter, ap.adj(), (String) null);
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
                            a(fileWriter, PushConstants.INTENT_ACTIVITY_NAME, ay.adz());
                            a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                            a(fileWriter, "crash_type", th.getClass().getName());
                            StringBuilder sb = new StringBuilder();
                            try {
                                if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                                    Iterator<Plugin> it = PluginCenter.getInstance().getAllPlugins().iterator();
                                    while (it.hasNext()) {
                                        Plugin next = it.next();
                                        if (next != null) {
                                            PluginSetting bU = PluginPackageManager.ni().bU(next.getPackageName());
                                            sb.append(next.getPackageName());
                                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                            sb.append(next.getCurrentPluginMode());
                                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                            if (bU != null) {
                                                sb.append(new File(bU.apkPath).exists());
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb.append(next.getVersionCode());
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb.append(bU.tempVersionCode);
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                if (bU.enable) {
                                                    sb.append("true");
                                                } else {
                                                    sb.append("false");
                                                }
                                            } else {
                                                sb.append("null");
                                            }
                                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                            }
                            StringBuilder sb2 = new StringBuilder();
                            String str3 = "";
                            try {
                            } catch (Exception e3) {
                                z2 = false;
                            }
                            if (this.ctP.info != null) {
                                if (!this.ctP.info.contains("java.lang.ClassNotFoundException")) {
                                }
                                try {
                                    PluginSettings nI = com.baidu.adp.plugin.packageManager.pluginSettings.c.nL().nI();
                                    if (nI != null) {
                                        sb2.append(nI.getContainerVersion());
                                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                        sb2.append(nI.getForbiddenFeatures());
                                        sb2.append("#");
                                        for (PluginSetting pluginSetting : nI.getPlugins().values()) {
                                            if (pluginSetting != null) {
                                                sb2.append(pluginSetting.packageName);
                                                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb2.append(pluginSetting.versionCode);
                                                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb2.append(pluginSetting.tempVersionCode);
                                                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb2.append(pluginSetting.enable);
                                                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb2.append(pluginSetting.forbidden);
                                                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb2.append(pluginSetting.installStatus);
                                                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb2.append(new File(pluginSetting.apkPath).exists());
                                                sb2.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                                            }
                                        }
                                    } else {
                                        sb2.append("pluginSettings_is_null");
                                    }
                                    str2 = com.baidu.adp.plugin.b.b.mV().toString();
                                    z = true;
                                    z2 = z;
                                    str3 = str2;
                                } catch (Exception e4) {
                                }
                                runningAppProcesses = ((ActivityManager) TbadkCoreApplication.getInst().getApp().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
                                int myPid = Process.myPid();
                                if (runningAppProcesses != null) {
                                    while (true) {
                                        if (i < runningAppProcesses.size()) {
                                            if (runningAppProcesses.get(i).pid != myPid) {
                                                i++;
                                            } else {
                                                a(fileWriter, "process_name", runningAppProcesses.get(i).processName);
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                String str4 = this.ctP.info + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.fT().fX();
                                if (z2) {
                                    str4 = str4 + "\n--PluginSettings--" + sb2.toString() + "\n--PluginTrace--" + str3;
                                }
                                a(fileWriter, "error", str4);
                                if (this.ctP.info != null && this.ctP.info.contains("java.lang.ArrayIndexOutOfBoundsException: src.length=8192 srcPos=1 dst.length=8192 dstPos=0 length=-1")) {
                                    int nextInt = new Random().nextInt(100);
                                    try {
                                        Field declaredField = thread.getClass().getDeclaredField("this$0");
                                        declaredField.setAccessible(true);
                                        Object obj2 = declaredField.get(thread);
                                        Field declaredField2 = obj2.getClass().getDeclaredField("mFile");
                                        declaredField2.setAccessible(true);
                                        obj = declaredField2.get(obj2);
                                        if (obj instanceof File) {
                                            File file = (File) obj;
                                            if (nextInt < 5) {
                                                if (M(file) == null) {
                                                    a(fileWriter, "--errorFile-", file.getAbsolutePath());
                                                } else {
                                                    a(fileWriter, "--errorFile-", file.getAbsolutePath() + " - " + com.baidu.adp.lib.util.c.encodeBytes(M));
                                                }
                                            }
                                            file.delete();
                                        }
                                    } catch (Exception e5) {
                                        if (nextInt < 5) {
                                            a(fileWriter, "--errorFile-", e5.toString());
                                        }
                                    }
                                }
                                a(fileWriter, "tieba_crash_new_info_end", (String) null);
                                fileWriter.append("\n");
                                fileWriter.flush();
                                fileWriter2 = fileWriter;
                            }
                            str2 = "";
                            z = false;
                            z2 = z;
                            str3 = str2;
                            runningAppProcesses = ((ActivityManager) TbadkCoreApplication.getInst().getApp().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
                            int myPid2 = Process.myPid();
                            if (runningAppProcesses != null) {
                            }
                            String str42 = this.ctP.info + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.fT().fX();
                            if (z2) {
                            }
                            a(fileWriter, "error", str42);
                            if (this.ctP.info != null) {
                                int nextInt2 = new Random().nextInt(100);
                                Field declaredField3 = thread.getClass().getDeclaredField("this$0");
                                declaredField3.setAccessible(true);
                                Object obj22 = declaredField3.get(thread);
                                Field declaredField22 = obj22.getClass().getDeclaredField("mFile");
                                declaredField22.setAccessible(true);
                                obj = declaredField22.get(obj22);
                                if (obj instanceof File) {
                                }
                            }
                            a(fileWriter, "tieba_crash_new_info_end", (String) null);
                            fileWriter.append("\n");
                            fileWriter.flush();
                            fileWriter2 = fileWriter;
                        } catch (Exception e6) {
                            e = e6;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.b((Writer) fileWriter);
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.n.b((Writer) fileWriter2);
                } catch (Exception e7) {
                    fileWriter = null;
                    e = e7;
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.util.n.b((Writer) null);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void a(Thread thread, Throwable th) {
        String str;
        if (this.ctP != null) {
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

    public static boolean l(Throwable th) {
        if ("java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            return true;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            return l(cause);
        }
        return false;
    }

    private void aqo() {
        try {
            File file = new File(ctQ);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(ctQ + System.currentTimeMillis());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private int aqp() {
        int i;
        long j = 0;
        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log";
        byte[] mh = com.baidu.tbadk.core.util.m.mh(str);
        String str2 = null;
        if (mh != null) {
            str2 = new String(mh);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str2)) {
            i = 0;
        } else {
            String[] split = str2.split(Config.TRACE_TODAY_VISIT_SPLIT);
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.g.b.l(split[0], 0);
                j = com.baidu.adp.lib.g.b.d(split[1], j2);
            }
        }
        int i2 = j != j2 ? 1 : i + 1;
        com.baidu.tbadk.core.util.m.g(str, (i2 + Config.TRACE_TODAY_VISIT_SPLIT + j2).getBytes());
        return i2;
    }

    private int aqq() {
        return com.baidu.adp.lib.stats.switchs.a.kq().getMaxAlertCount("alert_crash", 5);
    }

    private boolean aqr() {
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
        int adk = ap.adk();
        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_upload_info.log";
        byte[] mh = com.baidu.tbadk.core.util.m.mh(str);
        String str2 = null;
        if (mh != null) {
            str2 = new String(mh);
        }
        if (TextUtils.isEmpty(str2)) {
            i = adk;
            i2 = 0;
        } else {
            String[] split = str2.split(Config.TRACE_TODAY_VISIT_SPLIT);
            if (split == null || split.length != 2) {
                i = adk;
                i2 = 0;
            } else {
                int l = com.baidu.adp.lib.g.b.l(split[0], 0);
                int l2 = com.baidu.adp.lib.g.b.l(split[1], adk);
                i2 = l;
                i = l2;
            }
        }
        if (i != adk) {
            i2 = 0;
        }
        if (i2 > i3) {
            return true;
        }
        com.baidu.tbadk.core.util.m.g(str, ((i2 + 1) + Config.TRACE_TODAY_VISIT_SPLIT + adk).getBytes());
        return false;
    }

    public static byte[] M(File file) {
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
                            com.baidu.adp.lib.util.n.i(fileInputStream);
                            return bArr;
                        }
                    }
                    com.baidu.adp.lib.util.n.i(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.i(fileInputStream);
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
            com.baidu.adp.lib.util.n.i(fileInputStream);
            throw th;
        }
        return bArr;
    }
}
