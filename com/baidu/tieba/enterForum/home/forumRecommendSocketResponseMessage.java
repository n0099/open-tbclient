package com.baidu.tieba.enterForum.home;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.yz4;
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
/* loaded from: classes4.dex */
public class forumRecommendSocketResponseMessage extends SocketResponsedMessage {
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
    public forumRecommendSocketResponseMessage() {
        super(303011);
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

    public List<LikeForum> GetLikeForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.like_forum;
        }
        return (List) invokeV.objValue;
    }

    public List<RecommendForumInfo> GetRecommendForumInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.recommend_forum_info;
        }
        return (List) invokeV.objValue;
    }

    public Integer GetTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.time;
        }
        return (Integer) invokeV.objValue;
    }

    public ForumCreateInfo getForumCreateInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.forum_create_info;
        }
        return (ForumCreateInfo) invokeV.objValue;
    }

    public ForumPopupInfo getForumPopupInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.forum_popup_info;
        }
        return (ForumPopupInfo) invokeV.objValue;
    }

    public HotSearchInfoData getHotSearchInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.hotSearchInfo;
        }
        return (HotSearchInfoData) invokeV.objValue;
    }

    public PrivatePopInfo getPrivatePopInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.private_pop_info;
        }
        return (PrivatePopInfo) invokeV.objValue;
    }

    public List<RecommendForumInfo> getRecommendConcernForums() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.recommend_concern_forums;
        }
        return (List) invokeV.objValue;
    }

    public Integer getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.sortType;
        }
        return (Integer) invokeV.objValue;
    }

    public List<FrsTabInfo> getTabFeedList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.tabFeedList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, bArr) == null) && bArr != null && bArr.length > 0 && getError() == 0) {
            yz4.d();
            yz4.c("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName()).a(EnterForumModel.FORUMRECOMMEND_CACHE_KEY, bArr);
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        int intValue;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, bArr)) == null) {
            ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
            if (forumRecommendResIdl == null) {
                return null;
            }
            Error error = forumRecommendResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                setError(num.intValue());
            }
            Error error2 = forumRecommendResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                setErrorString(forumRecommendResIdl.error.usermsg);
            }
            if (getError() != 0) {
                return forumRecommendResIdl;
            }
            DataRes dataRes = forumRecommendResIdl.data;
            if (dataRes != null) {
                this.like_forum = dataRes.like_forum;
                this.time = dataRes.time;
                this.recommend_forum_info = dataRes.recommend_forum_info;
                if (dataRes.hot_search != null) {
                    HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                    this.hotSearchInfo = hotSearchInfoData;
                    hotSearchInfoData.S(forumRecommendResIdl.data.hot_search);
                }
                DataRes dataRes2 = forumRecommendResIdl.data;
                this.recommend_concern_forums = dataRes2.tag_recommend_forum;
                if (dataRes2.sort_type.intValue() == 0) {
                    intValue = 1;
                } else {
                    intValue = forumRecommendResIdl.data.sort_type.intValue();
                }
                this.sortType = Integer.valueOf(intValue);
                DataRes dataRes3 = forumRecommendResIdl.data;
                this.forum_create_info = dataRes3.forum_create_info;
                this.private_pop_info = dataRes3.private_forum_popinfo;
                this.tabFeedList = dataRes3.nav_tab_info;
                this.forum_popup_info = dataRes3.forum_popup_info;
            }
            return forumRecommendResIdl;
        }
        return invokeIL.objValue;
    }

    public void setSortType(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, num) == null) {
            this.sortType = num;
        }
    }
}
