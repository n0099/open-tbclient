package com.baidu.tieba.aiapps.apps.c;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.barcode.IAiAppScanCodeIoc;
import com.baidu.searchbox.ng.ai.apps.barcode.IScanResultCallback;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements IAiAppScanCodeIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.barcode.IAiAppScanCodeIoc
    public void scanCode(Context context, IScanResultCallback iScanResultCallback) {
        iScanResultCallback.onResult(new JSONObject(), 0);
    }
}
