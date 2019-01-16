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
    private h emH;
    private TalkBallNetModelImpl emI;
    private TalkBallRequestData emJ;
    private com.baidu.tieba.frs.worldcup.talkball.c.a ema;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private ArrayList<h> mThreadList;
    private long emK = 0;
    private int mPn = 1;
    private boolean hasMore = false;
    private NetModel.b emL = new NetModel.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.model.b.1
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
        this.ema = aVar;
        if (bundle != null) {
            this.mForumName = bundle.getString(ImageViewerConfig.FORUM_NAME, "");
            this.mForumId = bundle.getString(ImageViewerConfig.FORUM_ID, "");
        }
        aJN();
        fc();
    }

    private void aJN() {
        this.mThreadList = new ArrayList<>();
        this.emH = new m();
        this.mThreadList.add(this.emH);
    }

    private void fc() {
        this.emJ = new TalkBallRequestData();
        int aO = l.aO(TbadkCoreApplication.getInst());
        int aQ = l.aQ(TbadkCoreApplication.getInst());
        float aR = l.aR(TbadkCoreApplication.getInst());
        int i = aq.Ee().Eg() ? 2 : 1;
        this.emJ.h(Integer.valueOf(aO));
        this.emJ.i(Integer.valueOf(aQ));
        this.emJ.a(Double.valueOf(aR));
        this.emJ.j(Integer.valueOf(i));
        this.emJ.ev(this.mForumName);
        this.emJ.setRn(10);
        this.emI = new TalkBallNetModelImpl(this.mPageContext, this.emJ);
        this.emI.a(this.emL);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void refresh() {
        if (!this.emI.Fv()) {
            this.mPn = 1;
            this.emK = 0L;
            this.emJ.f(Long.valueOf(this.emK));
            this.emJ.k(Integer.valueOf(this.mPn));
            this.emJ.og(1);
            this.emI.OP();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void aaA() {
        if (!this.emI.Fv() && hasMore()) {
            this.emJ.f(Long.valueOf(this.emK));
            TalkBallRequestData talkBallRequestData = this.emJ;
            int i = this.mPn;
            this.mPn = i + 1;
            talkBallRequestData.k(Integer.valueOf(i));
            this.emJ.og(2);
            this.emI.OP();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, ArrayList<h> arrayList, c cVar) {
        if (this.ema != null) {
            this.ema.a(aVar, arrayList, cVar);
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
            aVar.hmg = j.kV() && (responsedMessage.getError() < -13 || responsedMessage.getError() > -10);
            aVar.isSuccess = responsedMessage.getError() == 0;
            aVar.errorCode = responsedMessage.getError();
            aVar.errorMsg = responsedMessage.getErrorString();
            aVar.hmh = responsedMessage.getDownSize();
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
            if (!v.I(a)) {
                this.mThreadList.remove(this.emH);
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
            if (bVar.aJA()) {
                arrayList.add(bVar.aJz());
            } else {
                bb aaq = bVar.aaq();
                if (aaq != null) {
                    arrayList.add(aaq);
                }
            }
        }
        return arrayList;
    }

    private void b(c cVar) {
        if (cVar != null) {
            this.hasMore = cVar.axg() == 1;
        }
    }

    private void c(c cVar) {
        if (cVar != null) {
            this.emK = cVar.aJP();
        }
    }

    private void d(c cVar) {
        this.mPn++;
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.model.a
    public void onDestroy() {
        if (this.emI != null) {
            this.emI.cancelLoadData();
        }
    }
}
