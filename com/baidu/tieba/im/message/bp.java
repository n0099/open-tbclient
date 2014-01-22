package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByFid.QueryGroupsByFidRes;
/* loaded from: classes.dex */
public class bp extends cr implements com.baidu.tieba.im.coder.f {
    private List<GroupInfoData> a;
    private GroupPermData b;

    public List<GroupInfoData> a() {
        return this.a;
    }

    public void a(List<GroupInfoData> list) {
        this.a = list;
    }

    public GroupPermData b() {
        return this.b;
    }

    public void a(GroupPermData groupPermData) {
        this.b = groupPermData;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        QueryGroupsByFidRes.QueryGroupsByFidResIdl parseFrom = QueryGroupsByFidRes.QueryGroupsByFidResIdl.parseFrom(bArr);
        e(i);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
            a(new ArrayList());
            int groupsCount = parseFrom.getData().getGroupsCount();
            for (int i2 = 0; i2 < groupsCount; i2++) {
                Im.GroupInfo groups = parseFrom.getData().getGroups(i2);
                GroupInfoData groupInfoData = new GroupInfoData();
                groupInfoData.setAuthorId(groups.getAuthorId());
                groupInfoData.setAuthorIsMeizhi(groups.getAuthorIsMeizhi());
                groupInfoData.setAuthorName(groups.getAuthorName());
                groupInfoData.setForumId(groups.getForumId());
                groupInfoData.setForumName("");
                groupInfoData.setGrade(groups.getGrade());
                groupInfoData.setGroupId(groups.getGroupId());
                groupInfoData.setIntro(groups.getIntro());
                groupInfoData.setIsGroupManager(0);
                groupInfoData.setMaxMemberNum(groups.getMaxMemberNum());
                groupInfoData.setMemberNum(groups.getMemberNum());
                groupInfoData.setName(groups.getName());
                groupInfoData.setPortrait(groups.getPortrait());
                groupInfoData.setMemGroup(groups.getIsMemberGroup() == 1);
                a().add(groupInfoData);
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
            a(groupPermData);
        }
    }
}
