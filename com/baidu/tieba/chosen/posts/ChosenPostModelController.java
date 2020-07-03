package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.chosen.posts.request.ChosenPostCacheModel;
import com.baidu.tieba.chosen.posts.request.ChosenPostModel;
import com.baidu.tieba.chosen.unlike.UnlikeHttpResponse;
import com.baidu.tieba.chosen.unlike.UnlikeRequest;
import com.baidu.tieba.chosen.unlike.UnlikeSocketReponse;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes10.dex */
public class ChosenPostModelController extends BdBaseModel<ChosenPostActivity> implements NetModel.b<com.baidu.tieba.chosen.posts.request.a, com.baidu.tieba.chosen.posts.request.b> {
    private ChosenPostActivity gVR;
    private ChosenPostModel gVS;
    private ChosenPostCacheModel gVT;
    private com.baidu.tbadk.mvc.d.a gVU;
    private com.baidu.tieba.chosen.posts.request.a gVV;
    private CacheModel.a<com.baidu.tieba.chosen.posts.request.b> gVW;
    private com.baidu.adp.framework.listener.a gVX;

    private void aVf() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(CmdConfigSocket.CMD_HOT_THREAD_UNLIKE);
        socketMessageTask.setNeedAck(true);
        socketMessageTask.setResponsedClass(UnlikeSocketReponse.class);
        socketMessageTask.setNeedCompress(false);
        MessageManager.getInstance().registerTask(socketMessageTask);
    }

    private void aVg() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003017, com.baidu.tieba.tbadkCore.a.a.bE(TbConfig.HOT_THREAD_UNLIKE, CmdConfigSocket.CMD_HOT_THREAD_UNLIKE));
        tbHttpMessageTask.setResponsedClass(UnlikeHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dY(long j) {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4102, null, null, null);
        bVar.setExtra(Long.valueOf(j));
        bVar.setUniqueId(getUniqueId());
        this.gVR.bhs().dispatchMvcEvent(bVar);
    }

    public ChosenPostModelController(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.gVU = new com.baidu.tbadk.mvc.d.a();
        this.gVW = new CacheModel.a<com.baidu.tieba.chosen.posts.request.b>() { // from class: com.baidu.tieba.chosen.posts.ChosenPostModelController.1
            @Override // com.baidu.tbadk.mvc.model.CacheModel.a
            public void a(ReadCacheRespMsg<List<com.baidu.tieba.chosen.posts.request.b>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.chosen.posts.request.b> readCacheMessage) {
                com.baidu.tieba.chosen.posts.request.b bVar;
                List<com.baidu.tieba.chosen.posts.request.b> data = readCacheRespMsg.getData();
                if (data != null && !data.isEmpty() && (bVar = data.get(0)) != null) {
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(4099, bVar, null, null);
                    bVar2.setUniqueId(ChosenPostModelController.this.getUniqueId());
                    ChosenPostModelController.this.gVR.bhs().dispatchMvcEvent(bVar2);
                }
                ChosenPostModelController.this.gVV.bPo();
                ChosenPostModelController.this.gVS.loadData();
            }

            @Override // com.baidu.tbadk.mvc.model.CacheModel.a
            public void a(WriteCacheRespMsg<List<com.baidu.tieba.chosen.posts.request.b>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.chosen.posts.request.b> writeCacheMessage) {
            }
        };
        this.gVX = new com.baidu.adp.framework.listener.a(1003017, CmdConfigSocket.CMD_HOT_THREAD_UNLIKE) { // from class: com.baidu.tieba.chosen.posts.ChosenPostModelController.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if (responsedMessage.getError() != 0) {
                        BdToast.a(ChosenPostModelController.this.gVR.getActivity(), responsedMessage.getErrorString(), 0).aUR().aUS();
                    } else if (responsedMessage instanceof UnlikeHttpResponse) {
                        ChosenPostModelController.this.dY(((UnlikeHttpResponse) responsedMessage).getThreadId());
                    } else if (responsedMessage instanceof UnlikeSocketReponse) {
                        ChosenPostModelController.this.dY(((UnlikeSocketReponse) responsedMessage).getThreadId());
                    }
                }
            }
        };
        this.gVR = chosenPostActivity;
        aVg();
        aVf();
        registerListener(this.gVX);
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar.bgX() == 4100) {
            this.gVS.loadData();
            return false;
        } else if (bVar.bgX() == 4101) {
            Object extra = bVar.getExtra();
            if (extra instanceof tinfo) {
                tinfo tinfoVar = (tinfo) extra;
                UnlikeRequest unlikeRequest = new UnlikeRequest();
                unlikeRequest.setThreadId(tinfoVar.thread_id.longValue());
                unlikeRequest.setType(tinfoVar.type.intValue());
                sendMessage(unlikeRequest);
                return false;
            }
            return false;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bPj() {
        this.gVT.bhc();
        return true;
    }

    protected boolean a(com.baidu.tieba.chosen.posts.request.a aVar, com.baidu.tieba.chosen.posts.request.b bVar) {
        this.gVR.bPi().a(bVar);
        if (bVar != null) {
            this.gVU.is(false);
            this.gVU.it(false);
            this.gVR.bPi().c(this.gVU);
            return true;
        }
        return true;
    }

    public void aj(Bundle bundle) {
        this.gVV = new com.baidu.tieba.chosen.posts.request.a();
        this.gVS = new ChosenPostModel(this.gVR.getPageContext(), this.gVV);
        this.gVS.a(this);
        this.gVT = new ChosenPostCacheModel(this.gVR.getPageContext());
        this.gVT.a(this.gVW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean mh(boolean z) {
        this.gVU.is(true);
        this.gVR.bPi().c(this.gVU);
        mi(true);
        this.gVV.bPo();
        this.gVS.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bPk() {
        this.gVV.bPo();
        this.gVS.loadData();
        this.gVU.it(true);
        this.gVU.iv(true);
        mi(false);
        this.gVR.bPi().c(this.gVU);
        return true;
    }

    private void mi(boolean z) {
        com.baidu.tbadk.mvc.c.b bVar;
        if (z) {
            bVar = new com.baidu.tbadk.mvc.c.b(4097, null, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(4098, null, null, null);
        }
        bVar.setUniqueId(getUniqueId());
        this.gVR.bhs().dispatchMvcEvent(bVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.chosen.posts.request.b> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.chosen.posts.request.a, com.baidu.tieba.chosen.posts.request.b> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.chosen.posts.request.a, com.baidu.tieba.chosen.posts.request.b> mvcNetMessage) {
        com.baidu.tieba.chosen.posts.request.b bVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            bVar = null;
        } else {
            bVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        }
        if (r1 == null || bVar == null || !a(r1, bVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.gVR.a(errorData);
            this.gVR.bPi().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.chosen.posts.request.b, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.chosen.posts.request.a, com.baidu.tieba.chosen.posts.request.b> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.chosen.posts.request.a, com.baidu.tieba.chosen.posts.request.b> mvcNetMessage) {
        com.baidu.tieba.chosen.posts.request.b bVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            bVar = null;
        } else {
            bVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        }
        if (r1 == null || bVar == null || !a(r1, bVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.gVR.a(errorData);
            this.gVR.bPi().a(errorData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
