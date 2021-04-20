package com.baidu.tieba.homepage.hotTopic.tab.net;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.HotThreadList.DataReq;
import tbclient.HotThreadList.HotThreadListReqIdl;
/* loaded from: classes4.dex */
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

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.tab_id = this.tabId;
        builder.tab_code = this.tabCode;
        if (z) {
            w.a(builder, true);
        }
        HotThreadListReqIdl.Builder builder2 = new HotThreadListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setTabCode(String str) {
        this.tabCode = str;
    }

    public void setTabId(String str) {
        this.tabId = str;
    }
}
