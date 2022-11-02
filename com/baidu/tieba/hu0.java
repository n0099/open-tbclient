package com.baidu.tieba;

import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.StateEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hu0 extends mu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hu0() {
        super(StateEvent.ACTION_STATE_CHANGED);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        v(5);
    }

    public static mu0 w(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, playerStatus, playerStatus2)) == null) {
            mu0 m = mu0.m(StateEvent.ACTION_STATE_CHANGED, 5);
            m.n(1, playerStatus);
            m.n(2, playerStatus2);
            return m;
        }
        return (mu0) invokeLL.objValue;
    }
}
