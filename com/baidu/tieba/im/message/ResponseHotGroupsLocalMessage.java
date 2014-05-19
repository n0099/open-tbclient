package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.data.GroupInfoData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.QueryHotGroups.QueryHotGroupsResIdl;
/* loaded from: classes.dex */
public class ResponseHotGroupsLocalMessage extends CustomResponsedMessage<Object> {
    private List<GroupInfoData> groups;
    private boolean hasMore;

    public ResponseHotGroupsLocalMessage() {
        super(MessageTypes.CMD_HOT_GROUPS_LOCAL);
    }

    public List<GroupInfoData> getGroups() {
        return this.groups;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void decodeInBackGround(int i, byte[] bArr) {
        QueryHotGroupsResIdl queryHotGroupsResIdl = (QueryHotGroupsResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryHotGroupsResIdl.class);
        setError(queryHotGroupsResIdl.error.errorno.intValue());
        setErrorString(queryHotGroupsResIdl.error.usermsg);
        if (getError() == 0) {
            setGroups(new ArrayList());
            int size = queryHotGroupsResIdl.data.groups == null ? 0 : queryHotGroupsResIdl.data.groups.size();
            for (int i2 = 0; i2 < size; i2++) {
                GroupInfoData groupInfoData = new GroupInfoData();
                getGroups().add(groupInfoData);
                GroupInfo groupInfo = queryHotGroupsResIdl.data.groups.get(i2);
                groupInfoData.setGroupId(groupInfo.groupId.intValue());
                groupInfoData.setForumId(groupInfo.forumId.intValue());
                groupInfoData.setForumName(groupInfo.forumName);
                groupInfoData.setName(groupInfo.name);
                groupInfoData.setIntro(groupInfo.intro);
                groupInfoData.setPortrait(groupInfo.portrait);
                groupInfoData.setMaxMemberNum(groupInfo.maxMemberNum.intValue());
                groupInfoData.setMemberNum(groupInfo.memberNum.intValue());
                groupInfoData.setAuthorId(groupInfo.authorId.intValue());
                groupInfoData.setAuthorName(groupInfo.authorName);
                groupInfoData.setGrade(groupInfo.grade.intValue());
                groupInfoData.setForumShowName(groupInfo.forumShowName);
                groupInfoData.setMemGroup(groupInfo.isMemberGroup.intValue() == 1);
            }
            if (queryHotGroupsResIdl.data.hasMore.intValue() == 1) {
                setHasMore(true);
            } else {
                setHasMore(false);
            }
        }
    }
}
