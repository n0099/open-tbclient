package com.baidu.tbadk.pluginArch;

import android.content.Context;
import com.baidu.adp.lib.util.commonsio.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public class PluginFileHelper {
    public static final String DOWNLOAD_DIR = "/pluginsEX/download/";
    public static final String ENABLE_FILE = "EnableConfig.xml";
    public static final String INSTALLEDCONFIG_DIR = "/pluginsEX/InstallConfig.xml";
    public static final String OPTIMISED_DIR = "/pluginsEX/optimised/";
    public static final String PLUGINROOT = "/pluginsEX/";
    public static final String UPDATE_DIR = "/pluginsEX/update/";
    public static final String OS_ARCH = PluginHelper.getArch();
    private static String gAbsolutePath = null;

    private static String getAbsolutePath() {
        if (gAbsolutePath == null) {
            Context context = PluginCenter.getInstance().mContext;
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                filesDir = new File("/data/data/" + context.getPackageName() + "/files/");
                try {
                    if (!filesDir.exists()) {
                        a.i(filesDir);
                    }
                } catch (IOException e) {
                }
            }
            gAbsolutePath = filesDir.getAbsolutePath();
        }
        return gAbsolutePath;
    }

    public static File libraryDir(String str) {
        return apkDir(str);
    }

    public static File resourcesDir(String str) {
        return apkDir(str);
    }

    public static File nativeDir(String str) {
        File file = new File(String.valueOf(pluginDir(str).getAbsolutePath()) + "/so/" + OS_ARCH);
        if (!file.exists()) {
            try {
                a.i(file);
            } catch (IOException e) {
            }
        }
        return file;
    }

    public static File pluginXML(String str) {
        if (str == null) {
            return null;
        }
        return new File(String.valueOf(pluginDir(str).getAbsolutePath()) + "/plugin.xml");
    }

    public static File pluginDir(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(String.valueOf(getAbsolutePath()) + PLUGINROOT + str);
        if (!file.exists()) {
            try {
                a.i(file);
                return file;
            } catch (IOException e) {
                return file;
            }
        }
        return file;
    }

    public static File apkDir(String str) {
        if (str == null) {
            return null;
        }
        return new File(String.valueOf(pluginDir(str).getAbsolutePath()) + "/" + str + ".apk");
    }

    public static File optimisedDir() {
        File file = new File(String.valueOf(getAbsolutePath()) + OPTIMISED_DIR);
        if (!file.exists()) {
            try {
                a.i(file);
            } catch (IOException e) {
            }
        }
        return file;
    }

    public static File downloadDir(String str) {
        File file = new File(String.valueOf(getAbsolutePath()) + DOWNLOAD_DIR, str);
        if (!file.exists()) {
            try {
                a.i(file);
            } catch (IOException e) {
            }
        }
        return file;
    }

    public static File updateDir(String str, int i) {
        File file = new File(String.valueOf(getAbsolutePath()) + UPDATE_DIR, String.valueOf(str) + "/" + String.valueOf(i) + "/");
        if (!file.exists()) {
            try {
                a.i(file);
            } catch (IOException e) {
            }
        }
        return new File(file, String.valueOf(str) + ".tbplugin");
    }

    public static File InstalledPluginXMLPath() {
        return new File(String.valueOf(getAbsolutePath()) + INSTALLEDCONFIG_DIR);
    }

    public static File enablePluginXMLPath(String str) {
        File pluginDir = pluginDir(str);
        if (pluginDir != null) {
            return new File(pluginDir, ENABLE_FILE);
        }
        return null;
    }
}
