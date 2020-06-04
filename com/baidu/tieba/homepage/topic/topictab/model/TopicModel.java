package com.baidu.tieba.homepage.topic.topictab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.homepage.topic.topictab.message.RequestGetTopicListMessage;
import com.baidu.tieba.homepage.topic.topictab.message.ResponseHttpGetTopicListMessage;
import com.baidu.tieba.homepage.topic.topictab.message.ResponseSocketGetTopicListMessage;
import com.baidu.tieba.message.RequestBlessMessage;
import java.util.List;
/* loaded from: classes9.dex */
public class TopicModel extends BdBaseModel {
    private a dve;
    private a idH;
    private com.baidu.tieba.homepage.topic.topictab.a iiL;
    private boolean mIsLoading;
    private List<o> mListData;
    private TbPageContext<?> mPageContext;

    public TopicModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.idH = new a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.topic.topictab.model.TopicModel.1
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
                        for (o oVar : TopicModel.this.mListData) {
                            if ((oVar instanceof com.baidu.tieba.homepage.topic.topictab.b.a) && (bVar = ((com.baidu.tieba.homepage.topic.topictab.b.a) oVar).iix) != null && longValue == bVar.pkId) {
                                bVar.userPkId = j2;
                                return;
                            }
                        }
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        com.baidu.tieba.tbadkCore.a.a.a(309628, ResponseSocketGetTopicListMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309628, CmdConfigHttp.CMD_TOPIC_LIST, TbConfig.URL_GET_TAB_TOPIC_LIST, ResponseHttpGetTopicListMessage.class, false, false, true, false);
        com.baidu.tieba.tbadkCore.a.a.a(309629, ResponseSocketGetTopicDetailMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309629, CmdConfigHttp.CMD_TOPIC_DETAIL, TbConfig.URL_GET_TOPIC_DETAIL, ResponseHttpGetTopicDetailMessage.class, false, false, true, false);
        com.baidu.tieba.tbadkCore.a.a.a(309631, ResponseSocketGetTopicThreadMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309631, CmdConfigHttp.CMD_TOPIC_THREAD, TbConfig.URL_GET_TOPIC_THREAD, ResponseHttpGetTopicThreadMessage.class, false, false, true, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_TOPIC_BLESS, BlessSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_TOPIC_BLESS, 1003065, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
        this.dve = new a(CmdConfigHttp.CMD_TOPIC_LIST, 309628) { // from class: com.baidu.tieba.homepage.topic.topictab.model.TopicModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                TopicModel.this.mIsLoading = false;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && TopicModel.this.unique_id == responsedMessage.getOrginalMessage().getTag() && TopicModel.this.iiL != null) {
                    List<o> list = null;
                    if (responsedMessage instanceof ResponseHttpGetTopicListMessage) {
                        list = ((ResponseHttpGetTopicListMessage) responsedMessage).getTopicDataList();
                    }
                    if (responsedMessage instanceof ResponseSocketGetTopicListMessage) {
                        list = ((ResponseSocketGetTopicListMessage) responsedMessage).getTopicDataList();
                    }
                    TopicModel.this.mListData = list;
                    TopicModel.this.iiL.o(responsedMessage.getError(), list);
                }
            }
        };
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.iiL = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.dve.setTag(bdUniqueId);
        registerListener(this.dve);
        this.idH.setTag(bdUniqueId);
        registerListener(this.idH);
    }

    public void chc() {
        if (!j.isNetworkAvailableForImmediately()) {
            if (this.iiL != null) {
                this.iiL.o(-1, null);
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
        MessageManager.getInstance().unRegisterListener(this.dve);
        MessageManager.getInstance().unRegisterListener(this.idH);
        this.mIsLoading = false;
    }
}
