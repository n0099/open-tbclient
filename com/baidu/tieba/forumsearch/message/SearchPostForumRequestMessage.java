package com.baidu.tieba.forumsearch.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.r;
import tbclient.SearchPostForum.DataReq;
import tbclient.SearchPostForum.SearchPostForumReqIdl;
/* loaded from: classes6.dex */
public class SearchPostForumRequestMessage extends NetMessage {
    private String word;

    public SearchPostForumRequestMessage() {
        super(CmdConfigHttp.CMD_SEARCH_POST_FORUM, 309466);
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
                r.bindCommonParamsToProtobufData(builder, true);
            }
            SearchPostForumReqIdl.Builder builder2 = new SearchPostForumReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
