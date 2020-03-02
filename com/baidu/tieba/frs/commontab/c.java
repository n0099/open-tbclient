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
    private d gvM;
    private FrsCommonTabRequestData gvP;
    private FrsCommonTabNetModel gvQ;
    private FrsDynamicRequestData gvR;
    private FrsDynamicModel gvS;
    private boolean gvT;
    private FrsCommonTabFragment gvu;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> gvU = new HashSet<>();
    private int mPn = 1;
    private long gvV = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.gvu = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.gvR = new FrsDynamicRequestData();
                this.gvR.forumId = i;
                this.gvR.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.gvR.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.gvR.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.gvS = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.gvR);
                this.gvS.a(this);
                this.gvS.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.gvP = new FrsCommonTabRequestData();
            this.gvP.fid = i;
            this.gvP.tabId = i2;
            this.gvP.isDefaultNavTab = ti(i2) ? 1 : 0;
            this.gvQ = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.gvP);
            this.gvQ.a(this);
            this.gvQ.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean ti(int i) {
        return (this.gvu == null || this.gvu.gvE == null || this.gvu.gvE.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void bGz() {
        this.gvT = true;
        if (!this.isDynamic) {
            if (!this.gvQ.isLoading()) {
                this.mPn = 1;
                this.gvP.pn = this.mPn;
                if (this.gvV >= 0) {
                    this.gvP.lastThreadId = this.gvV;
                }
                this.gvQ.loadData();
            }
        } else if (!this.gvS.isLoading()) {
            if (ar.aGD().aGE()) {
                this.gvR.qType = 2;
            } else {
                this.gvR.qType = 1;
            }
            this.gvR.lastThreadId = 0L;
            this.gvS.loadData();
        }
    }

    public void bcf() {
        this.gvT = false;
        if (!this.isDynamic) {
            if (!this.gvQ.isLoading()) {
                this.mPn++;
                this.gvP.pn = this.mPn;
                this.gvP.lastThreadId = -1L;
                this.gvQ.loadData();
            }
        } else if (!this.gvS.isLoading()) {
            if (ar.aGD().aGE()) {
                this.gvR.qType = 2;
            } else {
                this.gvR.qType = 1;
            }
            this.gvS.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.gvT) {
            this.gvM = dVar;
            this.gvU.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bj) {
                    String tid = ((bj) next).getTid();
                    if (!this.gvU.contains(tid)) {
                        this.gvU.add(tid);
                    }
                }
            }
        } else {
            this.gvM.hasMore = dVar.hasMore;
            this.gvM.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bj) {
                    String tid2 = ((bj) next2).getTid();
                    if (!this.gvU.contains(tid2)) {
                        ((bj) next2).cUb = this.gvu.isBrandForum;
                        this.gvM.threadList.add(next2);
                        this.gvU.add(tid2);
                    }
                }
            }
        }
        this.gvu.a(this.gvM);
        return true;
    }

    public void al(bj bjVar) {
        if (bjVar != null && this.gvM != null && this.gvM.threadList != null) {
            if (v.isEmpty(this.gvM.threadList)) {
                this.gvM.threadList.add(bjVar);
            } else {
                this.gvM.threadList.add(0, bjVar);
            }
            this.gvu.a(this.gvM);
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
                            this.gvR.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gvu.a(errorData);
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
                            this.gvR.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gvu.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.gvM == null || v.isEmpty(this.gvM.threadList)) ? false : true;
    }

    public void dw(long j) {
        this.gvV = j;
    }

    public boolean bGG() {
        return this.gvT;
    }
}
