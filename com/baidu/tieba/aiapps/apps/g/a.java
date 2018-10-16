package com.baidu.tieba.aiapps.apps.g;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppHistoryIoc;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.GetSwanHistoryAction;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements IAiAppHistoryIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppHistoryIoc
    public void getSwanHistory(GetSwanHistoryAction.OnSwanHistoryListener onSwanHistoryListener) {
        onSwanHistoryListener.onFinish(new JSONObject());
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppHistoryIoc
    public boolean removeSwanHistory(String str, boolean z) {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppHistoryIoc
    public void saveAiAppInHistory(Context context, AiApp aiApp) {
    }
}
