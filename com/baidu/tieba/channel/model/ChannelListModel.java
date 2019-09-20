package com.baidu.tieba.channel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.channel.data.e;
import com.baidu.tieba.channel.message.ResponseNetChannelListMessage;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ChannelListModel extends BdBaseModel<ChannelListActivity> {
    private boolean drA;
    private boolean duA;
    private a eKM;
    private e eKN;
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
        this.drA = true;
        this.duA = false;
        this.httpListener = new HttpMessageListener(CmdConfigHttp.CMD_GET_SUBSCRIBE_CHANNEL_LIST) { // from class: com.baidu.tieba.channel.model.ChannelListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseNetChannelListMessage) {
                    if (httpResponsedMessage.getError() == 0) {
                        ChannelListModel.this.a((ResponseNetChannelListMessage) httpResponsedMessage);
                    }
                    if (ChannelListModel.this.eKM != null) {
                        ChannelListModel.this.eKM.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ChannelListModel.this.drA, ChannelListModel.this.eKN);
                    }
                    ChannelListModel.this.drA = false;
                }
            }
        };
        this.mUserId = str;
    }

    public HttpMessage bi(int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_SUBSCRIBE_CHANNEL_LIST);
        httpMessage.addParam("user_id", this.mUserId);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        this.mPageNum = i;
        return httpMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponseNetChannelListMessage responseNetChannelListMessage) {
        if (responseNetChannelListMessage != null) {
            if (this.eKN == null) {
                this.eKN = new e();
            }
            e data = responseNetChannelListMessage.getData();
            if (data != null) {
                this.eKN.getItems().addAll(data.getItems());
                this.eKN.setHasMore(data.hasMore());
                this.mHasMore = data.hasMore();
            }
        }
    }

    public void aJu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SUBSCRIBE_CHANNEL_LIST, TbConfig.SERVER_ADDRESS + "c/f/video/getUserChannelList");
        tbHttpMessageTask.setResponsedClass(ResponseNetChannelListMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.httpListener);
    }

    public void removeListener() {
        MessageManager.getInstance().unRegisterListener(this.httpListener);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        bbr();
        return false;
    }

    private void bbr() {
        HttpMessage bi;
        LinkedList<HttpMessage> findHttpMessage = MessageManager.getInstance().findHttpMessage(getUniqueId());
        if (findHttpMessage == null || findHttpMessage.size() == 0) {
            if (!this.duA) {
                bi = bi(1, 8);
                this.eKN = null;
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

    public void iN(boolean z) {
        this.duA = z;
    }

    public void a(a aVar) {
        this.eKM = aVar;
    }
}
