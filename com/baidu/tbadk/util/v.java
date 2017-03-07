package com.baidu.tbadk.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ba;
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
public class v implements Thread.UncaughtExceptionHandler {
    private static final String aJa = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private final Thread.UncaughtExceptionHandler aIY = Thread.getDefaultUncaughtExceptionHandler();
    private ExceptionData aIZ = null;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Thread thread, Throwable th, boolean z) {
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (TbConfig.getDebugSwitch() && c(th)) {
            GX();
        }
        int GY = GY();
        if (!Ha()) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    printStream = new PrintStream(byteArrayOutputStream);
                } catch (Exception e) {
                    e = e;
                    printStream = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (Throwable th2) {
                    th = th2;
                    printStream = null;
                }
            } catch (Exception e2) {
                e = e2;
                printStream = null;
            } catch (Throwable th3) {
                th = th3;
                printStream = null;
                byteArrayOutputStream = null;
            }
            try {
                th.printStackTrace(printStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.aIZ = new ExceptionData();
                if (z) {
                    this.aIZ.info = th.getMessage();
                } else {
                    this.aIZ.info = new String(byteArray);
                    this.aIZ.mExcep = th;
                }
                GW();
                if (!z) {
                    a(thread, th);
                }
                com.baidu.adp.lib.b.e.eT().crash(this.aIZ.info);
                if (!TextUtils.isEmpty(this.aIZ.info)) {
                    BdLog.e(this.aIZ.info);
                }
                BdLog.e("hourCrash = " + GY);
                if (GY >= GZ()) {
                    b(thread, th);
                }
                com.baidu.adp.lib.util.o.d(printStream);
                com.baidu.adp.lib.util.o.d(byteArrayOutputStream);
                if (!z) {
                    if (TbConfig.getDebugSwitch() && this.aIY != null) {
                        this.aIY.uncaughtException(thread, th);
                    } else {
                        Process.killProcess(Process.myPid());
                    }
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                try {
                    e.printStackTrace();
                    com.baidu.adp.lib.util.o.d(printStream);
                    com.baidu.adp.lib.util.o.d(byteArrayOutputStream2);
                    if (!z) {
                        if (TbConfig.getDebugSwitch() && this.aIY != null) {
                            this.aIY.uncaughtException(thread, th);
                        } else {
                            Process.killProcess(Process.myPid());
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    com.baidu.adp.lib.util.o.d(printStream);
                    com.baidu.adp.lib.util.o.d(byteArrayOutputStream);
                    if (!z) {
                        if (TbConfig.getDebugSwitch() && this.aIY != null) {
                            this.aIY.uncaughtException(thread, th);
                        } else {
                            Process.killProcess(Process.myPid());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                com.baidu.adp.lib.util.o.d(printStream);
                com.baidu.adp.lib.util.o.d(byteArrayOutputStream);
                if (!z) {
                }
                throw th;
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

    private void GW() {
        if (this.aIZ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UEXCEPTION_MESSAGE, this.aIZ));
            if (this.aIZ.appendInfo != null) {
                Iterator<String> it = this.aIZ.appendInfo.keySet().iterator();
                while (it.hasNext()) {
                    ExceptionData exceptionData = this.aIZ;
                    exceptionData.info = String.valueOf(exceptionData.info) + "\n" + this.aIZ.appendInfo.get(it.next());
                }
            }
        }
    }

    private void a(Thread thread, Throwable th, String str) {
        FileWriter fileWriter;
        Throwable th2;
        Exception e;
        byte[] u;
        FileWriter fileWriter2 = null;
        if (this.aIZ != null) {
            try {
                File cV = com.baidu.tbadk.core.util.l.cV(str);
                if (cV != null && cV.length() < TbConfig.FATAL_ERROR_FILE_MAX_SIZE) {
                    fileWriter = new FileWriter(cV, true);
                    try {
                        try {
                            a(fileWriter, au.vA(), (String) null);
                            a(fileWriter, "tieba_crash_new_info", (String) null);
                            a(fileWriter, "version", TbConfig.getVersion());
                            a(fileWriter, "model", Build.MODEL);
                            a(fileWriter, "android_version", Build.VERSION.RELEASE);
                            a(fileWriter, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                            a(fileWriter, "from", TbConfig.getFrom());
                            a(fileWriter, "current_from", TbConfig.getCurrentFrom());
                            a(fileWriter, SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                            a(fileWriter, "client_id", TbadkCoreApplication.getClientId());
                            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                                a(fileWriter, "subapp_type", TbConfig.getSubappType());
                            }
                            a(fileWriter, "imei", TbadkCoreApplication.m9getInst().getImei());
                            a(fileWriter, "uname", TbadkCoreApplication.getCurrentAccountName());
                            a(fileWriter, "activity", ba.vP());
                            a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                            a(fileWriter, "crash_type", th.getClass().getName());
                            StringBuilder sb = new StringBuilder();
                            try {
                                if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                                    Iterator<Plugin> it = PluginCenter.getInstance().getAllPlugins().iterator();
                                    while (it.hasNext()) {
                                        Plugin next = it.next();
                                        if (next != null) {
                                            PluginSetting be = PluginPackageManager.jt().be(next.getPackageName());
                                            sb.append(next.getPackageName());
                                            sb.append("-");
                                            sb.append(next.getCurrentPluginMode());
                                            sb.append("-");
                                            if (be != null) {
                                                sb.append(new File(be.apkPath).exists());
                                                sb.append("-");
                                                sb.append(next.getVersionCode());
                                                sb.append("-");
                                                sb.append(be.tempVersionCode);
                                                sb.append("-");
                                                if (be.enable) {
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
                            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.m9getInst().getApp().getSystemService("activity")).getRunningAppProcesses();
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
                            a(fileWriter, "error", String.valueOf(this.aIZ.info) + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.cb().cf());
                            if (this.aIZ.info != null && this.aIZ.info.contains("java.lang.ArrayIndexOutOfBoundsException: src.length=8192 srcPos=1 dst.length=8192 dstPos=0 length=-1")) {
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
                                            if (u(file) == null) {
                                                a(fileWriter, "--errorFile-", file.getAbsolutePath());
                                            } else {
                                                a(fileWriter, "--errorFile-", String.valueOf(file.getAbsolutePath()) + " - " + com.baidu.adp.lib.util.c.encodeBytes(u));
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
                            com.baidu.adp.lib.util.o.a(fileWriter);
                            return;
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        com.baidu.adp.lib.util.o.a(fileWriter);
                        throw th2;
                    }
                }
                com.baidu.adp.lib.util.o.a(fileWriter2);
            } catch (Exception e5) {
                fileWriter = null;
                e = e5;
            } catch (Throwable th4) {
                fileWriter = null;
                th2 = th4;
                com.baidu.adp.lib.util.o.a(fileWriter);
                throw th2;
            }
        }
    }

    private void a(Thread thread, Throwable th) {
        String str;
        if (this.aIZ != null) {
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

    public static boolean c(Throwable th) {
        if ("java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            return true;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            return c(cause);
        }
        return false;
    }

    private void GX() {
        try {
            File file = new File(aJa);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(String.valueOf(aJa) + System.currentTimeMillis());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private int GY() {
        int i;
        long j = 0;
        byte[] az = com.baidu.adp.lib.util.e.az("crash_hour_record.log");
        String str = null;
        if (az != null) {
            str = new String(az);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.g.b.g(split[0], 0);
                j = com.baidu.adp.lib.g.b.c(split[1], j2);
            }
        }
        int i2 = j != j2 ? 1 : i + 1;
        com.baidu.adp.lib.util.e.e("crash_hour_record.log", (String.valueOf(i2) + ":" + j2).getBytes());
        return i2;
    }

    private int GZ() {
        return com.baidu.adp.lib.stats.switchs.a.gw().getMaxAlertCount("alert_crash", 5);
    }

    private boolean Ha() {
        int i;
        int i2;
        int i3 = 10;
        try {
            int i4 = com.baidu.tbadk.core.sharedPref.b.uo().getInt("crash_limit_count", 100);
            if (i4 >= 10) {
                i3 = i4;
            }
        } catch (Throwable th) {
            i3 = 100;
        }
        int vB = au.vB();
        byte[] az = com.baidu.adp.lib.util.e.az("crash_upload_info.log");
        String str = null;
        if (az != null) {
            str = new String(az);
        }
        if (TextUtils.isEmpty(str)) {
            i = vB;
            i2 = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = vB;
                i2 = 0;
            } else {
                int g = com.baidu.adp.lib.g.b.g(split[0], 0);
                int g2 = com.baidu.adp.lib.g.b.g(split[1], vB);
                i2 = g;
                i = g2;
            }
        }
        if (i != vB) {
            i2 = 0;
        }
        if (i2 > i3) {
            return true;
        }
        com.baidu.adp.lib.util.e.e("crash_upload_info.log", (String.valueOf(i2 + 1) + ":" + vB).getBytes());
        return false;
    }

    public static byte[] u(File file) {
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
                            com.baidu.adp.lib.util.o.j(fileInputStream);
                            return bArr;
                        }
                    }
                    com.baidu.adp.lib.util.o.j(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.o.j(fileInputStream);
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
            com.baidu.adp.lib.util.o.j(fileInputStream);
            throw th;
        }
        return bArr;
    }
}
