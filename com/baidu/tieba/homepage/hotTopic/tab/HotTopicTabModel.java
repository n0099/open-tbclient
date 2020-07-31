package com.baidu.tieba.homepage.hotTopic.tab;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.hotTopic.tab.net.HotTopicTabRequest;
/* loaded from: classes16.dex */
public class HotTopicTabModel extends BdBaseModel {
    private com.baidu.adp.framework.listener.a dFJ;
    private b iwN;
    private boolean mIsLoading;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HotTopicTabModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        cmP();
    }

    private void cmP() {
        this.dFJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661) { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                HotTopicTabModel.this.mIsLoading = false;
                if (HotTopicTabModel.this.iwN != null && (responsedMessage instanceof com.baidu.tieba.homepage.hotTopic.tab.net.a) && HotTopicTabModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    if (responsedMessage.getOrginalMessage() == null) {
                        HotTopicTabModel.this.iwN.n(-1, null);
                        return;
                    }
                    HotTopicTabModel.this.iwN.n(responsedMessage.getError(), ((com.baidu.tieba.homepage.hotTopic.tab.net.a) responsedMessage).getDataList());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPresenter(b bVar) {
        this.iwN = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.dFJ.setTag(bdUniqueId);
        registerListener(this.dFJ);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!j.isNetworkAvailableForImmediately() || this.mIsLoading) {
            return false;
        }
        cancelLoadData();
        HotTopicTabRequest hotTopicTabRequest = new HotTopicTabRequest();
        hotTopicTabRequest.setTag(this.unique_id);
        this.mIsLoading = MessageManager.getInstance().sendMessage(hotTopicTabRequest);
        return this.mIsLoading;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFJ);
        this.mIsLoading = false;
    }
}
