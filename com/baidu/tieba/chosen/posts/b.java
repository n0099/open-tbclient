package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.mvc.model.a;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.chosen.unlike.UnlikeHttpResponse;
import com.baidu.tieba.chosen.unlike.UnlikeRequest;
import com.baidu.tieba.chosen.unlike.UnlikeSocketReponse;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e<ChosenPostActivity> implements NetModel.b<com.baidu.tieba.chosen.posts.request.c, com.baidu.tieba.chosen.posts.request.d> {
    private ChosenPostActivity aQT;
    private com.baidu.tieba.chosen.posts.request.b aQU;
    private com.baidu.tieba.chosen.posts.request.a aQV;
    private com.baidu.tbadk.mvc.d.a aQW;
    private com.baidu.tieba.chosen.posts.request.c aQX;
    private a.InterfaceC0054a<com.baidu.tieba.chosen.posts.request.d> aQY;
    private com.baidu.adp.framework.listener.a aQZ;

    private void IP() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(307007);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(UnlikeSocketReponse.class);
        socketMessageTask.j(false);
        MessageManager.getInstance().registerTask(socketMessageTask);
    }

    private void IQ() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, com.baidu.tieba.tbadkCore.a.a.ak(TbConfig.HOT_THREAD_UNLIKE, 307007));
        tbHttpMessageTask.setResponsedClass(UnlikeHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(long j) {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4102, null, null, null);
        bVar.setExtra(Long.valueOf(j));
        bVar.setUniqueId(getUniqueId());
        this.aQT.ok().dispatchMvcEvent(bVar);
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.aQW = new com.baidu.tbadk.mvc.d.a();
        this.aQY = new c(this);
        this.aQZ = new d(this, CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, 307007);
        this.aQT = chosenPostActivity;
        IQ();
        IP();
        registerListener(this.aQZ);
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar.Dj() == 4100) {
            this.aQU.Dy();
            return false;
        } else if (bVar.Dj() == 4101) {
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
    public boolean ow() {
        this.aQV.Do();
        return true;
    }

    protected boolean a(com.baidu.tieba.chosen.posts.request.c cVar, com.baidu.tieba.chosen.posts.request.d dVar) {
        this.aQT.IO().a(dVar);
        if (dVar != null) {
            this.aQW.bu(false);
            this.aQW.bv(false);
            this.aQT.IO().d(this.aQW);
            return true;
        }
        return true;
    }

    public void b(Bundle bundle) {
        this.aQX = new com.baidu.tieba.chosen.posts.request.c();
        this.aQU = new com.baidu.tieba.chosen.posts.request.b(this.aQT.getPageContext(), this.aQX);
        this.aQU.a(this);
        this.aQV = new com.baidu.tieba.chosen.posts.request.a(this.aQT.getPageContext());
        this.aQV.a(this.aQY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bP(boolean z) {
        this.aQW.bu(true);
        this.aQT.IO().d(this.aQW);
        bQ(true);
        this.aQX.IU();
        this.aQU.Dy();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean IR() {
        this.aQX.IU();
        this.aQU.Dy();
        this.aQW.bv(true);
        this.aQW.bx(true);
        bQ(false);
        this.aQT.IO().d(this.aQW);
        return true;
    }

    private void bQ(boolean z) {
        com.baidu.tbadk.mvc.c.b bVar;
        if (z) {
            bVar = new com.baidu.tbadk.mvc.c.b(4097, null, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(4098, null, null, null);
        }
        bVar.setUniqueId(getUniqueId());
        this.aQT.ok().dispatchMvcEvent(bVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.chosen.posts.request.d> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.chosen.posts.request.c, com.baidu.tieba.chosen.posts.request.d> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.chosen.posts.request.c, com.baidu.tieba.chosen.posts.request.d> mvcNetMessage) {
        com.baidu.tieba.chosen.posts.request.d dVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            dVar = null;
        } else {
            dVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        }
        if (r1 == null || dVar == null || !a(r1, dVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.aQT.a(errorData);
            this.aQT.IO().a(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.chosen.posts.request.d, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.chosen.posts.request.c, com.baidu.tieba.chosen.posts.request.d> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.chosen.posts.request.c, com.baidu.tieba.chosen.posts.request.d> mvcNetMessage) {
        com.baidu.tieba.chosen.posts.request.d dVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            dVar = null;
        } else {
            dVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        }
        if (r1 == null || dVar == null || !a(r1, dVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.aQT.a(errorData);
            this.aQT.IO().a(errorData);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
