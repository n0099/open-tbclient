package com.baidu.tieba.homepage.personalize.c;

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
    private com.baidu.adp.framework.listener.a aOg;
    private a cNa;
    private String cNb;
    private String cNc;
    private ArrayList<String> cNd;
    private int cNe;
    private CustomMessageListener cNf;
    private CustomMessageListener cNg;
    private CustomMessageListener cNh;
    private boolean cdl;
    private boolean cdm;

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, int i, String str);

        void b(long j, DataRes dataRes, boolean z);
    }

    public g(com.baidu.adp.base.h<BaseFragmentActivity> hVar, BdUniqueId bdUniqueId) {
        super(hVar);
        this.aOg = new h(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.cdl = false;
        this.cdm = false;
        this.cNe = 0;
        this.cNf = new i(this, CmdConfigCustom.CMD_SET_NU_SEX_GUIDE);
        this.cNg = new j(this, CmdConfigCustom.CMD_SET_NU_AGE_GUIDE);
        this.cNh = new k(this, CmdConfigCustom.CMD_SET_INTEREST_GUIDE);
        setUniqueId(bdUniqueId);
        PT();
        PS();
        registerListener(this.aOg);
        registerListener(this.cNf);
        registerListener(this.cNg);
        registerListener(this.cNh);
    }

    public void a(a aVar) {
        this.cNa = aVar;
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
        if ((!StringUtils.isNull(this.cNb) || !StringUtils.isNull(this.cNc)) && !com.baidu.tbadk.core.sharedPref.b.um().getBoolean("close_new_user_guide_tip", false)) {
            recPersonalizeRequest.setSexTag(this.cNb);
            recPersonalizeRequest.seAgeTag(this.cNc);
        } else if (this.cNd != null) {
            recPersonalizeRequest.setInterestGuideTag(this.cNd);
        }
        recPersonalizeRequest.setTagType(this.cNe);
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

    private void PS() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.l(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void PT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.aF(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (!this.cdm) {
            this.cdm = true;
            a(1, false, responsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (!this.cdm) {
            this.cdm = true;
            a(1, true, responsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Gu().Gv() && com.baidu.tieba.homepage.framework.a.anF().getCreateTime() > 0) {
            long jZ = com.baidu.tieba.homepage.framework.a.anF().jZ(1);
            long createTime = com.baidu.tieba.homepage.framework.a.anF().getCreateTime();
            n nVar = new n(1005, z, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.anF().jY(1), false, jZ + createTime);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.Gp();
            }
            com.baidu.tieba.homepage.framework.a.anF().setCreateTime(0L);
        }
    }
}
