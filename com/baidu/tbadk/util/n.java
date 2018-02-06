package com.baidu.tbadk.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.crash.BdNativeCrash;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class n {
    private static String bDj = "native_crash_log.log";
    private static List<String> bDk = new ArrayList();
    private static BroadcastReceiver aqv = new BroadcastReceiver() { // from class: com.baidu.tbadk.util.n.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("package_name");
                if (!TextUtils.isEmpty(stringExtra) && "com.baidu.adp.plugin.installed".equals(intent.getAction())) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("native_crash_count_" + stringExtra, 0);
                }
            }
        }
    };
    private static BdNativeCrash.NativeCrashCallback bDl = new BdNativeCrash.NativeCrashCallback() { // from class: com.baidu.tbadk.util.n.2
        @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
        public void onNativeCrashed(int i, int i2, int i3, String str, String str2) {
            x xVar = new x();
            Thread thread = new Thread();
            thread.setName("NativeCrashThread");
            xVar.a(thread, (Throwable) new Exception(str), true);
            n.hm(str2);
        }

        @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
        public boolean onSoFound(String str) {
            try {
                if (n.bDk.indexOf(str) >= 0) {
                    return false;
                }
                if (!n.hn(str) && !n.ho(str) && !n.ap(str, TbadkCoreApplication.getInst().getApp().getApplicationInfo().sourceDir)) {
                    n.bDk.add(str);
                    return false;
                }
                return true;
            } catch (Throwable th) {
                n.bDk.add(str);
                return false;
            }
        }
    };

    public static void Pc() {
        if (BdNativeCrash.mbLibLoaded) {
            BdNativeCrash.getInstance().initCrash(TbConfig.getTempDirName(), TbConfig.FATAL_ERROR_NATIVE_DIR);
            BdNativeCrash.getInstance().setCrashCallback(bDl);
            Pd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hm(String str) {
        int i;
        int i2;
        int i3;
        if (!TextUtils.isEmpty(str)) {
            try {
                int i4 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("crash_limit_count", 100);
                i = i4 >= 10 ? i4 : 10;
            } catch (Throwable th) {
                i = 100;
            }
            try {
                int Dc = am.Dc();
                byte[] aL = com.baidu.adp.lib.util.f.aL(bDj);
                String str2 = null;
                if (aL != null) {
                    str2 = new String(aL);
                }
                if (TextUtils.isEmpty(str2)) {
                    i2 = Dc;
                    i3 = 0;
                } else {
                    String[] split = str2.split(":");
                    if (split == null || split.length != 2) {
                        i2 = Dc;
                        i3 = 0;
                    } else {
                        int h = com.baidu.adp.lib.g.b.h(split[0], 0);
                        int h2 = com.baidu.adp.lib.g.b.h(split[1], Dc);
                        i3 = h;
                        i2 = h2;
                    }
                }
                if (i2 != Dc) {
                    i3 = 0;
                }
                if (i3 > i) {
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.adp.plugin.b.a.qF().bn("native_crash_count_overrun");
                    return;
                }
                com.baidu.adp.lib.util.f.e(bDj, ((i3 + 1) + ":" + Dc).getBytes());
            } catch (Throwable th2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hn(String str) {
        if ("libpluginhook.so".equals(str)) {
            com.baidu.adp.plugin.b.a.qF().bn("plugin_patch_native_crashed");
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("plugin_patch_hook_failed_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("plugin_patch_hook_failed_count", 0) + 1);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ho(String str) {
        PluginSettings rr = com.baidu.adp.plugin.packageManager.pluginSettings.c.ru().rr();
        if (rr == null) {
            return false;
        }
        Map<String, PluginSetting> plugins = rr.getPlugins();
        if (plugins == null || plugins.isEmpty()) {
            return false;
        }
        for (PluginSetting pluginSetting : plugins.values()) {
            if (ap(str, pluginSetting.apkPath)) {
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("native_crash_count_" + pluginSetting.packageName, 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("native_crash_count_" + pluginSetting.packageName, i + 1);
                if (i >= 3) {
                    com.baidu.adp.plugin.b.a.qF().A("plugin_native_crashed", pluginSetting.packageName);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ap(String str, String str2) {
        ZipInputStream zipInputStream;
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + com.baidu.fsg.biometrics.base.d.h.c + File.separator + str);
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + "mips" + File.separator + str);
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + com.baidu.fsg.biometrics.base.d.h.a + File.separator + str);
        File file = new File(str2);
        if (file.exists()) {
            ZipInputStream zipInputStream2 = null;
            try {
                zipInputStream = new ZipInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            if (arrayList.contains(nextEntry.getName())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (IOException e) {
                        com.baidu.adp.lib.g.a.d(zipInputStream);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream2 = zipInputStream;
                        com.baidu.adp.lib.g.a.d(zipInputStream2);
                        throw th;
                    }
                }
                com.baidu.adp.lib.g.a.d(zipInputStream);
            } catch (IOException e2) {
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z;
    }

    private static void Pd() {
        try {
            Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            applicationContext.registerReceiver(aqv, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
