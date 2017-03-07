package com.baidu.tieba.homepage.personalize.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
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
public class RecPersonalizePageModel extends BdBaseModel<BaseFragmentActivity> {
    private boolean bWs;
    private boolean bWt;
    private a cAG;
    private String cAH;
    private String cAI;
    private ArrayList<String> cAJ;
    private int cAK;
    private CustomMessageListener cAL;
    private CustomMessageListener cAM;
    private CustomMessageListener cAN;
    private com.baidu.adp.framework.listener.a mNetMessageListener;

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, int i, String str);

        void b(long j, DataRes dataRes, boolean z);
    }

    public RecPersonalizePageModel(com.baidu.adp.base.g<BaseFragmentActivity> gVar, BdUniqueId bdUniqueId) {
        super(gVar);
        this.mNetMessageListener = new g(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.bWs = false;
        this.bWt = false;
        this.cAK = 0;
        this.cAL = new h(this, CmdConfigCustom.CMD_SET_NU_SEX_GUIDE);
        this.cAM = new i(this, CmdConfigCustom.CMD_SET_NU_AGE_GUIDE);
        this.cAN = new j(this, CmdConfigCustom.CMD_SET_INTEREST_GUIDE);
        setUniqueId(bdUniqueId);
        QC();
        TP();
        registerListener(this.mNetMessageListener);
        registerListener(this.cAL);
        registerListener(this.cAM);
        registerListener(this.cAN);
    }

    public void a(a aVar) {
        this.cAG = aVar;
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
        if ((!StringUtils.isNull(this.cAH) || !StringUtils.isNull(this.cAI)) && !com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("close_new_user_guide_tip", false)) {
            recPersonalizeRequest.setSexTag(this.cAH);
            recPersonalizeRequest.seAgeTag(this.cAI);
        } else if (this.cAJ != null) {
            recPersonalizeRequest.setInterestGuideTag(this.cAJ);
        }
        recPersonalizeRequest.setTagType(this.cAK);
        sendMessage(recPersonalizeRequest);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        sendMessage(new RecPersonalizeRequest());
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    private void TP() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.m(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void QC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.av(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ResponsedMessage<?> responsedMessage) {
        if (!this.bWt) {
            this.bWt = true;
            a(1, false, responsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (!this.bWt) {
            this.bWt = true;
            a(1, true, responsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Gi().Gj() && com.baidu.tieba.homepage.framework.a.aiz().getCreateTime() > 0) {
            long jC = com.baidu.tieba.homepage.framework.a.aiz().jC(1);
            long createTime = com.baidu.tieba.homepage.framework.a.aiz().getCreateTime();
            n nVar = new n(1005, z, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.aiz().jB(1), false, jC + createTime);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.Gd();
            }
            com.baidu.tieba.homepage.framework.a.aiz().setCreateTime(0L);
        }
    }
}
