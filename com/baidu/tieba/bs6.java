package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.j67;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bs6 implements j67.m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bs6() {
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

    public static final void b(z77 state, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, state, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            for (ea7 ea7Var : state.i()) {
                ed7.a.b(ea7Var, state.g() + 1);
                state.f().invoke(ea7Var);
            }
        }
    }

    @Override // com.baidu.tieba.j67.s
    public void a(ViewGroup view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            if (view2 instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) view2).b();
            }
        }
    }

    @Override // com.baidu.tieba.j67.m
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new PlayVoiceBntNew(context, PlayVoiceBntNew.PLAY_TYPE.NORMAL);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j67.m
    public void update(ViewGroup view2, final z77 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, state) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(state, "state");
            if (view2 instanceof PlayVoiceBntNew) {
                ja7 h = state.h();
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.from = h.b();
                voiceModel.setVoiceId(h.c());
                voiceModel.setDuration(h.a());
                PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) view2;
                playVoiceBntNew.setVoiceModel(voiceModel);
                playVoiceBntNew.setTag(voiceModel);
                playVoiceBntNew.b();
                Integer num = voiceModel.voice_status;
                Intrinsics.checkNotNullExpressionValue(num, "voiceModel.voice_status");
                playVoiceBntNew.j(num.intValue());
                playVoiceBntNew.l();
                playVoiceBntNew.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mr6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            bs6.b(z77.this, view3);
                        }
                    }
                });
            }
        }
    }
}
