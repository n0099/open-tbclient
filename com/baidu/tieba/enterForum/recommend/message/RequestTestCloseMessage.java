package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.CommonReq;
import tbclient.TestClose.DataReq;
import tbclient.TestClose.TestCloseReqIdl;
/* loaded from: classes9.dex */
public class RequestTestCloseMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f1014common;
    private long fromPage;
    private long testId;

    public RequestTestCloseMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_TEST_CLOSE, 309633);
    }

    public void setCommon(CommonReq commonReq) {
        this.f1014common = commonReq;
    }

    public void setTestId(long j) {
        this.testId = j;
    }

    public void setFromPage(long j) {
        this.fromPage = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f1258common = this.f1014common;
        builder.test_id = Long.valueOf(this.testId);
        builder.from_page = Long.valueOf(this.fromPage);
        if (z) {
            t.a(builder, true);
        }
        TestCloseReqIdl.Builder builder2 = new TestCloseReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
