package com.baidu.tieba.enterForum.recommend.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.enterForum.recommend.a;
import com.baidu.tieba.enterForum.recommend.message.RequestRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseHttpRecommendMessage;
import com.baidu.tieba.enterForum.recommend.message.ResponseSocketRecommendMessage;
/* loaded from: classes4.dex */
public class RecommendModel extends BdBaseModel {
    private a eEY;
    private boolean mIsLoading;
    private com.baidu.adp.framework.listener.a mNetMessageListener;
    private TbPageContext<?> mPageContext;

    public RecommendModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_RECOMMEND_FORUM, 309630) { // from class: com.baidu.tieba.enterForum.recommend.model.RecommendModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                RecommendModel.this.mIsLoading = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && RecommendModel.this.unique_id == responsedMessage.getOrginalMessage().getTag() && RecommendModel.this.eEY != null) {
                    com.baidu.tieba.enterForum.recommend.b.a aVar = null;
                    if (responsedMessage instanceof ResponseHttpRecommendMessage) {
                        aVar = ((ResponseHttpRecommendMessage) responsedMessage).getRecommendData();
                    }
                    if (responsedMessage instanceof ResponseSocketRecommendMessage) {
                        aVar = ((ResponseSocketRecommendMessage) responsedMessage).getRecommendData();
                    }
                    RecommendModel.this.eEY.a(responsedMessage.getError(), aVar);
                }
            }
        };
    }

    public void setPresenter(a aVar) {
        this.eEY = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.mNetMessageListener.setTag(bdUniqueId);
        registerListener(this.mNetMessageListener);
    }

    public void aXk() {
        if (!j.kM()) {
            if (this.eEY != null) {
                this.eEY.a(-1, null);
            }
        } else if (!this.mIsLoading) {
            cancelLoadData();
            RequestRecommendMessage requestRecommendMessage = new RequestRecommendMessage();
            requestRecommendMessage.setTag(this.unique_id);
            if (MessageManager.getInstance().sendMessage(requestRecommendMessage)) {
                this.mIsLoading = true;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mNetMessageListener);
        this.mIsLoading = false;
    }
}
