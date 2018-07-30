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
    public static final Integer dMK = 1;
    public static final Integer dML = 2;
    private com.baidu.tieba.frs.worldcup.videotopic.c.a dME;
    private VideoTopicNetModelImpl dMM;
    private VideoTopicRequestData dMN;
    private Integer dMa;
    private h dMg;
    private String mForumId;
    private TbPageContext mPageContext;
    private ArrayList<h> mThreadList;
    private Integer mPn = 1;
    private boolean hasMore = false;
    private NetModel.b dMk = new NetModel.b() { // from class: com.baidu.tieba.frs.worldcup.videotopic.data.b.1
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
        this.dME = aVar;
        if (bundle != null) {
            this.dMa = Integer.valueOf(bundle.getInt(IntentConfig.TOPIC_ID, 0));
            this.mForumId = bundle.getString("forum_id");
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
        this.dMN = new VideoTopicRequestData();
        Integer valueOf = Integer.valueOf(l.ah(TbadkCoreApplication.getInst()));
        Integer valueOf2 = Integer.valueOf(l.aj(TbadkCoreApplication.getInst()));
        Float valueOf3 = Float.valueOf(l.ak(TbadkCoreApplication.getInst()));
        Integer valueOf4 = Integer.valueOf(ar.zw().zy() ? 2 : 1);
        this.dMN.setScrW(valueOf);
        this.dMN.setScrH(valueOf2);
        this.dMN.nh(Float.toString(valueOf3.floatValue()));
        this.dMN.ni(Integer.toString(valueOf4.intValue()));
        this.dMN.l(this.dMa);
        this.dMN.setRn(10);
        this.dMM = new VideoTopicNetModelImpl(this.mPageContext, this.dMN);
        this.dMM.a(this.dMk);
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void refresh() {
        if (!this.dMM.AE()) {
            this.dMN.bM(1L);
            this.dMN.m(dMK);
            this.dMM.JR();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void Tn() {
        if (!this.dMM.AE() && hasMore()) {
            this.dMN.bM(this.mPn.intValue());
            this.dMN.m(dML);
            this.dMM.JR();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, ArrayList<h> arrayList) {
        if (this.dME != null) {
            this.dME.a(aVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public String getForumId() {
        return this.mForumId;
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void onDestroy() {
        if (this.dMM != null) {
            this.dMM.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.a f(ResponsedMessage responsedMessage) {
        d.a aVar = new d.a();
        if (responsedMessage != null) {
            aVar.gKB = j.jE() && (responsedMessage.getError() < -13 || responsedMessage.getError() > -10);
            aVar.isSuccess = responsedMessage.hasError() ? false : true;
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
            b(cVar);
            b(cVar, i);
        }
    }

    private void b(c cVar, int i) {
        if (cVar != null) {
            ArrayList<h> a = a(cVar);
            if (!w.z(a)) {
                this.mThreadList.remove(this.dMg);
                if (i == dMK.intValue()) {
                    this.mThreadList.clear();
                    this.mThreadList.addAll(0, a);
                } else if (i == dML.intValue()) {
                    this.mThreadList.addAll(a);
                }
            }
        }
    }

    private ArrayList<h> a(c cVar) {
        ArrayList<h> arrayList = new ArrayList<>();
        List<h> aBX = cVar.aBX();
        if (aBX == null) {
            return arrayList;
        }
        Iterator<h> it = aBX.iterator();
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
            this.hasMore = cVar.aBY().intValue() == 1;
        }
    }

    private void c(c cVar) {
        this.mPn = Integer.valueOf(this.mPn.intValue() + 1);
    }
}
