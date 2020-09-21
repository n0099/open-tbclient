package com.baidu.tieba.forumsearch.message;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.forumsearch.b.c;
import com.squareup.wire.Wire;
import tbclient.SearchPostForum.SearchPostForumResIdl;
/* loaded from: classes23.dex */
public class SearchPostForumHttpResponseMessage extends TbHttpResponsedMessage {
    private c mSearchData;

    public SearchPostForumHttpResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SearchPostForumResIdl searchPostForumResIdl = (SearchPostForumResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchPostForumResIdl.class);
        if (searchPostForumResIdl != null) {
            if (searchPostForumResIdl.error != null) {
                setError(searchPostForumResIdl.error.errorno.intValue());
                setErrorString(searchPostForumResIdl.error.usermsg);
            }
            if (getError() == 0 && getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof SearchPostForumRequestMessage) && searchPostForumResIdl.data != null) {
                this.mSearchData = new c(((SearchPostForumRequestMessage) getOrginalMessage().getExtra()).get_word());
                this.mSearchData.a(searchPostForumResIdl.data);
            }
        }
    }

    public c getSearchData() {
        return this.mSearchData;
    }
}
