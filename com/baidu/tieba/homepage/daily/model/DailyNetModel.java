package com.baidu.tieba.homepage.daily.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
import com.baidu.tieba.homepage.daily.message.DailyPageHttpResMessage;
import com.baidu.tieba.homepage.daily.message.DailyPageRequetMessage;
import com.baidu.tieba.homepage.daily.message.DailyPageSocketResMessage;
import tbclient.DailyPage.DataRes;
/* loaded from: classes4.dex */
public class DailyNetModel extends BdBaseModel {
    private int Zv;
    private com.baidu.adp.framework.listener.a bRo;
    private a gfr;
    private boolean mIsLoading;
    private final int mPageSize;

    /* loaded from: classes4.dex */
    public interface a {
        void O(int i, String str);

        void a(DataRes dataRes, boolean z);
    }

    public DailyNetModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageSize = 30;
        this.bRo = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_DAILY_PAGE, 309617) { // from class: com.baidu.tieba.homepage.daily.model.DailyNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                DailyNetModel.this.mIsLoading = false;
                int i = (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof DailyPageRequetMessage)) ? 0 : ((DailyPageRequetMessage) responsedMessage.getOrginalMessage().getExtra()).pn;
                if (responsedMessage.getError() != 0) {
                    if (DailyNetModel.this.gfr != null) {
                        DailyNetModel.this.gfr.O(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                DataRes dataRes = null;
                if (responsedMessage instanceof DailyPageHttpResMessage) {
                    dataRes = ((DailyPageHttpResMessage) responsedMessage).getData();
                } else if (responsedMessage instanceof DailyPageSocketResMessage) {
                    dataRes = ((DailyPageSocketResMessage) responsedMessage).getData();
                }
                DailyNetModel.this.Zv = i;
                if (DailyNetModel.this.gfr != null) {
                    DailyNetModel.this.gfr.a(dataRes, i == 1);
                }
            }
        };
        aMH();
        bbH();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.bRo.setTag(bdUniqueId);
        registerListener(this.bRo);
    }

    private void bbH() {
        b bVar = new b(309617);
        bVar.setResponsedClass(DailyPageSocketResMessage.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void aMH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DAILY_PAGE, com.baidu.tieba.tbadkCore.a.a.bl(TbConfig.URL_DAILY_PAGE, 309617));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(DailyPageHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void refresh() {
        mf(1);
    }

    public void aIU() {
        mf(this.Zv + 1);
    }

    public void mf(int i) {
        if (!this.mIsLoading) {
            DailyPageRequetMessage dailyPageRequetMessage = new DailyPageRequetMessage();
            dailyPageRequetMessage.pn = i;
            dailyPageRequetMessage.rn = 30;
            if (MessageManager.getInstance().sendMessage(dailyPageRequetMessage)) {
                this.mIsLoading = true;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    public void a(a aVar) {
        this.gfr = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bRo);
        this.mIsLoading = false;
    }
}
