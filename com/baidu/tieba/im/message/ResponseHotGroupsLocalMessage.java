package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryHotGroups.QueryHotGroupsRes;
/* loaded from: classes.dex */
public class ResponseHotGroupsLocalMessage extends CustomResponsedMessage<Object> {
    private List<GroupInfoData> a;
    private boolean b;

    public ResponseHotGroupsLocalMessage() {
        super(2001116);
    }

    public final List<GroupInfoData> b() {
        return this.a;
    }

    public final void a(byte[] bArr) {
        QueryHotGroupsRes.QueryHotGroupsResIdl parseFrom = QueryHotGroupsRes.QueryHotGroupsResIdl.parseFrom(bArr);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = new ArrayList();
            int groupsCount = parseFrom.getData().getGroupsCount();
            for (int i = 0; i < groupsCount; i++) {
                GroupInfoData groupInfoData = new GroupInfoData();
                this.a.add(groupInfoData);
                Im.GroupInfo groups = parseFrom.getData().getGroups(i);
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
}
