package com.baidu.tieba.flutter.plugin.commonPlatformView;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.PluginRegistry;
/* loaded from: classes4.dex */
public class CommonPlatformViewPlugin implements FlutterPlugin {
    public static void registerWith(PluginRegistry.Registrar registrar) {
        registrar.platformViewRegistry().registerViewFactory("common_platform_view", new CommonPlatformViewFactory(registrar.messenger()));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        flutterPluginBinding.getPlatformViewRegistry().registerViewFactory("common_platform_view", new CommonPlatformViewFactory(flutterPluginBinding.getBinaryMessenger()));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }
}
