package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import protobuf.LiveGroupInfo;
import protobuf.QueryHotLiveGroups.QueryHotLiveGroupsResIdl;
/* loaded from: classes.dex */
public class ResponseHotLiveListLocalMessage extends CustomResponsedMessage<Object> {
    private com.baidu.tieba.im.data.d hotLiveListData;

    public ResponseHotLiveListLocalMessage() {
        super(2001205);
    }

    public com.baidu.tieba.im.data.d getHotLiveListData() {
        return this.hotLiveListData;
    }

    public void setHotLiveListData(com.baidu.tieba.im.data.d dVar) {
        this.hotLiveListData = dVar;
    }

    public void decodeInBackGround(int i, byte[] bArr) {
        int i2 = 0;
        if (bArr != null) {
            QueryHotLiveGroupsResIdl queryHotLiveGroupsResIdl = (QueryHotLiveGroupsResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryHotLiveGroupsResIdl.class);
            setError(queryHotLiveGroupsResIdl.error.errorno.intValue());
            setErrorString(queryHotLiveGroupsResIdl.error.usermsg);
            if (getError() == 0) {
                this.hotLiveListData = new com.baidu.tieba.im.data.d();
                this.hotLiveListData.a(queryHotLiveGroupsResIdl.data.hasMore.intValue());
                this.hotLiveListData.a(new ArrayList());
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
                        this.hotLiveListData.b().add(liveCardData);
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
