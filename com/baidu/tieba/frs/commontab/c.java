package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c implements NetModel.b {
    private boolean fDC;
    private d fDP;
    private FrsCommonTabRequestData fDS;
    private FrsCommonTabNetModel fDT;
    private FrsDynamicRequestData fDU;
    private FrsDynamicModel fDV;
    private boolean fDW;
    private FrsCommonTabFragment fDw;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> fDX = new HashSet<>();
    private int mPn = 1;
    private long fDY = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.fDw = frsCommonTabFragment;
            if (i2 == 89) {
                this.fDC = true;
                this.fDU = new FrsDynamicRequestData();
                this.fDU.forumId = i;
                this.fDU.scrH = l.ah(TbadkCoreApplication.getInst());
                this.fDU.scrW = l.af(TbadkCoreApplication.getInst());
                this.fDU.scrDip = l.ai(TbadkCoreApplication.getInst());
                this.fDV = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.fDU);
                this.fDV.a(this);
                this.fDV.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.fDC = false;
            this.fDS = new FrsCommonTabRequestData();
            this.fDS.fid = i;
            this.fDS.tabId = i2;
            this.fDS.isDefaultNavTab = rZ(i2) ? 1 : 0;
            this.fDT = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.fDS);
            this.fDT.a(this);
            this.fDT.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean rZ(int i) {
        return (this.fDw == null || this.fDw.fDH == null || this.fDw.fDH.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void bpv() {
        this.fDW = true;
        if (!this.fDC) {
            if (!this.fDT.pQ()) {
                this.mPn = 1;
                this.fDS.pn = this.mPn;
                if (this.fDY >= 0) {
                    this.fDS.lastThreadId = this.fDY;
                }
                this.fDT.auR();
            }
        } else if (!this.fDV.pQ()) {
            if (ar.ajw().ajy()) {
                this.fDU.qType = 2;
            } else {
                this.fDU.qType = 1;
            }
            this.fDU.lastThreadId = 0L;
            this.fDV.auR();
        }
    }

    public void aJw() {
        this.fDW = false;
        if (!this.fDC) {
            if (!this.fDT.pQ()) {
                this.mPn++;
                this.fDS.pn = this.mPn;
                this.fDS.lastThreadId = -1L;
                this.fDT.auR();
            }
        } else if (!this.fDV.pQ()) {
            if (ar.ajw().ajy()) {
                this.fDU.qType = 2;
            } else {
                this.fDU.qType = 1;
            }
            this.fDV.auR();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.fDW) {
            this.fDP = dVar;
            this.fDX.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bh) {
                    String tid = ((bh) next).getTid();
                    if (!this.fDX.contains(tid)) {
                        this.fDX.add(tid);
                    }
                }
            }
        } else {
            this.fDP.hasMore = dVar.hasMore;
            this.fDP.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bh) {
                    String tid2 = ((bh) next2).getTid();
                    if (!this.fDX.contains(tid2)) {
                        ((bh) next2).bME = this.fDw.isBrandForum;
                        this.fDP.threadList.add(next2);
                        this.fDX.add(tid2);
                    }
                }
            }
        }
        this.fDw.a(this.fDP);
        return true;
    }

    public void ae(bh bhVar) {
        if (bhVar != null && this.fDP != null && this.fDP.threadList != null) {
            if (v.aa(this.fDP.threadList)) {
                this.fDP.threadList.add(bhVar);
            } else {
                this.fDP.threadList.add(0, bhVar);
            }
            this.fDw.a(this.fDP);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcHttpResponsedMessage != null) {
            d dVar = null;
            if (!mvcHttpResponsedMessage.hasError()) {
                if (mvcHttpResponsedMessage.getData() instanceof d) {
                    dVar = (d) mvcHttpResponsedMessage.getData();
                } else if (mvcHttpResponsedMessage.getData() instanceof com.baidu.tieba.frs.dynamic.a) {
                    com.baidu.tieba.frs.dynamic.a aVar = (com.baidu.tieba.frs.dynamic.a) mvcHttpResponsedMessage.getData();
                    d dVar2 = new d();
                    dVar2.threadList = aVar.threadList;
                    dVar2.hasMore = aVar.hasMore;
                    dVar2.userMap = aVar.userMap;
                    if (!v.aa(dVar2.threadList)) {
                        m mVar = (m) v.c(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bh) {
                            this.fDU.lastThreadId = com.baidu.adp.lib.g.b.e(((bh) mVar).getId(), 0L);
                        }
                    }
                    dVar = dVar2;
                }
            }
            if (dVar == null || !b(dVar)) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                if (this.mErrorCode != 0) {
                    this.fDw.a(errorData);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            d dVar = null;
            if (!mvcSocketResponsedMessage.hasError()) {
                if (mvcSocketResponsedMessage.getData() instanceof d) {
                    dVar = (d) mvcSocketResponsedMessage.getData();
                } else if (mvcSocketResponsedMessage.getData() instanceof com.baidu.tieba.frs.dynamic.a) {
                    com.baidu.tieba.frs.dynamic.a aVar = (com.baidu.tieba.frs.dynamic.a) mvcSocketResponsedMessage.getData();
                    d dVar2 = new d();
                    dVar2.threadList = aVar.threadList;
                    dVar2.hasMore = aVar.hasMore;
                    dVar2.userMap = aVar.userMap;
                    if (!v.aa(dVar2.threadList)) {
                        m mVar = (m) v.c(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bh) {
                            this.fDU.lastThreadId = com.baidu.adp.lib.g.b.e(((bh) mVar).getId(), 0L);
                        }
                    }
                    dVar = dVar2;
                }
            }
            if (dVar == null || !b(dVar)) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                if (this.mErrorCode != 0) {
                    this.fDw.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.fDP == null || v.aa(this.fDP.threadList)) ? false : true;
    }

    public void dm(long j) {
        this.fDY = j;
    }

    public boolean bpA() {
        return this.fDW;
    }
}
