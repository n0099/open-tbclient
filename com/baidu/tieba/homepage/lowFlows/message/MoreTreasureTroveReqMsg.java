package com.baidu.tieba.homepage.lowFlows.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import d.b.i0.r2.a0.a;
import tbclient.MoreTreasureTrove.DataReq;
import tbclient.MoreTreasureTrove.MoreTreasureTroveReqIdl;
/* loaded from: classes4.dex */
public class MoreTreasureTroveReqMsg extends NetMessage {
    public String lfUser;
    public String tabCode;
    public String taskId;

    public MoreTreasureTroveReqMsg() {
        super(CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.tab_code = this.tabCode;
            builder.lf_user = this.lfUser;
            builder.lf_user_taskid = this.taskId;
            builder.app_pos = a.e().a();
            if (z) {
                w.c(builder, true, true, false);
            }
            MoreTreasureTroveReqIdl.Builder builder2 = new MoreTreasureTroveReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getLfUser() {
        return this.lfUser;
    }

    public String getTabCode() {
        return this.tabCode;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setLfUser(String str) {
        this.lfUser = str;
    }

    public void setTabCode(String str) {
        this.tabCode = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }
}
