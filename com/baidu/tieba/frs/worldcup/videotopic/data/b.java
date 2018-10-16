package com.baidu.tieba.frs.worldcup.videotopic.data;

import android.os.Bundle;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b<T> implements a {
    public static final Integer ebR = 1;
    public static final Integer ebS = 2;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a ebL;
    private VideoTopicNetModelImpl ebT;
    private VideoTopicRequestData ebU;
    private Integer ebh;
    private h ebn;
    private String mForumId;
    private TbPageContext mPageContext;
    private ArrayList<h> mThreadList;
    private Integer mPn = 1;
    private boolean hasMore = false;
    private NetModel.b ebr = new NetModel.b() { // from class: com.baidu.tieba.frs.worldcup.videotopic.data.b.1
        @Override // com.baidu.tbadk.mvc.model.NetModel.c
        public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
            d.a f = b.this.f(mvcHttpResponsedMessage);
            if (f.isSuccess && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage instanceof VideoTopicHttpResponseMessage) && mvcNetMessage != null && mvcNetMessage.getRequestData() != null && (mvcNetMessage.getRequestData() instanceof VideoTopicRequestData)) {
                b.this.a((c) ((VideoTopicHttpResponseMessage) mvcHttpResponsedMessage).getData(), ((VideoTopicRequestData) mvcNetMessage.getRequestData()).getRequestType());
            }
            b.this.a(f, b.this.mThreadList);
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.d
        public void a(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
            d.a f = b.this.f(mvcSocketResponsedMessage);
            if (f.isSuccess && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage instanceof VideoTopicSocketResponseMessage) && mvcNetMessage != null && mvcNetMessage.getRequestData() != null && (mvcNetMessage.getRequestData() instanceof VideoTopicRequestData)) {
                b.this.a(((VideoTopicSocketResponseMessage) mvcSocketResponsedMessage).getData(), ((VideoTopicRequestData) mvcNetMessage.getRequestData()).getRequestType());
            }
            b.this.a(f, b.this.mThreadList);
        }
    };

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.videotopic.c.a aVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.ebL = aVar;
        if (bundle != null) {
            this.ebh = Integer.valueOf(bundle.getInt(IntentConfig.TOPIC_ID, 0));
            this.mForumId = bundle.getString("forum_id");
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
        this.ebU = new VideoTopicRequestData();
        Integer valueOf = Integer.valueOf(l.aO(TbadkCoreApplication.getInst()));
        Integer valueOf2 = Integer.valueOf(l.aQ(TbadkCoreApplication.getInst()));
        Float valueOf3 = Float.valueOf(l.aR(TbadkCoreApplication.getInst()));
        Integer valueOf4 = Integer.valueOf(aq.CG().CI() ? 2 : 1);
        this.ebU.setScrW(valueOf);
        this.ebU.setScrH(valueOf2);
        this.ebU.os(Float.toString(valueOf3.floatValue()));
        this.ebU.ot(Integer.toString(valueOf4.intValue()));
        this.ebU.l(this.ebh);
        this.ebU.setRn(10);
        this.ebT = new VideoTopicNetModelImpl(this.mPageContext, this.ebU);
        this.ebT.a(this.ebr);
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void refresh() {
        if (!this.ebT.DU()) {
            this.ebU.bX(1L);
            this.ebU.m(ebR);
            this.ebT.Nj();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void YK() {
        if (!this.ebT.DU() && hasMore()) {
            this.ebU.bX(this.mPn.intValue());
            this.ebU.m(ebS);
            this.ebT.Nj();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, ArrayList<h> arrayList) {
        if (this.ebL != null) {
            this.ebL.a(aVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public String getForumId() {
        return this.mForumId;
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void onDestroy() {
        if (this.ebT != null) {
            this.ebT.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.a f(ResponsedMessage responsedMessage) {
        d.a aVar = new d.a();
        if (responsedMessage != null) {
            aVar.gZz = j.kX() && (responsedMessage.getError() < -13 || responsedMessage.getError() > -10);
            aVar.isSuccess = responsedMessage.hasError() ? false : true;
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
            b(cVar);
            b(cVar, i);
        }
    }

    private void b(c cVar, int i) {
        if (cVar != null) {
            ArrayList<h> a = a(cVar);
            if (!v.J(a)) {
                this.mThreadList.remove(this.ebn);
                if (i == ebR.intValue()) {
                    this.mThreadList.clear();
                    this.mThreadList.addAll(0, a);
                } else if (i == ebS.intValue()) {
                    this.mThreadList.addAll(a);
                }
            }
        }
    }

    private ArrayList<h> a(c cVar) {
        ArrayList<h> arrayList = new ArrayList<>();
        List<h> aHz = cVar.aHz();
        if (aHz == null) {
            return arrayList;
        }
        Iterator<h> it = aHz.iterator();
        while (it.hasNext()) {
            bb bbVar = (bb) it.next();
            if (bbVar != null) {
                arrayList.add(bbVar);
            }
        }
        return arrayList;
    }

    private void b(c cVar) {
        if (cVar != null) {
            this.hasMore = cVar.aHA().intValue() == 1;
        }
    }

    private void c(c cVar) {
        this.mPn = Integer.valueOf(this.mPn.intValue() + 1);
    }
}
