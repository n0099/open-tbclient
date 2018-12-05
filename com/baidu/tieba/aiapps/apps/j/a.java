package com.baidu.tieba.aiapps.apps.j;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.download.DownloadActionCallback;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppDownloadIoc;
/* loaded from: classes4.dex */
public class a implements IAiAppDownloadIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppDownloadIoc
    public boolean downloadApp(Context context, String str, String str2, DownloadActionCallback downloadActionCallback) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppDownloadIoc
    public Object registerDownloadTips(Activity activity, boolean z, boolean z2) {
        return null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppDownloadIoc
    public void unRegisterDownloadTips(Object obj) {
    }
}
