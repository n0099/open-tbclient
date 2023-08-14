package com.baidu.tieba;

import com.baidu.tieba.impersonal.template.PersonalImageMsgTemplate;
import com.baidu.tieba.impersonal.template.PersonalTextMsgTemplate;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class ft8 implements m97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final kv8 a;

    public ft8(kv8 sendTransfer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sendTransfer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(sendTransfer, "sendTransfer");
        this.a = sendTransfer;
    }

    @Override // com.baidu.tieba.m97
    public List<u97<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PersonalTextMsgTemplate("text_left", this.a));
            arrayList.add(new PersonalTextMsgTemplate("text_right", this.a));
            arrayList.add(new tv8("loading_left"));
            arrayList.add(new uv8("voice_left"));
            arrayList.add(new PersonalImageMsgTemplate("image_left"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
