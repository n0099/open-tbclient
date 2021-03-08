package com.baidu.tieba.ala.alaar;

import android.content.Context;
import com.baidu.live.tbadk.ar.ArFaceSdkInit;
import com.baidu.live.tbadk.ar.LoadARSDKCallBack;
import com.baidu.minivideo.arface.b;
/* loaded from: classes10.dex */
public class a implements ArFaceSdkInit {
    @Override // com.baidu.live.tbadk.ar.ArFaceSdkInit
    public void init(Context context) {
        b.init(context);
    }

    @Override // com.baidu.live.tbadk.ar.ArFaceSdkInit
    public void loadSDK(final LoadARSDKCallBack loadARSDKCallBack) {
        b.a(new b.a() { // from class: com.baidu.tieba.ala.alaar.a.1
            @Override // com.baidu.minivideo.arface.b.a
            public void onProgress(int i, int i2) {
            }

            @Override // com.baidu.minivideo.arface.b.a
            public void onResult(boolean z, String str) {
                loadARSDKCallBack.onResult(z, str);
            }
        });
    }
}
