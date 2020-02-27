package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bj;
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
/* loaded from: classes9.dex */
public class c implements NetModel.b {
    private d gvK;
    private FrsCommonTabRequestData gvN;
    private FrsCommonTabNetModel gvO;
    private FrsDynamicRequestData gvP;
    private FrsDynamicModel gvQ;
    private boolean gvR;
    private FrsCommonTabFragment gvs;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> gvS = new HashSet<>();
    private int mPn = 1;
    private long gvT = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.gvs = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.gvP = new FrsDynamicRequestData();
                this.gvP.forumId = i;
                this.gvP.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.gvP.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.gvP.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.gvQ = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.gvP);
                this.gvQ.a(this);
                this.gvQ.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.gvN = new FrsCommonTabRequestData();
            this.gvN.fid = i;
            this.gvN.tabId = i2;
            this.gvN.isDefaultNavTab = ti(i2) ? 1 : 0;
            this.gvO = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.gvN);
            this.gvO.a(this);
            this.gvO.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean ti(int i) {
        return (this.gvs == null || this.gvs.gvC == null || this.gvs.gvC.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void bGx() {
        this.gvR = true;
        if (!this.isDynamic) {
            if (!this.gvO.isLoading()) {
                this.mPn = 1;
                this.gvN.pn = this.mPn;
                if (this.gvT >= 0) {
                    this.gvN.lastThreadId = this.gvT;
                }
                this.gvO.loadData();
            }
        } else if (!this.gvQ.isLoading()) {
            if (ar.aGB().aGC()) {
                this.gvP.qType = 2;
            } else {
                this.gvP.qType = 1;
            }
            this.gvP.lastThreadId = 0L;
            this.gvQ.loadData();
        }
    }

    public void bcd() {
        this.gvR = false;
        if (!this.isDynamic) {
            if (!this.gvO.isLoading()) {
                this.mPn++;
                this.gvN.pn = this.mPn;
                this.gvN.lastThreadId = -1L;
                this.gvO.loadData();
            }
        } else if (!this.gvQ.isLoading()) {
            if (ar.aGB().aGC()) {
                this.gvP.qType = 2;
            } else {
                this.gvP.qType = 1;
            }
            this.gvQ.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.gvR) {
            this.gvK = dVar;
            this.gvS.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bj) {
                    String tid = ((bj) next).getTid();
                    if (!this.gvS.contains(tid)) {
                        this.gvS.add(tid);
                    }
                }
            }
        } else {
            this.gvK.hasMore = dVar.hasMore;
            this.gvK.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bj) {
                    String tid2 = ((bj) next2).getTid();
                    if (!this.gvS.contains(tid2)) {
                        ((bj) next2).cUa = this.gvs.isBrandForum;
                        this.gvK.threadList.add(next2);
                        this.gvS.add(tid2);
                    }
                }
            }
        }
        this.gvs.a(this.gvK);
        return true;
    }

    public void al(bj bjVar) {
        if (bjVar != null && this.gvK != null && this.gvK.threadList != null) {
            if (v.isEmpty(this.gvK.threadList)) {
                this.gvK.threadList.add(bjVar);
            } else {
                this.gvK.threadList.add(0, bjVar);
            }
            this.gvs.a(this.gvK);
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
                    if (!v.isEmpty(dVar2.threadList)) {
                        m mVar = (m) v.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bj) {
                            this.gvP.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gvs.a(errorData);
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
                    if (!v.isEmpty(dVar2.threadList)) {
                        m mVar = (m) v.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bj) {
                            this.gvP.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gvs.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.gvK == null || v.isEmpty(this.gvK.threadList)) ? false : true;
    }

    public void dw(long j) {
        this.gvT = j;
    }

    public boolean bGE() {
        return this.gvR;
    }
}
