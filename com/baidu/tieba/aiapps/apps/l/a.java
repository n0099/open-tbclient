package com.baidu.tieba.aiapps.apps.l;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPluginIoc;
import com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask;
/* loaded from: classes4.dex */
public class a implements IAiAppPluginIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPluginIoc
    public void openDocument(Activity activity, Uri uri, String str) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPluginIoc
    public boolean isReadPluginAvailable(Context context, String str) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPluginIoc
    public void compressVideo(Context context, Bundle bundle, PickVideoTask.OnCompressResultCallback onCompressResultCallback) {
        onCompressResultCallback.onResult(false, null);
    }
}
