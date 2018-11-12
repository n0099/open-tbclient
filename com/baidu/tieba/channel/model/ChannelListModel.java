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
/* loaded from: classes3.dex */
public class ChannelListModel extends BdBaseModel<ChannelListActivity> {
    private boolean bMa;
    private boolean bOc;
    private a cUt;
    private e cUu;
    public HttpMessageListener httpListener;
    private boolean mHasMore;
    private int mPageNum;
    private String mUserId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, e eVar);
    }

    public ChannelListModel(com.baidu.adp.base.e<ChannelListActivity> eVar, String str) {
        super(eVar);
        this.bOc = true;
        this.bMa = false;
        this.httpListener = new HttpMessageListener(CmdConfigHttp.CMD_GET_SUBSCRIBE_CHANNEL_LIST) { // from class: com.baidu.tieba.channel.model.ChannelListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseNetChannelListMessage) {
                    if (httpResponsedMessage.getError() == 0) {
                        ChannelListModel.this.a((ResponseNetChannelListMessage) httpResponsedMessage);
                    }
                    if (ChannelListModel.this.cUt != null) {
                        ChannelListModel.this.cUt.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ChannelListModel.this.bOc, ChannelListModel.this.cUu);
                    }
                    ChannelListModel.this.bOc = false;
                }
            }
        };
        this.mUserId = str;
    }

    public HttpMessage ax(int i, int i2) {
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
            if (this.cUu == null) {
                this.cUu = new e();
            }
            e data = responseNetChannelListMessage.getData();
            if (data != null) {
                this.cUu.getItems().addAll(data.getItems());
                this.cUu.setHasMore(data.hasMore());
                this.mHasMore = data.hasMore();
            }
        }
    }

    public void YT() {
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
        aoL();
        return false;
    }

    private void aoL() {
        HttpMessage ax;
        LinkedList<HttpMessage> findHttpMessage = MessageManager.getInstance().findHttpMessage(getUniqueId());
        if (findHttpMessage == null || findHttpMessage.size() == 0) {
            if (!this.bMa) {
                ax = ax(1, 8);
                this.cUu = null;
            } else {
                ax = ax(this.mPageNum + 1, 8);
            }
            sendMessage(ax);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void fy(boolean z) {
        this.bMa = z;
    }

    public void a(a aVar) {
        this.cUt = aVar;
    }
}
