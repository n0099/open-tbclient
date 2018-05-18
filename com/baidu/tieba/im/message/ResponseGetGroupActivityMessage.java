package com.baidu.tieba.im.message;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.GroupActivityData;
import com.squareup.wire.Wire;
import protobuf.QueryGroupActivity.DataRes;
import protobuf.QueryGroupActivity.QueryGroupActivityResIdl;
/* loaded from: classes3.dex */
public class ResponseGetGroupActivityMessage extends TbSocketReponsedMessage {
    private static final String CACHE_KEY_PREFIX = "group_activity";
    private GroupActivityData activityData;

    public ResponseGetGroupActivityMessage() {
        super(103015);
    }

    public GroupActivityData getActivityData() {
        return this.activityData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
            groupActivityData.setGroupId(dataRes.groupId.longValue());
            groupActivityData.setActivityId(dataRes.activityId.intValue());
            groupActivityData.setUserId(dataRes.userId.longValue());
            groupActivityData.setUserName(dataRes.userName);
            groupActivityData.setIsEnd(dataRes.isEnd.intValue());
            this.activityData = groupActivityData;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        if (getActivityData() != null && getError() == 0) {
            String str = "";
            if (TbadkApplication.getCurrentAccountObj() != null) {
                str = TbadkApplication.getCurrentAccountObj().getID();
            }
            saveProtocolBufferDataToCache(com.baidu.tbadk.core.c.a.ty().cY("tb.im_groupactivity"), CACHE_KEY_PREFIX + str + getActivityData().getActivityId(), bArr);
        }
    }
}
