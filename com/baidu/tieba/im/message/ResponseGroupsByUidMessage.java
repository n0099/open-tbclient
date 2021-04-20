package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.squareup.wire.Wire;
import d.b.h0.r.r.a;
import java.util.ArrayList;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.GroupPermission;
import protobuf.QueryGroupsByUid.QueryGroupsByUidResIdl;
/* loaded from: classes4.dex */
public class ResponseGroupsByUidMessage extends TbSocketReponsedMessage {
    public static final String CACHE_KEY_PREFIX = "p_group_info";
    public int commonGroupNum;
    public List<GroupInfoData> commonGroups;
    public int groupNum;
    public GroupPermData groupPerm;
    public List<GroupInfoData> groups;

    public ResponseGroupsByUidMessage() {
        super(103003);
    }

    public int getCommonGroupNum() {
        return this.commonGroupNum;
    }

    public List<GroupInfoData> getCommonGroups() {
        return this.commonGroups;
    }

    public int getGroupNum() {
        return this.groupNum;
    }

    public GroupPermData getGroupPerm() {
        return this.groupPerm;
    }

    public List<GroupInfoData> getGroups() {
        return this.groups;
    }

    public ResponseGroupsByUidMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        if (getError() != 0) {
            return;
        }
        GroupsByUidMessage groupsByUidMessage = (GroupsByUidMessage) getOrginalMessage();
        String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
        if (groupsByUidMessage == null || groupsByUidMessage.getFriendUid() != 0) {
            return;
        }
        TbSocketReponsedMessage.saveProtocolBufferDataToCache(a.f().d("tb.im_entergroup"), CACHE_KEY_PREFIX + id, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryGroupsByUidResIdl queryGroupsByUidResIdl = (QueryGroupsByUidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupsByUidResIdl.class);
        setError(queryGroupsByUidResIdl.error.errorno.intValue());
        setErrorString(queryGroupsByUidResIdl.error.usermsg);
        if (getError() != 0) {
            return;
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
    }
}
