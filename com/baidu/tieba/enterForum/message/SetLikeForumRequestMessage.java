package com.baidu.tieba.enterForum.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.la5;
import com.baidu.tieba.sh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SetLikeForumSort.DataReq;
import tbclient.SetLikeForumSort.SetLikeForumSortReqIdl;
/* loaded from: classes3.dex */
public class SetLikeForumRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String moveList;
    public String originalLikeList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetLikeForumRequestMessage() {
        super(CmdConfigHttp.CMD_SET_LIKE_FORUM, 309685);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.original_like_list = this.originalLikeList;
                builder.new_like_list = this.moveList;
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    builder.tbs = la5.f();
                } else {
                    builder.tbs = TbadkCoreApplication.getInst().getTbs();
                }
                if (z) {
                    sh5.c(builder, true, true, false);
                }
                SetLikeForumSortReqIdl.Builder builder2 = new SetLikeForumSortReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public String getMoveList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.moveList : (String) invokeV.objValue;
    }

    public String getOriginalLikeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.originalLikeList : (String) invokeV.objValue;
    }

    public void setMoveList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.moveList = str;
        }
    }

    public void setOriginalLikeList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.originalLikeList = str;
        }
    }
}
