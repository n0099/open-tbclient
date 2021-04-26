package com.baidu.tieba.forumsearch.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.j0.p0.c.c;
import tbclient.Error;
import tbclient.SearchPostForum.SearchPostForumResIdl;
/* loaded from: classes4.dex */
public class SearchPostForumSocketResponseMessage extends SocketResponsedMessage {
    public c mSearchData;

    public SearchPostForumSocketResponseMessage() {
        super(309466);
    }

    public c getSearchData() {
        return this.mSearchData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        SearchPostForumResIdl searchPostForumResIdl = (SearchPostForumResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchPostForumResIdl.class);
        if (searchPostForumResIdl != null) {
            Error error = searchPostForumResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(searchPostForumResIdl.error.usermsg);
            }
            if (getError() != 0 || getOrginalMessage() == null || !(getOrginalMessage().getExtra() instanceof SearchPostForumRequestMessage) || searchPostForumResIdl.data == null) {
                return;
            }
            c cVar = new c(((SearchPostForumRequestMessage) getOrginalMessage().getExtra()).get_word());
            this.mSearchData = cVar;
            cVar.b(searchPostForumResIdl.data);
        }
    }
}
