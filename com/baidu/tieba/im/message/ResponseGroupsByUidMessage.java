package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.br4;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.GroupPermission;
import protobuf.QueryGroupsByUid.QueryGroupsByUidResIdl;
/* loaded from: classes3.dex */
public class ResponseGroupsByUidMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CACHE_KEY_PREFIX = "p_group_info";
    public transient /* synthetic */ FieldHolder $fh;
    public int commonGroupNum;
    public List<GroupInfoData> commonGroups;
    public int groupNum;
    public GroupPermData groupPerm;
    public List<GroupInfoData> groups;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseGroupsByUidMessage() {
        super(103003);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            QueryGroupsByUidResIdl queryGroupsByUidResIdl = (QueryGroupsByUidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupsByUidResIdl.class);
            setError(queryGroupsByUidResIdl.error.errorno.intValue());
            setErrorString(queryGroupsByUidResIdl.error.usermsg);
            if (getError() != 0) {
                return queryGroupsByUidResIdl;
            }
            this.groups = new ArrayList();
            List<GroupInfo> list = queryGroupsByUidResIdl.data.groups;
            if (list != null) {
                for (GroupInfo groupInfo : list) {
                    GroupInfoData groupInfoData = new GroupInfoData();
                    groupInfoData.setGroupId(groupInfo.groupId.longValue());
                    groupInfoData.setAuthorId(groupInfo.authorId.longValue());
                    groupInfoData.setAuthorName(groupInfo.authorName);
                    groupInfoData.setForumId(groupInfo.forumId.intValue());
                    groupInfoData.setGrade(groupInfo.grade.intValue());
                    groupInfoData.setIntro(groupInfo.intro);
                    groupInfoData.setName(groupInfo.name);
                    groupInfoData.setIsGroupManager(groupInfo.isGroupManager.intValue());
                    groupInfoData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
                    groupInfoData.setMemberNum(groupInfo.memberNum.intValue());
                    groupInfoData.setPortrait(groupInfo.portrait);
                    groupInfoData.setMemGroup(groupInfo.isMemberGroup.intValue() == 1);
                    getGroups().add(groupInfoData);
                }
            }
            this.commonGroups = new ArrayList();
            List<GroupInfo> list2 = queryGroupsByUidResIdl.data.commonGroups;
            if (list2 != null) {
                for (GroupInfo groupInfo2 : list2) {
                    GroupInfoData groupInfoData2 = new GroupInfoData();
                    groupInfoData2.setGroupId(groupInfo2.groupId.longValue());
                    groupInfoData2.setAuthorId(groupInfo2.authorId.longValue());
                    groupInfoData2.setAuthorName(groupInfo2.authorName);
                    groupInfoData2.setForumId(groupInfo2.forumId.intValue());
                    groupInfoData2.setGrade(groupInfo2.grade.intValue());
                    groupInfoData2.setIntro(groupInfo2.intro);
                    groupInfoData2.setName(groupInfo2.name);
                    groupInfoData2.setIsGroupManager(groupInfo2.isGroupManager.intValue());
                    groupInfoData2.setMaxMemberNum(groupInfo2.maxMemberNum.intValue());
                    groupInfoData2.setMemberNum(groupInfo2.memberNum.intValue());
                    groupInfoData2.setPortrait(groupInfo2.portrait);
                    groupInfoData2.setMemGroup(groupInfo2.isMemberGroup.intValue() == 1);
                    getCommonGroups().add(groupInfoData2);
                }
            }
            GroupPermission groupPermission = queryGroupsByUidResIdl.data.groupPerm;
            GroupPermData groupPermData = new GroupPermData();
            groupPermData.setCanCreateNormal(groupPermission.canCreateNormal.intValue());
            groupPermData.setCanCreateOfficial(groupPermission.canCreateOfficial.intValue());
            groupPermData.setCanCreatePersonal(groupPermission.canCreatePersonal.intValue());
            groupPermData.setCreateNormalTip(groupPermission.createNormalTip);
            groupPermData.setCreateOfficialTip(groupPermission.createOfficialTip);
            groupPermData.setCreatePersonalTip(groupPermission.createPersonalTip);
            groupPermData.setIsManager(groupPermission.isForumManager.intValue());
            this.groupPerm = groupPermData;
            this.groupNum = queryGroupsByUidResIdl.data.groupnum.intValue();
            this.commonGroupNum = queryGroupsByUidResIdl.data.commongroupnum.intValue();
            return queryGroupsByUidResIdl;
        }
        return invokeIL.objValue;
    }

    public int getCommonGroupNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.commonGroupNum : invokeV.intValue;
    }

    public List<GroupInfoData> getCommonGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.commonGroups : (List) invokeV.objValue;
    }

    public int getGroupNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.groupNum : invokeV.intValue;
    }

    public GroupPermData getGroupPerm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.groupPerm : (GroupPermData) invokeV.objValue;
    }

    public List<GroupInfoData> getGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.groups : (List) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseGroupsByUidMessage(int i) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && getError() == 0) {
            GroupsByUidMessage groupsByUidMessage = (GroupsByUidMessage) getOrginalMessage();
            String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
            if (groupsByUidMessage == null || groupsByUidMessage.getFriendUid() != 0) {
                return;
            }
            br4.f();
            TbSocketReponsedMessage.saveProtocolBufferDataToCache(br4.d("tb.im_entergroup"), CACHE_KEY_PREFIX + id, bArr);
        }
    }
}
