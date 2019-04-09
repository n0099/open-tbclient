package com.baidu.tieba.channel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.channel.data.c;
import com.baidu.tieba.channel.message.ResponseChannelFansListMessage;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ChannelFansListModel extends BdBaseModel<ChannelFansActivity> {
    private boolean ddh;
    private boolean dfW;
    private long emN;
    private a eon;
    private c eoo;
    public HttpMessageListener httpListener;
    private boolean mHasMore;
    private int mPageNum;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, String str, boolean z, c cVar);
    }

    public ChannelFansListModel(e<ChannelFansActivity> eVar, long j) {
        super(eVar);
        this.ddh = true;
        this.dfW = false;
        this.httpListener = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_FANS_LIST) { // from class: com.baidu.tieba.channel.model.ChannelFansListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponseChannelFansListMessage)) {
                    if (httpResponsedMessage.getError() == 0) {
                        ChannelFansListModel.this.a((ResponseChannelFansListMessage) httpResponsedMessage);
                    }
                    if (ChannelFansListModel.this.eon != null) {
                        ChannelFansListModel.this.eon.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ChannelFansListModel.this.ddh, ChannelFansListModel.this.eoo);
                    }
                    ChannelFansListModel.this.ddh = false;
                }
            }
        };
        this.emN = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponseChannelFansListMessage responseChannelFansListMessage) {
        if (responseChannelFansListMessage != null) {
            if (this.eoo == null) {
                this.eoo = new c();
            }
            c data = responseChannelFansListMessage.getData();
            if (data != null) {
                this.eoo.getItems().addAll(data.getItems());
                this.eoo.setHasMore(data.hasMore());
                this.mHasMore = data.hasMore();
            }
        }
    }

    public void aAX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_CHANNEL_FANS_LIST, TbConfig.SERVER_ADDRESS + "c/f/video/getChannelFansList");
        tbHttpMessageTask.setResponsedClass(ResponseChannelFansListMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.httpListener);
    }

    public void removeListener() {
        MessageManager.getInstance().unRegisterListener(this.httpListener);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        aRA();
        return false;
    }

    private void aRA() {
        LinkedList<HttpMessage> findHttpMessage = MessageManager.getInstance().findHttpMessage(getUniqueId());
        if (findHttpMessage == null || findHttpMessage.size() == 0) {
            if (!this.dfW) {
                this.mPageNum = 1;
                this.eoo = null;
            } else {
                this.mPageNum++;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_FANS_LIST);
            httpMessage.addParam("channel_id", this.emN);
            httpMessage.addParam(Config.PACKAGE_NAME, this.mPageNum);
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

    public void hW(boolean z) {
        this.dfW = z;
    }

    public void a(a aVar) {
        this.eon = aVar;
    }
}
