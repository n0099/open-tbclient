package com.baidu.tieba.flutter.plugin;

import androidx.annotation.NonNull;
import com.baidu.tieba.flutter.plugin.audioPlay.AudioPlayPlugin;
import com.baidu.tieba.flutter.plugin.commonPlatformView.CommonPlatformViewPlugin;
import com.baidu.tieba.flutter.plugin.globalStateSync.globalStateSyncPlugin;
import com.baidu.tieba.flutter.plugin.imageLoader.ImageLoaderPlugin;
import com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerPlugin;
import com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoPlugin;
import com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin;
import com.baidu.tieba.flutter.plugin.passprovider.PassProviderPlugin;
import com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorPlugin;
import com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDPlugin;
import com.baidu.tieba.flutter.plugin.tiebaShare.TiebaSharePlugin;
import com.baidu.tieba.flutter.plugin.tiebautility.android.TiebaUtilityPlugin;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;
/* loaded from: classes12.dex */
public class FlutterPluginInit {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FlutterPluginInit() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void init(@NonNull FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, flutterEngine) == null) || flutterEngine == null) {
            return;
        }
        flutterEngine.getPlugins().add(new NetworkInfoPlugin());
        flutterEngine.getPlugins().add(new AudioPlayPlugin());
        flutterEngine.getPlugins().add(new CommonPlatformViewPlugin());
        flutterEngine.getPlugins().add(new globalStateSyncPlugin());
        flutterEngine.getPlugins().add(new ImageLoaderPlugin());
        flutterEngine.getPlugins().add(new ImagePickerPlugin());
        flutterEngine.getPlugins().add(new NetworkServicePlugin());
        flutterEngine.getPlugins().add(new ProgressHUDPlugin());
        flutterEngine.getPlugins().add(new PerformanceMonitorPlugin());
        flutterEngine.getPlugins().add(new TiebaSharePlugin());
        flutterEngine.getPlugins().add(new TiebaUtilityPlugin());
        flutterEngine.getPlugins().add(new WebViewFlutterPlugin());
        flutterEngine.getPlugins().add(new PassProviderPlugin());
    }
}
