package com.baidu.tieba.im.forum.detail;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.DataRes;
import tbclient.GetForumDetail.GetForumDetailResIdl;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.ManagerApplyInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes4.dex */
public class ForumDetailSocketResponse extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ManagerApplyInfo applyInfo;
    public BzApplySwitch bzApplySwitch;
    public RecommendForumInfo forumInfo;
    public int isBawuShow;
    public boolean isComplaintShow;
    public ManagerElectionTab managerElectionTab;
    public PriManagerApplyInfo privateApplyInfo;
    public List<SimpleThreadInfo> threadInfoList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumDetailSocketResponse() {
        super(303021);
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

    public ManagerApplyInfo getApplyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.applyInfo;
        }
        return (ManagerApplyInfo) invokeV.objValue;
    }

    public BzApplySwitch getBzApplySwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.bzApplySwitch;
        }
        return (BzApplySwitch) invokeV.objValue;
    }

    public RecommendForumInfo getForumInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.forumInfo;
        }
        return (RecommendForumInfo) invokeV.objValue;
    }

    public ManagerElectionTab getManagerElectionTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.managerElectionTab;
        }
        return (ManagerElectionTab) invokeV.objValue;
    }

    public PriManagerApplyInfo getPrivateApplyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.privateApplyInfo;
        }
        return (PriManagerApplyInfo) invokeV.objValue;
    }

    public List<SimpleThreadInfo> getThreadInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.threadInfoList;
        }
        return (List) invokeV.objValue;
    }

    public int isBawuShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.isBawuShow;
        }
        return invokeV.intValue;
    }

    public boolean isComplaintShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.isComplaintShow;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            boolean z = false;
            GetForumDetailResIdl getForumDetailResIdl = (GetForumDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumDetailResIdl.class);
            if (getForumDetailResIdl == null) {
                return null;
            }
            Error error = getForumDetailResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getForumDetailResIdl.error.usermsg);
            }
            DataRes dataRes = getForumDetailResIdl.data;
            if (dataRes == null) {
                return getForumDetailResIdl;
            }
            this.forumInfo = dataRes.forum_info;
            this.threadInfoList = dataRes.thread_list;
            this.isBawuShow = dataRes.is_bawu_show.intValue();
            if (getForumDetailResIdl.data.is_complaint_show.intValue() != 0) {
                z = true;
            }
            this.isComplaintShow = z;
            DataRes dataRes2 = getForumDetailResIdl.data;
            this.applyInfo = dataRes2.bz_apply_info;
            this.privateApplyInfo = dataRes2.pribz_apply_info;
            this.managerElectionTab = dataRes2.election_tab;
            return getForumDetailResIdl;
        }
        return invokeIL.objValue;
    }
}
