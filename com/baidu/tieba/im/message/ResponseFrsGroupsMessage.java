package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryGroupsByFid.QueryGroupsByFidRes;
/* loaded from: classes.dex */
public class ResponseFrsGroupsMessage extends TbSocketReponsedMessage {
    private List<GroupInfoData> a;
    private GroupPermData b;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryGroupsByFidRes.QueryGroupsByFidResIdl parseFrom = QueryGroupsByFidRes.QueryGroupsByFidResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = new ArrayList();
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
        com.baidu.adp.framework.message.d<?> h = h();
        if (h != null && (h instanceof ag) && e() == 0) {
            ag agVar = (ag) h;
            a(com.baidu.tbadk.core.c.b.a().e(), "frs_group_" + agVar.j() + "_" + agVar.i(), bArr2);
        }
    }

    public ResponseFrsGroupsMessage() {
        super(103002);
    }

    public final List<GroupInfoData> d() {
        return this.a;
    }

    public final GroupPermData i() {
        return this.b;
    }
}
