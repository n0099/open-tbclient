package com.baidu.tieba.homepage.personalize.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RealTimeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RealTimeRequest;
import com.baidu.tieba.homepage.personalize.data.RealTimeSocketResponse;
/* loaded from: classes2.dex */
public class e {
    private BdUniqueId unique_id = null;

    public void m(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        ahw();
        alX();
    }

    private void alX() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309277);
        bVar.setResponsedClass(RealTimeSocketResponse.class);
        bVar.T(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void ahw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_REPORT_HOME_PIC_CLICK, com.baidu.tieba.tbadkCore.a.a.aI(TbConfig.HOME_REALTIME_ADDRESS, 309277));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RealTimeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(long j, String str, String str2, int i, String str3, int i2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
            RealTimeRequest realTimeRequest = new RealTimeRequest();
            realTimeRequest.setTid(j);
            realTimeRequest.setWeight(str);
            realTimeRequest.setSource(str2);
            realTimeRequest.setLocation(i);
            realTimeRequest.setAbtest_tag(str3);
            realTimeRequest.setType(i2);
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
