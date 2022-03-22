package com.baidu.tieba.danmu.ui;

import android.os.HandlerThread;
import android.os.Looper;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/baidu/tieba/danmu/ui/DanmakuPlayer$ActionHandler;", "Lcom/baidu/tieba/danmu/ui/DanmakuPlayer;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class DanmakuPlayer$actionHandler$2 extends Lambda implements Function0<DanmakuPlayer.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ DanmakuPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanmakuPlayer$actionHandler$2(DanmakuPlayer danmakuPlayer) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {danmakuPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = danmakuPlayer;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DanmakuPlayer.a invoke() {
        InterceptResult invokeV;
        HandlerThread h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DanmakuPlayer danmakuPlayer = this.this$0;
            h2 = danmakuPlayer.h();
            Looper looper = h2.getLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "actionThread.looper");
            return new DanmakuPlayer.a(danmakuPlayer, looper);
        }
        return (DanmakuPlayer.a) invokeV.objValue;
    }
}
