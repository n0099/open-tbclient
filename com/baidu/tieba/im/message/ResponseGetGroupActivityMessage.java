package com.baidu.tieba.im.message;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.GroupActivityData;
import com.squareup.wire.Wire;
import protobuf.QueryGroupActivity.DataRes;
import protobuf.QueryGroupActivity.QueryGroupActivityResIdl;
/* loaded from: classes.dex */
public class ResponseGetGroupActivityMessage extends TbSocketReponsedMessage {
    private static final String CACHE_KEY_PREFIX = "group_activity";
    private GroupActivityData activityData;

    public ResponseGetGroupActivityMessage() {
        super(MessageTypes.CMD_GET_GROUP_ACTIVITY);
    }

    public GroupActivityData getActivityData() {
        return this.activityData;
    }

    public void setActivityData(GroupActivityData groupActivityData) {
        this.activityData = groupActivityData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryGroupActivityResIdl queryGroupActivityResIdl = (QueryGroupActivityResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupActivityResIdl.class);
        setError(queryGroupActivityResIdl.error.errorno.intValue());
        setErrorString(queryGroupActivityResIdl.error.usermsg);
        if (getError() == 0) {
            DataRes dataRes = queryGroupActivityResIdl.data;
            GroupActivityData groupActivityData = new GroupActivityData();
            groupActivityData.setActivityPortrait(dataRes.activityPortrait);
            groupActivityData.setgActivityArea(dataRes.gActivityArea);
            groupActivityData.setgActivityContent(dataRes.gActivityContent);
            groupActivityData.setgActivityTime(dataRes.gActivityTime.longValue());
            groupActivityData.setgActivityTitle(dataRes.gActivityTitle);
            groupActivityData.setGroupId(dataRes.groupId.intValue());
            groupActivityData.setActivityId(dataRes.activityId.intValue());
            groupActivityData.setUserId(dataRes.userId.intValue());
            groupActivityData.setUserName(dataRes.userName);
            groupActivityData.setIsEnd(dataRes.isEnd.intValue());
            setActivityData(groupActivityData);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void processInBackGround(int i, byte[] bArr) {
        if (getActivityData() != null && getError() == 0) {
            String str = "";
            if (TbadkApplication.getCurrentAccountObj() != null) {
                str = TbadkApplication.getCurrentAccountObj().getID();
            }
            saveProtocolBufferDataToCache(com.baidu.tbadk.core.a.b.a().u(), CACHE_KEY_PREFIX + str + getActivityData().getActivityId(), bArr);
        }
    }
}
