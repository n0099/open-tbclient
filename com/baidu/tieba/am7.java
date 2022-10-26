package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.live.interfaces.service.ILivePlayerService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class am7 implements ILivePlayerService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public boolean isAuthError(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i == -2403 || i == -33403 : invokeI.booleanValue;
    }

    public am7() {
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

    public final LivePlayer a(BuildParams buildParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, buildParams)) == null) {
            return new cm7(buildParams);
        }
        return (LivePlayer) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public LivePlayer createBackPlayer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return new wl7(str);
        }
        return (LivePlayer) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public LivePlayer createPlayer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return new xl7(str);
        }
        return (LivePlayer) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public LivePlayer createPlayer(BuildParams buildParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, buildParams)) == null) {
            int playerType = buildParams.getPlayerType();
            if (playerType != 1) {
                if (playerType != 2) {
                    return createPlayer(buildParams.getRoomId());
                }
                return a(buildParams);
            }
            return createBackPlayer(buildParams.getRoomId());
        }
        return (LivePlayer) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public void initPlayerEvn(CyberPlayerManager.InstallListener installListener, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, installListener, i) == null) {
            yl7.e().h(installListener, i);
        }
    }
}
