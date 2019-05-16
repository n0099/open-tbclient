package com.baidu.tieba.aiapps.apps.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.apps.u.b.d;
import java.net.URISyntaxException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements d {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.u.b.d
    public boolean e(Context context, JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        if (optString == null) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(optString, 1);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent(null);
            parseUri.setSelector(null);
            try {
                if (context instanceof Activity) {
                    return ((Activity) context).startActivityIfNeeded(parseUri, -1);
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        } catch (URISyntaxException e2) {
            return false;
        }
    }

    @Override // com.baidu.swan.apps.u.b.d
    public boolean a(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
        String optString = jSONObject.optString("url");
        if (optString == null) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(optString, 1);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent(null);
            parseUri.setSelector(null);
            try {
                if (context instanceof Activity) {
                    return ((Activity) context).startActivityIfNeeded(parseUri, -1);
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        } catch (URISyntaxException e2) {
            return false;
        }
    }
}
