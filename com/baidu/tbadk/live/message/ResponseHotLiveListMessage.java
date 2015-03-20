package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.live.data.HotLiveListData;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import protobuf.LiveGroupInfo;
import protobuf.QueryHotLiveGroups.QueryHotLiveGroupsResIdl;
/* loaded from: classes.dex */
public class ResponseHotLiveListMessage extends TbSocketReponsedMessage {
    private HotLiveListData hotLiveListData;

    public ResponseHotLiveListMessage() {
        super(107003);
    }

    public HotLiveListData getHotLiveListData() {
        return this.hotLiveListData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        int i2 = 0;
        QueryHotLiveGroupsResIdl queryHotLiveGroupsResIdl = (QueryHotLiveGroupsResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryHotLiveGroupsResIdl.class);
        setError(queryHotLiveGroupsResIdl.error.errorno.intValue());
        setErrorString(queryHotLiveGroupsResIdl.error.usermsg);
        if (getError() == 0) {
            this.hotLiveListData = new HotLiveListData();
            this.hotLiveListData.setHasMore(queryHotLiveGroupsResIdl.data.hasMore.intValue());
            this.hotLiveListData.setGroups(new ArrayList());
            if (queryHotLiveGroupsResIdl.data.groups == null) {
                return;
            }
            while (true) {
                int i3 = i2;
                if (i3 < queryHotLiveGroupsResIdl.data.groups.size()) {
                    LiveCardData liveCardData = new LiveCardData();
                    LiveGroupInfo liveGroupInfo = queryHotLiveGroupsResIdl.data.groups.get(i3);
                    liveCardData.setAuthorId(liveGroupInfo.authorId.intValue());
                    liveCardData.setAuthorName(liveGroupInfo.authorName);
                    liveCardData.setBackground(liveGroupInfo.background);
                    liveCardData.setCreateTime(liveGroupInfo.createTime.intValue());
                    liveCardData.setDeviceId(liveGroupInfo.deviceId.intValue());
                    liveCardData.setForumId(liveGroupInfo.forumId.intValue());
                    liveCardData.setForumName(liveGroupInfo.forumName);
                    liveCardData.setGroupId(liveGroupInfo.groupId.intValue());
                    liveCardData.setGroupType(liveGroupInfo.groupType.intValue());
                    liveCardData.setIntro(liveGroupInfo.intro);
                    liveCardData.setLikers(liveGroupInfo.likers.intValue());
                    liveCardData.setListeners(liveGroupInfo.listeners.intValue());
                    liveCardData.setName(liveGroupInfo.name);
                    liveCardData.setPortrait(liveGroupInfo.portrait);
                    liveCardData.setPublisherId(liveGroupInfo.publisherId.intValue());
                    liveCardData.setPublisherName(liveGroupInfo.publisherName);
                    liveCardData.setPublisherPortrait(liveGroupInfo.publisherPortrait);
                    liveCardData.setStartTime(liveGroupInfo.startTime.intValue());
                    liveCardData.setStatus(liveGroupInfo.status.intValue());
                    liveCardData.setStreamId(liveGroupInfo.streamId);
                    liveCardData.setIsVip(liveGroupInfo.isVip.intValue());
                    this.hotLiveListData.getGroups().add(liveCardData);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        Message<?> orginalMessage = getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestHotLiveListMessage) && getError() == 0) {
            saveProtocolBufferDataToCache(com.baidu.tbadk.core.b.a.rc().bW("tb.live_hotlist"), "live_" + String.valueOf(((RequestHotLiveListMessage) orginalMessage).getType()), bArr);
        }
    }
}
