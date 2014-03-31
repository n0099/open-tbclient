package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByFid.QueryGroupsByFidRes;
/* loaded from: classes.dex */
public class ResponseFrsGroupsLocalMessage extends CustomResponsedMessage<Object> {
    private List<GroupInfoData> a;
    private GroupPermData b;

    public ResponseFrsGroupsLocalMessage() {
        super(2001201);
    }

    public final List<GroupInfoData> b() {
        return this.a;
    }

    public final void a(byte[] bArr) {
        QueryGroupsByFidRes.QueryGroupsByFidResIdl parseFrom = QueryGroupsByFidRes.QueryGroupsByFidResIdl.parseFrom(bArr);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = new ArrayList();
            int groupsCount = parseFrom.getData().getGroupsCount();
            for (int i = 0; i < groupsCount; i++) {
                Im.GroupInfo groups = parseFrom.getData().getGroups(i);
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
