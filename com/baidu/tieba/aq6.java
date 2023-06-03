package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.g37;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class aq6 implements g37.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public aq6() {
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

    @Override // com.baidu.tieba.g37.l
    public void a(ViewGroup view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            if (view2 instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) view2).e();
            }
        }
    }

    @Override // com.baidu.tieba.g37.h
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new PlayVoiceBntNew(context, PlayVoiceBntNew.PLAY_TYPE.NORMAL);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g37.h
    public void update(ViewGroup view2, Object data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, data) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(data, "data");
            if ((view2 instanceof PlayVoiceBntNew) && (data instanceof VoiceData.VoiceModel)) {
                PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) view2;
                VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) data;
                playVoiceBntNew.setVoiceModel(voiceModel);
                playVoiceBntNew.setTag(data);
                playVoiceBntNew.e();
                Integer num = voiceModel.voice_status;
                Intrinsics.checkNotNullExpressionValue(num, "data.voice_status");
                playVoiceBntNew.m(num.intValue());
                playVoiceBntNew.o();
            }
        }
    }
}
