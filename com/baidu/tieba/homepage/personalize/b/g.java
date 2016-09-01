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
    private com.baidu.adp.framework.listener.a aRx;
    private boolean bZR;
    private boolean bZS;
    private a cGY;
    private String cGZ;
    private String cHa;
    private ArrayList<String> cHb;
    private int cHc;
    private CustomMessageListener cHd;
    private CustomMessageListener cHe;
    private CustomMessageListener cHf;

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, int i, String str);

        void b(long j, DataRes dataRes, boolean z);
    }

    public g(com.baidu.adp.base.h<BaseFragmentActivity> hVar, BdUniqueId bdUniqueId) {
        super(hVar);
        this.aRx = new h(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.bZR = false;
        this.bZS = false;
        this.cHc = 0;
        this.cHd = new i(this, CmdConfigCustom.CMD_SET_NU_SEX_GUIDE);
        this.cHe = new j(this, CmdConfigCustom.CMD_SET_NU_AGE_GUIDE);
        this.cHf = new k(this, CmdConfigCustom.CMD_SET_INTEREST_GUIDE);
        setUniqueId(bdUniqueId);
        Oo();
        On();
        registerListener(this.aRx);
        registerListener(this.cHd);
        registerListener(this.cHe);
        registerListener(this.cHf);
    }

    public void a(a aVar) {
        this.cGY = aVar;
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
        if ((!StringUtils.isNull(this.cGZ) || !StringUtils.isNull(this.cHa)) && !com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("close_new_user_guide_tip", false)) {
            recPersonalizeRequest.setSexTag(this.cGZ);
            recPersonalizeRequest.seAgeTag(this.cHa);
        } else if (this.cHb != null) {
            recPersonalizeRequest.setInterestGuideTag(this.cHb);
        }
        recPersonalizeRequest.setTagType(this.cHc);
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

    private void On() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.l(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void Oo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.aG(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (!this.bZS) {
            this.bZS = true;
            a(1, false, responsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (!this.bZS) {
            this.bZS = true;
            a(1, true, responsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Gp().Gq() && com.baidu.tieba.homepage.framework.a.alw().getCreateTime() > 0) {
            long jM = com.baidu.tieba.homepage.framework.a.alw().jM(1);
            long createTime = com.baidu.tieba.homepage.framework.a.alw().getCreateTime();
            n nVar = new n(1005, z, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.alw().jL(1), false, jM + createTime);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.Gk();
            }
            com.baidu.tieba.homepage.framework.a.alw().setCreateTime(0L);
        }
    }
}
