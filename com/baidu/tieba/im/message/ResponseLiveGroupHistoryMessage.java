package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import protobuf.QueryLiveGroupHistory.History;
import protobuf.QueryLiveGroupHistory.QueryLiveGroupHistoryResIdl;
/* loaded from: classes.dex */
public class ResponseLiveGroupHistoryMessage extends SocketResponsedMessage {
    private com.baidu.tieba.im.data.f liveGroupHistoryData;

    public ResponseLiveGroupHistoryMessage() {
        super(107005);
    }

    public com.baidu.tieba.im.data.f getLiveGroupHistoryData() {
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
            if (getError() == 0 && queryLiveGroupHistoryResIdl.data != null) {
                this.liveGroupHistoryData = new com.baidu.tieba.im.data.f();
                this.liveGroupHistoryData.a(queryLiveGroupHistoryResIdl.data.hasMore.intValue());
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
                liveCardData.setStartTime(queryLiveGroupHistoryResIdl.data.group.startTime.intValue());
                liveCardData.setStatus(queryLiveGroupHistoryResIdl.data.group.status.intValue());
                liveCardData.setStreamId(queryLiveGroupHistoryResIdl.data.group.streamId);
                this.liveGroupHistoryData.a(liveCardData);
                this.liveGroupHistoryData.a(new ArrayList());
                while (true) {
                    int i3 = i2;
                    if (i3 < queryLiveGroupHistoryResIdl.data.historys.size()) {
                        History history = queryLiveGroupHistoryResIdl.data.historys.get(i3);
                        com.baidu.tieba.im.data.g gVar = new com.baidu.tieba.im.data.g();
                        gVar.a(history.groupId.intValue());
                        gVar.a(history.startTime.intValue());
                        gVar.b(history.endTime.intValue());
                        gVar.b(history.userId.intValue());
                        gVar.c(history.listeners.intValue());
                        gVar.d(history.likers.intValue());
                        gVar.a(history.playUrl);
                        this.liveGroupHistoryData.b().add(gVar);
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
