package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
/* loaded from: classes4.dex */
public interface ek1 {
    void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode);

    void onLoadingComplete(String str, View view2, Bitmap bitmap);

    void onLoadingStarted(String str, View view2);
}
