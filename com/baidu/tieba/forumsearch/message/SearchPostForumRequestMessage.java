package com.baidu.tieba.forumsearch.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.i0.z0.w;
import tbclient.SearchPostForum.DataReq;
import tbclient.SearchPostForum.SearchPostForumReqIdl;
/* loaded from: classes4.dex */
public class SearchPostForumRequestMessage extends NetMessage {
    public String word;

    public SearchPostForumRequestMessage() {
        super(CmdConfigHttp.CMD_SEARCH_POST_FORUM, 309466);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.word = get_word();
            if (z) {
                w.a(builder, true);
            }
            SearchPostForumReqIdl.Builder builder2 = new SearchPostForumReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public String get_word() {
        return this.word;
    }

    public void set_word(String str) {
        this.word = str;
    }
}
