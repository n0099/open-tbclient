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
/* loaded from: classes7.dex */
public class c implements NetModel.b {
    private d gtJ;
    private FrsCommonTabRequestData gtM;
    private FrsCommonTabNetModel gtN;
    private FrsDynamicRequestData gtO;
    private FrsDynamicModel gtP;
    private boolean gtQ;
    private FrsCommonTabFragment gtr;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> gtR = new HashSet<>();
    private int mPn = 1;
    private long gtS = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.gtr = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.gtO = new FrsDynamicRequestData();
                this.gtO.forumId = i;
                this.gtO.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.gtO.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.gtO.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.gtP = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.gtO);
                this.gtP.a(this);
                this.gtP.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.gtM = new FrsCommonTabRequestData();
            this.gtM.fid = i;
            this.gtM.tabId = i2;
            this.gtM.isDefaultNavTab = tc(i2) ? 1 : 0;
            this.gtN = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.gtM);
            this.gtN.a(this);
            this.gtN.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean tc(int i) {
        return (this.gtr == null || this.gtr.gtB == null || this.gtr.gtB.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void bEV() {
        this.gtQ = true;
        if (!this.isDynamic) {
            if (!this.gtN.isLoading()) {
                this.mPn = 1;
                this.gtM.pn = this.mPn;
                if (this.gtS >= 0) {
                    this.gtM.lastThreadId = this.gtS;
                }
                this.gtN.loadData();
            }
        } else if (!this.gtP.isLoading()) {
            if (ar.aEq().aEr()) {
                this.gtO.qType = 2;
            } else {
                this.gtO.qType = 1;
            }
            this.gtO.lastThreadId = 0L;
            this.gtP.loadData();
        }
    }

    public void aZN() {
        this.gtQ = false;
        if (!this.isDynamic) {
            if (!this.gtN.isLoading()) {
                this.mPn++;
                this.gtM.pn = this.mPn;
                this.gtM.lastThreadId = -1L;
                this.gtN.loadData();
            }
        } else if (!this.gtP.isLoading()) {
            if (ar.aEq().aEr()) {
                this.gtO.qType = 2;
            } else {
                this.gtO.qType = 1;
            }
            this.gtP.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.gtQ) {
            this.gtJ = dVar;
            this.gtR.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bj) {
                    String tid = ((bj) next).getTid();
                    if (!this.gtR.contains(tid)) {
                        this.gtR.add(tid);
                    }
                }
            }
        } else {
            this.gtJ.hasMore = dVar.hasMore;
            this.gtJ.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bj) {
                    String tid2 = ((bj) next2).getTid();
                    if (!this.gtR.contains(tid2)) {
                        ((bj) next2).cPY = this.gtr.isBrandForum;
                        this.gtJ.threadList.add(next2);
                        this.gtR.add(tid2);
                    }
                }
            }
        }
        this.gtr.a(this.gtJ);
        return true;
    }

    public void ak(bj bjVar) {
        if (bjVar != null && this.gtJ != null && this.gtJ.threadList != null) {
            if (v.isEmpty(this.gtJ.threadList)) {
                this.gtJ.threadList.add(bjVar);
            } else {
                this.gtJ.threadList.add(0, bjVar);
            }
            this.gtr.a(this.gtJ);
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
                            this.gtO.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gtr.a(errorData);
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
                            this.gtO.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gtr.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.gtJ == null || v.isEmpty(this.gtJ.threadList)) ? false : true;
    }

    public void dw(long j) {
        this.gtS = j;
    }

    public boolean bFc() {
        return this.gtQ;
    }
}
