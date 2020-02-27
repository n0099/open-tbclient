package com.baidu.tieba.forumsearch.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.forumsearch.b.c;
import com.squareup.wire.Wire;
import tbclient.SearchPostForum.SearchPostForumResIdl;
/* loaded from: classes11.dex */
public class SearchPostForumSocketResponseMessage extends SocketResponsedMessage {
    private c mSearchData;

    public SearchPostForumSocketResponseMessage() {
        super(CmdConfigSocket.CMD_SEARCH_POST_FORUM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
