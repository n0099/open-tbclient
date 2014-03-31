package com.baidu.tieba.im.message;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByUid.QueryGroupsByUidRes;
/* loaded from: classes.dex */
public class ResponseGroupsByUidMessage extends TbSocketReponsedMessage {
    private List<GroupInfoData> a;
    private GroupPermData b;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryGroupsByUidRes.QueryGroupsByUidResIdl parseFrom = QueryGroupsByUidRes.QueryGroupsByUidResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.baidu.adp.framework.message.f
    public final /* synthetic */ void b(int i, byte[] bArr) {
        byte[] bArr2 = bArr;
        if (e() == 0) {
            a(com.baidu.tbadk.core.c.b.a().s(), "p_group_info" + (TbadkApplication.N() != null ? TbadkApplication.N().getID() : ""), bArr2);
        }
    }

    public ResponseGroupsByUidMessage() {
        super(103003);
    }

    public ResponseGroupsByUidMessage(int i) {
        super(i);
    }

    public final List<GroupInfoData> d() {
        return this.a;
    }
}
