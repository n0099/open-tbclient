package com.baidu.tbadk.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.crash.BdNativeCrash;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.au;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class l {
    private static String aIS = "native_crash_log.log";
    private static List<String> aIT = new ArrayList();
    private static BroadcastReceiver Dh = new m();
    private static BdNativeCrash.NativeCrashCallback aIU = new n();

    public static void Gm() {
        if (BdNativeCrash.mbLibLoaded) {
            BdNativeCrash.getInstance().initCrash(TbConfig.getTempDirName(), TbConfig.FATAL_ERROR_NATIVE_DIR);
            BdNativeCrash.getInstance().setCrashCallback(aIU);
            Gn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gg(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        if (!TextUtils.isEmpty(str)) {
            try {
                int i5 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("crash_limit_count", 100);
                i = i5 < 10 ? 10 : i5;
            } catch (Throwable th) {
                i = 100;
            }
            try {
                int vj = au.vj();
                byte[] au = com.baidu.adp.lib.util.e.au(aIS);
                String str2 = null;
                if (au != null) {
                    str2 = new String(au);
                }
                if (TextUtils.isEmpty(str2)) {
                    i2 = vj;
                    i3 = 0;
                } else {
                    String[] split = str2.split(":");
                    if (split == null || split.length != 2) {
                        i2 = vj;
                        i3 = 0;
                    } else {
                        int g = com.baidu.adp.lib.g.b.g(split[0], 0);
                        int g2 = com.baidu.adp.lib.g.b.g(split[1], vj);
                        i3 = g;
                        i2 = g2;
                    }
                }
                if ((i2 == vj ? i3 : 0) > i) {
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.adp.plugin.b.a.jk().aV("native_crash_count_overrun");
                    return;
                }
                com.baidu.adp.lib.util.e.e(aIS, (String.valueOf(i4 + 1) + ":" + vj).getBytes());
            } catch (Throwable th2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean gh(String str) {
        if ("libpluginhook.so".equals(str)) {
            com.baidu.adp.plugin.b.a.jk().aV("plugin_patch_native_crashed");
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("plugin_patch_hook_failed_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("plugin_patch_hook_failed_count", 0) + 1);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean gi(String str) {
        PluginSettings jX = com.baidu.adp.plugin.packageManager.pluginSettings.c.ka().jX();
        if (jX == null) {
            return false;
        }
        Map<String, PluginSetting> plugins = jX.getPlugins();
        if (plugins == null || plugins.isEmpty()) {
            return false;
        }
        for (PluginSetting pluginSetting : plugins.values()) {
            if (ao(str, pluginSetting.apkPath)) {
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("native_crash_count_" + pluginSetting.packageName, 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("native_crash_count_" + pluginSetting.packageName, i + 1);
                if (i >= 3) {
                    com.baidu.adp.plugin.b.a.jk().B("plugin_native_crashed", pluginSetting.packageName);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ao(String str, String str2) {
        ZipInputStream zipInputStream;
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + "x86" + File.separator + str);
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + "mips" + File.separator + str);
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + "armeabi" + File.separator + str);
        File file = new File(str2);
        if (file.exists()) {
            ZipInputStream zipInputStream2 = null;
            try {
                zipInputStream = new ZipInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        } else if (arrayList.contains(nextEntry.getName())) {
                            z = true;
                            break;
                        }
                    } catch (IOException e) {
                        com.baidu.adp.lib.g.a.j(zipInputStream);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream2 = zipInputStream;
                        com.baidu.adp.lib.g.a.j(zipInputStream2);
                        throw th;
                    }
                }
                com.baidu.adp.lib.g.a.j(zipInputStream);
            } catch (IOException e2) {
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z;
    }

    private static void Gn() {
        try {
            Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            applicationContext.registerReceiver(Dh, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
