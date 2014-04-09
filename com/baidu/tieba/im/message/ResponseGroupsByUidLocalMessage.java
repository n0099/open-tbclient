package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByUid.QueryGroupsByUidRes;
/* loaded from: classes.dex */
public class ResponseGroupsByUidLocalMessage extends CustomResponsedMessage<Object> {
    private List<GroupInfoData> a;
    private GroupPermData b;

    public ResponseGroupsByUidLocalMessage() {
        super(2001106);
    }

    public ResponseGroupsByUidLocalMessage(int i) {
        super(i);
    }

    public final List<GroupInfoData> b() {
        return this.a;
    }

    public final void a(byte[] bArr) {
        QueryGroupsByUidRes.QueryGroupsByUidResIdl parseFrom = QueryGroupsByUidRes.QueryGroupsByUidResIdl.parseFrom(bArr);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = new ArrayList();
            int groupsCount = parseFrom.getData().getGroupsCount();
            for (int i = 0; i < groupsCount; i++) {
                Im.GroupInfo groups = parseFrom.getData().getGroups(i);
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
