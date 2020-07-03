package com.baidu.tieba.homepage.personalize.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RealTimeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RealTimeRequest;
import com.baidu.tieba.homepage.personalize.data.RealTimeSocketResponse;
/* loaded from: classes9.dex */
public class e {
    private BdUniqueId unique_id = null;

    public void i(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        aVg();
        aVf();
    }

    private void aVf() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_REPORT_HOME_PIC_CLICK);
        bVar.setResponsedClass(RealTimeSocketResponse.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void aVg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003072, com.baidu.tieba.tbadkCore.a.a.bE(TbConfig.HOME_REALTIME_ADDRESS, CmdConfigSocket.CMD_REPORT_HOME_PIC_CLICK));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RealTimeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(long j, String str, String str2, int i, String str3, int i2, String str4, BaijiahaoData baijiahaoData) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
            RealTimeRequest realTimeRequest = new RealTimeRequest();
            realTimeRequest.setTid(j);
            realTimeRequest.setWeight(str);
            realTimeRequest.setSource(str2);
            realTimeRequest.setLocation(i);
            realTimeRequest.setAbtest_tag(str3);
            realTimeRequest.setType(i2);
            realTimeRequest.setPage(str4);
            if (baijiahaoData != null && i2 != com.baidu.adp.lib.f.b.toInt("2", 0)) {
                realTimeRequest.setOriUgcNid(baijiahaoData.oriUgcNid);
                realTimeRequest.setOriUgcTid(baijiahaoData.oriUgcTid);
                realTimeRequest.setOriUgcType(Integer.toString(baijiahaoData.oriUgcType));
                realTimeRequest.setOriUgcVid(baijiahaoData.oriUgcVid);
            }
            sendMessage(realTimeRequest);
        }
    }

    private void sendMessage(NetMessage netMessage) {
        if (netMessage != null) {
            if (netMessage.getTag() == null) {
                netMessage.setTag(this.unique_id);
            }
            MessageManager.getInstance().sendMessage(netMessage);
        }
    }
}
