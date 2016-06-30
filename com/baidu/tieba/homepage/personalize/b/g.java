package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tbadk.performanceLog.n;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeSocketResponse;
import java.util.ArrayList;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private com.baidu.adp.framework.listener.a aLj;
    private boolean bMP;
    private boolean bMQ;
    private a csJ;
    private String csK;
    private String csL;
    private ArrayList<String> csM;
    private int csN;
    private CustomMessageListener csO;
    private CustomMessageListener csP;
    private CustomMessageListener csQ;

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, int i, String str);

        void b(long j, DataRes dataRes, boolean z);
    }

    public g(com.baidu.adp.base.h<BaseFragmentActivity> hVar, BdUniqueId bdUniqueId) {
        super(hVar);
        this.aLj = new h(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.bMP = false;
        this.bMQ = false;
        this.csN = 0;
        this.csO = new i(this, CmdConfigCustom.CMD_SET_NU_SEX_GUIDE);
        this.csP = new j(this, CmdConfigCustom.CMD_SET_NU_AGE_GUIDE);
        this.csQ = new k(this, CmdConfigCustom.CMD_SET_INTEREST_GUIDE);
        setUniqueId(bdUniqueId);
        LK();
        LJ();
        registerListener(this.aLj);
        registerListener(this.csO);
        registerListener(this.csP);
        registerListener(this.csQ);
    }

    public void a(a aVar) {
        this.csJ = aVar;
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
        recPersonalizeRequest.setLoadType(i);
        recPersonalizeRequest.setNeedTag(z);
        recPersonalizeRequest.setRequestTagCode(i2);
        recPersonalizeRequest.setThreadCount(i3);
        recPersonalizeRequest.setTag(getUniqueId());
        recPersonalizeRequest.setPn(i4);
        recPersonalizeRequest.setSuggestCount(i5);
        recPersonalizeRequest.setTagCode(i2);
        if ((!StringUtils.isNull(this.csK) || !StringUtils.isNull(this.csL)) && !com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("close_new_user_guide_tip", false)) {
            recPersonalizeRequest.setSexTag(this.csK);
            recPersonalizeRequest.seAgeTag(this.csL);
        } else if (this.csM != null) {
            recPersonalizeRequest.setInterestGuideTag(this.csM);
        }
        recPersonalizeRequest.setTagType(this.csN);
        sendMessage(recPersonalizeRequest);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        sendMessage(new RecPersonalizeRequest());
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    private void LJ() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.h(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void LK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.aF(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (!this.bMQ) {
            this.bMQ = true;
            a(1, false, responsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (!this.bMQ) {
            this.bMQ = true;
            a(1, true, responsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.EW().EX() && com.baidu.tieba.homepage.framework.a.agi().getCreateTime() > 0) {
            long jj = com.baidu.tieba.homepage.framework.a.agi().jj(1);
            long createTime = com.baidu.tieba.homepage.framework.a.agi().getCreateTime();
            n nVar = new n(1005, z, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.agi().ji(1), false, jj + createTime);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.ER();
            }
            com.baidu.tieba.homepage.framework.a.agi().setCreateTime(0L);
        }
    }
}
