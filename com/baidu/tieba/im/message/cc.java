package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByUid.QueryGroupsByUidRes;
/* loaded from: classes.dex */
public class cc extends da implements com.baidu.tieba.im.coder.f {
    private List<GroupInfoData> a;
    private GroupPermData b;

    public cc() {
        super(103003);
    }

    public final List<GroupInfoData> a() {
        return this.a;
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryGroupsByUidRes.QueryGroupsByUidResIdl parseFrom = QueryGroupsByUidRes.QueryGroupsByUidResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            this.a = new ArrayList();
            int groupsCount = parseFrom.getData().getGroupsCount();
            for (int i2 = 0; i2 < groupsCount; i2++) {
                Im.GroupInfo groups = parseFrom.getData().getGroups(i2);
                GroupInfoData groupInfoData = new GroupInfoData();
                groupInfoData.setGroupId(groups.getGroupId());
                groupInfoData.setAuthorId(groups.getAuthorId());
                groupInfoData.setAuthorName(groups.getAuthorName());
                groupInfoData.setForumId(groups.getForumId());
                groupInfoData.setGrade(groups.getGrade());
                groupInfoData.setIntro(groups.getIntro());
                groupInfoData.setName(groups.getName());
                groupInfoData.setIsGroupManager(groups.getIsGroupManager());
                groupInfoData.setMaxMemberNum(groups.getMaxMemberNum());
                groupInfoData.setMemberNum(groups.getMemberNum());
                groupInfoData.setPortrait(groups.getPortrait());
                groupInfoData.setMemGroup(groups.getIsMemberGroup() == 1);
                this.a.add(groupInfoData);
            }
            Im.GroupPermission groupPerm = parseFrom.getData().getGroupPerm();
            GroupPermData groupPermData = new GroupPermData();
            groupPermData.setCanCreateNormal(groupPerm.getCanCreateNormal());
            groupPermData.setCanCreateOfficial(groupPerm.getCanCreateOfficial());
            groupPermData.setCanCreatePersonal(groupPerm.getCanCreatePersonal());
            groupPermData.setCreateNormalTip(groupPerm.getCreateNormalTip());
            groupPermData.setCreateOfficialTip(groupPerm.getCreateOfficialTip());
            groupPermData.setCreatePersonalTip(groupPerm.getCreatePersonalTip());
            groupPermData.setIsManager(groupPerm.getIsForumManager());
            this.b = groupPermData;
        }
    }
}
