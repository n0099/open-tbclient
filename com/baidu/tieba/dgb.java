package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.Map;
/* loaded from: classes5.dex */
public class dgb extends qfb<TTNativeExpressAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dgb(TTNativeExpressAd tTNativeExpressAd) {
        super(tTNativeExpressAd);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tTNativeExpressAd};
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

    @Override // com.baidu.tieba.qfb
    public double a() {
        InterceptResult invokeV;
        Map<String, Object> mediaExtraInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                A a = this.a;
                if (a == 0 || (mediaExtraInfo = ((TTNativeExpressAd) a).getMediaExtraInfo()) == null || !mediaExtraInfo.containsKey("price")) {
                    return 0.0d;
                }
                return ((Integer) mediaExtraInfo.get("price")).intValue() / 100.0d;
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeV.doubleValue;
    }

    @Override // com.baidu.tieba.qfb
    public void b(String str, double d, double d2, boolean z, int i) {
        A a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (a = this.a) == 0) {
            return;
        }
        TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) a;
        if (z) {
            tTNativeExpressAd.win(Double.valueOf(d2));
        } else {
            tTNativeExpressAd.loss(Double.valueOf(d), str, String.valueOf(i));
        }
    }

    @Override // com.baidu.tieba.qfb
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b.isEmpty() && ((TTNativeExpressAd) this.a).getMediaExtraInfo() != null) {
                this.b = (String) ((TTNativeExpressAd) this.a).getMediaExtraInfo().get(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }
}
