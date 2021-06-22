package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.CommonReq;
import tbclient.TestClose.DataReq;
import tbclient.TestClose.TestCloseReqIdl;
/* loaded from: classes4.dex */
public class RequestTestCloseMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f14646common;
    public long fromPage;
    public long testId;

    public RequestTestCloseMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_TEST_CLOSE, 309633);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f72979common = this.f14646common;
        builder.test_id = Long.valueOf(this.testId);
        builder.from_page = Long.valueOf(this.fromPage);
        if (z) {
            w.a(builder, true);
        }
        TestCloseReqIdl.Builder builder2 = new TestCloseReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setCommon(CommonReq commonReq) {
        this.f14646common = commonReq;
    }

    public void setFromPage(long j) {
        this.fromPage = j;
    }

    public void setTestId(long j) {
        this.testId = j;
    }
}
