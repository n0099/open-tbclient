package com.baidu.tieba.flutter.hotreload;

import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
/* loaded from: classes4.dex */
public class FlutterHotReload {
    public static boolean changePlugin() {
        FlutterEngine engineProvider = FlutterBoost.instance().engineProvider();
        if (engineProvider == null || engineProvider.getPlugins() == null) {
            return false;
        }
        PluginRegistry plugins = engineProvider.getPlugins();
        try {
            Class<?> cls = Class.forName("d.b.y.a");
            if (plugins.has(cls)) {
                plugins.remove((Class<? extends FlutterPlugin>) cls);
                return true;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }
}
