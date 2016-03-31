package com.baidu.tieba.adkiller;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.KillAd.DataReq;
import tbclient.KillAd.KillAdReqIdl;
/* loaded from: classes.dex */
public class SubmitCloseNetMessage extends NetMessage {
    public static final int TYPE_CLOSE = 2;
    public static final int TYPE_KILL = 1;
    private String killTag;
    private int type;

    public SubmitCloseNetMessage() {
        super(CmdConfigHttp.CMD_SUBMIT_CLOSE_ADKILLER, 309266);
    }

    public String getKillTag() {
        return this.killTag;
    }

    public void setKillTag(String str) {
        this.killTag = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    private String createMd5() {
        return t.aZ("tb_adkiller" + this.type + this.killTag).toLowerCase();
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.ak_tag = this.killTag;
        builder.ak_cmd = String.valueOf(this.type);
        builder.ak_sign = createMd5();
        KillAdReqIdl.Builder builder2 = new KillAdReqIdl.Builder();
        if (z) {
            com.baidu.tbadk.util.l.a(builder, true);
        }
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
