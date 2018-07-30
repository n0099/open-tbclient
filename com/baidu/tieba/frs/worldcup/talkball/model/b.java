package com.baidu.tieba.frs.worldcup.talkball.model;

import android.os.Bundle;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements a {
    private com.baidu.tieba.frs.worldcup.talkball.c.a dLy;
    private h dMg;
    private TalkBallNetModelImpl dMh;
    private TalkBallRequestData dMi;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ArrayList<h> mThreadList;
    private long dMj = 0;
    private int mPn = 1;
    private boolean hasMore = false;
    private NetModel.b dMk = new NetModel.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.model.b.1
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
        this.dLy = aVar;
        if (bundle != null) {
            this.mForumName = bundle.getString(ImageViewerConfig.FORUM_NAME, "");
            this.mForumId = bundle.getString(ImageViewerConfig.FORUM_ID, "");
        }
        aBO();
        dE();
    }

    private void aBO() {
        this.mThreadList = new ArrayList<>();
        this.dMg = new m();
        this.mThreadList.add(this.dMg);
    }

    private void dE() {
        this.dMi = new TalkBallRequestData();
        int ah = l.ah(TbadkCoreApplication.getInst());
        int aj = l.aj(TbadkCoreApplication.getInst());
        float ak = l.ak(TbadkCoreApplication.getInst());
        int i = ar.zw().zy() ? 2 : 1;
        this.dMi.h(Integer.valueOf(ah));
        this.dMi.i(Integer.valueOf(aj));
        this.dMi.a(Double.valueOf(ak));
        this.dMi.j(Integer.valueOf(i));
        this.dMi.dm(this.mForumName);
        this.dMi.setRn(10);
        this.dMh = new TalkBallNetModelImpl(this.mPageContext, this.dMi);
        this.dMh.a(this.dMk);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void refresh() {
        if (!this.dMh.AE()) {
            this.mPn = 1;
            this.dMj = 0L;
            this.dMi.d(Long.valueOf(this.dMj));
            this.dMi.k(Integer.valueOf(this.mPn));
            this.dMi.mi(1);
            this.dMh.JR();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void Tn() {
        if (!this.dMh.AE() && hasMore()) {
            this.dMi.d(Long.valueOf(this.dMj));
            TalkBallRequestData talkBallRequestData = this.dMi;
            int i = this.mPn;
            this.mPn = i + 1;
            talkBallRequestData.k(Integer.valueOf(i));
            this.dMi.mi(2);
            this.dMh.JR();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, ArrayList<h> arrayList, c cVar) {
        if (this.dLy != null) {
            this.dLy.a(aVar, arrayList, cVar);
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
            aVar.gKB = j.jE() && (responsedMessage.getError() < -13 || responsedMessage.getError() > -10);
            aVar.isSuccess = responsedMessage.getError() == 0;
            aVar.errorCode = responsedMessage.getError();
            aVar.errorMsg = responsedMessage.getErrorString();
            aVar.gKC = responsedMessage.getDownSize();
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
                this.mThreadList.remove(this.dMg);
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
            if (bVar.aBB()) {
                arrayList.add(bVar.aBA());
            } else {
                bb Td = bVar.Td();
                if (Td != null) {
                    arrayList.add(Td);
                }
            }
        }
        return arrayList;
    }

    private void b(c cVar) {
        if (cVar != null) {
            this.hasMore = cVar.apA() == 1;
        }
    }

    private void c(c cVar) {
        if (cVar != null) {
            this.dMj = cVar.aBQ();
        }
    }

    private void d(c cVar) {
        this.mPn++;
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void onDestroy() {
        if (this.dMh != null) {
            this.dMh.cancelLoadData();
        }
    }
}
