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
import com.baidu.tbadk.core.util.ao;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class o {
    private static String beY = "native_crash_log.log";
    private static List<String> beZ = new ArrayList();
    private static BroadcastReceiver JW = new BroadcastReceiver() { // from class: com.baidu.tbadk.util.o.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra(ETAG.KEY_PACKAGE_NAME);
                if (!TextUtils.isEmpty(stringExtra) && "com.baidu.adp.plugin.installed".equals(intent.getAction())) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("native_crash_count_" + stringExtra, 0);
                }
            }
        }
    };
    private static BdNativeCrash.NativeCrashCallback bfa = new BdNativeCrash.NativeCrashCallback() { // from class: com.baidu.tbadk.util.o.2
        @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
        public void onNativeCrashed(int i, int i2, int i3, String str, String str2) {
            z zVar = new z();
            Thread thread = new Thread();
            thread.setName("NativeCrashThread");
            zVar.a(thread, (Throwable) new Exception(str), true);
            o.in(str2);
        }

        @Override // com.baidu.adp.lib.crash.BdNativeCrash.NativeCrashCallback
        public boolean onSoFound(String str) {
            try {
                if (o.beZ.indexOf(str) >= 0) {
                    return false;
                }
                if (!o.io(str) && !o.ip(str) && !o.aJ(str, TbadkCoreApplication.getInst().getApp().getApplicationInfo().sourceDir)) {
                    o.beZ.add(str);
                    return false;
                }
                return true;
            } catch (Throwable th) {
                o.beZ.add(str);
                return false;
            }
        }
    };

    public static void OO() {
        if (BdNativeCrash.mbLibLoaded) {
            BdNativeCrash.getInstance().initCrash(TbConfig.getTempDirName(), TbConfig.FATAL_ERROR_NATIVE_DIR);
            BdNativeCrash.getInstance().setCrashCallback(bfa);
            OP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void in(String str) {
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
                int CL = ao.CL();
                byte[] bn = com.baidu.adp.lib.util.f.bn(beY);
                String str2 = null;
                if (bn != null) {
                    str2 = new String(bn);
                }
                if (TextUtils.isEmpty(str2)) {
                    i2 = CL;
                    i3 = 0;
                } else {
                    String[] split = str2.split(":");
                    if (split == null || split.length != 2) {
                        i2 = CL;
                        i3 = 0;
                    } else {
                        int l = com.baidu.adp.lib.g.b.l(split[0], 0);
                        int l2 = com.baidu.adp.lib.g.b.l(split[1], CL);
                        i3 = l;
                        i2 = l2;
                    }
                }
                if (i2 != CL) {
                    i3 = 0;
                }
                if (i3 > i) {
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.adp.plugin.b.a.mO().bP("native_crash_count_overrun");
                    return;
                }
                com.baidu.adp.lib.util.f.e(beY, ((i3 + 1) + ":" + CL).getBytes());
            } catch (Throwable th2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean io(String str) {
        if ("libpluginhook.so".equals(str)) {
            com.baidu.adp.plugin.b.a.mO().bP("plugin_patch_native_crashed");
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("plugin_patch_hook_failed_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("plugin_patch_hook_failed_count", 0) + 1);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ip(String str) {
        PluginSettings nA = com.baidu.adp.plugin.packageManager.pluginSettings.c.nD().nA();
        if (nA == null) {
            return false;
        }
        Map<String, PluginSetting> plugins = nA.getPlugins();
        if (plugins == null || plugins.isEmpty()) {
            return false;
        }
        for (PluginSetting pluginSetting : plugins.values()) {
            if (aJ(str, pluginSetting.apkPath)) {
                int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("native_crash_count_" + pluginSetting.packageName, 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("native_crash_count_" + pluginSetting.packageName, i + 1);
                if (i >= 3) {
                    com.baidu.adp.plugin.b.a.mO().I("plugin_native_crashed", pluginSetting.packageName);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean aJ(String str, String str2) {
        ZipInputStream zipInputStream;
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + com.baidu.fsg.face.base.d.h.c + File.separator + str);
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + "mips" + File.separator + str);
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + com.baidu.fsg.face.base.d.h.a + File.separator + str);
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
                        com.baidu.adp.lib.g.a.h(zipInputStream);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream2 = zipInputStream;
                        com.baidu.adp.lib.g.a.h(zipInputStream2);
                        throw th;
                    }
                }
                com.baidu.adp.lib.g.a.h(zipInputStream);
            } catch (IOException e2) {
                zipInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z;
    }

    private static void OP() {
        try {
            Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            applicationContext.registerReceiver(JW, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
