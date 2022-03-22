package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.DataRes;
import tbclient.GetBawuInfo.GetBawuInfoResIdl;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes5.dex */
public class BawuTeamReadCacheResponseMessage extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeam mBawuTeamInfo;
    public int mIsPrivateForum;
    public ManagerApplyInfo mManagerApplyInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BawuTeamReadCacheResponseMessage() {
        super(2003005);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, bArr) == null) || bArr == null) {
            return;
        }
        GetBawuInfoResIdl getBawuInfoResIdl = (GetBawuInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBawuInfoResIdl.class);
        setError(getBawuInfoResIdl.error.errorno.intValue());
        setErrorString(getBawuInfoResIdl.error.usermsg);
        if (getError() == 0 && (dataRes = getBawuInfoResIdl.data) != null) {
            this.mBawuTeamInfo = dataRes.bawu_team_info;
            this.mIsPrivateForum = dataRes.is_private_forum.intValue();
            this.mManagerApplyInfo = getBawuInfoResIdl.data.manager_apply_info;
        }
    }

    public BawuTeam getBawuTeamInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBawuTeamInfo : (BawuTeam) invokeV.objValue;
    }

    public ManagerApplyInfo getManagerApplyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mManagerApplyInfo : (ManagerApplyInfo) invokeV.objValue;
    }

    public int isPrivateForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsPrivateForum : invokeV.intValue;
    }

    public void setBawuTeamInfo(BawuTeam bawuTeam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bawuTeam) == null) {
            this.mBawuTeamInfo = bawuTeam;
        }
    }

    public void setManagerApplyInfo(ManagerApplyInfo managerApplyInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, managerApplyInfo) == null) {
            this.mManagerApplyInfo = managerApplyInfo;
        }
    }
}
