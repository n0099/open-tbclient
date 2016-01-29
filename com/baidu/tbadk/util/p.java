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
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bc;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public class p implements Thread.UncaughtExceptionHandler {
    private static final String aDi = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private final Thread.UncaughtExceptionHandler aDg = Thread.getDefaultUncaughtExceptionHandler();
    private ExceptionData aDh = null;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (TbConfig.getDebugSwitch() && d(th)) {
            GF();
        }
        GG();
        if (!GH()) {
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
                try {
                    th.printStackTrace(printStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    this.aDh = new ExceptionData();
                    this.aDh.info = new String(byteArray);
                    GE();
                    a(thread, th);
                    com.baidu.adp.lib.c.e.gE().crash(this.aDh.info);
                    if (!TextUtils.isEmpty(this.aDh.info)) {
                        BdLog.e(this.aDh.info);
                    }
                    com.baidu.adp.lib.util.o.b((OutputStream) printStream);
                    com.baidu.adp.lib.util.o.b((OutputStream) byteArrayOutputStream);
                    if (TbConfig.getDebugSwitch() && this.aDg != null) {
                        this.aDg.uncaughtException(thread, th);
                    } else {
                        Process.killProcess(Process.myPid());
                    }
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    try {
                        e.printStackTrace();
                        com.baidu.adp.lib.util.o.b((OutputStream) printStream);
                        com.baidu.adp.lib.util.o.b((OutputStream) byteArrayOutputStream2);
                        if (TbConfig.getDebugSwitch() && this.aDg != null) {
                            this.aDg.uncaughtException(thread, th);
                        } else {
                            Process.killProcess(Process.myPid());
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.baidu.adp.lib.util.o.b((OutputStream) printStream);
                        com.baidu.adp.lib.util.o.b((OutputStream) byteArrayOutputStream);
                        if (!TbConfig.getDebugSwitch() && this.aDg != null) {
                            this.aDg.uncaughtException(thread, th);
                        } else {
                            Process.killProcess(Process.myPid());
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    com.baidu.adp.lib.util.o.b((OutputStream) printStream);
                    com.baidu.adp.lib.util.o.b((OutputStream) byteArrayOutputStream);
                    if (!TbConfig.getDebugSwitch()) {
                    }
                    Process.killProcess(Process.myPid());
                    throw th;
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

    private void GE() {
        if (this.aDh != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UEXCEPTION_MESSAGE, this.aDh));
            if (this.aDh.appendInfo != null) {
                Iterator<String> it = this.aDh.appendInfo.keySet().iterator();
                while (it.hasNext()) {
                    ExceptionData exceptionData = this.aDh;
                    exceptionData.info = String.valueOf(exceptionData.info) + "\n" + this.aDh.appendInfo.get(it.next());
                }
            }
        }
    }

    private void a(Thread thread, Throwable th) {
        FileWriter fileWriter;
        Throwable th2;
        Exception e;
        String str;
        byte[] w;
        FileWriter fileWriter2 = null;
        if (this.aDh != null) {
            try {
                if (TbConfig.getDebugSwitch()) {
                    str = TbConfig.FATAL_ERROR_DEBUG_FILE;
                } else {
                    str = TbConfig.FATAL_ERROR_FILE;
                }
                File cW = com.baidu.tbadk.core.util.m.cW(str);
                if (cW != null && cW.length() < TbConfig.FATAL_ERROR_FILE_MAX_SIZE) {
                    fileWriter = new FileWriter(cW, true);
                    try {
                        try {
                            a(fileWriter, aw.wc(), null);
                            a(fileWriter, "tieba_crash_new_info", null);
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
                            a(fileWriter, "imei", TbadkCoreApplication.m411getInst().getImei());
                            a(fileWriter, "uname", TbadkCoreApplication.getCurrentAccountName());
                            a(fileWriter, "activity", bc.ws());
                            a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                            a(fileWriter, "crash_type", th.getClass().getName());
                            StringBuilder sb = new StringBuilder();
                            try {
                                if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                                    Iterator<com.baidu.adp.plugin.a> it = PluginCenter.getInstance().getAllPlugins().iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.plugin.a next = it.next();
                                        if (next != null) {
                                            PluginSetting bs = PluginPackageManager.lD().bs(next.getPackageName());
                                            sb.append(next.getPackageName());
                                            sb.append("-");
                                            sb.append(next.kA());
                                            sb.append("-");
                                            if (bs != null) {
                                                sb.append(new File(bs.apkPath).exists());
                                                sb.append("-");
                                                sb.append(next.getVersionCode());
                                                sb.append("-");
                                                sb.append(bs.tempVersionCode);
                                                sb.append("-");
                                                if (bs.enable) {
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
                            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("activity")).getRunningAppProcesses();
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
                            a(fileWriter, "error", String.valueOf(this.aDh.info) + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.dH().dL());
                            if (this.aDh.info != null && this.aDh.info.contains("java.lang.ArrayIndexOutOfBoundsException: src.length=8192 srcPos=1 dst.length=8192 dstPos=0 length=-1")) {
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
                                                a(fileWriter, "--errorFile-", String.valueOf(file.getAbsolutePath()) + " - " + com.baidu.adp.lib.util.c.encodeBytes(w));
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
                            a(fileWriter, "tieba_crash_new_info_end", null);
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

    private void GF() {
        try {
            File file = new File(aDi);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(String.valueOf(aDi) + System.currentTimeMillis());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private void GG() {
        int i;
        long j = 0;
        byte[] aI = com.baidu.adp.lib.util.e.aI("crash_hour_record.log");
        String str = null;
        if (aI != null) {
            str = new String(aI);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.h.b.g(split[0], 0);
                j = com.baidu.adp.lib.h.b.c(split[1], j2);
            }
        }
        com.baidu.adp.lib.util.e.e("crash_hour_record.log", (String.valueOf(j != j2 ? 1 : i + 1) + ":" + j2).getBytes());
    }

    private boolean GH() {
        int i;
        int i2;
        int i3 = 10;
        try {
            int i4 = com.baidu.tbadk.core.sharedPref.b.uO().getInt("crash_limit_count", 100);
            if (i4 >= 10) {
                i3 = i4;
            }
        } catch (Throwable th) {
            i3 = 100;
        }
        int we = aw.we();
        byte[] aI = com.baidu.adp.lib.util.e.aI("crash_upload_info.log");
        String str = null;
        if (aI != null) {
            str = new String(aI);
        }
        if (TextUtils.isEmpty(str)) {
            i = we;
            i2 = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = we;
                i2 = 0;
            } else {
                int g = com.baidu.adp.lib.h.b.g(split[0], 0);
                int g2 = com.baidu.adp.lib.h.b.g(split[1], we);
                i2 = g;
                i = g2;
            }
        }
        if (i != we) {
            i2 = 0;
        }
        if (i2 > i3) {
            return true;
        }
        com.baidu.adp.lib.util.e.e("crash_upload_info.log", (String.valueOf(i2 + 1) + ":" + we).getBytes());
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
                            com.baidu.adp.lib.util.o.e(fileInputStream);
                            return bArr;
                        }
                    }
                    com.baidu.adp.lib.util.o.e(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.o.e(fileInputStream);
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
            com.baidu.adp.lib.util.o.e(fileInputStream);
            throw th;
        }
        return bArr;
    }
}
