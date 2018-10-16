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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
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
    private com.baidu.tieba.frs.worldcup.talkball.c.a eaG;
    private h ebn;
    private TalkBallNetModelImpl ebo;
    private TalkBallRequestData ebp;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ArrayList<h> mThreadList;
    private long ebq = 0;
    private int mPn = 1;
    private boolean hasMore = false;
    private NetModel.b ebr = new NetModel.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.model.b.1
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
        this.eaG = aVar;
        if (bundle != null) {
            this.mForumName = bundle.getString(ImageViewerConfig.FORUM_NAME, "");
            this.mForumId = bundle.getString(ImageViewerConfig.FORUM_ID, "");
        }
        aHq();
        fd();
    }

    private void aHq() {
        this.mThreadList = new ArrayList<>();
        this.ebn = new m();
        this.mThreadList.add(this.ebn);
    }

    private void fd() {
        this.ebp = new TalkBallRequestData();
        int aO = l.aO(TbadkCoreApplication.getInst());
        int aQ = l.aQ(TbadkCoreApplication.getInst());
        float aR = l.aR(TbadkCoreApplication.getInst());
        int i = aq.CG().CI() ? 2 : 1;
        this.ebp.h(Integer.valueOf(aO));
        this.ebp.i(Integer.valueOf(aQ));
        this.ebp.a(Double.valueOf(aR));
        this.ebp.j(Integer.valueOf(i));
        this.ebp.dU(this.mForumName);
        this.ebp.setRn(10);
        this.ebo = new TalkBallNetModelImpl(this.mPageContext, this.ebp);
        this.ebo.a(this.ebr);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void refresh() {
        if (!this.ebo.DU()) {
            this.mPn = 1;
            this.ebq = 0L;
            this.ebp.e(Long.valueOf(this.ebq));
            this.ebp.k(Integer.valueOf(this.mPn));
            this.ebp.nk(1);
            this.ebo.Nj();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void YK() {
        if (!this.ebo.DU() && hasMore()) {
            this.ebp.e(Long.valueOf(this.ebq));
            TalkBallRequestData talkBallRequestData = this.ebp;
            int i = this.mPn;
            this.mPn = i + 1;
            talkBallRequestData.k(Integer.valueOf(i));
            this.ebp.nk(2);
            this.ebo.Nj();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, ArrayList<h> arrayList, c cVar) {
        if (this.eaG != null) {
            this.eaG.a(aVar, arrayList, cVar);
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
            aVar.gZz = j.kX() && (responsedMessage.getError() < -13 || responsedMessage.getError() > -10);
            aVar.isSuccess = responsedMessage.getError() == 0;
            aVar.errorCode = responsedMessage.getError();
            aVar.errorMsg = responsedMessage.getErrorString();
            aVar.gZA = responsedMessage.getDownSize();
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
            if (!v.J(a)) {
                this.mThreadList.remove(this.ebn);
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
            if (bVar.aHd()) {
                arrayList.add(bVar.aHc());
            } else {
                bb YA = bVar.YA();
                if (YA != null) {
                    arrayList.add(YA);
                }
            }
        }
        return arrayList;
    }

    private void b(c cVar) {
        if (cVar != null) {
            this.hasMore = cVar.auK() == 1;
        }
    }

    private void c(c cVar) {
        if (cVar != null) {
            this.ebq = cVar.aHs();
        }
    }

    private void d(c cVar) {
        this.mPn++;
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void onDestroy() {
        if (this.ebo != null) {
            this.ebo.cancelLoadData();
        }
    }
}
