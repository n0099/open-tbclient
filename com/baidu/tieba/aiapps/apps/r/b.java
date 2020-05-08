package com.baidu.tieba.aiapps.apps.r;

import android.content.Context;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.swan.apps.w.b.m;
/* loaded from: classes12.dex */
public class b implements m {
    @Override // com.baidu.swan.apps.w.b.m
    public String bG(Context context) {
        return !ProcessUtils.isMainProcess() ? cG(context) : getZid(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getZid(Context context) {
        return FH.gzfi(context, null, 0, null);
    }

    private String cG(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, a.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }
}
