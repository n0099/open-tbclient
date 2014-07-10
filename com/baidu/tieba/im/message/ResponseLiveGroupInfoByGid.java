package com.baidu.tieba.im.message;

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
        super(107008);
    }

    public String getName() {
        return this.name;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public int getBlackListCount() {
        return this.blackListCount;
    }

    public String getPortraitId() {
        return this.portraitId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryLiveGroupByGidResIdl queryLiveGroupByGidResIdl = (QueryLiveGroupByGidResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryLiveGroupByGidResIdl.class);
        setError(queryLiveGroupByGidResIdl.error.errorno.intValue());
        setErrorString(queryLiveGroupByGidResIdl.error.usermsg);
        if (getError() == 0) {
            this.name = queryLiveGroupByGidResIdl.data.group.name;
            this.portrait = queryLiveGroupByGidResIdl.data.group.portrait;
            this.intro = queryLiveGroupByGidResIdl.data.group.intro;
            this.blackListCount = queryLiveGroupByGidResIdl.data.group.gagers.intValue();
            this.portraitId = queryLiveGroupByGidResIdl.data.group.portraitId;
        }
    }
}
