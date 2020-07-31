package com.baidu.tieba.homepage.hotTopic.tab.net;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.HotThreadList.DataReq;
import tbclient.HotThreadList.HotThreadListReqIdl;
/* loaded from: classes16.dex */
public class HotTopicTabRequest extends NetMessage {
    public static final String HOT_COMMENT_TAB_ID = "2";
    public static final String HOT_THREAD_TAB_ID = "1";
    private String tabId;

    public HotTopicTabRequest() {
        super(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661);
        this.tabId = "1";
    }

    public void setTabId(String str) {
        this.tabId = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.tab_id = this.tabId;
        if (z) {
            t.a(builder, true);
        }
        HotThreadListReqIdl.Builder builder2 = new HotThreadListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
