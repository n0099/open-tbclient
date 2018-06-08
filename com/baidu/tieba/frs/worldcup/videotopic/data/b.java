package com.baidu.tieba.frs.worldcup.videotopic.data;

import android.os.Bundle;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class b<T> implements a {
    public static final Integer dGB = 1;
    public static final Integer dGC = 2;
    private Integer dFR;
    private h dFX;
    private VideoTopicNetModelImpl dGD;
    private VideoTopicRequestData dGE;
    private com.baidu.tieba.frs.worldcup.videotopic.b.a dGv;
    private String mForumId;
    private TbPageContext mPageContext;
    private ArrayList<h> mThreadList;
    private Integer mPn = 1;
    private boolean hasMore = false;
    private NetModel.b dGb = new NetModel.b() { // from class: com.baidu.tieba.frs.worldcup.videotopic.data.b.1
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

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.videotopic.b.a aVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.dGv = aVar;
        if (bundle != null) {
            this.dFR = Integer.valueOf(bundle.getInt(IntentConfig.TOPIC_ID, 0));
            this.mForumId = bundle.getString("forum_id");
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
        this.dGE = new VideoTopicRequestData();
        Integer valueOf = Integer.valueOf(l.ah(TbadkCoreApplication.getInst()));
        Integer valueOf2 = Integer.valueOf(l.aj(TbadkCoreApplication.getInst()));
        Float valueOf3 = Float.valueOf(l.ak(TbadkCoreApplication.getInst()));
        Integer valueOf4 = Integer.valueOf(aq.zq().zs() ? 2 : 1);
        this.dGE.setScrW(valueOf);
        this.dGE.setScrH(valueOf2);
        this.dGE.nh(Float.toString(valueOf3.floatValue()));
        this.dGE.ni(Integer.toString(valueOf4.intValue()));
        this.dGE.l(this.dFR);
        this.dGE.setRn(10);
        this.dGD = new VideoTopicNetModelImpl(this.mPageContext, this.dGE);
        this.dGD.a(this.dGb);
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void refresh() {
        if (!this.dGD.Ax()) {
            this.dGE.bL(1L);
            this.dGE.m(dGB);
            this.dGD.JE();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void SJ() {
        if (!this.dGD.Ax() && hasMore()) {
            this.dGE.bL(this.mPn.intValue());
            this.dGE.m(dGC);
            this.dGD.JE();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public boolean hasMore() {
        return this.hasMore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, ArrayList<h> arrayList) {
        if (this.dGv != null) {
            this.dGv.a(aVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public String getForumId() {
        return this.mForumId;
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.data.a
    public void onDestroy() {
        if (this.dGD != null) {
            this.dGD.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d.a f(ResponsedMessage responsedMessage) {
        d.a aVar = new d.a();
        if (responsedMessage != null) {
            aVar.gFM = j.jD() && (responsedMessage.getError() < -13 || responsedMessage.getError() > -10);
            aVar.isSuccess = responsedMessage.hasError() ? false : true;
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
            b(cVar);
            b(cVar, i);
        }
    }

    private void b(c cVar, int i) {
        if (cVar != null) {
            ArrayList<h> a = a(cVar);
            if (!w.z(a)) {
                this.mThreadList.remove(this.dFX);
                if (i == dGB.intValue()) {
                    this.mThreadList.clear();
                    this.mThreadList.addAll(0, a);
                } else if (i == dGC.intValue()) {
                    this.mThreadList.addAll(a);
                }
            }
        }
    }

    private ArrayList<h> a(c cVar) {
        ArrayList<h> arrayList = new ArrayList<>();
        List<h> aAH = cVar.aAH();
        if (aAH == null) {
            return arrayList;
        }
        Iterator<h> it = aAH.iterator();
        while (it.hasNext()) {
            bd bdVar = (bd) it.next();
            if (bdVar != null) {
                arrayList.add(bdVar);
            }
        }
        return arrayList;
    }

    private void b(c cVar) {
        if (cVar != null) {
            this.hasMore = cVar.aAI().intValue() == 1;
        }
    }

    private void c(c cVar) {
        this.mPn = Integer.valueOf(this.mPn.intValue() + 1);
    }
}
