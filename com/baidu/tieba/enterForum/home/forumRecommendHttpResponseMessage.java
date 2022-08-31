package com.baidu.tieba.enterForum.home;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.ur4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.ForumCreateInfo;
import tbclient.ForumPopupInfo;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
import tbclient.ForumRecommend.LikeForum;
import tbclient.FrsTabInfo;
import tbclient.PrivatePopInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class forumRecommendHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumCreateInfo forum_create_info;
    public ForumPopupInfo forum_popup_info;
    public HotSearchInfoData hotSearchInfo;
    public List<LikeForum> like_forum;
    public PrivatePopInfo private_pop_info;
    public List<RecommendForumInfo> recommend_concern_forums;
    public List<RecommendForumInfo> recommend_forum_info;
    public Integer sortType;
    public List<FrsTabInfo> tabFeedList;
    public Integer time;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public forumRecommendHttpResponseMessage(int i) {
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
        this.sortType = 0;
    }

    public List<LikeForum> GetLikeForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.like_forum : (List) invokeV.objValue;
    }

    public List<RecommendForumInfo> GetRecommendForumInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.recommend_forum_info : (List) invokeV.objValue;
    }

    public Integer GetTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.time : (Integer) invokeV.objValue;
    }

    public ForumCreateInfo getForumCreateInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.forum_create_info : (ForumCreateInfo) invokeV.objValue;
    }

    public ForumPopupInfo getForumPopUpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.forum_popup_info : (ForumPopupInfo) invokeV.objValue;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.hotSearchInfo : (HotSearchInfoData) invokeV.objValue;
    }

    public PrivatePopInfo getPrivatePopInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.private_pop_info : (PrivatePopInfo) invokeV.objValue;
    }

    public List<RecommendForumInfo> getRecommendConcernForums() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.recommend_concern_forums : (List) invokeV.objValue;
    }

    public Integer getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.sortType : (Integer) invokeV.objValue;
    }

    public List<FrsTabInfo> getTabFeedList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.tabFeedList : (List) invokeV.objValue;
    }

    public void setSortType(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, num) == null) {
            this.sortType = num;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, bArr) == null) || bArr == null || bArr.length <= 0 || getError() != 0) {
            return;
        }
        ur4.f();
        ur4.e("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName()).a(EnterForumModel.FORUMRECOMMEND_CACHE_KEY, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ForumRecommendResIdl forumRecommendResIdl;
        DataRes dataRes;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) || bArr == null || (forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class)) == null) {
            return;
        }
        Error error = forumRecommendResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = forumRecommendResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(forumRecommendResIdl.error.usermsg);
        }
        if (getError() == 0 && (dataRes = forumRecommendResIdl.data) != null) {
            this.like_forum = dataRes.like_forum;
            this.time = dataRes.time;
            this.recommend_forum_info = dataRes.recommend_forum_info;
            if (dataRes.hot_search != null) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                this.hotSearchInfo = hotSearchInfoData;
                hotSearchInfoData.A(forumRecommendResIdl.data.hot_search);
            }
            DataRes dataRes2 = forumRecommendResIdl.data;
            this.recommend_concern_forums = dataRes2.tag_recommend_forum;
            this.sortType = Integer.valueOf(dataRes2.sort_type.intValue() == 0 ? 1 : forumRecommendResIdl.data.sort_type.intValue());
            DataRes dataRes3 = forumRecommendResIdl.data;
            this.forum_create_info = dataRes3.forum_create_info;
            this.private_pop_info = dataRes3.private_forum_popinfo;
            this.tabFeedList = dataRes3.nav_tab_info;
            this.forum_popup_info = dataRes3.forum_popup_info;
        }
    }
}
