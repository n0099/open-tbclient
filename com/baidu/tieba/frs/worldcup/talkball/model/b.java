package com.baidu.tieba.frs.worldcup.talkball.model;

import android.os.Bundle;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements a {
    private h dFX;
    private TalkBallNetModelImpl dFY;
    private TalkBallRequestData dFZ;
    private com.baidu.tieba.frs.worldcup.talkball.c.a dFq;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ArrayList<h> mThreadList;
    private long dGa = 0;
    private int mPn = 1;
    private boolean hasMore = false;
    private NetModel.b dGb = new NetModel.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.model.b.1
        @Override // com.baidu.tbadk.mvc.model.NetModel.c
        public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
            d.a f = b.this.f(mvcHttpResponsedMessage);
            c cVar = null;
            if (f.isSuccess && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage instanceof TalkBallHttpResponseMessage) && mvcNetMessage != null && mvcNetMessage.getRequestData() != null && (mvcNetMessage.getRequestData() instanceof TalkBallRequestData)) {
                cVar = (c) ((TalkBallHttpResponseMessage) mvcHttpResponsedMessage).getData();
                b.this.a(cVar, ((TalkBallRequestData) mvcNetMessage.getRequestData()).getRequestType());
            }
            b.this.a(f, b.this.mThreadList, cVar);
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.d
        public void a(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
            d.a f = b.this.f(mvcSocketResponsedMessage);
            c cVar = null;
            if (f.isSuccess && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage instanceof TalkBallSocketResponseMessage) && mvcNetMessage != null && mvcNetMessage.getRequestData() != null && (mvcNetMessage.getRequestData() instanceof TalkBallRequestData)) {
                cVar = ((TalkBallSocketResponseMessage) mvcSocketResponsedMessage).getData();
                b.this.a(cVar, ((TalkBallRequestData) mvcNetMessage.getRequestData()).getRequestType());
            }
            b.this.a(f, b.this.mThreadList, cVar);
        }
    };

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.talkball.c.a aVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.dFq = aVar;
        if (bundle != null) {
            this.mForumName = bundle.getString(ImageViewerConfig.FORUM_NAME, "");
            this.mForumId = bundle.getString(ImageViewerConfig.FORUM_ID, "");
        }
        aAy();
        dG();
    }

    private void aAy() {
        this.mThreadList = new ArrayList<>();
        this.dFX = new k();
        this.mThreadList.add(this.dFX);
    }

    private void dG() {
        this.dFZ = new TalkBallRequestData();
        int ah = l.ah(TbadkCoreApplication.getInst());
        int aj = l.aj(TbadkCoreApplication.getInst());
        float ak = l.ak(TbadkCoreApplication.getInst());
        int i = aq.zq().zs() ? 2 : 1;
        this.dFZ.h(Integer.valueOf(ah));
        this.dFZ.i(Integer.valueOf(aj));
        this.dFZ.a(Double.valueOf(ak));
        this.dFZ.j(Integer.valueOf(i));
        this.dFZ.dm(this.mForumName);
        this.dFZ.setRn(10);
        this.dFY = new TalkBallNetModelImpl(this.mPageContext, this.dFZ);
        this.dFY.a(this.dGb);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void refresh() {
        if (!this.dFY.Ax()) {
            this.mPn = 1;
            this.dGa = 0L;
            this.dFZ.e(Long.valueOf(this.dGa));
            this.dFZ.k(Integer.valueOf(this.mPn));
            this.dFZ.lP(1);
            this.dFY.JE();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void SJ() {
        if (!this.dFY.Ax() && hasMore()) {
            this.dFZ.e(Long.valueOf(this.dGa));
            TalkBallRequestData talkBallRequestData = this.dFZ;
            int i = this.mPn;
            this.mPn = i + 1;
            talkBallRequestData.k(Integer.valueOf(i));
            this.dFZ.lP(2);
            this.dFY.JE();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, ArrayList<h> arrayList, c cVar) {
        if (this.dFq != null) {
            this.dFq.a(aVar, arrayList, cVar);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public String getForumName() {
        return this.mForumName;
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public String getForumId() {
        return this.mForumId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.a f(ResponsedMessage responsedMessage) {
        d.a aVar = new d.a();
        if (responsedMessage != null) {
            aVar.gFM = j.jD() && (responsedMessage.getError() < -13 || responsedMessage.getError() > -10);
            aVar.isSuccess = responsedMessage.getError() == 0;
            aVar.errorCode = responsedMessage.getError();
            aVar.errorMsg = responsedMessage.getErrorString();
            aVar.gFN = responsedMessage.getDownSize();
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, int i) {
        if (cVar != null) {
            c(cVar);
            d(cVar);
            b(cVar);
            b(cVar, i);
        }
    }

    private void b(c cVar, int i) {
        if (cVar != null) {
            ArrayList<h> a = a(cVar);
            if (!w.z(a)) {
                this.mThreadList.remove(this.dFX);
                if (i == 1) {
                    this.mThreadList.clear();
                    this.mThreadList.addAll(0, a);
                } else if (i == 2) {
                    this.mThreadList.addAll(a);
                }
            }
        }
    }

    private ArrayList<h> a(c cVar) {
        ArrayList<h> arrayList = new ArrayList<>();
        List<com.baidu.tieba.frs.worldcup.talkball.b.b> threadList = cVar.getThreadList();
        if (threadList == null) {
            return arrayList;
        }
        for (com.baidu.tieba.frs.worldcup.talkball.b.b bVar : threadList) {
            if (bVar.aAl()) {
                arrayList.add(bVar.aAk());
            } else {
                bd Sz = bVar.Sz();
                if (Sz != null) {
                    arrayList.add(Sz);
                }
            }
        }
        return arrayList;
    }

    private void b(c cVar) {
        if (cVar != null) {
            this.hasMore = cVar.apF() == 1;
        }
    }

    private void c(c cVar) {
        if (cVar != null) {
            this.dGa = cVar.aAA();
        }
    }

    private void d(c cVar) {
        this.mPn++;
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void onDestroy() {
        if (this.dFY != null) {
            this.dFY.cancelLoadData();
        }
    }
}
