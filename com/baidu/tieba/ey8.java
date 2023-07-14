package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.AudioMsg;
import com.baidu.tieba.impersonal.data.VoiceMsgContent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ey8 extends yx8<AudioMsg, VoiceMsgContent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947750789, "Lcom/baidu/tieba/ey8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947750789, "Lcom/baidu/tieba/ey8;");
        }
    }

    @Override // com.baidu.tieba.yx8
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    public ey8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yx8
    /* renamed from: h */
    public AudioMsg e(VoiceMsgContent voiceMsgContent) {
        InterceptResult invokeL;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voiceMsgContent)) == null) {
            String str2 = (voiceMsgContent == null || (str2 = voiceMsgContent.b()) == null) ? "" : "";
            if (voiceMsgContent != null) {
                i = voiceMsgContent.a();
            } else {
                i = 0;
            }
            AudioMsg audioMsg = new AudioMsg(str2, i, 2);
            if (voiceMsgContent != null) {
                str = voiceMsgContent.f();
            } else {
                str = null;
            }
            audioMsg.setRemoteUrl(str);
            return audioMsg;
        }
        return (AudioMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yx8
    /* renamed from: i */
    public VoiceMsgContent g(AudioMsg sdkMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sdkMsg)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            VoiceMsgContent voiceMsgContent = new VoiceMsgContent();
            String localUrl = sdkMsg.getLocalUrl();
            Intrinsics.checkNotNullExpressionValue(localUrl, "sdkMsg.localUrl");
            voiceMsgContent.i(localUrl);
            String remoteUrl = sdkMsg.getRemoteUrl();
            Intrinsics.checkNotNullExpressionValue(remoteUrl, "sdkMsg.remoteUrl");
            voiceMsgContent.k(remoteUrl);
            voiceMsgContent.h(sdkMsg.getDuration());
            return voiceMsgContent;
        }
        return (VoiceMsgContent) invokeL.objValue;
    }
}
