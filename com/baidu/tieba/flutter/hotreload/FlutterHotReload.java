package com.baidu.tieba.flutter.hotreload;

import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
/* loaded from: classes11.dex */
public class FlutterHotReload {
    private static boolean changePlugin() {
        FlutterEngine engineProvider = FlutterBoost.instance().engineProvider();
        if (engineProvider != null && engineProvider.getPlugins() != null) {
            PluginRegistry plugins = engineProvider.getPlugins();
            try {
                Class<?> cls = Class.forName("com.baidu.i.a");
                if (plugins.has(cls)) {
                    plugins.remove((Class<? extends FlutterPlugin>) cls);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
