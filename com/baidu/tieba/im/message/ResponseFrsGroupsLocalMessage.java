package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.GroupPermission;
import protobuf.QueryGroupsByFid.QueryGroupsByFidResIdl;
/* loaded from: classes.dex */
public class ResponseFrsGroupsLocalMessage extends CustomResponsedMessage<Object> {
    private GroupPermData groupPerm;
    private List<GroupInfoData> groups;

    public ResponseFrsGroupsLocalMessage() {
        super(2001201);
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

    public void decodeInBackGround(int i, byte[] bArr) {
        QueryGroupsByFidResIdl queryGroupsByFidResIdl = (QueryGroupsByFidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupsByFidResIdl.class);
        setError(queryGroupsByFidResIdl.error.errorno.intValue());
        setErrorString(queryGroupsByFidResIdl.error.usermsg);
        if (getError() == 0) {
            setGroups(new ArrayList());
            if (queryGroupsByFidResIdl.data.groups != null) {
                for (GroupInfo groupInfo : queryGroupsByFidResIdl.data.groups) {
                    GroupInfoData groupInfoData = new GroupInfoData();
                    groupInfoData.setAuthorId(groupInfo.authorId.intValue());
                    groupInfoData.setAuthorIsMeizhi(groupInfo.authorIsMeizhi.intValue());
                    groupInfoData.setAuthorName(groupInfo.authorName);
                    groupInfoData.setForumId(groupInfo.forumId.intValue());
                    groupInfoData.setForumName("");
                    groupInfoData.setGrade(groupInfo.grade.intValue());
                    groupInfoData.setGroupId(groupInfo.groupId.intValue());
                    groupInfoData.setIntro(groupInfo.intro);
                    groupInfoData.setIsGroupManager(0);
                    groupInfoData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
                    groupInfoData.setMemberNum(groupInfo.memberNum.intValue());
                    groupInfoData.setName(groupInfo.name);
                    groupInfoData.setPortrait(groupInfo.portrait);
                    groupInfoData.setMemGroup(groupInfo.isMemberGroup.intValue() == 1);
                    getGroups().add(groupInfoData);
                }
            }
            GroupPermission groupPermission = queryGroupsByFidResIdl.data.groupPerm;
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
}
