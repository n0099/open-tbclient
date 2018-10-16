package com.baidu.tieba.aiapps.apps.abtest.msg;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.p;
import tbclient.decrypt.DataReq;
import tbclient.decrypt.DecryptCodeReqIdl;
/* loaded from: classes4.dex */
public class DecryptCodeReqMsg extends NetMessage {
    private String code;

    public DecryptCodeReqMsg() {
        super(CmdConfigHttp.CMD_DECRYPT_AI_APP_CODE, 309626);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.tieba_code = this.code;
            p.bindCommonParamsToProtobufData(builder, true, true, true);
            DecryptCodeReqIdl.Builder builder2 = new DecryptCodeReqIdl.Builder();
            builder2.data = builder.build(true);
            return builder2.build(true);
        } catch (Throwable th) {
            return null;
        }
    }

    public void setCode(String str) {
        this.code = str;
    }
}
