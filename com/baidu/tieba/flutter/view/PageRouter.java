package com.baidu.tieba.flutter.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.baidu.tieba.flutter.util.OpenNative;
import java.util.Map;
/* loaded from: classes4.dex */
public class PageRouter {
    public static final String FLUTTER_PAGE_URL = "f2f://";
    public static final String NATIVE_PAGE_URL = "f2n://";

    @TargetApi(11)
    public static boolean openPageByUrl(Context context, String str, Map<String, Object> map) {
        try {
            if (str.startsWith(NATIVE_PAGE_URL)) {
                return OpenNative.toNativePage(context, Uri.parse(str).getHost(), map);
            }
            if (str.startsWith(FLUTTER_PAGE_URL)) {
                return OpenFlutter.openFlutterPage(context, Uri.parse(str).getHost(), map);
            }
            BdLog.e("flutter openPageByUrl not match");
            return false;
        } catch (Throwable th) {
            BdLog.e("flutter openPageByUrl error:" + th);
            return false;
        }
    }
}
