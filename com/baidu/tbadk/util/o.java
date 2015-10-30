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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
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
public class o implements Thread.UncaughtExceptionHandler {
    private static final String azR = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private final Thread.UncaughtExceptionHandler azP = Thread.getDefaultUncaughtExceptionHandler();
    private ExceptionData azQ = null;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (TbConfig.getDebugSwitch() && d(th)) {
            ED();
        }
        EE();
        if (!EF()) {
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
                    this.azQ = new ExceptionData();
                    this.azQ.info = new String(byteArray);
                    EC();
                    a(thread, th);
                    com.baidu.adp.lib.b.e.gv().crash(this.azQ.info);
                    if (!TextUtils.isEmpty(this.azQ.info)) {
                        BdLog.e(this.azQ.info);
                    }
                    com.baidu.adp.lib.util.o.b((OutputStream) printStream);
                    com.baidu.adp.lib.util.o.b((OutputStream) byteArrayOutputStream);
                    if (TbConfig.getDebugSwitch() && this.azP != null) {
                        this.azP.uncaughtException(thread, th);
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
                        if (TbConfig.getDebugSwitch() && this.azP != null) {
                            this.azP.uncaughtException(thread, th);
                        } else {
                            Process.killProcess(Process.myPid());
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.baidu.adp.lib.util.o.b((OutputStream) printStream);
                        com.baidu.adp.lib.util.o.b((OutputStream) byteArrayOutputStream);
                        if (!TbConfig.getDebugSwitch() && this.azP != null) {
                            this.azP.uncaughtException(thread, th);
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

    private void EC() {
        if (this.azQ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UEXCEPTION_MESSAGE, this.azQ));
            if (this.azQ.appendInfo != null) {
                Iterator<String> it = this.azQ.appendInfo.keySet().iterator();
                while (it.hasNext()) {
                    ExceptionData exceptionData = this.azQ;
                    exceptionData.info = String.valueOf(exceptionData.info) + "\n" + this.azQ.appendInfo.get(it.next());
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
        if (this.azQ != null) {
            try {
                if (TbConfig.getDebugSwitch()) {
                    str = TbConfig.FATAL_ERROR_DEBUG_FILE;
                } else {
                    str = TbConfig.FATAL_ERROR_FILE;
                }
                File cO = com.baidu.tbadk.core.util.n.cO(str);
                if (cO != null && cO.length() < TbConfig.FATAL_ERROR_FILE_MAX_SIZE) {
                    fileWriter = new FileWriter(cO, true);
                    try {
                        try {
                            a(fileWriter, as.uD(), null);
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
                            a(fileWriter, "activity", ax.uS());
                            a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                            a(fileWriter, "crash_type", th.getClass().getName());
                            StringBuilder sb = new StringBuilder();
                            try {
                                if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                                    Iterator<com.baidu.adp.plugin.a> it = PluginCenter.getInstance().getAllPlugins().iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.plugin.a next = it.next();
                                        if (next != null) {
                                            PluginSetting bn = PluginPackageManager.lR().bn(next.getPackageName());
                                            sb.append(next.getPackageName());
                                            sb.append("-");
                                            sb.append(next.kn());
                                            sb.append("-");
                                            if (bn != null) {
                                                sb.append(bn.versionCode);
                                                sb.append("-");
                                                sb.append(bn.tempVersionCode);
                                                sb.append("-");
                                                if (bn.enable) {
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
                            a(fileWriter, "error", String.valueOf(this.azQ.info) + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.dF().dJ());
                            if (this.azQ.info != null && this.azQ.info.contains("java.lang.ArrayIndexOutOfBoundsException: src.length=8192 srcPos=1 dst.length=8192 dstPos=0 length=-1")) {
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

    private void ED() {
        try {
            File file = new File(azR);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(String.valueOf(azR) + System.currentTimeMillis());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private void EE() {
        int i;
        long j = 0;
        byte[] aH = com.baidu.adp.lib.util.e.aH("crash_hour_record.log");
        String str = null;
        if (aH != null) {
            str = new String(aH);
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
        com.baidu.adp.lib.util.e.e("crash_hour_record.log", (String.valueOf(j != j2 ? 1 : i + 1) + ":" + j2).getBytes());
    }

    private boolean EF() {
        int i;
        int i2;
        int i3 = 10;
        try {
            int i4 = com.baidu.tbadk.core.sharedPref.b.tr().getInt("crash_limit_count", 100);
            if (i4 >= 10) {
                i3 = i4;
            }
        } catch (Throwable th) {
            i3 = 100;
        }
        int uE = as.uE();
        byte[] aH = com.baidu.adp.lib.util.e.aH("crash_upload_info.log");
        String str = null;
        if (aH != null) {
            str = new String(aH);
        }
        if (TextUtils.isEmpty(str)) {
            i = uE;
            i2 = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = uE;
                i2 = 0;
            } else {
                int g = com.baidu.adp.lib.g.b.g(split[0], 0);
                int g2 = com.baidu.adp.lib.g.b.g(split[1], uE);
                i2 = g;
                i = g2;
            }
        }
        if (i != uE) {
            i2 = 0;
        }
        if (i2 > i3) {
            return true;
        }
        com.baidu.adp.lib.util.e.e("crash_upload_info.log", (String.valueOf(i2 + 1) + ":" + uE).getBytes());
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
                            com.baidu.adp.lib.util.o.d(fileInputStream);
                            return bArr;
                        }
                    }
                    com.baidu.adp.lib.util.o.d(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.o.d(fileInputStream);
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
            com.baidu.adp.lib.util.o.d(fileInputStream);
            throw th;
        }
        return bArr;
    }
}
