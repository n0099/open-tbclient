package com.baidu.tieba.homepage.tabfeed.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.tabfeed.c;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.homepage.tabfeed.message.TabFeedListSocketResponsedMessage;
/* loaded from: classes9.dex */
public class HomePageTabFeedNetModel extends BdBaseModel {
    private boolean eSL;
    private int hiS;
    private com.baidu.adp.framework.listener.a hja;
    private boolean isLoading;
    private c ixx;
    private a ixy;
    private String tabCode;
    private String tabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.tabfeed.data.a aVar) {
        if (aVar != null) {
            this.hiS = aVar.cks();
        }
        if (this.ixx != null) {
            this.ixx.a(this.ixy.a(this.eSL, aVar));
        }
    }

    public HomePageTabFeedNetModel(TbPageContext tbPageContext, c cVar) {
        super(tbPageContext);
        this.eSL = true;
        this.isLoading = false;
        this.hiS = 1;
        this.hja = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, 309655) { // from class: com.baidu.tieba.homepage.tabfeed.model.HomePageTabFeedNetModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                HomePageTabFeedNetModel.this.isLoading = false;
                if (responsedMessage != null) {
                    com.baidu.tieba.homepage.tabfeed.data.a aVar = null;
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).tabFeedData;
                    } else if (responsedMessage instanceof TabFeedListSocketResponsedMessage) {
                        aVar = ((TabFeedListSocketResponsedMessage) responsedMessage).tabFeedData;
                    }
                    HomePageTabFeedNetModel.this.mErrorCode = responsedMessage.getError();
                    HomePageTabFeedNetModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(HomePageTabFeedNetModel.this.mErrorCode);
                    errorData.setError_msg(HomePageTabFeedNetModel.this.mErrorString);
                    if (HomePageTabFeedNetModel.this.ixx != null) {
                        if (HomePageTabFeedNetModel.this.mErrorCode != 0 || aVar == null) {
                            HomePageTabFeedNetModel.this.ixx.a(errorData);
                        } else {
                            HomePageTabFeedNetModel.this.a(aVar);
                        }
                    }
                }
            }
        };
        com.baidu.tieba.tbadkCore.a.a.a(309655, TabFeedListSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309655, CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, TbConfig.URL_TAB_ACTIVITY_TAB, TabFeedListHttpResponsedMessage.class, false, false, true, false);
        this.ixy = new a();
        this.ixx = cVar;
    }

    public void l(BdUniqueId bdUniqueId) {
        setUniqueId(bdUniqueId);
        MessageManager.getInstance().unRegisterListener(this.hja);
        this.hja.getHttpMessageListener().setSelfListener(true);
        this.hja.getSocketMessageListener().setSelfListener(true);
        registerListener(this.hja);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterListener(this.hja);
        this.isLoading = false;
        this.eSL = true;
    }

    public void ec(String str, String str2) {
        this.tabCode = str;
        this.tabName = str2;
    }

    public void btv() {
        if (!this.isLoading) {
            this.eSL = false;
            tD(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.eSL = true;
            tD(1);
        }
    }

    private void tD(int i) {
        TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
        tabFeedListRequestMessage.loadType = i;
        tabFeedListRequestMessage.tabCode = this.tabCode;
        tabFeedListRequestMessage.tabName = this.tabName;
        if (i == 2) {
            tabFeedListRequestMessage.pn = this.hiS + 1;
        } else if (i == 1) {
            tabFeedListRequestMessage.pn = 1;
        } else {
            return;
        }
        this.isLoading = true;
        sendMessage(tabFeedListRequestMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.isLoading = false;
    }

    public boolean hasData() {
        if (this.ixy == null) {
            return false;
        }
        return this.ixy.hasData();
    }
}
