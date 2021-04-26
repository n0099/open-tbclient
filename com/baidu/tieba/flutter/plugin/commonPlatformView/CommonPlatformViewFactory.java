package com.baidu.tieba.flutter.plugin.commonPlatformView;

import android.content.Context;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class CommonPlatformViewFactory extends PlatformViewFactory {
    public static HashMap<String, CommonPlatformView> viewMap = new HashMap<>();
    public final BinaryMessenger messenger;

    public CommonPlatformViewFactory(BinaryMessenger binaryMessenger) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = binaryMessenger;
    }

    public static void removePlatformViewByPersistentViewId(int i2) {
        if (viewMap.containsKey(String.valueOf(i2))) {
            viewMap.remove(Integer.valueOf(i2));
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewFactory
    public PlatformView create(Context context, int i2, Object obj) {
        Map map = (obj == null || !(obj instanceof Map)) ? null : (Map) obj;
        String valueOf = map == null ? "0" : String.valueOf(map.get("persistentViewId"));
        if (Integer.parseInt(valueOf) < 0) {
            CommonPlatformView commonPlatformView = viewMap.get(valueOf);
            if (commonPlatformView == null) {
                CommonPlatformView commonPlatformView2 = new CommonPlatformView(context, this.messenger, i2, map);
                viewMap.put(valueOf, commonPlatformView2);
                return commonPlatformView2;
            }
            return commonPlatformView;
        }
        return new CommonPlatformView(context, this.messenger, i2, map);
    }
}
