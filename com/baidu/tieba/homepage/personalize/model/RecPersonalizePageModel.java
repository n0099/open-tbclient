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
    private boolean bPk;
    private boolean bPl;
    private a czk;
    private String czl;
    private String czm;
    private ArrayList<String> czn;
    private int czo;
    private CustomMessageListener czp;
    private CustomMessageListener czq;
    private CustomMessageListener czr;
    private com.baidu.adp.framework.listener.a mNetMessageListener;

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, int i, String str);

        void b(long j, DataRes dataRes, boolean z);
    }

    public RecPersonalizePageModel(com.baidu.adp.base.g<BaseFragmentActivity> gVar, BdUniqueId bdUniqueId) {
        super(gVar);
        this.mNetMessageListener = new g(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.bPk = false;
        this.bPl = false;
        this.czo = 0;
        this.czp = new h(this, CmdConfigCustom.CMD_SET_NU_SEX_GUIDE);
        this.czq = new i(this, CmdConfigCustom.CMD_SET_NU_AGE_GUIDE);
        this.czr = new j(this, CmdConfigCustom.CMD_SET_INTEREST_GUIDE);
        setUniqueId(bdUniqueId);
        PJ();
        SP();
        registerListener(this.mNetMessageListener);
        registerListener(this.czp);
        registerListener(this.czq);
        registerListener(this.czr);
    }

    public void a(a aVar) {
        this.czk = aVar;
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
        if ((!StringUtils.isNull(this.czl) || !StringUtils.isNull(this.czm)) && !com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("close_new_user_guide_tip", false)) {
            recPersonalizeRequest.setSexTag(this.czl);
            recPersonalizeRequest.seAgeTag(this.czm);
        } else if (this.czn != null) {
            recPersonalizeRequest.setInterestGuideTag(this.czn);
        }
        recPersonalizeRequest.setTagType(this.czo);
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

    private void SP() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.l(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void PJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, com.baidu.tieba.tbadkCore.a.a.aC(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ResponsedMessage<?> responsedMessage) {
        if (!this.bPl) {
            this.bPl = true;
            a(1, false, responsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ResponsedMessage<?> responsedMessage) {
        if (!this.bPl) {
            this.bPl = true;
            a(1, true, responsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.FO().FP() && com.baidu.tieba.homepage.framework.a.ajm().getCreateTime() > 0) {
            long jX = com.baidu.tieba.homepage.framework.a.ajm().jX(1);
            long createTime = com.baidu.tieba.homepage.framework.a.ajm().getCreateTime();
            n nVar = new n(1005, z, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.ajm().jW(1), false, jX + createTime);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.FJ();
            }
            com.baidu.tieba.homepage.framework.a.ajm().setCreateTime(0L);
        }
    }
}
