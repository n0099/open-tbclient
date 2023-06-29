package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import java.util.Map;
/* loaded from: classes5.dex */
public class eab extends z9b<RewardVideoAD> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eab(RewardVideoAD rewardVideoAD) {
        super(rewardVideoAD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rewardVideoAD};
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
        this.b = "";
    }

    @Override // com.baidu.tieba.z9b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (String) ((RewardVideoAD) this.a).getExtraInfo().get(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z9b
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z9b
    public void b(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            ((RewardVideoAD) this.a).sendLossNotification(map);
        }
    }

    @Override // com.baidu.tieba.z9b
    public void d(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            ((RewardVideoAD) this.a).sendWinNotification(map);
        }
    }

    @Override // com.baidu.tieba.z9b
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ((RewardVideoAD) this.a).getECPM();
        }
        return invokeV.intValue;
    }
}
