package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface gs3 {
    String a();

    boolean b(Context context, Intent intent, String str, String str2, String str3);

    String c();

    boolean d(Context context, JSONObject jSONObject, DownloadParams.SwanAppDownloadType swanAppDownloadType, nr3 nr3Var);

    String e();

    String f(String str);

    String g();

    String getAppId();

    String getAppKey();

    String getScene();

    String getSdkVersion();

    int h();

    String i(String str);

    int j();

    int k();

    Uri l(Context context, File file);

    String m();

    JSONObject n();

    boolean o(View view2);
}
