package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.Map;
/* loaded from: classes5.dex */
public class g3b extends z2b<TTNativeAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g3b(TTNativeAd tTNativeAd) {
        super(tTNativeAd);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tTNativeAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.z2b
    public double a() {
        InterceptResult invokeV;
        Map<String, Object> mediaExtraInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                A a = this.a;
                if (a == 0 || (mediaExtraInfo = ((TTNativeAd) a).getMediaExtraInfo()) == null || !mediaExtraInfo.containsKey("price")) {
                    return 0.0d;
                }
                return ((Integer) mediaExtraInfo.get("price")).intValue() / 100.0d;
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeV.doubleValue;
    }

    @Override // com.baidu.tieba.z2b
    public void b(String str, double d, double d2, boolean z, int i) {
        A a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (a = this.a) == 0) {
            return;
        }
        TTNativeAd tTNativeAd = (TTNativeAd) a;
        if (z) {
            tTNativeAd.win(Double.valueOf(d2));
        } else {
            tTNativeAd.loss(Double.valueOf(d), str, String.valueOf(i));
        }
    }

    @Override // com.baidu.tieba.z2b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b.isEmpty() && ((TTNativeAd) this.a).getMediaExtraInfo() != null) {
                this.b = (String) ((TTNativeAd) this.a).getMediaExtraInfo().get(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }
}
