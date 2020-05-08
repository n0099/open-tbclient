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
import com.baidu.tieba.frs.p;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c implements NetModel.b {
    private FrsCommonTabFragment hfB;
    private d hfW;
    private FrsCommonTabRequestData hga;
    private FrsCommonTabNetModel hgb;
    private FrsDynamicRequestData hgc;
    private FrsDynamicModel hgd;
    private boolean hge;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> hgf = new HashSet<>();
    private int mPn = 1;
    private long hgg = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.hfB = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.hgc = new FrsDynamicRequestData();
                this.hgc.forumId = i;
                this.hgc.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.hgc.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.hgc.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.hgd = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.hgc);
                this.hgd.a(this);
                this.hgd.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.hga = new FrsCommonTabRequestData();
            this.hga.fid = i;
            this.hga.tabId = i2;
            this.hga.isDefaultNavTab = tI(i2) ? 1 : 0;
            this.hga.tabName = str;
            this.hga.isGeneralTab = i3;
            this.hgb = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.hga);
            this.hgb.a(this);
            this.hgb.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean tI(int i) {
        return (this.hfB == null || this.hfB.hfO == null || this.hfB.hfO.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void tJ(int i) {
        this.hge = true;
        if (!this.isDynamic) {
            if (!this.hgb.isLoading()) {
                this.mPn = 1;
                this.hga.pn = this.mPn;
                this.hga.sortType = i;
                if (this.hgg >= 0) {
                    this.hga.lastThreadId = this.hgg;
                }
                this.hgb.loadData();
            }
        } else if (!this.hgd.isLoading()) {
            if (ar.aOS().aOT()) {
                this.hgc.qType = 2;
            } else {
                this.hgc.qType = 1;
            }
            this.hgc.lastThreadId = 0L;
            this.hgd.loadData();
        }
    }

    public void tK(int i) {
        this.hge = false;
        if (!this.isDynamic) {
            if (!this.hgb.isLoading()) {
                this.mPn++;
                this.hga.pn = this.mPn;
                this.hga.sortType = i;
                this.hga.lastThreadId = -1L;
                this.hgb.loadData();
            }
        } else if (!this.hgd.isLoading()) {
            if (ar.aOS().aOT()) {
                this.hgc.qType = 2;
            } else {
                this.hgc.qType = 1;
            }
            this.hgd.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.hge) {
            this.hfW = dVar;
            this.hgf.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bj) {
                    String tid = ((bj) next).getTid();
                    if (!this.hgf.contains(tid)) {
                        this.hgf.add(tid);
                    }
                }
            }
        } else {
            this.hfW.hasMore = dVar.hasMore;
            this.hfW.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bj) {
                    String tid2 = ((bj) next2).getTid();
                    if (!this.hgf.contains(tid2)) {
                        ((bj) next2).dtE = this.hfB.isBrandForum;
                        this.hfW.threadList.add(next2);
                        this.hgf.add(tid2);
                    }
                }
            }
        }
        this.hfB.a(this.hfW);
        return true;
    }

    public void ao(bj bjVar) {
        if (bjVar != null && this.hfW != null && this.hfW.threadList != null) {
            if (v.isEmpty(this.hfW.threadList)) {
                this.hfW.threadList.add(bjVar);
            } else {
                if (this.hfW.threadList.size() == 1 && (this.hfW.threadList.get(0) instanceof p)) {
                    this.hfW.threadList.remove(0);
                }
                this.hfW.threadList.add(0, bjVar);
            }
            this.hfB.a(this.hfW);
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
                            this.hgc.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.hfB.a(errorData);
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
                            this.hgc.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.hfB.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.hfW == null || v.isEmpty(this.hfW.threadList)) ? false : true;
    }

    public void ef(long j) {
        this.hgg = j;
    }

    public boolean bRv() {
        return this.hge;
    }
}
