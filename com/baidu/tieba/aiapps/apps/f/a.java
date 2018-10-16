package com.baidu.tieba.aiapps.apps.f;

import android.os.Bundle;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppFeedbackIoc;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
/* loaded from: classes4.dex */
public class a implements IAiAppFeedbackIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppFeedbackIoc
    public void feedback(Bundle bundle, IAiAppFeedbackIoc.OnFeedbackResultCallback onFeedbackResultCallback) {
        onFeedbackResultCallback.onResult(AiAppNetworkUtils.NETWORK_TYPE_CELL_UN_CONNECTED);
    }
}
