package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tieba.ve;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.SearchGroup.SearchGroupResIdl;
/* loaded from: classes4.dex */
public class ResponseSearchGroupMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ve.b<String>> cacheList;
    public long gid;
    public List<BaseGroupData> searchResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSearchGroupMessage() {
        super(103007);
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
        this.searchResult = new ArrayList();
        this.cacheList = new ArrayList();
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            SearchGroupResIdl searchGroupResIdl = (SearchGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchGroupResIdl.class);
            setError(searchGroupResIdl.error.errorno.intValue());
            setErrorString(searchGroupResIdl.error.usermsg);
            if (getError() != 0) {
                return searchGroupResIdl;
            }
            LinkedList linkedList = new LinkedList();
            GroupInfo groupInfo = searchGroupResIdl.data.group;
            if (groupInfo != null) {
                BaseGroupData baseGroupData = new BaseGroupData();
                baseGroupData.setGroupId(groupInfo.groupId.longValue());
                baseGroupData.setName(groupInfo.name);
                baseGroupData.setIntro(groupInfo.intro);
                baseGroupData.setPortrait(groupInfo.portrait);
                baseGroupData.setPosition(groupInfo.position);
                baseGroupData.setLng(String.valueOf(groupInfo.lng));
                baseGroupData.setLat(String.valueOf(groupInfo.lat));
                baseGroupData.setNotice(groupInfo.notice);
                baseGroupData.setAlbum(groupInfo.album);
                baseGroupData.setStatus(groupInfo.status.intValue());
                baseGroupData.setAuthorId(groupInfo.authorId.longValue());
                baseGroupData.setAuthorName(groupInfo.authorName);
                baseGroupData.setAuthorNameShow(groupInfo.authorNameShow);
                baseGroupData.setCreateTime(groupInfo.createTime.intValue());
                baseGroupData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
                baseGroupData.setMemberNum(groupInfo.memberNum.intValue());
                baseGroupData.setGroupType(groupInfo.groupType.intValue());
                baseGroupData.setForumId(groupInfo.forumId.intValue());
                linkedList.add(baseGroupData);
            }
            setSearchResult(linkedList);
            return searchGroupResIdl;
        }
        return invokeIL.objValue;
    }

    public List<ve.b<String>> getCacheList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cacheList : (List) invokeV.objValue;
    }

    public long getGid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.gid : invokeV.longValue;
    }

    public List<BaseGroupData> getSearchResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.searchResult : (List) invokeV.objValue;
    }

    public void setCacheList(List<ve.b<String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.cacheList = list;
        }
    }

    public void setGid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.gid = j;
        }
    }

    public void setSearchResult(List<BaseGroupData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.searchResult = list;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSearchGroupMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.searchResult = new ArrayList();
        this.cacheList = new ArrayList();
    }
}
