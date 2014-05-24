package com.baidu.tieba.im.message;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.GroupPermission;
import protobuf.QueryGroupsByUid.QueryGroupsByUidResIdl;
/* loaded from: classes.dex */
public class ResponseGroupsByUidMessage extends TbSocketReponsedMessage {
    private static final String CACHE_KEY_PREFIX = "p_group_info";
    private GroupPermData groupPerm;
    private List<GroupInfoData> groups;

    public ResponseGroupsByUidMessage() {
        super(MessageTypes.CMD_QUERY_GROUP_BY_UID);
    }

    public ResponseGroupsByUidMessage(int i) {
        super(i);
    }

    public List<GroupInfoData> getGroups() {
        return this.groups;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public GroupPermData getGroupPerm() {
        return this.groupPerm;
    }

    public void setGroupPerm(GroupPermData groupPermData) {
        this.groupPerm = groupPermData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryGroupsByUidResIdl queryGroupsByUidResIdl = (QueryGroupsByUidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupsByUidResIdl.class);
        setError(queryGroupsByUidResIdl.error.errorno.intValue());
        setErrorString(queryGroupsByUidResIdl.error.usermsg);
        if (getError() == 0) {
            setGroups(new ArrayList());
            if (queryGroupsByUidResIdl.data.groups != null) {
                for (GroupInfo groupInfo : queryGroupsByUidResIdl.data.groups) {
                    GroupInfoData groupInfoData = new GroupInfoData();
                    groupInfoData.setGroupId(groupInfo.groupId.intValue());
                    groupInfoData.setAuthorId(groupInfo.authorId.intValue());
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
            GroupPermission groupPermission = queryGroupsByUidResIdl.data.groupPerm;
            GroupPermData groupPermData = new GroupPermData();
            groupPermData.setCanCreateNormal(groupPermission.canCreateNormal.intValue());
            groupPermData.setCanCreateOfficial(groupPermission.canCreateOfficial.intValue());
            groupPermData.setCanCreatePersonal(groupPermission.canCreatePersonal.intValue());
            groupPermData.setCreateNormalTip(groupPermission.createNormalTip);
            groupPermData.setCreateOfficialTip(groupPermission.createOfficialTip);
            groupPermData.setCreatePersonalTip(groupPermission.createPersonalTip);
            groupPermData.setIsManager(groupPermission.isForumManager.intValue());
            setGroupPerm(groupPermData);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void processInBackGround(int i, byte[] bArr) {
        if (getError() == 0) {
            String str = "";
            if (TbadkApplication.getCurrentAccountObj() != null) {
                str = TbadkApplication.getCurrentAccountObj().getID();
            }
            saveProtocolBufferDataToCache(com.baidu.tbadk.core.a.b.a().v(), CACHE_KEY_PREFIX + str, bArr);
        }
    }
}
