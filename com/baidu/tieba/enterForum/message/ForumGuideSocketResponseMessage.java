package com.baidu.tieba.enterForum.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cq4;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.ForumCreateInfo;
import tbclient.ForumGuide.DataRes;
import tbclient.ForumGuide.ForumGuideResIdl;
import tbclient.ForumGuide.HotSearch;
import tbclient.ForumGuide.LikeForum;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class ForumGuideSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumCreateInfo forumCreateInfo;
    public List<HotSearch> hotSearches;
    public Integer isLogin;
    public List<LikeForum> likeForum;
    public Integer msignLevel;
    public String msignText;
    public Integer msignValid;
    public List<ThreadInfo> voiceRoomList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumGuideSocketResponseMessage() {
        super(309683);
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

    public ForumCreateInfo getForumCreateInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.forumCreateInfo : (ForumCreateInfo) invokeV.objValue;
    }

    public List<HotSearch> getHotSearches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.hotSearches : (List) invokeV.objValue;
    }

    public Integer getIsLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.isLogin : (Integer) invokeV.objValue;
    }

    public List<LikeForum> getLikeForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.likeForum : (List) invokeV.objValue;
    }

    public Integer getMsignLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.msignLevel : (Integer) invokeV.objValue;
    }

    public String getMsignText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.msignText : (String) invokeV.objValue;
    }

    public Integer getMsignValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.msignValid : (Integer) invokeV.objValue;
    }

    public List<ThreadInfo> getVoiceRoomList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.voiceRoomList : (List) invokeV.objValue;
    }

    public void setForumCreateInfo(ForumCreateInfo forumCreateInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, forumCreateInfo) == null) {
            this.forumCreateInfo = forumCreateInfo;
        }
    }

    public void setHotSearches(List<HotSearch> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.hotSearches = list;
        }
    }

    public void setIsLogin(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, num) == null) {
            this.isLogin = num;
        }
    }

    public void setLikeForum(List<LikeForum> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.likeForum = list;
        }
    }

    public void setMsignLevel(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, num) == null) {
            this.msignLevel = num;
        }
    }

    public void setMsignText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.msignText = str;
        }
    }

    public void setMsignValid(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, num) == null) {
            this.msignValid = num;
        }
    }

    public void setVoiceRoomList(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.voiceRoomList = list;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || bArr == null || bArr.length <= 0 || getError() != 0) {
            return;
        }
        cq4.f();
        cq4.e("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName()).a(EnterForumModel.FORUMRGUIDE_CACHE_KEY, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ForumGuideResIdl forumGuideResIdl;
        DataRes dataRes;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) || (forumGuideResIdl = (ForumGuideResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumGuideResIdl.class)) == null) {
            return;
        }
        Error error = forumGuideResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = forumGuideResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(forumGuideResIdl.error.usermsg);
        }
        if (getError() == 0 && (dataRes = forumGuideResIdl.data) != null) {
            this.likeForum = dataRes.like_forum;
            this.hotSearches = dataRes.hot_search;
            this.forumCreateInfo = dataRes.forum_create_info;
            this.isLogin = dataRes.is_login;
            this.msignValid = dataRes.msign_valid;
            this.msignText = dataRes.msign_text;
            this.msignLevel = dataRes.msign_level;
            this.voiceRoomList = dataRes.voice_room_list;
        }
    }
}
