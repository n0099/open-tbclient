package com.baidu.tieba.homepage.personalize.model;

import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.h;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.n.k;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeSocketResponse;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class RecPersonalizePageModel extends BdBaseModel<BaseFragmentActivity> {
    private com.baidu.adp.framework.listener.a eBn;
    private boolean eUy;
    private int eUz;
    private a kdC;

    /* loaded from: classes2.dex */
    public interface a {
        void a(DataRes dataRes, boolean z, boolean z2);

        void aF(int i, String str);
    }

    public RecPersonalizePageModel(f<BaseFragmentActivity> fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        this.eUy = false;
        this.eUz = 1;
        this.eBn = new com.baidu.adp.framework.listener.a(1003070, CmdConfigSocket.CMD_RECOMMEND_PERSONALIZED) { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.1
            /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
            @Override // com.baidu.adp.framework.listener.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMessage(final ResponsedMessage<?> responsedMessage) {
                boolean z;
                final boolean z2;
                if (responsedMessage != null && RecPersonalizePageModel.this.kdC != null) {
                    if (responsedMessage.getOrginalMessage() != null) {
                        Object extra = responsedMessage.getOrginalMessage().getExtra();
                        if (extra instanceof RecPersonalizeRequest) {
                            RecPersonalizeRequest recPersonalizeRequest = (RecPersonalizeRequest) extra;
                            boolean z3 = recPersonalizeRequest.getLoadType() == 1;
                            z = recPersonalizeRequest.getNeedForumlist() == 1;
                            z2 = z3;
                            if (responsedMessage.getError() == 0) {
                                if (TbSingleton.getInstance().needUploadMoreLog()) {
                                    com.baidu.tbadk.core.d.a.a("homePage", -1L, responsedMessage.getCmd(), "rec_personalized_error", responsedMessage.getError(), responsedMessage.getErrorString(), new Object[0]);
                                }
                                RecPersonalizePageModel.this.kdC.aF(responsedMessage.getError(), responsedMessage.getErrorString());
                            } else {
                                DataRes dataRes = null;
                                if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                                    dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                                } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                                    dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                                }
                                RecPersonalizePageModel.this.kdC.a(dataRes, z2, z);
                            }
                            if (!(responsedMessage instanceof RecPersonalizeSocketResponse)) {
                                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.1.1
                                    @Override // android.os.MessageQueue.IdleHandler
                                    public boolean queueIdle() {
                                        RecPersonalizePageModel.this.a(responsedMessage, z2);
                                        return false;
                                    }
                                });
                                return;
                            } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.1.2
                                    @Override // android.os.MessageQueue.IdleHandler
                                    public boolean queueIdle() {
                                        RecPersonalizePageModel.this.b(responsedMessage, z2);
                                        return false;
                                    }
                                });
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    z = false;
                    z2 = false;
                    if (responsedMessage.getError() == 0) {
                    }
                    if (!(responsedMessage instanceof RecPersonalizeSocketResponse)) {
                    }
                }
            }
        };
        setUniqueId(bdUniqueId);
        bqN();
        bqM();
        registerListener(this.eBn);
    }

    public void a(a aVar) {
        this.kdC = aVar;
    }

    public void f(int i, int i2, int i3, int i4, int i5) {
        RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
        recPersonalizeRequest.setLoadType(i);
        recPersonalizeRequest.setThreadCount(i2);
        recPersonalizeRequest.setPreAdThreadCount(i3);
        recPersonalizeRequest.setTag(getUniqueId());
        recPersonalizeRequest.setPn(i4);
        recPersonalizeRequest.setSuggestCount(i5);
        recPersonalizeRequest.setNeedForumlist(0);
        int i6 = this.eUz;
        this.eUz = i6 + 1;
        recPersonalizeRequest.setRequestTime(i6);
        recPersonalizeRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
        recPersonalizeRequest.setSwitchToHttpStrategy(new NetMessage.a() { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.2
            @Override // com.baidu.adp.framework.message.NetMessage.a
            public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    if (socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005 || socketResponsedMessage.getError() == h.QUEUE_SEND_ERROR_CLEAR) {
                        if (TbSingleton.getInstance().needUploadMoreLog()) {
                            com.baidu.tbadk.core.d.a.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
        });
        sendMessage(recPersonalizeRequest);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
        int i = this.eUz;
        this.eUz = i + 1;
        recPersonalizeRequest.setRequestTime(i);
        recPersonalizeRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
        recPersonalizeRequest.setSwitchToHttpStrategy(new NetMessage.a() { // from class: com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.3
            @Override // com.baidu.adp.framework.message.NetMessage.a
            public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    if (socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005 || socketResponsedMessage.getError() == h.QUEUE_SEND_ERROR_CLEAR) {
                        if (TbSingleton.getInstance().needUploadMoreLog()) {
                            com.baidu.tbadk.core.d.a.a("homePage", -1L, socketResponsedMessage.getCmd(), "rec_personalized_transform", socketResponsedMessage.getError(), "transform socket to http", new Object[0]);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
        });
        sendMessage(recPersonalizeRequest);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    private void bqM() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_RECOMMEND_PERSONALIZED);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void bqN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003070, com.baidu.tieba.tbadkCore.a.a.bU(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, CmdConfigSocket.CMD_RECOMMEND_PERSONALIZED));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        if (!this.eUy) {
            this.eUy = true;
            a(1, false, responsedMessage);
        }
        a(z, false, responsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ResponsedMessage<?> responsedMessage, boolean z) {
        if (!this.eUy) {
            this.eUy = true;
            a(1, true, responsedMessage);
        }
        a(z, true, responsedMessage);
    }

    public void a(boolean z, boolean z2, ResponsedMessage<?> responsedMessage) {
        if (k.bDO().isSmallFlow()) {
            long Bl = com.baidu.tieba.homepage.framework.a.cNr().Bl(1);
            long createTime = com.baidu.tieba.homepage.framework.a.cNr().getCreateTime();
            com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d(1005, z2, responsedMessage, 0L, createTime, com.baidu.tieba.homepage.framework.a.cNr().Bk(1), false, Bl + createTime);
            dVar.pageType = 1;
            if (z) {
                dVar.fHt = Bl;
                dVar.lj(false);
                return;
            }
            dVar.fHs = Bl;
            dVar.lj(true);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (k.bDO().isSmallFlow() && com.baidu.tieba.homepage.framework.a.cNr().getCreateTime() > 0) {
            long Bl = com.baidu.tieba.homepage.framework.a.cNr().Bl(1);
            long createTime = com.baidu.tieba.homepage.framework.a.cNr().getCreateTime();
            long Bk = com.baidu.tieba.homepage.framework.a.cNr().Bk(1);
            long j = Bl + createTime;
            long Bj = com.baidu.tieba.homepage.framework.a.cNr().Bj(1);
            if (Bj > 0) {
                j = System.currentTimeMillis() - Bj;
            }
            com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d(1005, z, responsedMessage, 0L, createTime, Bk, false, j);
            if (dVar != null) {
                dVar.pageType = i;
                dVar.bDL();
            }
            com.baidu.tieba.homepage.framework.a.cNr().setCreateTime(0L);
        }
    }
}
