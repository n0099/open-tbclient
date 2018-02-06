package com.baidu.tieba.channel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.channel.data.c;
import com.baidu.tieba.channel.message.ResponseChannelFansListMessage;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class ChannelFansListModel extends BdBaseModel<ChannelFansActivity> {
    private boolean ccH;
    private boolean clp;
    private long dbL;
    private a ddl;
    private c ddm;
    public HttpMessageListener httpListener;
    private boolean mHasMore;
    private int mPageNum;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, c cVar);
    }

    public ChannelFansListModel(e<ChannelFansActivity> eVar, long j) {
        super(eVar);
        this.clp = true;
        this.ccH = false;
        this.httpListener = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_FANS_LIST) { // from class: com.baidu.tieba.channel.model.ChannelFansListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponseChannelFansListMessage)) {
                    if (httpResponsedMessage.getError() == 0) {
                        ChannelFansListModel.this.a((ResponseChannelFansListMessage) httpResponsedMessage);
                    }
                    if (ChannelFansListModel.this.ddl != null) {
                        ChannelFansListModel.this.ddl.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ChannelFansListModel.this.clp, ChannelFansListModel.this.ddm);
                    }
                    ChannelFansListModel.this.clp = false;
                }
            }
        };
        this.dbL = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponseChannelFansListMessage responseChannelFansListMessage) {
        if (responseChannelFansListMessage != null) {
            if (this.ddm == null) {
                this.ddm = new c();
            }
            c data = responseChannelFansListMessage.getData();
            if (data != null) {
                this.ddm.getItems().addAll(data.getItems());
                this.ddm.setHasMore(data.hasMore());
                this.mHasMore = data.hasMore();
            }
        }
    }

    public void WM() {
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
        amt();
        return false;
    }

    private void amt() {
        LinkedList<HttpMessage> findHttpMessage = MessageManager.getInstance().findHttpMessage(getUniqueId());
        if (findHttpMessage == null || findHttpMessage.size() == 0) {
            if (!this.ccH) {
                this.mPageNum = 1;
                this.ddm = null;
            } else {
                this.mPageNum++;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_FANS_LIST);
            httpMessage.addParam("channel_id", this.dbL);
            httpMessage.addParam("pn", this.mPageNum);
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

    public void eT(boolean z) {
        this.ccH = z;
    }

    public void a(a aVar) {
        this.ddl = aVar;
    }
}
