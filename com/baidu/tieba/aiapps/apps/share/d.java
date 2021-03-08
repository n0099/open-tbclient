package com.baidu.tieba.aiapps.apps.share;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
import com.baidu.swan.apps.t.b.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d implements i {
    i.a gov;
    private CustomMessageListener gow = new CustomMessageListener(2921366) { // from class: com.baidu.tieba.aiapps.apps.share.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.gov != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    d.this.gov.ayE();
                } else {
                    d.this.gov.ayF();
                }
            }
        }
    };

    public d() {
        TbadkCoreApplication.getInst().setSkinType(0);
        MessageManager.getInstance().registerListener(this.gow);
    }

    @Override // com.baidu.swan.apps.t.b.i
    public void a(Context context, JSONObject jSONObject, final i.a aVar) {
        if (context instanceof Activity) {
            this.gov = aVar;
            Bundle bundle = new Bundle();
            try {
                String optString = jSONObject.optString("shareUrl");
                if (StringUtils.isNull(optString)) {
                    optString = jSONObject.getString("linkUrl");
                }
                if (optString.indexOf("appid") > 0) {
                    jSONObject.put("linkUrl", "https://tieba.baidu.com/mo/q/smallapp/sharePage?from=singlemessage&isappinstalled=0#/?" + optString.substring(optString.indexOf("appid")));
                } else {
                    jSONObject.put("linkUrl", optString);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            bundle.putString("options", jSONObject.toString());
            bundle.putBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_SNAPSHOT, jSONObject.optBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_SNAPSHOT));
            bundle.putBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_FORCE_LIGHT_THEME, jSONObject.optBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_FORCE_LIGHT_THEME));
            bundle.putString("source", "swan_");
            bundle.putInt("screenOrientation", ((Activity) context).getRequestedOrientation());
            DelegateUtils.callOnMainWithActivity((Activity) context, AiAppsShareDelegateActivity.class, b.class, bundle, new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.share.d.2
                @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
                public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                    if (delegateResult.isOk()) {
                        if (delegateResult.mResult.getBoolean("share_result")) {
                            aVar.ayE();
                        } else {
                            aVar.ayF();
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.t.b.i
    public void a(Context context, String str, Uri uri) {
    }
}
