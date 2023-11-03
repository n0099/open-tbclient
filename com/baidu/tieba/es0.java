package com.baidu.tieba;

import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.StateEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class es0 extends js0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static js0 x(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, playerStatus, playerStatus2)) == null) {
            js0 n = js0.n(StateEvent.ACTION_STATE_CHANGED, 5);
            n.o(1, playerStatus);
            n.o(2, playerStatus2);
            return n;
        }
        return (js0) invokeLL.objValue;
    }
}
