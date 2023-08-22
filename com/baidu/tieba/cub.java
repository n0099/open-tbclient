package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
/* loaded from: classes5.dex */
public class cub extends fub<PushTokenResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cub(String str, IMessageEntity iMessageEntity) {
        super(str, iMessageEntity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iMessageEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (IMessageEntity) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.fub
    public void a(ApiException apiException, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, apiException, obj) == null) {
            if (apiException == null) {
                apiException = HonorPushErrorEnum.ERROR_UNKNOWN.toApiException();
            }
            if (apiException.getErrorCode() == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                if (obj instanceof PushTokenResult) {
                    PushTokenResult pushTokenResult = (PushTokenResult) obj;
                    try {
                        htb.b.b(jtb.e.a(), pushTokenResult.getPushToken());
                    } catch (Exception unused) {
                    }
                    this.e.b(pushTokenResult);
                    return;
                }
                apiException = HonorPushErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
            String str = "task execute failed. error:" + apiException.getErrorCode();
            this.e.a(apiException);
        }
    }
}
