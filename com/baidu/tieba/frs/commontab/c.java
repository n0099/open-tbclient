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
    private d hfQ;
    private FrsCommonTabRequestData hfU;
    private FrsCommonTabNetModel hfV;
    private FrsDynamicRequestData hfW;
    private FrsDynamicModel hfX;
    private boolean hfY;
    private FrsCommonTabFragment hfv;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> hfZ = new HashSet<>();
    private int mPn = 1;
    private long hga = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.hfv = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.hfW = new FrsDynamicRequestData();
                this.hfW.forumId = i;
                this.hfW.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.hfW.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.hfW.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.hfX = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.hfW);
                this.hfX.a(this);
                this.hfX.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.hfU = new FrsCommonTabRequestData();
            this.hfU.fid = i;
            this.hfU.tabId = i2;
            this.hfU.isDefaultNavTab = tI(i2) ? 1 : 0;
            this.hfU.tabName = str;
            this.hfU.isGeneralTab = i3;
            this.hfV = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.hfU);
            this.hfV.a(this);
            this.hfV.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean tI(int i) {
        return (this.hfv == null || this.hfv.hfI == null || this.hfv.hfI.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void tJ(int i) {
        this.hfY = true;
        if (!this.isDynamic) {
            if (!this.hfV.isLoading()) {
                this.mPn = 1;
                this.hfU.pn = this.mPn;
                this.hfU.sortType = i;
                if (this.hga >= 0) {
                    this.hfU.lastThreadId = this.hga;
                }
                this.hfV.loadData();
            }
        } else if (!this.hfX.isLoading()) {
            if (ar.aOV().aOW()) {
                this.hfW.qType = 2;
            } else {
                this.hfW.qType = 1;
            }
            this.hfW.lastThreadId = 0L;
            this.hfX.loadData();
        }
    }

    public void tK(int i) {
        this.hfY = false;
        if (!this.isDynamic) {
            if (!this.hfV.isLoading()) {
                this.mPn++;
                this.hfU.pn = this.mPn;
                this.hfU.sortType = i;
                this.hfU.lastThreadId = -1L;
                this.hfV.loadData();
            }
        } else if (!this.hfX.isLoading()) {
            if (ar.aOV().aOW()) {
                this.hfW.qType = 2;
            } else {
                this.hfW.qType = 1;
            }
            this.hfX.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.hfY) {
            this.hfQ = dVar;
            this.hfZ.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bj) {
                    String tid = ((bj) next).getTid();
                    if (!this.hfZ.contains(tid)) {
                        this.hfZ.add(tid);
                    }
                }
            }
        } else {
            this.hfQ.hasMore = dVar.hasMore;
            this.hfQ.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bj) {
                    String tid2 = ((bj) next2).getTid();
                    if (!this.hfZ.contains(tid2)) {
                        ((bj) next2).dtA = this.hfv.isBrandForum;
                        this.hfQ.threadList.add(next2);
                        this.hfZ.add(tid2);
                    }
                }
            }
        }
        this.hfv.a(this.hfQ);
        return true;
    }

    public void ao(bj bjVar) {
        if (bjVar != null && this.hfQ != null && this.hfQ.threadList != null) {
            if (v.isEmpty(this.hfQ.threadList)) {
                this.hfQ.threadList.add(bjVar);
            } else {
                if (this.hfQ.threadList.size() == 1 && (this.hfQ.threadList.get(0) instanceof p)) {
                    this.hfQ.threadList.remove(0);
                }
                this.hfQ.threadList.add(0, bjVar);
            }
            this.hfv.a(this.hfQ);
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
                            this.hfW.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.hfv.a(errorData);
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
                            this.hfW.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.hfv.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.hfQ == null || v.isEmpty(this.hfQ.threadList)) ? false : true;
    }

    public void ef(long j) {
        this.hga = j;
    }

    public boolean bRx() {
        return this.hfY;
    }
}
