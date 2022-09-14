package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import org.json.JSONObject;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class al9 implements RippedAd.Acceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ al9 a = new al9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ al9() {
    }

    @Override // com.fun.ad.sdk.internal.api.ripper.RippedAd.Acceptor
    public final String accept(Object obj) {
        InterceptResult invokeL;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            optString = ((JSONObject) obj).optString("url");
            return optString;
        }
        return (String) invokeL.objValue;
    }
}
