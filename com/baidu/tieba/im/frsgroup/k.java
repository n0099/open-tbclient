package com.baidu.tieba.im.frsgroup;

import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import protobuf.GroupInfo;
import protobuf.GroupPermission;
import protobuf.QueryGroupsByFid.QueryGroupsByFidResIdl;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.mvc.b.b, com.baidu.tbadk.mvc.b.i {
    protected GroupPermData groupPerm;
    protected List<GroupInfoData> groups;

    public List<GroupInfoData> getGroups() {
        return this.groups;
    }

    public GroupPermData getGroupPerm() {
        return this.groupPerm;
    }

    @Override // com.baidu.tbadk.mvc.b.i
    public void d(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.i
    public void a(Message message) {
        if (message instanceof QueryGroupsByFidResIdl) {
            QueryGroupsByFidResIdl queryGroupsByFidResIdl = (QueryGroupsByFidResIdl) message;
            this.groups = new ArrayList();
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
            this.groupPerm = groupPermData;
        }
    }

    @Override // com.baidu.tbadk.mvc.b.c
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] tl() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean z(byte[] bArr) {
        try {
            a((QueryGroupsByFidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupsByFidResIdl.class));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
