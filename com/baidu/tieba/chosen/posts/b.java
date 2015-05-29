package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.model.q;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.chosen.unlike.UnlikeHttpResponse;
import com.baidu.tieba.chosen.unlike.UnlikeRequest;
import com.baidu.tieba.chosen.unlike.UnlikeSocketReponse;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.d.d<com.baidu.tieba.chosen.posts.request.c, com.baidu.tieba.chosen.posts.request.d> {
    private ChosenPostActivity aCU;
    private com.baidu.tieba.chosen.posts.request.b aCV;
    private com.baidu.tieba.chosen.posts.request.a aCW;
    private com.baidu.tbadk.mvc.e.b aCX;
    private com.baidu.tieba.chosen.posts.request.c aCY;
    private com.baidu.tbadk.mvc.model.d<com.baidu.tieba.chosen.posts.request.d> aCZ;
    private com.baidu.adp.framework.listener.a aDa;

    private void GN() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(307007);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(UnlikeSocketReponse.class);
        socketMessageTask.j(false);
        MessageManager.getInstance().registerTask(socketMessageTask);
    }

    private void GO() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, com.baidu.tieba.tbadkCore.a.a.S(TbConfig.HOT_THREAD_UNLIKE, 307007));
        tbHttpMessageTask.setResponsedClass(UnlikeHttpResponse.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(long j) {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4102, null, null, null);
        bVar.setExtra(Long.valueOf(j));
        bVar.setUniqueId(getUniqueId());
        AL().dispatchMvcEvent(bVar);
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity);
        this.aCX = new com.baidu.tbadk.mvc.e.b();
        this.aCZ = new c(this);
        this.aDa = new d(this, CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, 307007);
        this.aCU = chosenPostActivity;
        GO();
        GN();
        registerListener(this.aDa);
        AL().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.d, com.baidu.tbadk.mvc.d.e, com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar.Br() == 4100) {
            this.aCV.BL();
        } else if (bVar.Br() == 4101) {
            Object extra = bVar.getExtra();
            if (extra instanceof tinfo) {
                tinfo tinfoVar = (tinfo) extra;
                UnlikeRequest unlikeRequest = new UnlikeRequest();
                unlikeRequest.setThreadId(tinfoVar.thread_id.longValue());
                unlikeRequest.setType(tinfoVar.type.intValue());
                sendMessage(unlikeRequest);
            }
        }
        return super.a(bVar);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean oM() {
        this.aCW.BD();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(com.baidu.tieba.chosen.posts.request.c cVar, com.baidu.tieba.chosen.posts.request.d dVar) {
        b(dVar);
        if (dVar != null) {
            this.aCX.bc(false);
            this.aCX.bd(false);
            a(this.aCX);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.aCY = new com.baidu.tieba.chosen.posts.request.c();
        this.aCV = new com.baidu.tieba.chosen.posts.request.b(this.aCU.getPageContext(), this.aCY);
        this.aCV.a((q) this);
        this.aCW = new com.baidu.tieba.chosen.posts.request.a(this.aCU.getPageContext());
        this.aCW.a(this.aCZ);
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean bb(boolean z) {
        this.aCX.bc(true);
        a(this.aCX);
        by(true);
        this.aCY.GR();
        this.aCV.BL();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean BA() {
        this.aCY.GR();
        this.aCV.BL();
        this.aCX.bd(true);
        this.aCX.bf(true);
        by(false);
        a(this.aCX);
        return true;
    }

    private void by(boolean z) {
        com.baidu.tbadk.mvc.c.b bVar;
        if (z) {
            bVar = new com.baidu.tbadk.mvc.c.b(4097, null, null, null);
        } else {
            bVar = new com.baidu.tbadk.mvc.c.b(4098, null, null, null);
        }
        bVar.setUniqueId(getUniqueId());
        AL().dispatchMvcEvent(bVar);
    }
}
