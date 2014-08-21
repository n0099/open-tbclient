package com.baidu.tbadk.pluginArch;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class y {
    private static y c;
    final TreeMap<String, WeakReference<Resources>> a = new TreeMap<>();
    final LinkedList<File> b = new LinkedList<>();

    public static y a() {
        y yVar;
        synchronized (y.class) {
            if (c == null) {
                c = new y();
            }
            yVar = c;
        }
        return yVar;
    }

    public Resources a(String str, Resources resources) {
        AssetManager b;
        if (str != null && resources != null) {
            WeakReference<Resources> weakReference = this.a.get(str);
            Resources resources2 = weakReference != null ? weakReference.get() : null;
            if (resources2 == null && (b = b(str)) != null) {
                Resources resources3 = new Resources(b, resources.getDisplayMetrics(), resources.getConfiguration());
                this.a.put(str, new WeakReference<>(resources3));
                return resources3;
            }
            return resources2;
        }
        return null;
    }

    public void a(Context context) {
        if (context != null) {
            Iterator<File> it = this.b.iterator();
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

    public boolean a(String str) {
        File c2;
        if (str == null || (c2 = c(str)) == null || !c2.exists()) {
            return false;
        }
        this.b.add(c2);
        return true;
    }

    private AssetManager b(String str) {
        AssetManager assetManager;
        if (str == null) {
            return null;
        }
        File c2 = c(str);
        String absolutePath = (c2 == null || !c2.exists()) ? null : c2.getAbsolutePath();
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

    private File c(String str) {
        if (str == null) {
            return null;
        }
        return n.b(str);
    }
}
