package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.live.data.FrsLiveListData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import protobuf.LiveGroupInfo;
import protobuf.QueryLiveGroupsByFid.QueryLiveGroupsByFidResIdl;
/* loaded from: classes.dex */
public class ResponseFrsLiveListMessage extends SocketResponsedMessage {
    private FrsLiveListData frsLiveListData;

    public ResponseFrsLiveListMessage() {
        super(107001);
    }

    public FrsLiveListData getFrsLiveListData() {
        return this.frsLiveListData;
    }

    public void setFrsLiveListData(FrsLiveListData frsLiveListData) {
        this.frsLiveListData = frsLiveListData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryLiveGroupsByFidResIdl queryLiveGroupsByFidResIdl = (QueryLiveGroupsByFidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryLiveGroupsByFidResIdl.class);
        setError(queryLiveGroupsByFidResIdl.error.errorno.intValue());
        setErrorString(queryLiveGroupsByFidResIdl.error.usermsg);
        if (getError() == 0 && queryLiveGroupsByFidResIdl.data != null && queryLiveGroupsByFidResIdl.data.groups != null) {
            this.frsLiveListData = new FrsLiveListData();
            this.frsLiveListData.setHasMore(queryLiveGroupsByFidResIdl.data.hasMore.intValue());
            this.frsLiveListData.setGroups(new ArrayList());
            for (int i2 = 0; i2 < queryLiveGroupsByFidResIdl.data.groups.size(); i2++) {
                LiveCardData liveCardData = new LiveCardData();
                LiveGroupInfo liveGroupInfo = queryLiveGroupsByFidResIdl.data.groups.get(i2);
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
                liveCardData.setFlag(liveGroupInfo.flag.intValue());
                liveCardData.setIsVip(liveGroupInfo.isVip.intValue());
                if (liveGroupInfo.label != null) {
                    liveCardData.setLabelName(liveGroupInfo.label.labelName);
                }
                if (liveGroupInfo.fromType == null) {
                    liveCardData.setFromType(0);
                } else {
                    liveCardData.setFromType(liveGroupInfo.fromType.intValue());
                }
                this.frsLiveListData.getGroups().add(liveCardData);
            }
            this.frsLiveListData.setHotGroups(new ArrayList());
            if (queryLiveGroupsByFidResIdl.data.hotGroups != null) {
                for (int i3 = 0; i3 < queryLiveGroupsByFidResIdl.data.hotGroups.size(); i3++) {
                    LiveCardData liveCardData2 = new LiveCardData();
                    LiveGroupInfo liveGroupInfo2 = queryLiveGroupsByFidResIdl.data.hotGroups.get(i3);
                    liveCardData2.setAuthorId(liveGroupInfo2.authorId.intValue());
                    liveCardData2.setAuthorName(liveGroupInfo2.authorName);
                    liveCardData2.setBackground(liveGroupInfo2.background);
                    liveCardData2.setCreateTime(liveGroupInfo2.createTime.intValue());
                    liveCardData2.setDeviceId(liveGroupInfo2.deviceId.intValue());
                    liveCardData2.setForumId(liveGroupInfo2.forumId.intValue());
                    liveCardData2.setForumName(liveGroupInfo2.forumName);
                    liveCardData2.setGroupId(liveGroupInfo2.groupId.intValue());
                    liveCardData2.setGroupType(liveGroupInfo2.groupType.intValue());
                    liveCardData2.setIntro(liveGroupInfo2.intro);
                    liveCardData2.setLikers(liveGroupInfo2.likers.intValue());
                    liveCardData2.setListeners(liveGroupInfo2.listeners.intValue());
                    liveCardData2.setName(liveGroupInfo2.name);
                    liveCardData2.setPortrait(liveGroupInfo2.portrait);
                    liveCardData2.setPublisherId(liveGroupInfo2.publisherId.intValue());
                    liveCardData2.setPublisherName(liveGroupInfo2.publisherName);
                    liveCardData2.setPublisherPortrait(liveGroupInfo2.publisherPortrait);
                    liveCardData2.setIsVip(liveGroupInfo2.isVip.intValue());
                    liveCardData2.setStartTime(liveGroupInfo2.startTime.intValue());
                    liveCardData2.setStatus(liveGroupInfo2.status.intValue());
                    liveCardData2.setStreamId(liveGroupInfo2.streamId);
                    if (liveGroupInfo2.label != null) {
                        liveCardData2.setLabelName(liveGroupInfo2.label.labelName);
                    }
                    this.frsLiveListData.getHotGroups().add(liveCardData2);
                }
            }
        }
    }
}
