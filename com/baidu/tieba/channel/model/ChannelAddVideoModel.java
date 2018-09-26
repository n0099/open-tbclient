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
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import com.baidu.tieba.channel.message.ChannelAddVideoResponseMessage;
import com.baidu.tieba.channel.message.ResponseNetUserVideoListMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ChannelAddVideoModel extends BdBaseModel<ChannelAddVideoActivity> {
    public HttpMessageListener addVideoListener;
    private boolean bCK;
    private boolean bEO;
    private a cJd;
    private b cKN;
    private com.baidu.tieba.channel.data.a cKO;
    public HttpMessageListener getUserVideoListener;
    private boolean mHasMore;
    private int mPageNum;

    /* loaded from: classes3.dex */
    public interface a {
        void M(int i, String str);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, String str, boolean z, com.baidu.tieba.channel.data.a aVar);
    }

    public ChannelAddVideoModel(e<ChannelAddVideoActivity> eVar) {
        super(eVar);
        this.bEO = true;
        this.bCK = false;
        this.getUserVideoListener = new HttpMessageListener(CmdConfigHttp.CMD_GET_USER_VIDEO_LIST) { // from class: com.baidu.tieba.channel.model.ChannelAddVideoModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponseNetUserVideoListMessage)) {
                    if (httpResponsedMessage.getError() == 0) {
                        ChannelAddVideoModel.this.a((ResponseNetUserVideoListMessage) httpResponsedMessage);
                    }
                    if (ChannelAddVideoModel.this.cKN != null) {
                        ChannelAddVideoModel.this.cKN.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ChannelAddVideoModel.this.bEO, ChannelAddVideoModel.this.cKO);
                    }
                    ChannelAddVideoModel.this.bEO = false;
                }
            }
        };
        this.addVideoListener = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_ADD_VIDEOS) { // from class: com.baidu.tieba.channel.model.ChannelAddVideoModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelAddVideoResponseMessage) && ChannelAddVideoModel.this.cJd != null) {
                    ChannelAddVideoModel.this.cJd.M(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponseNetUserVideoListMessage responseNetUserVideoListMessage) {
        if (responseNetUserVideoListMessage != null) {
            if (this.cKO == null) {
                this.cKO = new com.baidu.tieba.channel.data.a();
            }
            com.baidu.tieba.channel.data.a data = responseNetUserVideoListMessage.getData();
            if (data != null) {
                this.cKO.getItems().addAll(data.getItems());
                this.cKO.setHasMore(data.hasMore());
                this.mHasMore = data.hasMore();
            }
        }
    }

    public void Vb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_USER_VIDEO_LIST, TbConfig.SERVER_ADDRESS + "c/f/video/getUserVideoList");
        tbHttpMessageTask.setResponsedClass(ResponseNetUserVideoListMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.getUserVideoListener);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANNEL_ADD_VIDEOS, TbConfig.SERVER_ADDRESS + "c/c/video/addVideos");
        tbHttpMessageTask2.setResponsedClass(ChannelAddVideoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        tbHttpMessageTask2.setIsNeedTbs(true);
        registerListener(this.addVideoListener);
    }

    public void removeListener() {
        MessageManager.getInstance().unRegisterListener(this.getUserVideoListener);
        MessageManager.getInstance().unRegisterListener(this.addVideoListener);
    }

    public void alG() {
        LinkedList<HttpMessage> findHttpMessage = MessageManager.getInstance().findHttpMessage(getUniqueId());
        if (findHttpMessage == null || findHttpMessage.size() == 0) {
            if (!this.bCK) {
                this.mPageNum = 1;
                this.cKO = null;
            } else {
                this.mPageNum++;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_USER_VIDEO_LIST);
            httpMessage.addParam(Config.PACKAGE_NAME, this.mPageNum);
            httpMessage.addParam("ps", 20);
            sendMessage(httpMessage);
        }
    }

    public void a(long j, List<Long> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(String.valueOf(list.get(i)));
            stringBuffer.append(",");
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANNEL_ADD_VIDEOS);
        httpMessage.addParam("channel_id", j);
        httpMessage.addParam("thread_ids", stringBuffer.toString());
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void eV(boolean z) {
        this.bCK = z;
    }

    public void a(b bVar) {
        this.cKN = bVar;
    }

    public void a(a aVar) {
        this.cJd = aVar;
    }
}
