package com.baidu.tieba.im.forum.detail;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
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
public class ForumDetailHttpResponse extends TbHttpResponsedMessage {
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
    public ForumDetailHttpResponse(int i) {
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
    }

    public ManagerApplyInfo getApplyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.applyInfo : (ManagerApplyInfo) invokeV.objValue;
    }

    public BzApplySwitch getBzApplySwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.bzApplySwitch : (BzApplySwitch) invokeV.objValue;
    }

    public RecommendForumInfo getForumInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.forumInfo : (RecommendForumInfo) invokeV.objValue;
    }

    public ManagerElectionTab getManagerElectionTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.managerElectionTab : (ManagerElectionTab) invokeV.objValue;
    }

    public PriManagerApplyInfo getPrivateApplyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.privateApplyInfo : (PriManagerApplyInfo) invokeV.objValue;
    }

    public List<SimpleThreadInfo> getThreadInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.threadInfoList : (List) invokeV.objValue;
    }

    public int isBawuShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isBawuShow : invokeV.intValue;
    }

    public boolean isComplaintShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isComplaintShow : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            GetForumDetailResIdl getForumDetailResIdl = (GetForumDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumDetailResIdl.class);
            if (getForumDetailResIdl == null) {
                return;
            }
            Error error = getForumDetailResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getForumDetailResIdl.error.usermsg);
            }
            DataRes dataRes = getForumDetailResIdl.data;
            if (dataRes == null) {
                return;
            }
            this.forumInfo = dataRes.forum_info;
            this.threadInfoList = dataRes.thread_list;
            this.isBawuShow = dataRes.is_bawu_show.intValue();
            DataRes dataRes2 = getForumDetailResIdl.data;
            this.applyInfo = dataRes2.bz_apply_info;
            this.isComplaintShow = dataRes2.is_complaint_show.intValue() != 0;
            DataRes dataRes3 = getForumDetailResIdl.data;
            this.privateApplyInfo = dataRes3.pribz_apply_info;
            this.managerElectionTab = dataRes3.election_tab;
        }
    }
}
