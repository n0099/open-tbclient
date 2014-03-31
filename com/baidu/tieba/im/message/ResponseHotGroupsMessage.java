package com.baidu.tieba.im.message;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryHotGroups.QueryHotGroupsRes;
/* loaded from: classes.dex */
public class ResponseHotGroupsMessage extends TbSocketReponsedMessage {
    private List<GroupInfoData> a;
    private boolean b;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryHotGroupsRes.QueryHotGroupsResIdl parseFrom = QueryHotGroupsRes.QueryHotGroupsResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = new ArrayList();
            int groupsCount = parseFrom.getData().getGroupsCount();
            for (int i2 = 0; i2 < groupsCount; i2++) {
                GroupInfoData groupInfoData = new GroupInfoData();
                this.a.add(groupInfoData);
                Im.GroupInfo groups = parseFrom.getData().getGroups(i2);
                groupInfoData.setGroupId(groups.getGroupId());
                groupInfoData.setForumId(groups.getForumId());
                groupInfoData.setForumName(groups.getForumName());
                groupInfoData.setName(groups.getName());
                groupInfoData.setIntro(groups.getIntro());
                groupInfoData.setPortrait(groups.getPortrait());
                groupInfoData.setMaxMemberNum(groups.getMaxMemberNum());
                groupInfoData.setMemberNum(groups.getMemberNum());
                groupInfoData.setAuthorId(groups.getAuthorId());
                groupInfoData.setAuthorName(groups.getAuthorName());
                groupInfoData.setGrade(groups.getGrade());
                groupInfoData.setForumShowName(groups.getForumShowName());
                groupInfoData.setMemGroup(groups.getIsMemberGroup() == 1);
            }
            if (parseFrom.getData().getHasMore() == 1) {
                this.b = true;
            } else {
                this.b = false;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.baidu.adp.framework.message.f
    public final /* synthetic */ void b(int i, byte[] bArr) {
        byte[] bArr2 = bArr;
        if (e() == 0 && (h() instanceof an) && ((an) h()).i()) {
            a(com.baidu.tbadk.core.c.b.a().f(), "p_hot_groups_info" + (TbadkApplication.N() != null ? TbadkApplication.N().getID() : ""), bArr2);
        }
    }

    public ResponseHotGroupsMessage() {
        super(103012);
    }

    public final List<GroupInfoData> d() {
        return this.a;
    }

    public final boolean i() {
        return this.b;
    }
}
