package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.openid.sdk.OnGetOaidListener;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class ag9 implements OnGetOaidListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ ag9 a = new ag9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ ag9() {
    }

    @Override // com.fun.openid.sdk.OnGetOaidListener
    public final void onGetOaid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            HostAppInfo.a(str);
        }
    }
}
