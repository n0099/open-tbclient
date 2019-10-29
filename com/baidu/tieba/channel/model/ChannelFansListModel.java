package com.baidu.tieba.channel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.channel.data.c;
import com.baidu.tieba.channel.message.ResponseChannelFansListMessage;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ChannelFansListModel extends BdBaseModel<ChannelFansActivity> {
    private boolean dyK;
    private long eRQ;
    private boolean eTm;
    private a eTo;
    private c eTp;
    public HttpMessageListener httpListener;
    private boolean mHasMore;
    private int mPageNum;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, String str, boolean z, c cVar);
    }

    public ChannelFansListModel(e<ChannelFansActivity> eVar, long j) {
        super(eVar);
        this.dyK = true;
        this.eTm = false;
        this.httpListener = new HttpMessageListener(1003314) { // from class: com.baidu.tieba.channel.model.ChannelFansListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponseChannelFansListMessage)) {
                    if (httpResponsedMessage.getError() == 0) {
                        ChannelFansListModel.this.a((ResponseChannelFansListMessage) httpResponsedMessage);
                    }
                    if (ChannelFansListModel.this.eTo != null) {
                        ChannelFansListModel.this.eTo.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ChannelFansListModel.this.dyK, ChannelFansListModel.this.eTp);
                    }
                    ChannelFansListModel.this.dyK = false;
                }
            }
        };
        this.eRQ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponseChannelFansListMessage responseChannelFansListMessage) {
        if (responseChannelFansListMessage != null) {
            if (this.eTp == null) {
                this.eTp = new c();
            }
            c data = responseChannelFansListMessage.getData();
            if (data != null) {
                this.eTp.getItems().addAll(data.getItems());
                this.eTp.setHasMore(data.hasMore());
                this.mHasMore = data.hasMore();
            }
        }
    }

    public void aIU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003314, TbConfig.SERVER_ADDRESS + Config.GET_CHANNEL_FANS_LIST);
        tbHttpMessageTask.setResponsedClass(ResponseChannelFansListMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.httpListener);
    }

    public void removeListener() {
        MessageManager.getInstance().unRegisterListener(this.httpListener);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        bbv();
        return false;
    }

    private void bbv() {
        LinkedList<HttpMessage> findHttpMessage = MessageManager.getInstance().findHttpMessage(getUniqueId());
        if (findHttpMessage == null || findHttpMessage.size() == 0) {
            if (!this.eTm) {
                this.mPageNum = 1;
                this.eTp = null;
            } else {
                this.mPageNum++;
            }
            HttpMessage httpMessage = new HttpMessage(1003314);
            httpMessage.addParam("channel_id", this.eRQ);
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, this.mPageNum);
            httpMessage.addParam("ps", 20);
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void iQ(boolean z) {
        this.eTm = z;
    }

    public void a(a aVar) {
        this.eTo = aVar;
    }
}
