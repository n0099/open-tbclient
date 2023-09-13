package com.baidu.tbadk.switchs;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.bl1;
import com.baidu.tieba.xe;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class UniKVTestFetcher extends bl1<xe> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UniKVTestFetcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.bl1
    public xe createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new xe(this) { // from class: com.baidu.tbadk.switchs.UniKVTestFetcher.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UniKVTestFetcher this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.tieba.xe
                public boolean isTypeDoubleKv() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                        return UniKVTestSwitch.isTypeDoubleKv();
                    }
                    return invokeV2.booleanValue;
                }

                @Override // com.baidu.tieba.xe
                public boolean isTypeDoubleSp() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return UniKVTestSwitch.isTypeDoubleSp();
                    }
                    return invokeV2.booleanValue;
                }

                @Override // com.baidu.tieba.xe
                public boolean isTypeSp() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return UniKVTestSwitch.isTypeSp();
                    }
                    return invokeV2.booleanValue;
                }
            };
        }
        return (xe) invokeV.objValue;
    }
}
