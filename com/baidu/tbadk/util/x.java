package com.baidu.tbadk.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.at;
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
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes.dex */
public class x implements Thread.UncaughtExceptionHandler {
    private static final String bBz = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private final Thread.UncaughtExceptionHandler bBx = Thread.getDefaultUncaughtExceptionHandler();
    private ExceptionData bBy = null;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [121=4] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Thread thread, Throwable th, boolean z) {
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (TbConfig.getDebugSwitch() && g(th)) {
            OM();
        }
        int ON = ON();
        if (OP()) {
            return;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                printStream = new PrintStream(byteArrayOutputStream);
                try {
                    th.printStackTrace(printStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    this.bBy = new ExceptionData();
                    if (z) {
                        this.bBy.info = th.getMessage();
                    } else {
                        this.bBy.info = new String(byteArray);
                        this.bBy.mExcep = th;
                    }
                    OL();
                    if (!z) {
                        a(thread, th);
                    }
                    com.baidu.adp.lib.b.d.mA().crash(this.bBy.info);
                    if (!TextUtils.isEmpty(this.bBy.info)) {
                        BdLog.e(this.bBy.info);
                    }
                    BdLog.e("hourCrash = " + ON);
                    if (ON >= OO()) {
                        b(thread, th);
                    }
                    com.baidu.adp.lib.util.n.b((OutputStream) printStream);
                    com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream);
                    if (z) {
                        return;
                    }
                    if (!TbConfig.getDebugSwitch() || this.bBx == null) {
                        Process.killProcess(Process.myPid());
                    } else {
                        this.bBx.uncaughtException(thread, th);
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
                        if (!TbConfig.getDebugSwitch() || this.bBx == null) {
                            Process.killProcess(Process.myPid());
                        } else {
                            this.bBx.uncaughtException(thread, th);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.baidu.adp.lib.util.n.b((OutputStream) printStream);
                        com.baidu.adp.lib.util.n.b((OutputStream) byteArrayOutputStream);
                        if (!z) {
                            if (!TbConfig.getDebugSwitch() || this.bBx == null) {
                                Process.killProcess(Process.myPid());
                            } else {
                                this.bBx.uncaughtException(thread, th);
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

    private void OL() {
        if (this.bBy != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UEXCEPTION_MESSAGE, this.bBy));
            if (this.bBy.appendInfo != null) {
                for (String str : this.bBy.appendInfo.keySet()) {
                    StringBuilder sb = new StringBuilder();
                    ExceptionData exceptionData = this.bBy;
                    exceptionData.info = sb.append(exceptionData.info).append("\n").append(this.bBy.appendInfo.get(str)).toString();
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
        byte[] x;
        FileWriter fileWriter2 = null;
        ?? r1 = this.bBy;
        try {
            if (r1 != 0) {
                try {
                    File dA = com.baidu.tbadk.core.util.k.dA(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str);
                    if (dA != null && dA.length() < TbConfig.FATAL_ERROR_FILE_MAX_SIZE) {
                        fileWriter = new FileWriter(dA, true);
                        try {
                            a(fileWriter, am.CI(), (String) null);
                            a(fileWriter, "tieba_crash_new_info", (String) null);
                            a(fileWriter, ClientCookie.VERSION_ATTR, TbConfig.getVersion());
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
                            a(fileWriter, PushConstants.INTENT_ACTIVITY_NAME, at.CX());
                            a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                            a(fileWriter, "crash_type", th.getClass().getName());
                            StringBuilder sb = new StringBuilder();
                            try {
                                if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                                    Iterator<Plugin> it = PluginCenter.getInstance().getAllPlugins().iterator();
                                    while (it.hasNext()) {
                                        Plugin next = it.next();
                                        if (next != null) {
                                            PluginSetting br = PluginPackageManager.qS().br(next.getPackageName());
                                            sb.append(next.getPackageName());
                                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                            sb.append(next.getCurrentPluginMode());
                                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                            if (br != null) {
                                                sb.append(new File(br.apkPath).exists());
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb.append(next.getVersionCode());
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                sb.append(br.tempVersionCode);
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                if (br.enable) {
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
                            a(fileWriter, "error", this.bBy.info + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.jF().jJ());
                            if (this.bBy.info != null && this.bBy.info.contains("java.lang.ArrayIndexOutOfBoundsException: src.length=8192 srcPos=1 dst.length=8192 dstPos=0 length=-1")) {
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
                                            if (x(file) == null) {
                                                a(fileWriter, "--errorFile-", file.getAbsolutePath());
                                            } else {
                                                a(fileWriter, "--errorFile-", file.getAbsolutePath() + " - " + com.baidu.adp.lib.util.c.encodeBytes(x));
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
        if (this.bBy != null) {
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

    public static boolean g(Throwable th) {
        if ("java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            return true;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            return g(cause);
        }
        return false;
    }

    private void OM() {
        try {
            File file = new File(bBz);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(bBz + System.currentTimeMillis());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private int ON() {
        int i;
        long j = 0;
        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log";
        byte[] dG = com.baidu.tbadk.core.util.k.dG(str);
        String str2 = null;
        if (dG != null) {
            str2 = new String(dG);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str2)) {
            i = 0;
        } else {
            String[] split = str2.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.g.b.h(split[0], 0);
                j = com.baidu.adp.lib.g.b.c(split[1], j2);
            }
        }
        int i2 = j != j2 ? 1 : i + 1;
        com.baidu.tbadk.core.util.k.i(str, (i2 + ":" + j2).getBytes());
        return i2;
    }

    private int OO() {
        return com.baidu.adp.lib.stats.switchs.a.ob().getMaxAlertCount("alert_crash", 5);
    }

    private boolean OP() {
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
        int CJ = am.CJ();
        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_upload_info.log";
        byte[] dG = com.baidu.tbadk.core.util.k.dG(str);
        String str2 = null;
        if (dG != null) {
            str2 = new String(dG);
        }
        if (TextUtils.isEmpty(str2)) {
            i = CJ;
            i2 = 0;
        } else {
            String[] split = str2.split(":");
            if (split == null || split.length != 2) {
                i = CJ;
                i2 = 0;
            } else {
                int h = com.baidu.adp.lib.g.b.h(split[0], 0);
                int h2 = com.baidu.adp.lib.g.b.h(split[1], CJ);
                i2 = h;
                i = h2;
            }
        }
        if (i != CJ) {
            i2 = 0;
        }
        if (i2 > i3) {
            return true;
        }
        com.baidu.tbadk.core.util.k.i(str, ((i2 + 1) + ":" + CJ).getBytes());
        return false;
    }

    public static byte[] x(File file) {
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
                            com.baidu.adp.lib.util.n.d(fileInputStream);
                            return bArr;
                        }
                    }
                    com.baidu.adp.lib.util.n.d(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.d(fileInputStream);
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
            com.baidu.adp.lib.util.n.d(fileInputStream);
            throw th;
        }
        return bArr;
    }
}
