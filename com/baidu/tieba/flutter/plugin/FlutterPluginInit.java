package com.baidu.tieba.flutter.plugin;

import androidx.annotation.NonNull;
import com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayPlugin;
import com.baidu.tieba.flutter.plugin.commonPlatformView.CommonPlatformViewPlugin;
import com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin;
import com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderPlugin;
import com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerPlugin;
import com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoPlugin;
import com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin;
import com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorPlugin;
import com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDPlugin;
import com.baidu.tieba.flutter.plugin.tiebaShare.TiebaSharePlugin;
import com.baidu.tieba.flutter.plugin.tiebaUtility.android.TiebaUtilityPlugin;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;
/* loaded from: classes4.dex */
public class FlutterPluginInit {
    public static void init(@NonNull FlutterEngine flutterEngine) {
        if (flutterEngine == null) {
            return;
        }
        flutterEngine.getPlugins().add(new NetworkInfoPlugin());
        flutterEngine.getPlugins().add(new AudioPlayPlugin());
        flutterEngine.getPlugins().add(new CommonPlatformViewPlugin());
        flutterEngine.getPlugins().add(new FlutterBoostPlugin());
        flutterEngine.getPlugins().add(new globalStateSyncPlugin());
        flutterEngine.getPlugins().add(new ImageLoaderPlugin());
        flutterEngine.getPlugins().add(new ImagePickerPlugin());
        flutterEngine.getPlugins().add(new NetworkServicePlugin());
        flutterEngine.getPlugins().add(new ProgressHUDPlugin());
        flutterEngine.getPlugins().add(new PerformanceMonitorPlugin());
        flutterEngine.getPlugins().add(new TiebaSharePlugin());
        flutterEngine.getPlugins().add(new TiebaUtilityPlugin());
        flutterEngine.getPlugins().add(new WebViewFlutterPlugin());
    }
}
