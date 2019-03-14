package com.baidu.tieba.aiapps.apps.share;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
import com.baidu.swan.apps.u.b.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements u {
    u.a cWw;
    private CustomMessageListener cWx = new CustomMessageListener(2921366) { // from class: com.baidu.tieba.aiapps.apps.share.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.cWw != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cWw.Du();
                } else {
                    c.this.cWw.Dv();
                }
            }
        }
    };

    public c() {
        TbadkCoreApplication.getInst().setSkinType(0);
        MessageManager.getInstance().registerListener(this.cWx);
    }

    @Override // com.baidu.swan.apps.u.b.u
    public void a(Context context, JSONObject jSONObject, final u.a aVar) {
        if (context instanceof Activity) {
            this.cWw = aVar;
            Bundle bundle = new Bundle();
            bundle.putString("options", jSONObject.toString());
            bundle.putBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_SNAPSHOT, jSONObject.optBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_SNAPSHOT));
            bundle.putBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_FORCE_LIGHT_THEME, jSONObject.optBoolean(SwanAppUtilsJavaScriptInterface.KEY_SHARE_FORCE_LIGHT_THEME));
            bundle.putString("source", "swan_");
            bundle.putInt("screenOrientation", ((Activity) context).getRequestedOrientation());
            DelegateUtils.callOnMainWithActivity((Activity) context, AiAppsShareDelegateActivity.class, b.class, bundle, new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.share.c.2
                @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
                public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                    if (delegateResult.isOk()) {
                        if (delegateResult.mResult.getBoolean("share_result")) {
                            aVar.Du();
                        } else {
                            aVar.Dv();
                        }
                    }
                }
            });
        }
    }
}
