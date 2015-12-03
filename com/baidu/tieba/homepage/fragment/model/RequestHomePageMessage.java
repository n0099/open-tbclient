package com.baidu.tieba.homepage.fragment.model;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.i;
import tbclient.HomePage.DataReq;
import tbclient.HomePage.HomePageReqIdl;
/* loaded from: classes.dex */
public class RequestHomePageMessage extends NetMessage {
    private Long userId;

    public RequestHomePageMessage() {
        super(CmdConfigHttp.CMD_HOME_PAGE, 309086);
    }

    public Long get_user_id() {
        return this.userId;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.user_id = get_user_id();
            if (z) {
                i.a(builder, true);
            }
            HomePageReqIdl.Builder builder2 = new HomePageReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
