package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryHotGroups.QueryHotGroupsRes;
/* loaded from: classes.dex */
public class cd extends da implements com.baidu.tieba.im.coder.f {
    private List<GroupInfoData> a;
    private boolean b;

    public cd() {
        super.e(103012);
    }

    public List<GroupInfoData> a() {
        return this.a;
    }

    public void a(List<GroupInfoData> list) {
        this.a = list;
    }

    public boolean b() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryHotGroupsRes.QueryHotGroupsResIdl parseFrom = QueryHotGroupsRes.QueryHotGroupsResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            a(new ArrayList());
            int groupsCount = parseFrom.getData().getGroupsCount();
            for (int i2 = 0; i2 < groupsCount; i2++) {
                GroupInfoData groupInfoData = new GroupInfoData();
                a().add(groupInfoData);
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
                a(true);
            } else {
                a(false);
            }
        }
    }
}
