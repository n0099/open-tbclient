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
    private com.baidu.adp.framework.listener.a aMd;
    private boolean bOA;
    private boolean bOz;
    private CustomMessageListener cvA;
    private CustomMessageListener cvB;
    private a cvu;
    private String cvv;
    private String cvw;
    private ArrayList<String> cvx;
    private int cvy;
    private CustomMessageListener cvz;

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, int i, String str);

        void b(long j, DataRes dataRes, boolean z);
    }

    public g(com.baidu.adp.base.h<BaseFragmentActivity> hVar, BdUniqueId bdUniqueId) {
        super(hVar);
        this.aMd = new h(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.bOz = false;
        this.bOA = false;
        this.cvy = 0;
        this.cvz = new i(this, CmdConfigCustom.CMD_SET_NU_SEX_GUIDE);
        this.cvA = new j(this, CmdConfigCustom.CMD_SET_NU_AGE_GUIDE);
        this.cvB = new k(this, CmdConfigCustom.CMD_SET_INTEREST_GUIDE);
        setUniqueId(bdUniqueId);
        LJ();
        LI();
        registerListener(this.aMd);
        registerListener(this.cvz);
        registerListener(this.cvA);
        registerListener(this.cvB);
    }

    public void a(a aVar) {
        this.cvu = aVar;
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
        if ((!StringUtils.isNull(this.cvv) || !StringUtils.isNull(this.cvw)) && !com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("close_new_user_guide_tip", false)) {
            recPersonalizeRequest.setSexTag(this.cvv);
            recPersonalizeRequest.seAgeTag(this.cvw);
        } else if (this.cvx != null) {
            recPersonalizeRequest.setInterestGuideTag(this.cvx);
        }
        recPersonalizeRequest.setTagType(this.cvy);
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

    private void LI() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.j(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void LJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.aG(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (!this.bOA) {
            this.bOA = true;
            a(1, false, responsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (!this.bOA) {
            this.bOA = true;
            a(1, true, responsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.EV().EW() && com.baidu.tieba.homepage.framework.a.agL().getCreateTime() > 0) {
            long jk = com.baidu.tieba.homepage.framework.a.agL().jk(1);
            long createTime = com.baidu.tieba.homepage.framework.a.agL().getCreateTime();
            n nVar = new n(1005, z, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.agL().jj(1), false, jk + createTime);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.EQ();
            }
            com.baidu.tieba.homepage.framework.a.agL().setCreateTime(0L);
        }
    }
}
