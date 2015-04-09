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
import com.baidu.adp.lib.util.v;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bi;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class m implements Thread.UncaughtExceptionHandler {
    private static final String aqM = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + File.separator + "tieba" + File.separator + "oom" + File.separator;
    private final Thread.UncaughtExceptionHandler aqK = Thread.getDefaultUncaughtExceptionHandler();
    private com.baidu.tbadk.core.data.j aqL = null;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (TbConfig.getDebugSwitch() && f(th)) {
            Do();
        }
        Dp();
        if (!Dq()) {
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
                this.aqL = new com.baidu.tbadk.core.data.j();
                this.aqL.info = new String(byteArray);
                Dn();
                d(th);
                com.baidu.adp.lib.b.f.gz().crash(this.aqL.info);
                com.baidu.adp.lib.stats.f.hP().handleException();
                if (!TextUtils.isEmpty(this.aqL.info)) {
                    BdLog.e(this.aqL.info);
                }
                v.b(printStream);
                v.b(byteArrayOutputStream);
                if (TbConfig.getDebugSwitch() && this.aqK != null) {
                    this.aqK.uncaughtException(thread, th);
                } else {
                    Process.killProcess(Process.myPid());
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                try {
                    e.printStackTrace();
                    v.b(printStream);
                    v.b(byteArrayOutputStream2);
                    if (TbConfig.getDebugSwitch() && this.aqK != null) {
                        this.aqK.uncaughtException(thread, th);
                    } else {
                        Process.killProcess(Process.myPid());
                    }
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    v.b(printStream);
                    v.b(byteArrayOutputStream);
                    if (!TbConfig.getDebugSwitch() && this.aqK != null) {
                        this.aqK.uncaughtException(thread, th);
                    } else {
                        Process.killProcess(Process.myPid());
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                v.b(printStream);
                v.b(byteArrayOutputStream);
                if (!TbConfig.getDebugSwitch()) {
                }
                Process.killProcess(Process.myPid());
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

    private void Dn() {
        if (this.aqL != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016301, this.aqL));
            if (this.aqL.PG != null) {
                Iterator<String> it = this.aqL.PG.keySet().iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.core.data.j jVar = this.aqL;
                    jVar.info = String.valueOf(jVar.info) + "\n" + this.aqL.PG.get(it.next());
                }
            }
        }
    }

    private void d(Throwable th) {
        FileWriter fileWriter;
        Throwable th2;
        Exception e;
        String str;
        FileWriter fileWriter2 = null;
        if (this.aqL != null) {
            try {
                if (TbConfig.getDebugSwitch()) {
                    str = TbConfig.FATAL_ERROR_DEBUG_FILE;
                } else {
                    str = TbConfig.FATAL_ERROR_FILE;
                }
                File cp = com.baidu.tbadk.core.util.o.cp(str);
                if (cp != null && cp.length() < TbConfig.FATAL_ERROR_FILE_MAX_SIZE) {
                    fileWriter = new FileWriter(cp, true);
                    try {
                        try {
                            a(fileWriter, bd.sW(), null);
                            a(fileWriter, "tieba_crash_new_info", null);
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
                            a(fileWriter, "imei", TbadkCoreApplication.m411getInst().getImei());
                            a(fileWriter, "uname", TbadkCoreApplication.getCurrentAccountName());
                            a(fileWriter, "activity", bi.tk());
                            a(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                            a(fileWriter, "crash_type", th.getClass().getName());
                            StringBuilder sb = new StringBuilder();
                            try {
                                if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                                    Iterator<com.baidu.adp.plugin.b> it = PluginCenter.getInstance().getAllPlugins().iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.plugin.b next = it.next();
                                        if (next != null) {
                                            PluginSetting bi = PluginPackageManager.ls().bi(next.getPackageName());
                                            sb.append(next.getPackageName());
                                            sb.append("-");
                                            sb.append(next.ke());
                                            sb.append("-");
                                            if (bi != null) {
                                                sb.append(bi.versionCode);
                                                sb.append("-");
                                                sb.append(bi.tempVersionCode);
                                                sb.append("-");
                                                if (bi.enable) {
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
                            a(fileWriter, "error", String.valueOf(this.aqL.info) + "--pluginInfo-" + sb.toString());
                            a(fileWriter, "tieba_crash_new_info_end", null);
                            fileWriter.append("\n");
                            fileWriter.flush();
                            fileWriter2 = fileWriter;
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            v.a(fileWriter);
                            return;
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        v.a(fileWriter);
                        throw th2;
                    }
                }
                v.a(fileWriter2);
            } catch (Exception e4) {
                fileWriter = null;
                e = e4;
            } catch (Throwable th4) {
                fileWriter = null;
                th2 = th4;
                v.a(fileWriter);
                throw th2;
            }
        }
    }

    public static boolean f(Throwable th) {
        if ("java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            return true;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            return f(cause);
        }
        return false;
    }

    private void Do() {
        try {
            File file = new File(aqM);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(String.valueOf(aqM) + System.currentTimeMillis());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private void Dp() {
        int i;
        long j = 0;
        byte[] aE = com.baidu.adp.lib.util.f.aE("crash_hour_record.log");
        String str = null;
        if (aE != null) {
            str = new String(aE);
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
        com.baidu.adp.lib.util.f.d("crash_hour_record.log", (String.valueOf(j != j2 ? 1 : i + 1) + ":" + j2).getBytes());
    }

    private boolean Dq() {
        int i;
        int i2;
        int i3 = 10;
        try {
            int i4 = com.baidu.tbadk.core.sharedPref.b.rB().getInt("crash_limit_count", 100);
            if (i4 >= 10) {
                i3 = i4;
            }
        } catch (Throwable th) {
            i3 = 100;
        }
        int sX = bd.sX();
        byte[] aE = com.baidu.adp.lib.util.f.aE("crash_upload_info.log");
        String str = null;
        if (aE != null) {
            str = new String(aE);
        }
        if (TextUtils.isEmpty(str)) {
            i = sX;
            i2 = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = sX;
                i2 = 0;
            } else {
                int i5 = com.baidu.adp.lib.g.c.toInt(split[0], 0);
                int i6 = com.baidu.adp.lib.g.c.toInt(split[1], sX);
                i2 = i5;
                i = i6;
            }
        }
        if (i != sX) {
            i2 = 0;
        }
        if (i2 > i3) {
            return true;
        }
        com.baidu.adp.lib.util.f.d("crash_upload_info.log", (String.valueOf(i2 + 1) + ":" + sX).getBytes());
        return false;
    }
}
