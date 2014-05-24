package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.QueryGroupCount.QueryGroupCountResIdl;
/* loaded from: classes.dex */
public class ResponseQueryGroupCountMessage extends TbSocketReponsedMessage {
    private static final String CACHE_KEY_PREFIX = "p_enter_forum_group_info";
    private String link;
    private int localGroupCount;
    private String picUrl;
    private int userGroupCount;

    public ResponseQueryGroupCountMessage() {
        super(MessageTypes.CMD_QUERY_GROUP_COUNT);
    }

    public ResponseQueryGroupCountMessage(int i) {
        super(i);
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public int getUserGroupCount() {
        return this.userGroupCount;
    }

    public void setUserGroupCount(int i) {
        this.userGroupCount = i;
    }

    public int getLocalGroupCount() {
        return this.localGroupCount;
    }

    public void setLocalGroupCount(int i) {
        this.localGroupCount = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryGroupCountResIdl queryGroupCountResIdl = (QueryGroupCountResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupCountResIdl.class);
        setError(queryGroupCountResIdl.error.errorno.intValue());
        setErrorString(queryGroupCountResIdl.error.usermsg);
        if (getError() == 0) {
            setLocalGroupCount(queryGroupCountResIdl.data.localGroupCount.intValue());
            setUserGroupCount(queryGroupCountResIdl.data.userGroupCount.intValue());
            if (queryGroupCountResIdl.data.banner != null) {
                setPicUrl(queryGroupCountResIdl.data.banner.picUrl);
                setLink(queryGroupCountResIdl.data.banner.link);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void processInBackGround(int i, byte[] bArr) {
        saveProtocolBufferDataToCache(com.baidu.tbadk.core.a.b.a().w(), CACHE_KEY_PREFIX, bArr);
    }
}
