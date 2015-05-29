package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.live.data.LiveGroupHistoryData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import protobuf.QueryLiveGroupHistory.History;
import protobuf.QueryLiveGroupHistory.QueryLiveGroupHistoryResIdl;
/* loaded from: classes.dex */
public class ResponseLiveGroupHistoryMessage extends SocketResponsedMessage {
    private LiveGroupHistoryData liveGroupHistoryData;

    public ResponseLiveGroupHistoryMessage() {
        super(107005);
    }

    public LiveGroupHistoryData getLiveGroupHistoryData() {
        return this.liveGroupHistoryData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        int i2 = 0;
        QueryLiveGroupHistoryResIdl queryLiveGroupHistoryResIdl = (QueryLiveGroupHistoryResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryLiveGroupHistoryResIdl.class);
        if (queryLiveGroupHistoryResIdl.error != null) {
            setError(queryLiveGroupHistoryResIdl.error.errorno.intValue());
            setErrorString(queryLiveGroupHistoryResIdl.error.usermsg);
            if (getError() == 0 && queryLiveGroupHistoryResIdl.data != null && queryLiveGroupHistoryResIdl.data.group != null) {
                this.liveGroupHistoryData = new LiveGroupHistoryData();
                this.liveGroupHistoryData.setHasMore(queryLiveGroupHistoryResIdl.data.hasMore.intValue());
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setAuthorId(queryLiveGroupHistoryResIdl.data.group.authorId.intValue());
                liveCardData.setAuthorName(queryLiveGroupHistoryResIdl.data.group.authorName);
                liveCardData.setBackground(queryLiveGroupHistoryResIdl.data.group.background);
                liveCardData.setCreateTime(queryLiveGroupHistoryResIdl.data.group.createTime.intValue());
                liveCardData.setDeviceId(queryLiveGroupHistoryResIdl.data.group.deviceId.intValue());
                liveCardData.setForumId(queryLiveGroupHistoryResIdl.data.group.forumId.intValue());
                liveCardData.setGroupId(queryLiveGroupHistoryResIdl.data.group.groupId.intValue());
                liveCardData.setGroupType(queryLiveGroupHistoryResIdl.data.group.groupType.intValue());
                liveCardData.setIntro(queryLiveGroupHistoryResIdl.data.group.intro);
                liveCardData.setLikers(queryLiveGroupHistoryResIdl.data.group.likers.intValue());
                liveCardData.setListeners(queryLiveGroupHistoryResIdl.data.group.listeners.intValue());
                liveCardData.setName(queryLiveGroupHistoryResIdl.data.group.name);
                liveCardData.setPortrait(queryLiveGroupHistoryResIdl.data.group.portrait);
                liveCardData.setPublisherId(queryLiveGroupHistoryResIdl.data.group.publisherId.intValue());
                liveCardData.setPublisherName(queryLiveGroupHistoryResIdl.data.group.publisherName);
                liveCardData.setPublisherPortrait(queryLiveGroupHistoryResIdl.data.group.publisherPortrait);
                liveCardData.setIsVip(queryLiveGroupHistoryResIdl.data.group.isVip.intValue());
                liveCardData.setStartTime(queryLiveGroupHistoryResIdl.data.group.startTime.intValue());
                liveCardData.setStatus(queryLiveGroupHistoryResIdl.data.group.status.intValue());
                liveCardData.setStreamId(queryLiveGroupHistoryResIdl.data.group.streamId);
                this.liveGroupHistoryData.setLiveCardData(liveCardData);
                this.liveGroupHistoryData.setHistorys(new ArrayList());
                while (true) {
                    int i3 = i2;
                    if (i3 < queryLiveGroupHistoryResIdl.data.historys.size()) {
                        History history = queryLiveGroupHistoryResIdl.data.historys.get(i3);
                        LiveGroupHistoryData.History history2 = new LiveGroupHistoryData.History();
                        history2.setGroupId(history.groupId.intValue());
                        history2.setStartTime(history.startTime.intValue());
                        history2.setEndTime(history.endTime.intValue());
                        history2.setUserId(history.userId.intValue());
                        history2.setListeners(history.listeners.intValue());
                        history2.setLikers(history.likers.intValue());
                        history2.setPlayUrl(history.playUrl);
                        this.liveGroupHistoryData.getHistorys().add(history2);
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
