package com.baidu.tieba.forumMember.member;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bf6;
import com.baidu.tieba.km8;
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
public class ForumMemberSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isNeedUpdateCache;
    public boolean mIsBawuShow;
    public boolean mIsPrivateForum;
    public ManagerApplyInfo mManagerApplyInfo;
    public MemberGodInfo mMemberGodInfo;
    public List<MemberGroupInfo> mMemberGroupInfoList;
    public PriManagerApplyInfo mPrivateMgrApplyInfo;
    public km8 mUserInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumMemberSocketResponseMessage() {
        super(301004);
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
        this.isNeedUpdateCache = false;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            GetMemberInfoResIdl getMemberInfoResIdl = (GetMemberInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMemberInfoResIdl.class);
            if (getMemberInfoResIdl != null) {
                Error error = getMemberInfoResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(getMemberInfoResIdl.error.usermsg);
                }
                if (getError() != 0) {
                    return getMemberInfoResIdl;
                }
                DataRes dataRes = getMemberInfoResIdl.data;
                if (dataRes != null) {
                    if (dataRes.forum_member_info != null) {
                        km8 km8Var = new km8();
                        this.mUserInfo = km8Var;
                        km8Var.x(getMemberInfoResIdl.data.forum_member_info.is_like.intValue());
                        this.mUserInfo.t(getMemberInfoResIdl.data.forum_member_info.cur_score.intValue());
                        this.mUserInfo.w(getMemberInfoResIdl.data.forum_member_info.levelup_score.intValue());
                        this.mUserInfo.y(getMemberInfoResIdl.data.forum_member_info.user_level.intValue());
                        this.mUserInfo.v(getMemberInfoResIdl.data.forum_member_info.level_name);
                    }
                    DataRes dataRes2 = getMemberInfoResIdl.data;
                    this.mMemberGroupInfoList = dataRes2.member_group_info;
                    this.mMemberGodInfo = dataRes2.member_god_info;
                    this.mManagerApplyInfo = dataRes2.manager_apply_info;
                    this.mIsBawuShow = dataRes2.is_bawuapply_show.intValue() != 0;
                    this.mIsPrivateForum = getMemberInfoResIdl.data.is_private_forum.intValue() != 0;
                    this.mPrivateMgrApplyInfo = getMemberInfoResIdl.data.primanager_apply_info;
                    this.isNeedUpdateCache = true;
                } else {
                    this.isNeedUpdateCache = false;
                }
            }
            return getMemberInfoResIdl;
        }
        return invokeIL.objValue;
    }

    public ManagerApplyInfo getManagerApplyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mManagerApplyInfo : (ManagerApplyInfo) invokeV.objValue;
    }

    public MemberGodInfo getMemberGodInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mMemberGodInfo : (MemberGodInfo) invokeV.objValue;
    }

    public List<MemberGroupInfo> getMemberGroupInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mMemberGroupInfoList : (List) invokeV.objValue;
    }

    public PriManagerApplyInfo getPrivateMgrApplyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPrivateMgrApplyInfo : (PriManagerApplyInfo) invokeV.objValue;
    }

    public km8 getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mUserInfo : (km8) invokeV.objValue;
    }

    public boolean isBawuShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIsBawuShow : invokeV.booleanValue;
    }

    public boolean isPrivateForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mIsPrivateForum : invokeV.booleanValue;
    }

    public void setManagerApplyInfo(ManagerApplyInfo managerApplyInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, managerApplyInfo) == null) {
            this.mManagerApplyInfo = managerApplyInfo;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && this.isNeedUpdateCache) {
            ForumMemberRequestMessage forumMemberRequestMessage = null;
            if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                forumMemberRequestMessage = (ForumMemberRequestMessage) getOrginalMessage().getExtra();
            }
            if (forumMemberRequestMessage != null) {
                bf6 bf6Var = new bf6();
                bf6Var.c(forumMemberRequestMessage.getForumName() + "", bArr);
            }
        }
    }
}
