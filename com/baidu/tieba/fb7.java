package com.baidu.tieba;

import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.tieba.im.chat.emoji.ImEmojiUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class fb7 implements OnVideoErrorListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ fb7 a = new fb7();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ fb7() {
    }

    @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
    public final boolean onError(ErrorInfo errorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, errorInfo)) == null) ? ImEmojiUtil.f = false : invokeL.booleanValue;
    }
}
