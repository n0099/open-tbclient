package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
/* loaded from: classes3.dex */
public class ChosenPostModelController extends BdBaseModel<ChosenPostActivity> implements NetModel.b<com.baidu.tieba.chosen.posts.request.a, com.baidu.tieba.chosen.posts.request.b> {
    private ChosenPostActivity cGh;
    private ChosenPostModel cGi;
    private ChosenPostCacheModel cGj;
    private com.baidu.tbadk.mvc.d.a cGk;
    private com.baidu.tieba.chosen.posts.request.a cGl;
    private CacheModel.a<com.baidu.tieba.chosen.posts.request.b> cGm;
    private com.baidu.adp.framework.listener.a cGn;

    private void akr() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(307007);
        socketMessageTask.p(true);
        socketMessageTask.setResponsedClass(UnlikeSocketReponse.class);
        socketMessageTask.q(false);
        MessageManager.getInstance().registerTask(socketMessageTask);
    }

    private void age() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, com.baidu.tieba.tbadkCore.a.a.aN(TbConfig.HOT_THREAD_UNLIKE, 307007));
        tbHttpMessageTask.setResponsedClass(UnlikeHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(long j) {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4102, null, null, null);
        bVar.setExtra(Long.valueOf(j));
        bVar.setUniqueId(getUniqueId());
        this.cGh.JT().dispatchMvcEvent(bVar);
    }

    public ChosenPostModelController(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.cGk = new com.baidu.tbadk.mvc.d.a();
        this.cGm = new CacheModel.a<com.baidu.tieba.chosen.posts.request.b>() { // from class: com.baidu.tieba.chosen.posts.ChosenPostModelController.1
            @Override // com.baidu.tbadk.mvc.model.CacheModel.a
            public void a(ReadCacheRespMsg<List<com.baidu.tieba.chosen.posts.request.b>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.chosen.posts.request.b> readCacheMessage) {
                com.baidu.tieba.chosen.posts.request.b bVar;
                List<com.baidu.tieba.chosen.posts.request.b> data = readCacheRespMsg.getData();
                if (data != null && !data.isEmpty() && (bVar = data.get(0)) != null) {
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(FragmentTransaction.TRANSIT_FRAGMENT_FADE, bVar, null, null);
                    bVar2.setUniqueId(ChosenPostModelController.this.getUniqueId());
                    ChosenPostModelController.this.cGh.JT().dispatchMvcEvent(bVar2);
                }
                ChosenPostModelController.this.cGl.akx();
                ChosenPostModelController.this.cGi.JE();
            }

            @Override // com.baidu.tbadk.mvc.model.CacheModel.a
            public void a(WriteCacheRespMsg<List<com.baidu.tieba.chosen.posts.request.b>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.chosen.posts.request.b> writeCacheMessage) {
            }
        };
        this.cGn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, 307007) { // from class: com.baidu.tieba.chosen.posts.ChosenPostModelController.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if (responsedMessage.getError() != 0) {
                        BdToast.a(ChosenPostModelController.this.cGh.getActivity(), responsedMessage.getErrorString(), 0).xg().xi();
                    } else if (responsedMessage instanceof UnlikeHttpResponse) {
                        ChosenPostModelController.this.bq(((UnlikeHttpResponse) responsedMessage).getThreadId());
                    } else if (responsedMessage instanceof UnlikeSocketReponse) {
                        ChosenPostModelController.this.bq(((UnlikeSocketReponse) responsedMessage).getThreadId());
                    }
                }
            }
        };
        this.cGh = chosenPostActivity;
        age();
        akr();
        registerListener(this.cGn);
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar.Jl() == 4100) {
            this.cGi.JE();
            return false;
        } else if (bVar.Jl() == 4101) {
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
    public boolean aks() {
        this.cGj.Jp();
        return true;
    }

    protected boolean a(com.baidu.tieba.chosen.posts.request.a aVar, com.baidu.tieba.chosen.posts.request.b bVar) {
        this.cGh.akq().a(bVar);
        if (bVar != null) {
            this.cGk.bP(false);
            this.cGk.bQ(false);
            this.cGh.akq().b(this.cGk);
            return true;
        }
        return true;
    }

    public void i(Bundle bundle) {
        this.cGl = new com.baidu.tieba.chosen.posts.request.a();
        this.cGi = new ChosenPostModel(this.cGh.getPageContext(), this.cGl);
        this.cGi.a(this);
        this.cGj = new ChosenPostCacheModel(this.cGh.getPageContext());
        this.cGj.a(this.cGm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean eI(boolean z) {
        this.cGk.bP(true);
        this.cGh.akq().b(this.cGk);
        eJ(true);
        this.cGl.akx();
        this.cGi.JE();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean akt() {
        this.cGl.akx();
        this.cGi.JE();
        this.cGk.bQ(true);
        this.cGk.bS(true);
        eJ(false);
        this.cGh.akq().b(this.cGk);
        return true;
    }

    private void eJ(boolean z) {
        com.baidu.tbadk.mvc.c.b bVar;
        if (z) {
            bVar = new com.baidu.tbadk.mvc.c.b(FragmentTransaction.TRANSIT_FRAGMENT_OPEN, null, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(InputDeviceCompat.SOURCE_TOUCHSCREEN, null, null, null);
        }
        bVar.setUniqueId(getUniqueId());
        this.cGh.JT().dispatchMvcEvent(bVar);
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
            this.cGh.a(errorData);
            this.cGh.akq().a(errorData);
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
            this.cGh.a(errorData);
            this.cGh.akq().a(errorData);
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
