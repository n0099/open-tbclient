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
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b<T> implements a {
    public static final Integer dMG = 1;
    public static final Integer dMH = 2;
    private Integer dLW;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a dMA;
    private VideoTopicNetModelImpl dMI;
    private VideoTopicRequestData dMJ;
    private h dMc;
    private String mForumId;
    private TbPageContext mPageContext;
    private ArrayList<h> mThreadList;
    private Integer mPn = 1;
    private boolean hasMore = false;
    private NetModel.b dMg = new NetModel.b() { // from class: com.baidu.tieba.frs.worldcup.videotopic.data.b.1
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
        this.dMA = aVar;
        if (bundle != null) {
            this.dLW = Integer.valueOf(bundle.getInt(IntentConfig.TOPIC_ID, 0));
            this.mForumId = bundle.getString("forum_id");
        }
        aBL();
        dE();
    }

    private void aBL() {
        this.mThreadList = new ArrayList<>();
        this.dMc = new m();
        this.mThreadList.add(this.dMc);
    }

    private void dE() {
        this.dMJ = new VideoTopicRequestData();
        Integer valueOf = Integer.valueOf(l.ah(TbadkCoreApplication.getInst()));
        Integer valueOf2 = Integer.valueOf(l.aj(TbadkCoreApplication.getInst()));
        Float valueOf3 = Float.valueOf(l.ak(TbadkCoreApplication.getInst()));
        Integer valueOf4 = Integer.valueOf(ar.zu().zw() ? 2 : 1);
        this.dMJ.setScrW(valueOf);
        this.dMJ.setScrH(valueOf2);
        this.dMJ.nj(Float.toString(valueOf3.floatValue()));
        this.dMJ.nk(Integer.toString(valueOf4.intValue()));
        this.dMJ.l(this.dLW);
        this.dMJ.setRn(10);
        this.dMI = new VideoTopicNetModelImpl(this.mPageContext, this.dMJ);
        this.dMI.a(this.dMg);
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void refresh() {
        if (!this.dMI.AB()) {
            this.dMJ.bM(1L);
            this.dMJ.m(dMG);
            this.dMI.JV();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void Tq() {
        if (!this.dMI.AB() && hasMore()) {
            this.dMJ.bM(this.mPn.intValue());
            this.dMJ.m(dMH);
            this.dMI.JV();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, ArrayList<h> arrayList) {
        if (this.dMA != null) {
            this.dMA.a(aVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public String getForumId() {
        return this.mForumId;
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void onDestroy() {
        if (this.dMI != null) {
            this.dMI.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.a f(ResponsedMessage responsedMessage) {
        d.a aVar = new d.a();
        if (responsedMessage != null) {
            aVar.gKD = j.jE() && (responsedMessage.getError() < -13 || responsedMessage.getError() > -10);
            aVar.isSuccess = responsedMessage.hasError() ? false : true;
            aVar.errorCode = responsedMessage.getError();
            aVar.errorMsg = responsedMessage.getErrorString();
            aVar.gKE = responsedMessage.getDownSize();
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
            if (!w.z(a)) {
                this.mThreadList.remove(this.dMc);
                if (i == dMG.intValue()) {
                    this.mThreadList.clear();
                    this.mThreadList.addAll(0, a);
                } else if (i == dMH.intValue()) {
                    this.mThreadList.addAll(a);
                }
            }
        }
    }

    private ArrayList<h> a(c cVar) {
        ArrayList<h> arrayList = new ArrayList<>();
        List<h> aBU = cVar.aBU();
        if (aBU == null) {
            return arrayList;
        }
        Iterator<h> it = aBU.iterator();
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
            this.hasMore = cVar.aBV().intValue() == 1;
        }
    }

    private void c(c cVar) {
        this.mPn = Integer.valueOf(this.mPn.intValue() + 1);
    }
}
