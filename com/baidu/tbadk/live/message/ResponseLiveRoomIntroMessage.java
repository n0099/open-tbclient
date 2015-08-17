package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.LiveGroupInfo;
import protobuf.QueryLiveGroupByGidAndPid.QueryLiveGroupByGidAndPidResIdl;
/* loaded from: classes.dex */
public class ResponseLiveRoomIntroMessage extends SocketResponsedMessage {
    public LiveCardData introData;
    public List<LiveCardData> otherLiveRoomDataList;

    public ResponseLiveRoomIntroMessage() {
        super(107004);
        this.introData = null;
        this.otherLiveRoomDataList = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryLiveGroupByGidAndPidResIdl queryLiveGroupByGidAndPidResIdl = (QueryLiveGroupByGidAndPidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryLiveGroupByGidAndPidResIdl.class);
        setError(queryLiveGroupByGidAndPidResIdl.error.errorno.intValue());
        setErrorString(queryLiveGroupByGidAndPidResIdl.error.usermsg);
        if (getError() == 0) {
            this.introData = new LiveCardData();
            parseData(queryLiveGroupByGidAndPidResIdl.data.group, this.introData);
            List<LiveGroupInfo> list = queryLiveGroupByGidAndPidResIdl.data.publishGroups;
            if (list != null) {
                this.otherLiveRoomDataList = new ArrayList();
                for (LiveGroupInfo liveGroupInfo : list) {
                    LiveCardData liveCardData = new LiveCardData();
                    parseData(liveGroupInfo, liveCardData);
                    this.otherLiveRoomDataList.add(liveCardData);
                }
            }
        }
    }

    private void parseData(LiveGroupInfo liveGroupInfo, LiveCardData liveCardData) {
        liveCardData.setAuthorId(liveGroupInfo.authorId.longValue());
        liveCardData.setAuthorName(liveGroupInfo.authorName);
        liveCardData.setBackground(liveGroupInfo.background);
        liveCardData.setCreateTime(liveGroupInfo.createTime.intValue());
        liveCardData.setDeviceId(liveGroupInfo.deviceId.intValue());
        liveCardData.setForumId(liveGroupInfo.forumId.intValue());
        liveCardData.setGroupId(liveGroupInfo.groupId.intValue());
        liveCardData.setGroupType(liveGroupInfo.groupType.intValue());
        liveCardData.setIntro(liveGroupInfo.intro);
        liveCardData.setLikers(liveGroupInfo.likers.intValue());
        liveCardData.setListeners(liveGroupInfo.listeners.intValue());
        liveCardData.setName(liveGroupInfo.name);
        liveCardData.setPortrait(liveGroupInfo.portrait);
        liveCardData.setPublisherId(liveGroupInfo.publisherId.longValue());
        liveCardData.setPublisherName(liveGroupInfo.publisherName);
        liveCardData.setPublisherPortrait(liveGroupInfo.publisherPortrait);
        liveCardData.setIsVip(liveGroupInfo.isVip.intValue());
        liveCardData.setStartTime(liveGroupInfo.startTime.intValue());
        liveCardData.setStatus(liveGroupInfo.status.intValue());
        liveCardData.setStreamId(liveGroupInfo.streamId);
        liveCardData.setForumName(liveGroupInfo.forumName);
    }
}
