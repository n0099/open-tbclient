package com.baidu.tieba.forumsearch.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.SearchPostForum.DataReq;
import tbclient.SearchPostForum.SearchPostForumReqIdl;
/* loaded from: classes8.dex */
public class SearchPostForumRequestMessage extends NetMessage {
    private String word;

    public SearchPostForumRequestMessage() {
        super(1003335, CmdConfigSocket.CMD_SEARCH_POST_FORUM);
    }

    public String get_word() {
        return this.word;
    }

    public void set_word(String str) {
        this.word = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.word = get_word();
            if (z) {
                v.b(builder, true);
            }
            SearchPostForumReqIdl.Builder builder2 = new SearchPostForumReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
