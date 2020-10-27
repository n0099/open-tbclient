package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.frs.s;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class c implements NetModel.b {
    private FrsCommonTabFragment iJZ;
    private FrsCommonTabRequestData iKB;
    private FrsCommonTabNetModel iKC;
    private FrsDynamicRequestData iKD;
    private FrsDynamicModel iKE;
    private boolean iKF;
    private d iKu;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> iKG = new HashSet<>();
    private int mPn = 1;
    private long iKH = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.iJZ = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.iKD = new FrsDynamicRequestData();
                this.iKD.forumId = i;
                this.iKD.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.iKD.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.iKD.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.iKE = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.iKD);
                this.iKE.a(this);
                this.iKE.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.iKB = new FrsCommonTabRequestData();
            this.iKB.fid = i;
            this.iKB.tabId = i2;
            this.iKB.isDefaultNavTab = zc(i2) ? 1 : 0;
            this.iKB.tabName = str;
            this.iKB.isGeneralTab = i3;
            this.iKC = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.iKB);
            this.iKC.a(this);
            this.iKC.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.iKB != null) {
            this.iKB.tabType = i;
        }
    }

    private boolean zc(int i) {
        return (this.iJZ == null || this.iJZ.iKm == null || this.iJZ.iKm.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void zd(int i) {
        this.iKF = true;
        if (!this.isDynamic) {
            if (!this.iKC.isLoading()) {
                this.mPn = 1;
                this.iKB.pn = this.mPn;
                this.iKB.sortType = i;
                if (this.iKH >= 0) {
                    this.iKB.lastThreadId = this.iKH;
                }
                this.iKC.loadData();
            }
        } else if (!this.iKE.isLoading()) {
            if (au.boO().boP()) {
                this.iKD.qType = 2;
            } else {
                this.iKD.qType = 1;
            }
            this.iKD.lastThreadId = 0L;
            this.iKE.loadData();
        }
    }

    public void ze(int i) {
        this.iKF = false;
        if (!this.isDynamic) {
            if (!this.iKC.isLoading()) {
                this.mPn++;
                this.iKB.pn = this.mPn;
                this.iKB.sortType = i;
                this.iKB.lastThreadId = -1L;
                this.iKC.loadData();
            }
        } else if (!this.iKE.isLoading()) {
            if (au.boO().boP()) {
                this.iKD.qType = 2;
            } else {
                this.iKD.qType = 1;
            }
            this.iKE.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.iKF) {
            this.iKu = dVar;
            this.iKG.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof bw) {
                    String tid = ((bw) next).getTid();
                    if (!this.iKG.contains(tid)) {
                        this.iKG.add(tid);
                    }
                }
            }
        } else {
            this.iKu.hasMore = dVar.hasMore;
            this.iKu.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bw) {
                    String tid2 = ((bw) next2).getTid();
                    if (!this.iKG.contains(tid2)) {
                        ((bw) next2).eAK = this.iJZ.isBrandForum;
                        this.iKu.threadList.add(next2);
                        this.iKG.add(tid2);
                    }
                }
            }
        }
        this.iJZ.a(this.iKu);
        return true;
    }

    public void an(bw bwVar) {
        if (bwVar != null && this.iKu != null && this.iKu.threadList != null) {
            if (y.isEmpty(this.iKu.threadList)) {
                this.iKu.threadList.add(bwVar);
            } else {
                if (this.iKu.threadList.size() == 1 && (this.iKu.threadList.get(0) instanceof s)) {
                    this.iKu.threadList.remove(0);
                }
                this.iKu.threadList.add(0, bwVar);
            }
            this.iJZ.a(this.iKu);
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
                    if (!y.isEmpty(dVar2.threadList)) {
                        q qVar = (q) y.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (qVar instanceof bw) {
                            this.iKD.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.iJZ.a(errorData);
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
                    if (!y.isEmpty(dVar2.threadList)) {
                        q qVar = (q) y.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (qVar instanceof bw) {
                            this.iKD.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.iJZ.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.iKu == null || y.isEmpty(this.iKu.threadList)) ? false : true;
    }

    public d czd() {
        return this.iKu;
    }

    public void fk(long j) {
        this.iKH = j;
    }

    public boolean cze() {
        return this.iKF;
    }
}
