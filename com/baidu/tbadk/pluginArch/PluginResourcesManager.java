package com.baidu.tbadk.pluginArch;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.baidu.adp.lib.g.d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class PluginResourcesManager {
    private static PluginResourcesManager sResourcesManager;
    final TreeMap<String, WeakReference<Resources>> mActivPlugineResources = new TreeMap<>();
    final LinkedList<File> mGlobalResPath = new LinkedList<>();

    public static PluginResourcesManager getInstance() {
        PluginResourcesManager pluginResourcesManager;
        synchronized (PluginResourcesManager.class) {
            if (sResourcesManager == null) {
                sResourcesManager = new PluginResourcesManager();
            }
            pluginResourcesManager = sResourcesManager;
        }
        return pluginResourcesManager;
    }

    public Resources getPluginResource(String str, Resources resources) {
        AssetManager assetManager;
        d dVar;
        if (str != null && resources != null) {
            WeakReference<Resources> weakReference = this.mActivPlugineResources.get(str);
            Resources resources2 = weakReference != null ? weakReference.get() : null;
            if (resources2 == null && (assetManager = getAssetManager(str)) != null) {
                if (PluginNameList.NAME_NIGHT_RESOURCE.equals(str)) {
                    dVar = new d(new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration()), true);
                } else {
                    dVar = new d(new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration()));
                }
                this.mActivPlugineResources.put(str, new WeakReference<>(dVar));
                return dVar;
            }
            return resources2;
        }
        return null;
    }

    public void addGlobalPluginResourcePath(Context context) {
        if (context != null) {
            Iterator<File> it = this.mGlobalResPath.iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next.exists()) {
                    try {
                        context.getAssets().getClass().getMethod("addAssetPath", String.class).invoke(context.getResources().getAssets(), next.getAbsolutePath());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean registerGlobalRes(String str) {
        if (str == null) {
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, "register null plugin name", str);
            return false;
        }
        File reourcesPath = getReourcesPath(str);
        if (reourcesPath != null && reourcesPath.exists()) {
            this.mGlobalResPath.add(reourcesPath);
            return true;
        }
        PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, "resource not found", str);
        return false;
    }

    private AssetManager getAssetManager(String str) {
        AssetManager assetManager;
        if (str != null && PluginCenter.getInstance().checkPluginInstalled(str)) {
            File reourcesPath = getReourcesPath(str);
            String absolutePath = (reourcesPath == null || !reourcesPath.exists()) ? null : reourcesPath.getAbsolutePath();
            if (absolutePath != null) {
                try {
                    assetManager = (AssetManager) AssetManager.class.newInstance();
                    assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, absolutePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return assetManager;
            }
            assetManager = null;
            return assetManager;
        }
        return null;
    }

    private File getReourcesPath(String str) {
        if (str == null) {
            return null;
        }
        return PluginFileHelper.resourcesDir(str);
    }
}
