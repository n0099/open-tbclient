package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.live.data.HotLiveListData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import protobuf.LiveGroupInfo;
import protobuf.QueryLiveGroupsByUid.QueryLiveGroupsByUidResIdl;
/* loaded from: classes.dex */
public class ResponseMyLiveListLocalMessage extends CustomResponsedMessage<Object> {
    private HotLiveListData hotLiveListData;

    public ResponseMyLiveListLocalMessage() {
        super(CmdConfigCustom.CMD_QUERY_MYLIVE_LOCAL);
    }

    public HotLiveListData getHotLiveListData() {
        return this.hotLiveListData;
    }

    public void setHotLiveListData(HotLiveListData hotLiveListData) {
        this.hotLiveListData = hotLiveListData;
    }

    public void decodeInBackGround(int i, byte[] bArr) {
        int i2 = 0;
        QueryLiveGroupsByUidResIdl queryLiveGroupsByUidResIdl = (QueryLiveGroupsByUidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryLiveGroupsByUidResIdl.class);
        setError(queryLiveGroupsByUidResIdl.error.errorno.intValue());
        setErrorString(queryLiveGroupsByUidResIdl.error.usermsg);
        if (getError() == 0) {
            this.hotLiveListData = new HotLiveListData();
            this.hotLiveListData.setHasMore(queryLiveGroupsByUidResIdl.data.hasMore.intValue());
            this.hotLiveListData.setGroups(new ArrayList());
            if (queryLiveGroupsByUidResIdl.data.groups == null) {
                return;
            }
            while (true) {
                int i3 = i2;
                if (i3 < queryLiveGroupsByUidResIdl.data.groups.size()) {
                    LiveCardData liveCardData = new LiveCardData();
                    LiveGroupInfo liveGroupInfo = queryLiveGroupsByUidResIdl.data.groups.get(i3);
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
                    liveCardData.setStartTime(liveGroupInfo.startTime.intValue());
                    liveCardData.setStatus(liveGroupInfo.status.intValue());
                    liveCardData.setStreamId(liveGroupInfo.streamId);
                    if (liveGroupInfo.label != null) {
                        liveCardData.setLabelName(liveGroupInfo.label.labelName);
                    }
                    this.hotLiveListData.getGroups().add(liveCardData);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
