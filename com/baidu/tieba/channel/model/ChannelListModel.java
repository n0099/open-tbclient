package com.baidu.tieba.channel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.channel.data.e;
import com.baidu.tieba.channel.message.ResponseNetChannelListMessage;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ChannelListModel extends BdBaseModel<ChannelListActivity> {
    private boolean dxT;
    private a eSB;
    private e eSC;
    private boolean eSv;
    public HttpMessageListener httpListener;
    private boolean mHasMore;
    private int mPageNum;
    private String mUserId;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, String str, boolean z, e eVar);
    }

    public ChannelListModel(com.baidu.adp.base.e<ChannelListActivity> eVar, String str) {
        super(eVar);
        this.dxT = true;
        this.eSv = false;
        this.httpListener = new HttpMessageListener(1003304) { // from class: com.baidu.tieba.channel.model.ChannelListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseNetChannelListMessage) {
                    if (httpResponsedMessage.getError() == 0) {
                        ChannelListModel.this.a((ResponseNetChannelListMessage) httpResponsedMessage);
                    }
                    if (ChannelListModel.this.eSB != null) {
                        ChannelListModel.this.eSB.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ChannelListModel.this.dxT, ChannelListModel.this.eSC);
                    }
                    ChannelListModel.this.dxT = false;
                }
            }
        };
        this.mUserId = str;
    }

    public HttpMessage bi(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1003304);
        httpMessage.addParam("user_id", this.mUserId);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        this.mPageNum = i;
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponseNetChannelListMessage responseNetChannelListMessage) {
        if (responseNetChannelListMessage != null) {
            if (this.eSC == null) {
                this.eSC = new e();
            }
            e data = responseNetChannelListMessage.getData();
            if (data != null) {
                this.eSC.getItems().addAll(data.getItems());
                this.eSC.setHasMore(data.hasMore());
                this.mHasMore = data.hasMore();
            }
        }
    }

    public void aIS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003304, TbConfig.SERVER_ADDRESS + com.baidu.live.tbadk.data.Config.GET_USER_SUBCRIBE_CHANNEL_LIST);
        tbHttpMessageTask.setResponsedClass(ResponseNetChannelListMessage.class);
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
        HttpMessage bi;
        LinkedList<HttpMessage> findHttpMessage = MessageManager.getInstance().findHttpMessage(getUniqueId());
        if (findHttpMessage == null || findHttpMessage.size() == 0) {
            if (!this.eSv) {
                bi = bi(1, 8);
                this.eSC = null;
            } else {
                bi = bi(this.mPageNum + 1, 8);
            }
            sendMessage(bi);
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
        this.eSB = aVar;
    }
}
