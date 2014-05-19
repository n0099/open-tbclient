package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.QueryLiveGroupByGid.QueryLiveGroupByGidResIdl;
/* loaded from: classes.dex */
public class ResponseLiveGroupInfoByGid extends TbSocketReponsedMessage {
    private int blackListCount;
    private String intro;
    private String name;
    private String portrait;
    private String portraitId;

    public ResponseLiveGroupInfoByGid() {
        super(MessageTypes.CMD_GET_LIVE_GROUP_INFO);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public int getBlackListCount() {
        return this.blackListCount;
    }

    public void setBlackListCount(int i) {
        this.blackListCount = i;
    }

    public String getPortraitId() {
        return this.portraitId;
    }

    public void setPortraitId(String str) {
        this.portraitId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryLiveGroupByGidResIdl queryLiveGroupByGidResIdl = (QueryLiveGroupByGidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryLiveGroupByGidResIdl.class);
        setError(queryLiveGroupByGidResIdl.error.errorno.intValue());
        setErrorString(queryLiveGroupByGidResIdl.error.usermsg);
        if (getError() == 0) {
            setName(queryLiveGroupByGidResIdl.data.group.name);
            setPortrait(queryLiveGroupByGidResIdl.data.group.portrait);
            setIntro(queryLiveGroupByGidResIdl.data.group.intro);
            setBlackListCount(queryLiveGroupByGidResIdl.data.group.gagers.intValue());
            setPortraitId(queryLiveGroupByGidResIdl.data.group.portraitId);
        }
    }
}
