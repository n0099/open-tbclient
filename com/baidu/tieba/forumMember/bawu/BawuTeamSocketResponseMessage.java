package com.baidu.tieba.forumMember.bawu;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.b1.a.d;
import com.baidu.adp.framework.message.SocketResponsedMessage;
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
/* loaded from: classes12.dex */
public class BawuTeamSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String cacheKey;
    public boolean isNeedUpdateCache;
    public BawuTeam mBawuTeamInfo;
    public int mIsPrivateForum;
    public ManagerApplyInfo mManagerApplyInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BawuTeamSocketResponseMessage() {
        super(301007);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isNeedUpdateCache = false;
    }

    public BawuTeam getBawuTeamInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBawuTeamInfo : (BawuTeam) invokeV.objValue;
    }

    public ManagerApplyInfo getManagerApplyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mManagerApplyInfo : (ManagerApplyInfo) invokeV.objValue;
    }

    public int isPrivateForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIsPrivateForum : invokeV.intValue;
    }

    public void setBawuTeamInfo(BawuTeam bawuTeam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bawuTeam) == null) {
            this.mBawuTeamInfo = bawuTeam;
        }
    }

    public void setManagerApplyInfo(ManagerApplyInfo managerApplyInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, managerApplyInfo) == null) {
            this.mManagerApplyInfo = managerApplyInfo;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) && this.isNeedUpdateCache) {
            BawuTeamRequestMessage bawuTeamRequestMessage = null;
            if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                bawuTeamRequestMessage = (BawuTeamRequestMessage) getOrginalMessage().getExtra();
            }
            if (bawuTeamRequestMessage != null) {
                this.cacheKey = "" + bawuTeamRequestMessage.getForumId();
            }
            new d().c(this.cacheKey, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) || bArr == null) {
            return;
        }
        GetBawuInfoResIdl getBawuInfoResIdl = (GetBawuInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBawuInfoResIdl.class);
        setError(getBawuInfoResIdl.error.errorno.intValue());
        setErrorString(getBawuInfoResIdl.error.usermsg);
        if (getError() == 0 && (dataRes = getBawuInfoResIdl.data) != null) {
            this.mBawuTeamInfo = dataRes.bawu_team_info;
            this.mIsPrivateForum = dataRes.is_private_forum.intValue();
            this.mManagerApplyInfo = getBawuInfoResIdl.data.manager_apply_info;
            this.isNeedUpdateCache = true;
        }
    }
}
