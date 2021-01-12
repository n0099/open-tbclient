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
/* loaded from: classes7.dex */
public class ChosenPostModelController extends BdBaseModel<ChosenPostActivity> implements NetModel.b<com.baidu.tieba.chosen.posts.request.a, com.baidu.tieba.chosen.posts.request.b> {
    private ChosenPostActivity iwm;
    private ChosenPostModel iwn;
    private ChosenPostCacheModel iwo;
    private com.baidu.tbadk.mvc.d.a iwp;
    private com.baidu.tieba.chosen.posts.request.a iwq;
    private CacheModel.a<com.baidu.tieba.chosen.posts.request.b> iwr;
    private com.baidu.adp.framework.listener.a iws;

    private void bqM() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(CmdConfigSocket.CMD_HOT_THREAD_UNLIKE);
        socketMessageTask.setNeedAck(true);
        socketMessageTask.setResponsedClass(UnlikeSocketReponse.class);
        socketMessageTask.setNeedCompress(false);
        MessageManager.getInstance().registerTask(socketMessageTask);
    }

    private void bqN() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003017, com.baidu.tieba.tbadkCore.a.a.bU(TbConfig.HOT_THREAD_UNLIKE, CmdConfigSocket.CMD_HOT_THREAD_UNLIKE));
        tbHttpMessageTask.setResponsedClass(UnlikeHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(long j) {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4102, null, null, null);
        bVar.setExtra(Long.valueOf(j));
        bVar.setUniqueId(getUniqueId());
        this.iwm.bDq().dispatchMvcEvent(bVar);
    }

    public ChosenPostModelController(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.iwp = new com.baidu.tbadk.mvc.d.a();
        this.iwr = new CacheModel.a<com.baidu.tieba.chosen.posts.request.b>() { // from class: com.baidu.tieba.chosen.posts.ChosenPostModelController.1
            @Override // com.baidu.tbadk.mvc.model.CacheModel.a
            public void onCacheDataGet(ReadCacheRespMsg<List<com.baidu.tieba.chosen.posts.request.b>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.chosen.posts.request.b> readCacheMessage) {
                com.baidu.tieba.chosen.posts.request.b bVar;
                List<com.baidu.tieba.chosen.posts.request.b> data = readCacheRespMsg.getData();
                if (data != null && !data.isEmpty() && (bVar = data.get(0)) != null) {
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(4099, bVar, null, null);
                    bVar2.setUniqueId(ChosenPostModelController.this.getUniqueId());
                    ChosenPostModelController.this.iwm.bDq().dispatchMvcEvent(bVar2);
                }
                ChosenPostModelController.this.iwq.crX();
                ChosenPostModelController.this.iwn.loadData();
            }

            @Override // com.baidu.tbadk.mvc.model.CacheModel.a
            public void onCacheDataWrite(WriteCacheRespMsg<List<com.baidu.tieba.chosen.posts.request.b>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.chosen.posts.request.b> writeCacheMessage) {
            }
        };
        this.iws = new com.baidu.adp.framework.listener.a(1003017, CmdConfigSocket.CMD_HOT_THREAD_UNLIKE) { // from class: com.baidu.tieba.chosen.posts.ChosenPostModelController.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if (responsedMessage.getError() != 0) {
                        BdToast.b(ChosenPostModelController.this.iwm.getActivity(), responsedMessage.getErrorString(), 0).bqj().bqk();
                    } else if (responsedMessage instanceof UnlikeHttpResponse) {
                        ChosenPostModelController.this.gb(((UnlikeHttpResponse) responsedMessage).getThreadId());
                    } else if (responsedMessage instanceof UnlikeSocketReponse) {
                        ChosenPostModelController.this.gb(((UnlikeSocketReponse) responsedMessage).getThreadId());
                    }
                }
            }
        };
        this.iwm = chosenPostActivity;
        bqN();
        bqM();
        registerListener(this.iws);
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar.bCV() == 4100) {
            this.iwn.loadData();
            return false;
        } else if (bVar.bCV() == 4101) {
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
    public boolean crS() {
        this.iwo.bDa();
        return true;
    }

    protected boolean a(com.baidu.tieba.chosen.posts.request.a aVar, com.baidu.tieba.chosen.posts.request.b bVar) {
        this.iwm.crR().a(bVar);
        if (bVar != null) {
            this.iwp.le(false);
            this.iwp.lf(false);
            this.iwm.crR().c(this.iwp);
            return true;
        }
        return true;
    }

    public void aj(Bundle bundle) {
        this.iwq = new com.baidu.tieba.chosen.posts.request.a();
        this.iwn = new ChosenPostModel(this.iwm.getPageContext(), this.iwq);
        this.iwn.a(this);
        this.iwo = new ChosenPostCacheModel(this.iwm.getPageContext());
        this.iwo.a(this.iwr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean pw(boolean z) {
        this.iwp.le(true);
        this.iwm.crR().c(this.iwp);
        px(true);
        this.iwq.crX();
        this.iwn.loadData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean crT() {
        this.iwq.crX();
        this.iwn.loadData();
        this.iwp.lf(true);
        this.iwp.lh(true);
        px(false);
        this.iwm.crR().c(this.iwp);
        return true;
    }

    private void px(boolean z) {
        com.baidu.tbadk.mvc.c.b bVar;
        if (z) {
            bVar = new com.baidu.tbadk.mvc.c.b(4097, null, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(4098, null, null, null);
        }
        bVar.setUniqueId(getUniqueId());
        this.iwm.bDq().dispatchMvcEvent(bVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.chosen.posts.request.b> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.chosen.posts.request.a, com.baidu.tieba.chosen.posts.request.b> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.chosen.posts.request.a, com.baidu.tieba.chosen.posts.request.b> mvcNetMessage) {
        com.baidu.tieba.chosen.posts.request.b bVar;
        com.baidu.tieba.chosen.posts.request.a aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            bVar = null;
            aVar = null;
        } else {
            bVar = mvcHttpResponsedMessage.getData();
            aVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
        }
        if (aVar == null || bVar == null || !a(aVar, bVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.iwm.a(errorData);
            this.iwm.crR().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.chosen.posts.request.b, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.chosen.posts.request.a, com.baidu.tieba.chosen.posts.request.b> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.chosen.posts.request.a, com.baidu.tieba.chosen.posts.request.b> mvcNetMessage) {
        com.baidu.tieba.chosen.posts.request.b bVar;
        com.baidu.tieba.chosen.posts.request.a aVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            bVar = null;
            aVar = null;
        } else {
            bVar = mvcSocketResponsedMessage.getData();
            aVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
        }
        if (aVar == null || bVar == null || !a(aVar, bVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.iwm.a(errorData);
            this.iwm.crR().a(errorData);
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
