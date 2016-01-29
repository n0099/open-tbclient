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
    private ChosenPostActivity aTa;
    private com.baidu.tieba.chosen.posts.request.b aTb;
    private com.baidu.tieba.chosen.posts.request.a aTc;
    private com.baidu.tbadk.mvc.d.a aTd;
    private com.baidu.tieba.chosen.posts.request.c aTe;
    private a.InterfaceC0055a<com.baidu.tieba.chosen.posts.request.d> aTf;
    private com.baidu.adp.framework.listener.a aTg;

    private void KH() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(307007);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(UnlikeSocketReponse.class);
        socketMessageTask.j(false);
        MessageManager.getInstance().registerTask(socketMessageTask);
    }

    private void KI() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, com.baidu.tieba.tbadkCore.a.a.am(TbConfig.HOT_THREAD_UNLIKE, 307007));
        tbHttpMessageTask.setResponsedClass(UnlikeHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(long j) {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4102, null, null, null);
        bVar.setExtra(Long.valueOf(j));
        bVar.setUniqueId(getUniqueId());
        this.aTa.oF().dispatchMvcEvent(bVar);
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.aTd = new com.baidu.tbadk.mvc.d.a();
        this.aTf = new c(this);
        this.aTg = new d(this, CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, 307007);
        this.aTa = chosenPostActivity;
        KI();
        KH();
        registerListener(this.aTg);
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar.EE() == 4100) {
            this.aTb.ET();
            return false;
        } else if (bVar.EE() == 4101) {
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
    public boolean oR() {
        this.aTc.EJ();
        return true;
    }

    protected boolean a(com.baidu.tieba.chosen.posts.request.c cVar, com.baidu.tieba.chosen.posts.request.d dVar) {
        this.aTa.KG().a(dVar);
        if (dVar != null) {
            this.aTd.bw(false);
            this.aTd.bx(false);
            this.aTa.KG().d(this.aTd);
            return true;
        }
        return true;
    }

    public void c(Bundle bundle) {
        this.aTe = new com.baidu.tieba.chosen.posts.request.c();
        this.aTb = new com.baidu.tieba.chosen.posts.request.b(this.aTa.getPageContext(), this.aTe);
        this.aTb.a(this);
        this.aTc = new com.baidu.tieba.chosen.posts.request.a(this.aTa.getPageContext());
        this.aTc.a(this.aTf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bU(boolean z) {
        this.aTd.bw(true);
        this.aTa.KG().d(this.aTd);
        bV(true);
        this.aTe.KN();
        this.aTb.ET();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean KJ() {
        this.aTe.KN();
        this.aTb.ET();
        this.aTd.bx(true);
        this.aTd.bz(true);
        bV(false);
        this.aTa.KG().d(this.aTd);
        return true;
    }

    private void bV(boolean z) {
        com.baidu.tbadk.mvc.c.b bVar;
        if (z) {
            bVar = new com.baidu.tbadk.mvc.c.b(4097, null, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(4098, null, null, null);
        }
        bVar.setUniqueId(getUniqueId());
        this.aTa.oF().dispatchMvcEvent(bVar);
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
            this.aTa.a(errorData);
            this.aTa.KG().a(errorData);
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
            this.aTa.a(errorData);
            this.aTa.KG().a(errorData);
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
