package com.baidu.tieba;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: VoiceManager.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class c75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static VoiceManager.IPlayView a(VoiceManager.k kVar, VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, kVar, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeLL.objValue;
    }
}
