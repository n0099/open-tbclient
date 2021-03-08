package com.baidu.tieba.homepage.lowFlows.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.v;
import tbclient.MoreTreasureTrove.DataReq;
import tbclient.MoreTreasureTrove.MoreTreasureTroveReqIdl;
/* loaded from: classes2.dex */
public class MoreTreasureTroveReqMsg extends NetMessage {
    private String lfUser;
    private String tabCode;
    private String taskId;

    public String getTabCode() {
        return this.tabCode;
    }

    public void setTabCode(String str) {
        this.tabCode = str;
    }

    public String getLfUser() {
        return this.lfUser;
    }

    public void setLfUser(String str) {
        this.lfUser = str;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public MoreTreasureTroveReqMsg() {
        super(CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.tab_code = this.tabCode;
            builder.lf_user = this.lfUser;
            builder.lf_user_taskid = this.taskId;
            builder.app_pos = com.baidu.tieba.recapp.c.a.dEu().dEy();
            if (z) {
                v.a(builder, true, true, false);
            }
            MoreTreasureTroveReqIdl.Builder builder2 = new MoreTreasureTroveReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
