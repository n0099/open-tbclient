package com.baidu.tieba.frs.itemtab.gamecode;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class GameCodeGetMsg extends HttpMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARAM_ITEM_ID = "item_id";
    public static final String PARAM_LIST_ID = "list_id";
    public transient /* synthetic */ FieldHolder $fh;
    public final int position;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCodeGetMsg(int i, int i2, int i3) {
        super(CmdConfigHttp.CMD_GET_GAME_CODE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.position = i;
        addParam("item_id", i2);
        addParam(PARAM_LIST_ID, i3);
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.position : invokeV.intValue;
    }
}
