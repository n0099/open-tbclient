package com.baidu.tieba.aiapps.apps.i;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.adaptation.a.f;
import com.baidu.swan.apps.as.c;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a implements f {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.adaptation.a.f
    public boolean h(Context context, JSONObject jSONObject) {
        return o(context, jSONObject);
    }

    @Override // com.baidu.swan.apps.adaptation.a.f
    public boolean a(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
        return o(context, jSONObject);
    }

    @Override // com.baidu.swan.apps.adaptation.a.f
    public boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull com.baidu.swan.apps.adlanding.download.a.a aVar) {
        return o(context, jSONObject);
    }

    private boolean o(Context context, JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            d.a(AppRuntime.getAppContext(), "download url is empty");
            return false;
        }
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(optString));
        request.setDestinationInExternalPublicDir("", optString.substring(optString.lastIndexOf("/") + 1));
        DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
        if (downloadManager != null) {
            downloadManager.enqueue(request);
            return c.startActivitySafely(context, new Intent("android.intent.action.VIEW_DOWNLOADS"));
        }
        return false;
    }
}
