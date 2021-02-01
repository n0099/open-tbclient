package com.baidu.tieba.homepage.hotTopic.tab.net;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.v;
import tbclient.HotThreadList.DataReq;
import tbclient.HotThreadList.HotThreadListReqIdl;
/* loaded from: classes2.dex */
public class HotTopicTabRequest extends NetMessage {
    public static final String HOT_COMMENT_TAB_ID = "2";
    public static final String HOT_TAB_CODE_ALL = "all";
    public static final String HOT_THREAD_TAB_ID = "1";
    public String tabCode;
    public String tabId;

    public HotTopicTabRequest() {
        super(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661);
        this.tabCode = "all";
        this.tabId = "1";
    }

    public void setTabId(String str) {
        this.tabId = str;
    }

    public void setTabCode(String str) {
        this.tabCode = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.tab_id = this.tabId;
        builder.tab_code = this.tabCode;
        if (z) {
            v.b(builder, true);
        }
        HotThreadListReqIdl.Builder builder2 = new HotThreadListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
