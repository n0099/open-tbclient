package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.GroupPermission;
import protobuf.QueryGroupsByUid.QueryGroupsByUidResIdl;
/* loaded from: classes3.dex */
public class ResponseGroupsByUidLocalMessage extends CustomResponsedMessage<Object> {
    public int commonGroupNum;
    public List<GroupInfoData> commonGroups;
    public int groupNum;
    public GroupPermData groupPerm;
    public List<GroupInfoData> groups;

    public ResponseGroupsByUidLocalMessage() {
        super(2001106);
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryGroupsByUidResIdl queryGroupsByUidResIdl = (QueryGroupsByUidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupsByUidResIdl.class);
        setError(queryGroupsByUidResIdl.error.errorno.intValue());
        setErrorString(queryGroupsByUidResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        setGroups(new ArrayList());
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
        setCommonGroups(new ArrayList());
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
        setGroupPerm(groupPermData);
        setGroupNum(queryGroupsByUidResIdl.data.groupnum.intValue());
        setCommonGroupNum(queryGroupsByUidResIdl.data.commongroupnum.intValue());
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

    public void setCommonGroupNum(int i) {
        this.commonGroupNum = i;
    }

    public void setCommonGroups(List<GroupInfoData> list) {
        this.commonGroups = list;
    }

    public void setGroupNum(int i) {
        this.groupNum = i;
    }

    public void setGroupPerm(GroupPermData groupPermData) {
        this.groupPerm = groupPermData;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public ResponseGroupsByUidLocalMessage(int i) {
        super(i);
    }
}
