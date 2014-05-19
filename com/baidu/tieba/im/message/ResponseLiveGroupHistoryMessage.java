package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.data.h;
import com.baidu.tieba.im.data.i;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import protobuf.QueryLiveGroupHistory.History;
import protobuf.QueryLiveGroupHistory.QueryLiveGroupHistoryResIdl;
/* loaded from: classes.dex */
public class ResponseLiveGroupHistoryMessage extends SocketResponsedMessage {
    private h liveGroupHistoryData;

    public ResponseLiveGroupHistoryMessage() {
        super(MessageTypes.CMD_LIVE_GROUP_HISTORY);
    }

    public h getLiveGroupHistoryData() {
        return this.liveGroupHistoryData;
    }

    public void setLiveGroupHistoryData(h hVar) {
        this.liveGroupHistoryData = hVar;
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
                this.liveGroupHistoryData = new h();
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
                        i iVar = new i();
                        iVar.a(history.groupId.intValue());
                        iVar.a(history.startTime.intValue());
                        iVar.b(history.endTime.intValue());
                        iVar.b(history.userId.intValue());
                        iVar.c(history.listeners.intValue());
                        iVar.d(history.likers.intValue());
                        iVar.a(history.playUrl);
                        this.liveGroupHistoryData.b().add(iVar);
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
