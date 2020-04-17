package com.baidu.tieba.homepage.topic.topicdetail.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.RequestGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.RequestGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseHttpGetTopicThreadMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicDetailMessage;
import com.baidu.tieba.homepage.topic.topicdetail.message.ResponseSocketGetTopicThreadMessage;
import com.baidu.tieba.message.RequestBlessMessage;
import java.util.List;
/* loaded from: classes9.dex */
public class TopicDetailModel extends BdBaseModel {
    private com.baidu.adp.framework.listener.a hOd;
    private com.baidu.tieba.homepage.topic.topicdetail.a hRP;
    private com.baidu.tieba.homepage.topic.topicdetail.b.a hRQ;
    private TbPageContext<?> mPageContext;

    public TopicDetailModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hOd = new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.homepage.topic.topicdetail.model.TopicDetailModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                long j2;
                if (responsedMessage != null) {
                    if (responsedMessage instanceof BlessHttpResponseMessage) {
                        j2 = ((BlessHttpResponseMessage) responsedMessage).userPkId;
                        j = ((BlessHttpResponseMessage) responsedMessage).pkID;
                    } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                        j2 = ((BlessSocketResponseMessage) responsedMessage).userPkId;
                        j = ((BlessSocketResponseMessage) responsedMessage).pkID;
                    } else {
                        j = 0;
                        j2 = 0;
                    }
                    if (j == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) {
                        j = ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue();
                    }
                    if (j != 0 && TopicDetailModel.this.hRQ != null && TopicDetailModel.this.hRQ.hRw != null && TopicDetailModel.this.hRQ.hRw.hRB != null && TopicDetailModel.this.hRQ.hRw.hRB.pkId == j) {
                        TopicDetailModel.this.hRQ.hRw.hRB.userPkId = j2;
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TOPIC_DETAIL, 309629) { // from class: com.baidu.tieba.homepage.topic.topicdetail.model.TopicDetailModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && TopicDetailModel.this.unique_id == responsedMessage.getOrginalMessage().getTag() && TopicDetailModel.this.hRP != null) {
                    if (responsedMessage instanceof ResponseHttpGetTopicDetailMessage) {
                        TopicDetailModel.this.hRQ = ((ResponseHttpGetTopicDetailMessage) responsedMessage).getTopicDetailData();
                    }
                    if (responsedMessage instanceof ResponseSocketGetTopicDetailMessage) {
                        TopicDetailModel.this.hRQ = ((ResponseSocketGetTopicDetailMessage) responsedMessage).getTopicDetailData();
                    }
                    TopicDetailModel.this.hRP.a(responsedMessage.getError(), TopicDetailModel.this.hRQ);
                }
            }
        });
        registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_TOPIC_THREAD, 309631) { // from class: com.baidu.tieba.homepage.topic.topicdetail.model.TopicDetailModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && TopicDetailModel.this.unique_id == responsedMessage.getOrginalMessage().getTag() && TopicDetailModel.this.hRP != null) {
                    List<m> list = null;
                    boolean z = false;
                    if (responsedMessage instanceof ResponseHttpGetTopicThreadMessage) {
                        list = ((ResponseHttpGetTopicThreadMessage) responsedMessage).getDataList();
                        z = ((ResponseHttpGetTopicThreadMessage) responsedMessage).getHasMore();
                    }
                    if (responsedMessage instanceof ResponseSocketGetTopicThreadMessage) {
                        list = ((ResponseSocketGetTopicThreadMessage) responsedMessage).getDataList();
                        z = ((ResponseSocketGetTopicThreadMessage) responsedMessage).getHasMore();
                    }
                    TopicDetailModel.this.hRP.a(responsedMessage.getError(), z, list);
                }
            }
        });
        registerListener(this.hOd);
    }

    public void a(com.baidu.tieba.homepage.topic.topicdetail.a aVar) {
        this.hRP = aVar;
    }

    public void ep(long j) {
        if (!j.isNetworkAvailableForImmediately()) {
            if (this.hRP != null) {
                this.hRP.a(-1, null);
                return;
            }
            return;
        }
        RequestGetTopicDetailMessage requestGetTopicDetailMessage = new RequestGetTopicDetailMessage();
        requestGetTopicDetailMessage.setTopicId(j);
        requestGetTopicDetailMessage.setCallFrom("topic_tab");
        requestGetTopicDetailMessage.setTag(this.unique_id);
        sendMessage(requestGetTopicDetailMessage);
    }

    public void c(long j, long j2, long j3) {
        if (!j.isNetworkAvailableForImmediately()) {
            if (this.hRP != null) {
                this.hRP.a(-1, false, null);
                return;
            }
            return;
        }
        RequestGetTopicThreadMessage requestGetTopicThreadMessage = new RequestGetTopicThreadMessage();
        requestGetTopicThreadMessage.setTopicId(j);
        requestGetTopicThreadMessage.setPageNo(j2);
        requestGetTopicThreadMessage.setLastFeedId(j3);
        requestGetTopicThreadMessage.setCallFrom("topic_tab");
        requestGetTopicThreadMessage.setTag(this.unique_id);
        sendMessage(requestGetTopicThreadMessage);
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
}
