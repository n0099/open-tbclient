package com.baidu.tbadk.im.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import protobuf.LiveGroupLabel;
import protobuf.Photo;
import protobuf.QueryLiveGroupByGid.QueryLiveGroupByGidResIdl;
/* loaded from: classes.dex */
public class ResponseLiveGroupInfoByGid extends TbSocketReponsedMessage {
    private List<Photo> LiveRoomBackground;
    private int blackListCount;
    private int isVip;
    private String liveRoomAnnounce;
    private String liveRoomIntro;
    private LiveGroupLabel liveRoomLabel;
    private String liveRoomName;
    private Photo liveRoomPortraitIfo;

    public ResponseLiveGroupInfoByGid() {
        super(107008);
    }

    public String getLiveRoomName() {
        return this.liveRoomName;
    }

    public String getLiveRoomAnnouncement() {
        return this.liveRoomAnnounce;
    }

    public String getLiveRoomIntro() {
        return this.liveRoomIntro;
    }

    public List<Photo> getLiveRoomBackgroud() {
        return this.LiveRoomBackground;
    }

    public LiveGroupLabel getLiveGroupLabel() {
        return this.liveRoomLabel;
    }

    public Photo getPortraitInfo() {
        return this.liveRoomPortraitIfo;
    }

    public int getBlackListCount() {
        return this.blackListCount;
    }

    public boolean isVip() {
        return this.isVip != 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryLiveGroupByGidResIdl queryLiveGroupByGidResIdl = (QueryLiveGroupByGidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryLiveGroupByGidResIdl.class);
        setError(queryLiveGroupByGidResIdl.error.errorno.intValue());
        setErrorString(queryLiveGroupByGidResIdl.error.usermsg);
        if (getError() == 0) {
            this.liveRoomName = queryLiveGroupByGidResIdl.data.group.name;
            this.liveRoomPortraitIfo = queryLiveGroupByGidResIdl.data.group.avatar;
            this.liveRoomAnnounce = queryLiveGroupByGidResIdl.data.group.intro;
            this.blackListCount = queryLiveGroupByGidResIdl.data.group.gagers.intValue();
            this.liveRoomIntro = queryLiveGroupByGidResIdl.data.group.signature;
            this.liveRoomLabel = queryLiveGroupByGidResIdl.data.group.label;
            this.isVip = queryLiveGroupByGidResIdl.data.group.isVip.intValue();
            this.LiveRoomBackground = queryLiveGroupByGidResIdl.data.group.backgrounds;
        }
    }
}
