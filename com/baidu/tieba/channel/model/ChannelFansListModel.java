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
    private boolean dxT;
    private long eQZ;
    private boolean eSv;
    private a eSx;
    private c eSy;
    public HttpMessageListener httpListener;
    private boolean mHasMore;
    private int mPageNum;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, String str, boolean z, c cVar);
    }

    public ChannelFansListModel(e<ChannelFansActivity> eVar, long j) {
        super(eVar);
        this.dxT = true;
        this.eSv = false;
        this.httpListener = new HttpMessageListener(1003314) { // from class: com.baidu.tieba.channel.model.ChannelFansListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponseChannelFansListMessage)) {
                    if (httpResponsedMessage.getError() == 0) {
                        ChannelFansListModel.this.a((ResponseChannelFansListMessage) httpResponsedMessage);
                    }
                    if (ChannelFansListModel.this.eSx != null) {
                        ChannelFansListModel.this.eSx.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ChannelFansListModel.this.dxT, ChannelFansListModel.this.eSy);
                    }
                    ChannelFansListModel.this.dxT = false;
                }
            }
        };
        this.eQZ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponseChannelFansListMessage responseChannelFansListMessage) {
        if (responseChannelFansListMessage != null) {
            if (this.eSy == null) {
                this.eSy = new c();
            }
            c data = responseChannelFansListMessage.getData();
            if (data != null) {
                this.eSy.getItems().addAll(data.getItems());
                this.eSy.setHasMore(data.hasMore());
                this.mHasMore = data.hasMore();
            }
        }
    }

    public void aIS() {
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
        bbt();
        return false;
    }

    private void bbt() {
        LinkedList<HttpMessage> findHttpMessage = MessageManager.getInstance().findHttpMessage(getUniqueId());
        if (findHttpMessage == null || findHttpMessage.size() == 0) {
            if (!this.eSv) {
                this.mPageNum = 1;
                this.eSy = null;
            } else {
                this.mPageNum++;
            }
            HttpMessage httpMessage = new HttpMessage(1003314);
            httpMessage.addParam("channel_id", this.eQZ);
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
        this.eSv = z;
    }

    public void a(a aVar) {
        this.eSx = aVar;
    }
}
