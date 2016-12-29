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
    private com.baidu.adp.framework.listener.a aNx;
    private boolean bIS;
    private boolean bIT;
    private a csf;
    private String csg;
    private String csh;
    private ArrayList<String> csi;
    private int csj;
    private CustomMessageListener csk;
    private CustomMessageListener csl;
    private CustomMessageListener csm;

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, int i, String str);

        void b(long j, DataRes dataRes, boolean z);
    }

    public g(com.baidu.adp.base.h<BaseFragmentActivity> hVar, BdUniqueId bdUniqueId) {
        super(hVar);
        this.aNx = new h(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.bIS = false;
        this.bIT = false;
        this.csj = 0;
        this.csk = new i(this, CmdConfigCustom.CMD_SET_NU_SEX_GUIDE);
        this.csl = new j(this, CmdConfigCustom.CMD_SET_NU_AGE_GUIDE);
        this.csm = new k(this, CmdConfigCustom.CMD_SET_INTEREST_GUIDE);
        setUniqueId(bdUniqueId);
        Ps();
        Pr();
        registerListener(this.aNx);
        registerListener(this.csk);
        registerListener(this.csl);
        registerListener(this.csm);
    }

    public void a(a aVar) {
        this.csf = aVar;
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
        if ((!StringUtils.isNull(this.csg) || !StringUtils.isNull(this.csh)) && !com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("close_new_user_guide_tip", false)) {
            recPersonalizeRequest.setSexTag(this.csg);
            recPersonalizeRequest.seAgeTag(this.csh);
        } else if (this.csi != null) {
            recPersonalizeRequest.setInterestGuideTag(this.csi);
        }
        recPersonalizeRequest.setTagType(this.csj);
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

    private void Pr() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.l(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void Ps() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.aB(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (!this.bIT) {
            this.bIT = true;
            a(1, false, responsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (!this.bIT) {
            this.bIT = true;
            a(1, true, responsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.FU().FV() && com.baidu.tieba.homepage.framework.a.aif().getCreateTime() > 0) {
            long jk = com.baidu.tieba.homepage.framework.a.aif().jk(1);
            long createTime = com.baidu.tieba.homepage.framework.a.aif().getCreateTime();
            n nVar = new n(1005, z, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.aif().jj(1), false, jk + createTime);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.FP();
            }
            com.baidu.tieba.homepage.framework.a.aif().setCreateTime(0L);
        }
    }
}
