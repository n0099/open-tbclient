package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.QueryGroupCount.QueryGroupCountResIdl;
/* loaded from: classes.dex */
public class ResponseQueryGroupCountMessage extends TbSocketReponsedMessage {
    private static final String CACHE_KEY_PREFIX = "p_enter_forum_group_info";
    private String geographicLocation;
    private String link;
    private int localGroupCount;
    private String picUrl;
    private int userGroupCount;

    public ResponseQueryGroupCountMessage() {
        super(103011);
        this.geographicLocation = "";
    }

    public ResponseQueryGroupCountMessage(int i) {
        super(i);
        this.geographicLocation = "";
    }

    public String getGeographicLocation() {
        return this.geographicLocation;
    }

    public String getLink() {
        return this.link;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getUserGroupCount() {
        return this.userGroupCount;
    }

    public int getLocalGroupCount() {
        return this.localGroupCount;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryGroupCountResIdl queryGroupCountResIdl = (QueryGroupCountResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryGroupCountResIdl.class);
        setError(queryGroupCountResIdl.error.errorno.intValue());
        setErrorString(queryGroupCountResIdl.error.usermsg);
        if (getError() == 0) {
            this.localGroupCount = queryGroupCountResIdl.data.localGroupCount.intValue();
            this.userGroupCount = queryGroupCountResIdl.data.userGroupCount.intValue();
            this.geographicLocation = queryGroupCountResIdl.data.position;
            if (queryGroupCountResIdl.data.banner != null) {
                this.picUrl = queryGroupCountResIdl.data.banner.picUrl;
                this.link = queryGroupCountResIdl.data.banner.link;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        saveProtocolBufferDataToCache(com.baidu.tbadk.core.a.b.a().w(), CACHE_KEY_PREFIX, bArr);
    }
}
