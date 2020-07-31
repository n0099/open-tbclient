package com.baidu.tieba.im.forum.broadcast.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.im.forum.broadcast.a;
import com.baidu.tieba.im.forum.broadcast.data.BroadcastMajorHistoryRequestMessage;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorHistoryMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorResidueMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseSocketMajorHistoryMessage;
/* loaded from: classes20.dex */
public class ForumBroadCastMajorHistoryModel extends BdBaseModel {
    private boolean eZg;
    private final a iYg;
    private com.baidu.tieba.im.forum.broadcast.data.a iYh;
    private HttpMessageListener iYi;
    private boolean isLoading;
    private long lastId;
    private final String mForumId;
    private com.baidu.adp.framework.listener.a netMessageListener;

    public ForumBroadCastMajorHistoryModel(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.lastId = 0L;
        this.iYh = null;
        this.netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669) { // from class: com.baidu.tieba.im.forum.broadcast.model.ForumBroadCastMajorHistoryModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                ForumBroadCastMajorHistoryModel.this.isLoading = false;
                if (responsedMessage != null) {
                    com.baidu.tieba.im.forum.broadcast.data.a aVar2 = null;
                    if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                        aVar2 = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
                    } else if (responsedMessage instanceof ResponseSocketMajorHistoryMessage) {
                        aVar2 = ((ResponseSocketMajorHistoryMessage) responsedMessage).getData();
                    }
                    ForumBroadCastMajorHistoryModel.this.mErrorCode = responsedMessage.getError();
                    ForumBroadCastMajorHistoryModel.this.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(ForumBroadCastMajorHistoryModel.this.mErrorCode);
                    errorData.setError_msg(ForumBroadCastMajorHistoryModel.this.mErrorString);
                    if (ForumBroadCastMajorHistoryModel.this.iYg != null) {
                        if (ForumBroadCastMajorHistoryModel.this.mErrorCode != 0 || aVar2 == null) {
                            ForumBroadCastMajorHistoryModel.this.iYg.a(errorData);
                            return;
                        }
                        ForumBroadCastMajorHistoryModel.this.iYh = aVar2;
                        ForumBroadCastMajorHistoryModel.this.bST();
                    }
                }
            }
        };
        this.iYi = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE) { // from class: com.baidu.tieba.im.forum.broadcast.model.ForumBroadCastMajorHistoryModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    ForumBroadcastMajorResidueData forumBroadcastMajorResidueData = null;
                    if (httpResponsedMessage instanceof ResponseHttpMajorResidueMessage) {
                        forumBroadcastMajorResidueData = ((ResponseHttpMajorResidueMessage) httpResponsedMessage).getData();
                    }
                    if (ForumBroadCastMajorHistoryModel.this.iYg != null) {
                        ForumBroadCastMajorHistoryModel.this.iYg.a(forumBroadcastMajorResidueData);
                    }
                }
            }
        };
        com.baidu.tieba.tbadkCore.a.a.a(309669, ResponseSocketMajorHistoryMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309669, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, TbConfig.URL_FORUM_BROADCAST_HISTORY, ResponseHttpMajorHistoryMessage.class, true, false, true, false);
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE, "c/f/forum/getForumMangerRights", ResponseHttpMajorResidueMessage.class, true, true, true, true);
        registerListener(this.netMessageListener);
        registerListener(this.iYi);
        this.iYg = aVar;
        this.mForumId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bST() {
        if (this.iYh.ctG() != null && this.iYh.ctG().size() > 1) {
            this.lastId = this.iYh.ctG().get(this.iYh.ctG().size() - 1).ctM();
        }
        this.iYh.pM(this.eZg);
        this.iYg.a(this.iYh);
    }

    public void bwE() {
        if (!this.isLoading) {
            this.eZg = false;
            tV(2);
        }
    }

    public void refresh() {
        if (!this.isLoading) {
            this.eZg = true;
            tV(1);
        }
    }

    private void tV(int i) {
        BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
        broadcastMajorHistoryRequestMessage.queryType = 1;
        broadcastMajorHistoryRequestMessage.needCount = 15;
        try {
            broadcastMajorHistoryRequestMessage.forumId = Long.parseLong(this.mForumId);
        } catch (Exception e) {
            broadcastMajorHistoryRequestMessage.forumId = 0L;
        }
        if (i == 2) {
            broadcastMajorHistoryRequestMessage.lastId = this.lastId;
        } else if (i == 1) {
            broadcastMajorHistoryRequestMessage.lastId = 0L;
        } else {
            return;
        }
        this.isLoading = true;
        sendMessage(broadcastMajorHistoryRequestMessage);
    }

    public void ctS() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("forum_id", this.mForumId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean hasData() {
        return (this.iYh == null || x.isEmpty(this.iYh.ctG())) ? false : true;
    }

    public void onDestory() {
        this.iYh = null;
    }
}
