package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes5.dex */
public final class b19 extends a19<ImageMsg, az8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.a19
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public b19() {
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
    @Override // com.baidu.tieba.a19
    /* renamed from: h */
    public ImageMsg e(az8 az8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, az8Var)) == null) {
            return new ImageMsg();
        }
        return (ImageMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a19
    /* renamed from: i */
    public az8 g(ImageMsg sdkMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sdkMsg)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            az8 az8Var = new az8();
            az8Var.e(sdkMsg.getRemoteUrl());
            az8Var.g(sdkMsg.getThumbUrl());
            az8Var.d(StringsKt__StringsKt.trim((CharSequence) sdkMsg.getMsgContent().toString()).toString());
            return az8Var;
        }
        return (az8) invokeL.objValue;
    }
}
