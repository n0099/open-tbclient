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
    private ChosenPostActivity aCV;
    private com.baidu.tieba.chosen.posts.request.b aCW;
    private com.baidu.tieba.chosen.posts.request.a aCX;
    private com.baidu.tbadk.mvc.e.b aCY;
    private com.baidu.tieba.chosen.posts.request.c aCZ;
    private com.baidu.tbadk.mvc.model.d<com.baidu.tieba.chosen.posts.request.d> aDa;
    private com.baidu.adp.framework.listener.a aDb;

    private void GO() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(307007);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(UnlikeSocketReponse.class);
        socketMessageTask.j(false);
        MessageManager.getInstance().registerTask(socketMessageTask);
    }

    private void GP() {
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
        AM().dispatchMvcEvent(bVar);
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity);
        this.aCY = new com.baidu.tbadk.mvc.e.b();
        this.aDa = new c(this);
        this.aDb = new d(this, CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, 307007);
        this.aCV = chosenPostActivity;
        GP();
        GO();
        registerListener(this.aDb);
        AM().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.d, com.baidu.tbadk.mvc.d.e, com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar.Bs() == 4100) {
            this.aCW.BM();
        } else if (bVar.Bs() == 4101) {
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
        this.aCX.BE();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(com.baidu.tieba.chosen.posts.request.c cVar, com.baidu.tieba.chosen.posts.request.d dVar) {
        b(dVar);
        if (dVar != null) {
            this.aCY.bc(false);
            this.aCY.bd(false);
            a(this.aCY);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.aCZ = new com.baidu.tieba.chosen.posts.request.c();
        this.aCW = new com.baidu.tieba.chosen.posts.request.b(this.aCV.getPageContext(), this.aCZ);
        this.aCW.a((q) this);
        this.aCX = new com.baidu.tieba.chosen.posts.request.a(this.aCV.getPageContext());
        this.aCX.a(this.aDa);
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean bb(boolean z) {
        this.aCY.bc(true);
        a(this.aCY);
        by(true);
        this.aCZ.GS();
        this.aCW.BM();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean BB() {
        this.aCZ.GS();
        this.aCW.BM();
        this.aCY.bd(true);
        this.aCY.bf(true);
        by(false);
        a(this.aCY);
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
        AM().dispatchMvcEvent(bVar);
    }
}
