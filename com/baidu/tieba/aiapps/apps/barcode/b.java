package com.baidu.tieba.aiapps.apps.barcode;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.u.b.h;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import java.nio.charset.Charset;
/* loaded from: classes12.dex */
public class b implements h {
    @Override // com.baidu.swan.apps.u.b.h
    public void a(Context context, final com.baidu.swan.apps.f.a aVar) {
        if (context instanceof Activity) {
            DelegateUtils.callOnMainWithActivity((Activity) context, ScanCodeDelegateActivity.class, a.class, new Bundle(), new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.barcode.b.1
                @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
                public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                    if (delegateResult.isOk()) {
                        aVar.onSuccess(delegateResult.mResult.getString(QRCodeScanActivityConfig.RESULT_SCAN_CODE, ""), "", Charset.defaultCharset().name());
                    }
                }
            });
        }
    }
}
