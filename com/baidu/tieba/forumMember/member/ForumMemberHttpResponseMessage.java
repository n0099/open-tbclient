package com.baidu.tieba.forumMember.member;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.w49;
import com.baidu.tieba.xs6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GetMemberInfo.DataRes;
import tbclient.GetMemberInfo.GetMemberInfoResIdl;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
/* loaded from: classes4.dex */
public class ForumMemberHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isNeedUpdateCache;
    public boolean mIsBawuShow;
    public boolean mIsPrivateForum;
    public ManagerApplyInfo mManagerApplyInfo;
    public MemberGodInfo mMemberGodInfo;
    public List<MemberGroupInfo> mMemberGroupInfoList;
    public PriManagerApplyInfo mPrivateMgrApplyInfo;
    public w49 mUserInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumMemberHttpResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || !this.isNeedUpdateCache) {
            return;
        }
        ForumMemberRequestMessage forumMemberRequestMessage = null;
        if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
            forumMemberRequestMessage = (ForumMemberRequestMessage) getOrginalMessage().getExtra();
        }
        if (forumMemberRequestMessage != null) {
            xs6 xs6Var = new xs6();
            xs6Var.c(forumMemberRequestMessage.getForumName() + "", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            boolean z2 = false;
            GetMemberInfoResIdl getMemberInfoResIdl = (GetMemberInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMemberInfoResIdl.class);
            if (getMemberInfoResIdl != null) {
                Error error = getMemberInfoResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(getMemberInfoResIdl.error.usermsg);
                }
                if (getError() != 0) {
                    return;
                }
                DataRes dataRes = getMemberInfoResIdl.data;
                if (dataRes != null) {
                    if (dataRes.forum_member_info != null) {
                        w49 w49Var = new w49();
                        this.mUserInfo = w49Var;
                        w49Var.y(getMemberInfoResIdl.data.forum_member_info.is_like.intValue());
                        this.mUserInfo.u(getMemberInfoResIdl.data.forum_member_info.cur_score.intValue());
                        this.mUserInfo.x(getMemberInfoResIdl.data.forum_member_info.levelup_score.intValue());
                        this.mUserInfo.A(getMemberInfoResIdl.data.forum_member_info.user_level.intValue());
                        this.mUserInfo.w(getMemberInfoResIdl.data.forum_member_info.level_name);
                    }
                    DataRes dataRes2 = getMemberInfoResIdl.data;
                    this.mMemberGroupInfoList = dataRes2.member_group_info;
                    this.mMemberGodInfo = dataRes2.member_god_info;
                    this.mManagerApplyInfo = dataRes2.manager_apply_info;
                    if (dataRes2.is_bawuapply_show.intValue() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mIsBawuShow = z;
                    if (getMemberInfoResIdl.data.is_private_forum.intValue() != 0) {
                        z2 = true;
                    }
                    this.mIsPrivateForum = z2;
                    this.mPrivateMgrApplyInfo = getMemberInfoResIdl.data.primanager_apply_info;
                    this.isNeedUpdateCache = true;
                    return;
                }
                this.isNeedUpdateCache = false;
            }
        }
    }

    public ManagerApplyInfo getManagerApplyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mManagerApplyInfo;
        }
        return (ManagerApplyInfo) invokeV.objValue;
    }

    public MemberGodInfo getMemberGodInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mMemberGodInfo;
        }
        return (MemberGodInfo) invokeV.objValue;
    }

    public List<MemberGroupInfo> getMemberGroupInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mMemberGroupInfoList;
        }
        return (List) invokeV.objValue;
    }

    public PriManagerApplyInfo getPrivateMgrApplyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mPrivateMgrApplyInfo;
        }
        return (PriManagerApplyInfo) invokeV.objValue;
    }

    public w49 getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mUserInfo;
        }
        return (w49) invokeV.objValue;
    }

    public boolean isBawuShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mIsBawuShow;
        }
        return invokeV.booleanValue;
    }

    public boolean isPrivateForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mIsPrivateForum;
        }
        return invokeV.booleanValue;
    }

    public void setManagerApplyInfo(ManagerApplyInfo managerApplyInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, managerApplyInfo) == null) {
            this.mManagerApplyInfo = managerApplyInfo;
        }
    }
}
