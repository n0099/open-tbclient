package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
import com.baidu.tieba.homepage.topic.topictab.message.ResponseHttpGetTopicListMessage;
import com.baidu.tieba.homepage.topic.topictab.message.ResponseSocketGetTopicListMessage;
import com.baidu.tieba.message.RequestBlessMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicModel extends BdBaseModel {
    private a bRo;
    private a gkd;
    private com.baidu.tieba.homepage.topic.topictab.a goG;
    private boolean mIsLoading;
    private List<m> mListData;
    private TbPageContext<?> mPageContext;

    public TopicModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gkd = new a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.topic.topictab.model.TopicModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                long j2;
                b bVar;
                if (responsedMessage != null) {
                    if (responsedMessage instanceof BlessHttpResponseMessage) {
                        long j3 = ((BlessHttpResponseMessage) responsedMessage).userPkId;
                        j = ((BlessHttpResponseMessage) responsedMessage).pkID;
                        j2 = j3;
                    } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                        long j4 = ((BlessSocketResponseMessage) responsedMessage).userPkId;
                        j = ((BlessSocketResponseMessage) responsedMessage).pkID;
                        j2 = j4;
                    } else {
                        j = 0;
                        j2 = 0;
                    }
                    long longValue = (j == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) ? ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue() : j;
                    if (longValue != 0 && TopicModel.this.mListData != null) {
                        for (m mVar : TopicModel.this.mListData) {
                            if ((mVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) mVar).gos) != null && longValue == bVar.pkId) {
                                bVar.userPkId = j2;
                                return;
                            }
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.bRo = new a(CmdConfigHttp.CMD_TOPIC_LIST, 309628) { // from class: com.baidu.tieba.homepage.topic.topictab.model.TopicModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                TopicModel.this.mIsLoading = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && TopicModel.this.unique_id == responsedMessage.getOrginalMessage().getTag() && TopicModel.this.goG != null) {
                    List<m> list = null;
                    if (responsedMessage instanceof ResponseHttpGetTopicListMessage) {
                        list = ((ResponseHttpGetTopicListMessage) responsedMessage).getTopicDataList();
                    }
                    if (responsedMessage instanceof ResponseSocketGetTopicListMessage) {
                        list = ((ResponseSocketGetTopicListMessage) responsedMessage).getTopicDataList();
                    }
                    TopicModel.this.mListData = list;
                    TopicModel.this.goG.k(responsedMessage.getError(), list);
                }
            }
        };
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.goG = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.bRo.setTag(bdUniqueId);
        registerListener(this.bRo);
        registerListener(this.gkd);
    }

    public void bvC() {
        if (!j.isNetworkAvailableForImmediately()) {
            if (this.goG != null) {
                this.goG.k(-1, null);
            }
        } else if (!this.mIsLoading) {
            cancelLoadData();
            RequestGetTopicListMessage requestGetTopicListMessage = new RequestGetTopicListMessage();
            requestGetTopicListMessage.setCallFrom("topic_tab");
            requestGetTopicListMessage.setTag(this.unique_id);
            if (MessageManager.getInstance().sendMessage(requestGetTopicListMessage)) {
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
        MessageManager.getInstance().unRegisterListener(this.bRo);
        this.mIsLoading = false;
    }
}
