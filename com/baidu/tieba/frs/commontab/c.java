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
    private FrsCommonTabFragment gvG;
    private d gvY;
    private FrsCommonTabRequestData gwb;
    private FrsCommonTabNetModel gwc;
    private FrsDynamicRequestData gwd;
    private FrsDynamicModel gwe;
    private boolean gwf;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> gwg = new HashSet<>();
    private int mPn = 1;
    private long gwh = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.gvG = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.gwd = new FrsDynamicRequestData();
                this.gwd.forumId = i;
                this.gwd.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.gwd.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.gwd.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.gwe = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.gwd);
                this.gwe.a(this);
                this.gwe.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.gwb = new FrsCommonTabRequestData();
            this.gwb.fid = i;
            this.gwb.tabId = i2;
            this.gwb.isDefaultNavTab = ti(i2) ? 1 : 0;
            this.gwc = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.gwb);
            this.gwc.a(this);
            this.gwc.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean ti(int i) {
        return (this.gvG == null || this.gvG.gvQ == null || this.gvG.gvQ.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void bGA() {
        this.gwf = true;
        if (!this.isDynamic) {
            if (!this.gwc.isLoading()) {
                this.mPn = 1;
                this.gwb.pn = this.mPn;
                if (this.gwh >= 0) {
                    this.gwb.lastThreadId = this.gwh;
                }
                this.gwc.loadData();
            }
        } else if (!this.gwe.isLoading()) {
            if (ar.aGD().aGE()) {
                this.gwd.qType = 2;
            } else {
                this.gwd.qType = 1;
            }
            this.gwd.lastThreadId = 0L;
            this.gwe.loadData();
        }
    }

    public void bcg() {
        this.gwf = false;
        if (!this.isDynamic) {
            if (!this.gwc.isLoading()) {
                this.mPn++;
                this.gwb.pn = this.mPn;
                this.gwb.lastThreadId = -1L;
                this.gwc.loadData();
            }
        } else if (!this.gwe.isLoading()) {
            if (ar.aGD().aGE()) {
                this.gwd.qType = 2;
            } else {
                this.gwd.qType = 1;
            }
            this.gwe.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.gwf) {
            this.gvY = dVar;
            this.gwg.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bj) {
                    String tid = ((bj) next).getTid();
                    if (!this.gwg.contains(tid)) {
                        this.gwg.add(tid);
                    }
                }
            }
        } else {
            this.gvY.hasMore = dVar.hasMore;
            this.gvY.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bj) {
                    String tid2 = ((bj) next2).getTid();
                    if (!this.gwg.contains(tid2)) {
                        ((bj) next2).cUc = this.gvG.isBrandForum;
                        this.gvY.threadList.add(next2);
                        this.gwg.add(tid2);
                    }
                }
            }
        }
        this.gvG.a(this.gvY);
        return true;
    }

    public void al(bj bjVar) {
        if (bjVar != null && this.gvY != null && this.gvY.threadList != null) {
            if (v.isEmpty(this.gvY.threadList)) {
                this.gvY.threadList.add(bjVar);
            } else {
                this.gvY.threadList.add(0, bjVar);
            }
            this.gvG.a(this.gvY);
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
                            this.gwd.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gvG.a(errorData);
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
                            this.gwd.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gvG.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.gvY == null || v.isEmpty(this.gvY.threadList)) ? false : true;
    }

    public void dw(long j) {
        this.gwh = j;
    }

    public boolean bGH() {
        return this.gwf;
    }
}
