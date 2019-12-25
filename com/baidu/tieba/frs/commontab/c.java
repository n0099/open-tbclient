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
/* loaded from: classes6.dex */
public class c implements NetModel.b {
    private d gqA;
    private FrsCommonTabRequestData gqD;
    private FrsCommonTabNetModel gqE;
    private FrsDynamicRequestData gqF;
    private FrsDynamicModel gqG;
    private boolean gqH;
    private FrsCommonTabFragment gqi;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> gqI = new HashSet<>();
    private int mPn = 1;
    private long gqJ = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.gqi = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.gqF = new FrsDynamicRequestData();
                this.gqF.forumId = i;
                this.gqF.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.gqF.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.gqF.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.gqG = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.gqF);
                this.gqG.a(this);
                this.gqG.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.gqD = new FrsCommonTabRequestData();
            this.gqD.fid = i;
            this.gqD.tabId = i2;
            this.gqD.isDefaultNavTab = sX(i2) ? 1 : 0;
            this.gqE = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.gqD);
            this.gqE.a(this);
            this.gqE.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean sX(int i) {
        return (this.gqi == null || this.gqi.gqs == null || this.gqi.gqs.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void bDT() {
        this.gqH = true;
        if (!this.isDynamic) {
            if (!this.gqE.isLoading()) {
                this.mPn = 1;
                this.gqD.pn = this.mPn;
                if (this.gqJ >= 0) {
                    this.gqD.lastThreadId = this.gqJ;
                }
                this.gqE.loadData();
            }
        } else if (!this.gqG.isLoading()) {
            if (ar.aDX().aDY()) {
                this.gqF.qType = 2;
            } else {
                this.gqF.qType = 1;
            }
            this.gqF.lastThreadId = 0L;
            this.gqG.loadData();
        }
    }

    public void aZs() {
        this.gqH = false;
        if (!this.isDynamic) {
            if (!this.gqE.isLoading()) {
                this.mPn++;
                this.gqD.pn = this.mPn;
                this.gqD.lastThreadId = -1L;
                this.gqE.loadData();
            }
        } else if (!this.gqG.isLoading()) {
            if (ar.aDX().aDY()) {
                this.gqF.qType = 2;
            } else {
                this.gqF.qType = 1;
            }
            this.gqG.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.gqH) {
            this.gqA = dVar;
            this.gqI.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bj) {
                    String tid = ((bj) next).getTid();
                    if (!this.gqI.contains(tid)) {
                        this.gqI.add(tid);
                    }
                }
            }
        } else {
            this.gqA.hasMore = dVar.hasMore;
            this.gqA.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bj) {
                    String tid2 = ((bj) next2).getTid();
                    if (!this.gqI.contains(tid2)) {
                        ((bj) next2).cPO = this.gqi.isBrandForum;
                        this.gqA.threadList.add(next2);
                        this.gqI.add(tid2);
                    }
                }
            }
        }
        this.gqi.a(this.gqA);
        return true;
    }

    public void aj(bj bjVar) {
        if (bjVar != null && this.gqA != null && this.gqA.threadList != null) {
            if (v.isEmpty(this.gqA.threadList)) {
                this.gqA.threadList.add(bjVar);
            } else {
                this.gqA.threadList.add(0, bjVar);
            }
            this.gqi.a(this.gqA);
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
                            this.gqF.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gqi.a(errorData);
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
                            this.gqF.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gqi.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.gqA == null || v.isEmpty(this.gqA.threadList)) ? false : true;
    }

    public void dr(long j) {
        this.gqJ = j;
    }

    public boolean bEa() {
        return this.gqH;
    }
}
